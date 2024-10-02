--liquibase formatted sql
--changeset rat:tlmt-0050-0005-0001
CREATE FUNCTION extensions.array_intersect(a anyarray, b anyarray)
    RETURNS anyarray AS $$ SELECT ARRAY(
        SELECT unnest(a)
        INTERSECT
        SELECT unnest(b)
    ) $$ LANGUAGE SQL;
GRANT EXECUTE ON FUNCTION extensions.array_intersect(anyarray, anyarray) TO public;
--rollback DROP FUNCTION extensions.array_intersect(anyarray, anyarray);
