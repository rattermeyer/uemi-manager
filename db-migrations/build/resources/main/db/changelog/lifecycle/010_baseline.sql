--liquibase formatted sql
--changeset rat:lifecycle-001
CREATE TABLE lifecycle.lifecycle_item
(
    uuid         uuid             DEFAULT extensions.uuid_generate_v4(),
    id           BIGINT  NOT NULL GENERATED ALWAYS AS IDENTITY,
    active       BOOLEAN NOT NULL DEFAULT TRUE,
    description  VARCHAR(1024),
    name         VARCHAR(64),
    last_updated TIMESTAMP        DEFAULT current_timestamp,
    created_at   TIMESTAMP        DEFAULT current_timestamp,
    CONSTRAINT pk_lifecycle_item PRIMARY KEY (id),
    CONSTRAINT uc_portfolio_item_name UNIQUE (name)
);
ALTER TABLE lifecycle.lifecycle_item OWNER TO lifecycle_admin;

--changeset rat:lifecycle-002
CREATE TABLE lifecycle.lifecycle_item_link
(
    lifecycle_item_id BIGINT NOT NULL,
    index             INT,
    name              VARCHAR(128),
    url               VARCHAR(1024),
    comment           VARCHAR(1024),
    CONSTRAINT pk_lifecycle_item_link PRIMARY KEY (lifecycle_item_id, index),
    CONSTRAINT uc_portfolio_item_link_name UNIQUE (lifecycle_item_id, name),
    CONSTRAINT fk_lifecycle_item_link_item FOREIGN KEY (lifecycle_item_id) REFERENCES lifecycle.lifecycle_item (id) ON DELETE CASCADE
);
ALTER TABLE lifecycle.lifecycle_item_link OWNER TO lifecycle_admin;

--changeset rat:lifecycle-003
CREATE TABLE lifecycle.portfolio
(
    uuid                uuid DEFAULT extensions.uuid_generate_v4(),
    id                  BIGINT  NOT NULL GENERATED ALWAYS AS IDENTITY,
    published           BOOLEAN NOT NULL,
    published_timestamp TIMESTAMP WITH TIME ZONE,
    version             VARCHAR(255),
    CONSTRAINT pk_portfolio PRIMARY KEY (id)
);
ALTER TABLE lifecycle.portfolio OWNER TO lifecycle_admin;

--changeset rat:lifecycle-004
CREATE TABLE lifecycle.portfolio_item
(
    portfolio_id BIGINT NOT NULL,
    item_uuid    uuid   NOT NULL,
    item_name    VARCHAR(64),
    status       VARCHAR(32),
    reason       VARCHAR(512),
    modified_at  TIMESTAMP WITH TIME ZONE DEFAULT current_timestamp,
    created_at   TIMESTAMP WITH TIME ZONE DEFAULT current_timestamp,
    CONSTRAINT pk_portfolio_item PRIMARY KEY (portfolio_id, item_name),
    CONSTRAINT fk_portfolio_item_portfolio FOREIGN KEY (portfolio_id) REFERENCES lifecycle.portfolio (id) ON DELETE CASCADE
);
ALTER TABLE lifecycle.portfolio_item OWNER TO lifecycle_admin;

--changeset rat:lifecycle-004-1
CREATE TYPE lifecycle.tag_group_rule AS ENUM ('OPTIONAL', 'AT_LEAST_ONE', 'AT_MOST_ONE', 'EXACTLY_ONE', 'NONE');
ALTER TYPE lifecycle.tag_group_rule OWNER TO lifecycle_admin;

--changeset rat:lifecycle-005
CREATE TABLE lifecycle.tag_group
(
    uuid             uuid                     DEFAULT extensions.uuid_generate_v4(),
    id               BIGINT NOT NULL GENERATED ALWAYS AS IDENTITY,
    title            VARCHAR(255),
    background_color VARCHAR(7),
    rule             tag_group_rule           DEFAULT 'OPTIONAL',
    modified_at      TIMESTAMP WITH TIME ZONE DEFAULT current_timestamp,
    created_at       TIMESTAMP WITH TIME ZONE DEFAULT current_timestamp,
    CONSTRAINT pk_tag_group PRIMARY KEY (id),
    CONSTRAINT uc_tag_group_title UNIQUE (title)
);
ALTER TABLE lifecycle.tag_group OWNER TO lifecycle_admin;

--changeset rat:lifecycle-006
CREATE TABLE lifecycle.tag
(
    name         VARCHAR(32) NOT NULL,
    tag_group_id BIGINT      NOT NULL,
    active       BOOLEAN     NOT NULL DEFAULT TRUE,
    CONSTRAINT pk_tag PRIMARY KEY (name),
    CONSTRAINT fk_tag_tag_group FOREIGN KEY (tag_group_id) REFERENCES tag_group (id) ON DELETE CASCADE
);
ALTER TABLE lifecycle.tag OWNER TO lifecycle_admin;

--changeset rat:lifecycle-007
CREATE TYPE lifecycle.joblevel AS ENUM ('MANAGEMENT', 'SONSTIGE',
    'ASSOCIATE', 'PROFESSIONAL', 'SENIOR', 'LEAD', 'ENTERPRISE', 'STUDENT',
    'SENIOR_MANAGEMENT', 'GESCHÄFTSLEITUNG', 'ALL');
ALTER TYPE lifecycle.joblevel OWNER TO lifecycle_admin;

--changeset rat:lifecycle-008
CREATE TYPE lifecycle.region AS ENUM ('OC', 'NO', 'W', 'SW', 'SO', 'PO');
ALTER TYPE lifecycle.region OWNER TO lifecycle_admin;

--changeset rat:lifecycle-009
CREATE TABLE lifecycle.skill_distribution
(
    id           BIGINT NOT NULL GENERATED ALWAYS AS IDENTITY,
    uuid         uuid                     DEFAULT extensions.uuid_generate_v4(),
    synced_at    TIMESTAMP WITH TIME ZONE DEFAULT current_timestamp,
    count_skills INT,
    CONSTRAINT pk_skill_distribution PRIMARY KEY (id)
);
ALTER TABLE lifecycle.skill_distribution OWNER TO lifecycle_admin;

--changeset rat:lifecycle-010
CREATE TABLE lifecycle.skill_assessment
(
    skill_distribution_id BIGINT NOT NULL,
    item_uuid             uuid,
    region                region,
    joblevel              joblevel,
    count                 INT,
    last_updated          TIMESTAMP WITH TIME ZONE DEFAULT current_timestamp,
    CONSTRAINT fk_skill_assessment_distribution FOREIGN KEY (skill_distribution_id) REFERENCES lifecycle.skill_distribution (id) ON DELETE CASCADE
);
ALTER TABLE lifecycle.skill_assessment OWNER TO lifecycle_admin;

--changeset rat:lifecycle-011
CREATE TABLE lifecycle.outbox
(
    event_uuid   uuid                     DEFAULT extensions.uuid_generate_v4(),
    item_uuid    uuid  NOT NULL,
    created_at   TIMESTAMP WITH TIME ZONE DEFAULT current_timestamp,
    published_at TIMESTAMP WITH TIME ZONE,
    event        jsonb NOT NULL
);
ALTER TABLE lifecycle.outbox OWNER TO lifecycle_admin;

--changeset rat:lifecycle-012
CREATE INDEX idx_outbox_created_at ON lifecycle.outbox (created_at);

--changeset rat:lifecycle-013
CREATE INDEX idx_outbox_published_at ON lifecycle.outbox (published_at);
