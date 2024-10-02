--liquibase formatted sql
--changeset rat:tlmt-1301 runOnChange:true
UPDATE tlmt.portfolio_version
SET version='21.2.0'
WHERE uuid = '474d9c1b-ddbe-4a90-943b-1508a26d3c6a';
UPDATE tlmt.portfolio_version
SET version='20.2.0'
WHERE uuid = 'bdd95f58-77f3-427d-8ce0-d00619599408';
UPDATE tlmt.portfolio_version
SET version='20.2.1'
WHERE uuid = '66678836-67cc-4ef0-b481-abd0474a14b7';
UPDATE tlmt.portfolio_version
SET version='21.1.0'
WHERE uuid = '40917a09-ba62-4897-9651-d076a7cead11';
UPDATE tlmt.portfolio_version
SET version='21.1.1'
WHERE uuid = '86be6ea7-5565-4cfe-a0f1-915c85cdb805';
UPDATE tlmt.portfolio_version
SET version='21.1.2'
WHERE uuid = '0d5e1f5e-af5e-4788-888d-0fd3177291fe';

--changeset rat:tlmt-1302
ALTER TABLE tlmt.portfolio_version
    ALTER COLUMN version SET NOT NULL,
    ALTER COLUMN uuid SET NOT NULL;

--changeset rat:tlmt-1303
ALTER TABLE tlmt.portfolioitem
    ALTER COLUMN uuid SET NOT NULL,
    ALTER COLUMN name SET NOT NULL;

--changeset rat:tlmt-1304
ALTER TABLE tlmt.taggroup
    ALTER COLUMN tags SET NOT NULL;

--changeset rat:tlmt-1305
UPDATE tlmt.statuschange SET portfolio_version_uuid = (
    SELECT uuid FROM tlmt.portfolio_version where tlmt.portfolio_version.id = tlmt.statuschange.portfolio_version_id)
WHERE portfolio_version_uuid IS NULL;

--changeset rat:tlmt-1306
ALTER TABLE tlmt.statuschange
    ALTER COLUMN portfolio_version_uuid SET NOT NULL,
    ALTER COLUMN portfolio_version_id SET NOT NULL,
    ALTER COLUMN portfolioitem_id SET NOT NULL;
