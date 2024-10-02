---liquibase formatted sql
---changeset rat:ppm-999 runAlways:true
GRANT USAGE ON SCHEMA ppm TO ppm_user;
GRANT SELECT, INSERT, UPDATE, DELETE ON ALL TABLES IN SCHEMA ppm TO ppm_user;
GRANT ALL ON ALL TABLES IN SCHEMA ppm TO ppm_admin;

GRANT USAGE ON SCHEMA authnz TO ppm_user;
GRANT SELECT, INSERT, UPDATE, DELETE ON ALL TABLES IN SCHEMA authnz TO ppm_user;
