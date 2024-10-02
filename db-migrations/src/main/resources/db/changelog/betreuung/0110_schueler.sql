--liquibase formatted sql
--changeset rat:0110-schueler-2
CREATE TABLE schueler
(
    uuid                      uuid        NOT NULL DEFAULT extensions.uuid_generate_v7(),
    benutzer_uuid             uuid,
    name                      VARCHAR(40) NOT NULL,
    vorname                   VARCHAR(40) NOT NULL,
    geburtsdatum              DATE        NOT NULL,
    klasse                    VARCHAR(3)  NOT NULL,
    vertrag_von               DATE        NOT NULL,
    vertrag_bis               DATE,
    kuendigung_eingegangen_am DATE,
    CONSTRAINT pk_schueler PRIMARY KEY (uuid),
    CONSTRAINT uq_schueler_name_vorname_geburtsdatum UNIQUE (name, vorname, geburtsdatum),
    CONSTRAINT fk_schueler_sorgeberechtigter FOREIGN KEY (benutzer_uuid) REFERENCES benutzer (uuid)
);

--changeset rat:0110-schueler-3
CREATE TYPE wochentag AS ENUM ('MO', 'DI', 'MI', 'DO', 'FR');
--changeset rat:0110-schueler-4
CREATE TABLE standardzeiten
(
    schueler_uuid    uuid      NOT NULL,
    wochentag        wochentag NOT NULL,
    vormittag_beginn TIME,
    vormittag_ende   TIME,
    mittag_beginn    TIME,
    mittag_ende      TIME,
    buskind          BOOLEAN,
    CONSTRAINT fk_standardzeiten_schueler FOREIGN KEY (schueler_uuid) REFERENCES schueler (uuid)
);

--changeset rat:0110-schueler-5
CREATE TABLE betreuungszeit
(
    schueler_uuid    uuid NOT NULL,
    datum            DATE NOT NULL,
    vormittag_beginn TIME,
    vormittag_ende   TIME,
    keine_fruehbetreuung BOOLEAN NOT NULL DEFAULT FALSE,
    mittag_beginn     TIME,
    mittag_ende      TIME,
    keine_mittagsbetreuung BOOLEAN NOT NULL DEFAULT FALSE,
    buskind          BOOLEAN,
    anwesend         BOOLEAN,
    krank            BOOLEAN,
    kommentar        TEXT,
    CONSTRAINT fk_betreuungszeit_schueler FOREIGN KEY (schueler_uuid) REFERENCES schueler (uuid)
);

--changeset rat:0110-schueler-6
CREATE TABLE schliesstage
(
    datum DATE NOT NULL,
    kommentar TEXT,
    CONSTRAINT pk_schliesstage PRIMARY KEY (datum)
);


--changeset rat:0110-schueler-7
CREATE OR REPLACE VIEW schueler_betreuungszeiten AS
WITH datum_serie AS (
    SELECT 
        datum::date,
        CASE 
            WHEN extract(dow from datum) = 1 THEN 'MO'::wochentag
            WHEN extract(dow from datum) = 2 THEN 'DI'::wochentag
            WHEN extract(dow from datum) = 3 THEN 'MI'::wochentag
            WHEN extract(dow from datum) = 4 THEN 'DO'::wochentag
            WHEN extract(dow from datum) = 5 THEN 'FR'::wochentag
            ELSE NULL
        END AS wochentag
    FROM 
        generate_series(current_date - interval '1 year', current_date + interval '1 year', '1 day'::interval) datum
    WHERE extract(dow from datum) BETWEEN 1 AND 5
)
SELECT 
    schueler.uuid AS schueler_uuid,
    datum_serie.datum,
    datum_serie.wochentag,
    EXISTS (SELECT 1 FROM schliesstage WHERE datum = datum_serie.datum) as geschlossen,

    COALESCE(betreuungszeit.keine_fruehbetreuung, FALSE) AS keine_fruehbetreuung,
    COALESCE(betreuungszeit.vormittag_beginn, standardzeiten.vormittag_beginn) AS vormittag_beginn,
    COALESCE(betreuungszeit.vormittag_ende, standardzeiten.vormittag_ende) AS vormittag_ende,
    COALESCE(betreuungszeit.mittag_beginn, standardzeiten.mittag_beginn) AS mittag_beginn,
    COALESCE(betreuungszeit.mittag_ende, standardzeiten.mittag_ende) AS mittag_ende,
    COALESCE(betreuungszeit.keine_mittagsbetreuung, FALSE) AS keine_mittagsbetreuung,
    betreuungszeit.krank AS krank
FROM 
    schueler
CROSS JOIN 
    datum_serie
LEFT JOIN 
    betreuungszeit ON schueler.uuid = betreuungszeit.schueler_uuid AND datum_serie.datum = betreuungszeit.datum
LEFT JOIN 
    standardzeiten ON datum_serie.wochentag = standardzeiten.wochentag;



