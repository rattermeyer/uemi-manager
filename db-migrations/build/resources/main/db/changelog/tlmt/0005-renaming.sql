--liquibase formatted sql
--changeset rat:tlmt-0005-01
ALTER TABLE tlmt.techradar RENAME TO portfolio_version;

--changeset rat:tlmt-0005-02
ALTER TABLE tlmt.statuschange RENAME COLUMN techradar_id TO portfolio_version_id;

--changeset rat:tlmt-0005-03
ALTER TABLE tlmt.statuschange RENAME COLUMN techradar_uuid TO portfolio_version_uuid;
