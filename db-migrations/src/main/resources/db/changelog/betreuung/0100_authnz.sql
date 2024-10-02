--liquibase formatted sql
--changeset rat:0100-authnz-1
CREATE TABLE benutzer
(
    uuid          uuid PRIMARY KEY NOT NULL DEFAULT extensions.uuid_generate_v7(),
    benutzername  VARCHAR(40)      NOT NULL,
    email         VARCHAR(254)     NOT NULL,
    name          VARCHAR(40)      NOT NULL,
    vorname       VARCHAR(40)      NOT NULL,
    passwort_hash VARCHAR(128)     NOT NULL,
    CONSTRAINT uq_benutzer_benutzername UNIQUE (benutzername),
    CONSTRAINT uq_benutzer_email UNIQUE (email)
);

--changeset rat:0100-authnz-2
CREATE TABLE rolle
(
    uuid uuid PRIMARY KEY NOT NULL DEFAULT extensions.uuid_generate_v7(),
    name VARCHAR(40)      NOT NULL,
    CONSTRAINT uq_rolle_name UNIQUE (name)
);

--changeset rat:0100-authnz-3
CREATE TABLE benutzer_rolle
(
    benutzer_uuid uuid NOT NULL,
    rolle_uuid    uuid NOT NULL,
    CONSTRAINT pk_benutzer_rolle PRIMARY KEY (benutzer_uuid, rolle_uuid),
    CONSTRAINT fk_benutzer_rolle_benutzer FOREIGN KEY (benutzer_uuid) REFERENCES benutzer (uuid),
    CONSTRAINT fk_benutzer_rolle_rolle FOREIGN KEY (rolle_uuid) REFERENCES rolle (uuid)
);

--changeset rat:0100-authnz-4 runOnChange: true
INSERT INTO rolle (uuid, name)
VALUES ('01920bef-9e70-7489-9ced-61c6bc9f1f27', 'ADMIN'),
       ('01922564-cb31-7a45-ab08-40560aedd97b', 'BETREUER_IN'),
       ('01922566-8c73-7d65-b2f4-6ca8f4492476', 'SCHUELER_IN'),
       ('01922566-ef4b-76fe-9a0f-d7d91ba41472', 'BEAUFTRAGTE_R') -- ÜMI Beauftragte_r
ON CONFLICT DO NOTHING;
INSERT INTO benutzer (uuid, benutzername, email, name, vorname, passwort_hash)
VALUES ('01920bef-9e70-7489-9ced-61c6bc9f1f27', 'admin',
        'admin@betreuung.org', 'Admin', 'Max',
        '$argon2id$v=19$m=65536,t=3,p=4$vATzh4O0NyCCECU3ir58gg$C+TjNOJOdeiX2o7jHFOzDRB3DRXD17MIvgHZt9be6hI'), -- passwort: changeme
       ('01922569-25ed-7120-9af6-16a11fe1370e', 'betreuer',
        'monika.betreuer@orga.de', 'Betreuer', 'Monika',
        '$argon2id$v=19$m=65536,t=3,p=4$vATzh4O0NyCCECU3ir58gg$C+TjNOJOdeiX2o7jHFOzDRB3DRXD17MIvgHZt9be6hI'),
       ('0192256e-bd3a-7afa-aba1-ce9cadf4751b', 'schueler',
        'jens.schueler@schule.de', 'Schueler', 'Jens',
        '$argon2id$v=19$m=65536,t=3,p=4$vATzh4O0NyCCECU3ir58gg$C+TjNOJOdeiX2o7jHFOzDRB3DRXD17MIvgHZt9be6hI')
ON CONFLICT DO NOTHING;
INSERT INTO benutzer_rolle (benutzer_uuid, rolle_uuid)
VALUES ('01920bef-9e70-7489-9ced-61c6bc9f1f27', '01920bef-9e70-7489-9ced-61c6bc9f1f27'), -- ADMIN
       ('01922569-25ed-7120-9af6-16a11fe1370e', '01922564-cb31-7a45-ab08-40560aedd97b'), -- BETREUER_IN
       ('0192256e-bd3a-7afa-aba1-ce9cadf4751b', '01922566-8c73-7d65-b2f4-6ca8f4492476')  -- SCHUELER_IN
ON CONFLICT DO NOTHING;

