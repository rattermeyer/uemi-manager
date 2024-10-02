--liquibase formatted sql
--changeset rat:0100-1
DROP TABLE IF EXISTS authnz.session;
CREATE UNLOGGED TABLE authnz.session
(
    id      uuid                     NOT NULL DEFAULT extensions.uuid_generate_v4(),
    data    json                     NOT NULL,
    expires TIMESTAMP WITH TIME ZONE NOT NULL DEFAULT now() + INTERVAL '1 day'
);


GRANT USAGE ON SCHEMA authnz TO tlmt_admin;
GRANT SELECT, INSERT, UPDATE, DELETE ON TABLE authnz.session TO tlmt_user,tlmt_admin,ppm_user,susy_user,lifecycle_user;
GRANT USAGE ON SCHEMA authnz TO tlmt_user,ppm_user,susy_user,lifecycle_user;
