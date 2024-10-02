--liquibase formatted sql
--changeset rat:9999-1 runAlways:true
GRANT USAGE ON SCHEMA authnz TO tlmt_admin;
GRANT USAGE ON SCHEMA authnz TO tlmt_user,ppm_user,susy_user,lifecycle_user;
GRANT SELECT, INSERT, UPDATE, DELETE ON TABLE authnz.session TO tlmt_user,tlmt_admin,ppm_user,susy_user,lifecycle_user;
