--liquibase formatted sql
--changeset tlmt:0090-001
ALTER TABLE tlmt.portfolioitem
    ALTER COLUMN id SET DEFAULT nextval('tlmt.hibernate_sequence'),
    ALTER COLUMN active SET DEFAULT TRUE,
    ALTER COLUMN merged SET DEFAULT FALSE;
