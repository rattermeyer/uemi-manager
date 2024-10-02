--liquibase formatted sql
--changeset tlmt:0080-1
CREATE SEQUENCE IF NOT EXISTS tlmt.portfolio_version_seq ;
ALTER TABLE tlmt.portfolio_version_seq OWNER TO tlmt_admin;
--changeset tlmt:0080-2
SELECT setval('tlmt.portfolio_version_seq', (SELECT COALESCE(MAX(id)+1,1) FROM portfolio_version));
--changeset tlmt:0080-3
ALTER TABLE tlmt.portfolio_version ALTER COLUMN id SET DEFAULT nextval('portfolio_version_seq');
