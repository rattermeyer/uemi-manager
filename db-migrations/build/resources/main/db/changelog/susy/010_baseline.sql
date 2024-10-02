--liquibase formatted sql
--changeset rat:susy-001
CREATE TYPE item_type AS ENUM ('NEW', 'LIFECYCLE_MANAGED', 'LIFECYCLE_UNMANAGED', 'IGNORED');
--changeset rat:susy-002
CREATE TABLE susy.proposal
(
    uuid         uuid                     DEFAULT gen_random_uuid() NOT NULL,
    name         VARCHAR(128)                                       NOT NULL,
    item_type    susy.item_type                                     NOT NULL DEFAULT 'NEW'::susy.item_type,
    description  VARCHAR(1024),
    name_aliases VARCHAR(128)[],
    created_at   TIMESTAMP WITH TIME ZONE DEFAULT now()             NOT NULL,
    modified_at  TIMESTAMP WITH TIME ZONE DEFAULT now()             NOT NULL,
    created_by   VARCHAR(64),
    modified_by  VARCHAR(64),
    CONSTRAINT pk_proposal PRIMARY KEY (uuid),
    CONSTRAINT uc_proposal_name UNIQUE (name)
);

--changeset rat:susy-003
CREATE TYPE process_status AS ENUM ('LIFECYCLE_REVIEW', 'SKILL_REVIEW', 'REVIEWED');

--changeset rat:susy-004
CREATE TABLE susy.review_process
(
    uuid            uuid                     DEFAULT gen_random_uuid() NOT NULL,
    proposal_uuid   uuid                                               NOT NULL,
    requester_email VARCHAR(254),
    status          process_status,
    created_at      TIMESTAMP WITH TIME ZONE DEFAULT now()             NOT NULL,
    finished_at     TIMESTAMP WITH TIME ZONE,
    CONSTRAINT pk_review_process PRIMARY KEY (uuid),
    CONSTRAINT fk_review_process_proposal_uuid FOREIGN KEY (proposal_uuid) REFERENCES susy.proposal (uuid) ON DELETE CASCADE
);

--changeset rat:susy-005
CREATE TABLE susy.review_process_step
(
    review_process_uuid  uuid                                   NOT NULL,
    step_number          INT                                    NOT NULL,
    status               process_status                         NOT NULL,
    next_status_decision VARCHAR(1024),
    type_decision        item_type,
    reason               VARCHAR(1024),
    created_at           TIMESTAMP WITH TIME ZONE DEFAULT now() NOT NULL,
    created_by           VARCHAR(254),
    modified_at          TIMESTAMP WITH TIME ZONE DEFAULT now() NOT NULL,
    modified_by          VARCHAR(254),
    status_entered_at    TIMESTAMP WITH TIME ZONE GENERATED ALWAYS AS (created_at) STORED,
    status_exited_at     TIMESTAMP WITH TIME ZONE GENERATED ALWAYS AS (modified_at) STORED,
    CONSTRAINT pk_review_process_status PRIMARY KEY (review_process_uuid, step_number),
    CONSTRAINT fk_review_process_status_review_process_id FOREIGN KEY (review_process_uuid) REFERENCES susy.review_process (uuid) ON DELETE CASCADE
)
