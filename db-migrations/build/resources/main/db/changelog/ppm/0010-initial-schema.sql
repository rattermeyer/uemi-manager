--liquibase formatted sql
--changeset rat:ppm-0010
CREATE TABLE IF NOT EXISTS ppm.sector
(
    uuid uuid         NOT NULL DEFAULT extensions.uuid_generate_v7(),
    name VARCHAR(255) NOT NULL,
    CONSTRAINT pk_sector PRIMARY KEY (uuid),
    CONSTRAINT uq_sector_name UNIQUE (name)
);

--changeset rat:ppm-0020
CREATE TABLE IF NOT EXISTS ppm.customer
(
    uuid        uuid NOT NULL DEFAULT extensions.uuid_generate_v7(),
    id          SERIAL,
    external_id VARCHAR(255),
    sector_uuid uuid,
    name        VARCHAR(255),
    CONSTRAINT pk_customer PRIMARY KEY (id)
);

--changeset rat:ppm-0030
CREATE UNLOGGED TABLE IF NOT EXISTS item
(
    uuid         uuid         NOT NULL,
    last_updated TIMESTAMP WITH TIME ZONE DEFAULT now(),
    description  VARCHAR(1024),
    name         VARCHAR(200) NOT NULL,
    aliases      VARCHAR(200)[],
    status       VARCHAR(125),
    tags         jsonb
);
CREATE INDEX IF NOT EXISTS idx_item_tags ON item USING gin (tags);

--changeset rat:ppm-0040
CREATE TABLE IF NOT EXISTS ppm.communication_log
(
    uuid             uuid NOT NULL            DEFAULT extensions.uuid_generate_v7(),
    channel          VARCHAR(255),
    successful       BOOLEAN                  DEFAULT TRUE,
    message          VARCHAR(1024),
    communication_ts TIMESTAMP WITH TIME ZONE DEFAULT now()
);

--changeset rat:ppm-0050
CREATE TABLE IF NOT EXISTS ppm.product
(
    customer_id uuid,
    id          SERIAL,
    uuid        uuid NOT NULL,
    description VARCHAR(1024),
    name        VARCHAR(255),
    CONSTRAINT pk_product PRIMARY KEY (id)
);

--changeset rat:ppm-0060
CREATE TABLE IF NOT EXISTS ppm.product_portfolio
(
    id         SERIAL,
    uuid       uuid NOT NULL DEFAULT extensions.uuid_generate_v7(),
    created_at TIMESTAMP WITH TIME ZONE,
    product_id INTEGER,
    version    VARCHAR(50),
    CONSTRAINT pk_product_portfolio PRIMARY KEY (id),
    CONSTRAINT fk_product_portfolio_product FOREIGN KEY (product_id) REFERENCES ppm.product (id) ON DELETE CASCADE,
    CONSTRAINT uq_product_portfolio_version UNIQUE (product_id, version)
);

--changeset rat:ppm-0070
CREATE TABLE IF NOT EXISTS ppm.product_portfolio_item
(
    product_portfolio_id INTEGER NOT NULL,
    item_uuid            uuid    NOT NULL,
    CONSTRAINT fk_product_portfolio_item_product_portfolio FOREIGN KEY (product_portfolio_id) REFERENCES ppm.product_portfolio (id) ON DELETE CASCADE,
    CONSTRAINT uq_product_portfolio_item UNIQUE (product_portfolio_id, item_uuid)
);

--changeset rat:ppm-0080
CREATE TYPE project_lifecycle_state AS ENUM ('PLANNING', 'ACTIVE', 'FINISHED', 'UNKOWN');

--changeset rat:ppm-0090
CREATE TABLE IF NOT EXISTS ppm.project
(
    id                      BIGSERIAL,
    uuid                    uuid NOT NULL DEFAULT extensions.uuid_generate_v7(),
    product_id              BIGSERIAL,
    external_project_id     VARCHAR(255),
    finished_at             TIMESTAMP WITH TIME ZONE,
    started_at              TIMESTAMP WITH TIME ZONE,
    description             TEXT,
    project_lifecycle_state project_lifecycle_state,
    name                    VARCHAR(255),
    CONSTRAINT pk_project PRIMARY KEY (id),
    CONSTRAINT fk_project_product FOREIGN KEY (product_id) REFERENCES ppm.product (id)
);

--changeset rat:ppm-0100
CREATE TABLE IF NOT EXISTS ppm.project_portfolio
(
    id         SERIAL,
    uuid       uuid    NOT NULL         DEFAULT extensions.uuid_generate_v7(),
    project_id INTEGER NOT NULL,
    created_at TIMESTAMP WITH TIME ZONE DEFAULT now(),
    version    VARCHAR(50),
    CONSTRAINT pk_project_portfolio PRIMARY KEY (id),
    CONSTRAINT fk_project_portfolio_project FOREIGN KEY (project_id) REFERENCES ppm.project (id) ON DELETE CASCADE,
    CONSTRAINT uq_project_portfolio_version UNIQUE (project_id, version)
);


--changeset rat:ppm-0110
CREATE TABLE IF NOT EXISTS ppm.project_portfolio_item
(
    project_portfolio_id INTEGER NOT NULL,
    item_uuid            uuid    NOT NULL,
    CONSTRAINT fk_project_portfolio_item_project_portfolio FOREIGN KEY (project_portfolio_id) REFERENCES ppm.project_portfolio (id) ON DELETE CASCADE,
    CONSTRAINT uq_project_portfolio_item UNIQUE (project_portfolio_id, item_uuid)
);
