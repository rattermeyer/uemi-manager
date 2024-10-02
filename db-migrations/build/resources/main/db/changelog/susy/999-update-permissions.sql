---liquibase formatted sql
---changeset rat:susy-999 runAlways:true
GRANT USAGE ON SCHEMA susy TO susy_user;
GRANT SELECT, INSERT, UPDATE, DELETE ON ALL TABLES IN SCHEMA susy TO susy_user;
GRANT ALL ON ALL TABLES IN SCHEMA susy TO susy_admin;

GRANT USAGE ON SCHEMA authnz TO susy_user;
GRANT SELECT, INSERT, UPDATE, DELETE ON ALL TABLES IN SCHEMA authnz TO susy_user;
