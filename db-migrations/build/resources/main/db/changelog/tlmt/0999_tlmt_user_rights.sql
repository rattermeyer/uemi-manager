--liquibase formatted sql
--changeset rat:0999-1 runAlways:true
GRANT USAGE ON SCHEMA tlmt TO tlmt_user;
GRANT select,insert,update,delete ON ALL TABLES IN SCHEMA tlmt TO tlmt_user;
GRANT select,usage ON ALL SEQUENCES IN SCHEMA tlmt TO tlmt_user;
GRANT execute ON ALL FUNCTIONS IN SCHEMA tlmt TO tlmt_user;

--changeset rat:0999-2 runAlways:true
GRANT USAGE ON SCHEMA tlmt TO tlmt_admin;
GRANT select,insert,update,delete ON ALL TABLES IN SCHEMA tlmt TO tlmt_admin;
GRANT select,usage ON ALL SEQUENCES IN SCHEMA tlmt TO tlmt_admin;
GRANT execute ON ALL FUNCTIONS IN SCHEMA tlmt TO tlmt_admin;
