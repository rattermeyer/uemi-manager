--liquibase formatted sql
--changeset rat:0200-1
CREATE TABLE IF NOT EXISTS tlmt.queue
(
    id          uuid                     NOT NULL DEFAULT extensions.uuid_generate_v7(),
    name        VARCHAR(1024)            NOT NULL,
    payload     json                     NOT NULL,
    inserted_at TIMESTAMP WITH TIME ZONE NOT NULL DEFAULT now()
);

--changeset rat:0200-2
CREATE INDEX IF NOT EXISTS idx_queue_inserted_at ON tlmt.queue (inserted_at ASC);

--changeset rat:0200-3
CREATE OR REPLACE FUNCTION tlmt.queue_enqueue(p_name VARCHAR(1024), p_payload json, p_type VARCHAR) RETURNS uuid
AS
$$
DECLARE
    v_id        uuid;
    v_timestamp TIMESTAMP WITH TIME ZONE;
BEGIN
    v_id := extensions.uuid_generate_v7();
    v_timestamp := now();
    INSERT INTO tlmt.queue (id, name, payload, inserted_at)
    VALUES (v_id, p_name,
            json_build_object('specversion', '1.0',
                              'source', p_name,
                              'id', v_id,
                              'time', v_timestamp,
                              'type', p_type,
                              'datacontenttype', 'application/json',
                              'data', p_payload), v_timestamp)
    RETURNING id INTO v_id;
    RETURN v_id;
END
$$ LANGUAGE plpgsql;
COMMENT ON FUNCTION tlmt.queue_enqueue(VARCHAR, json, VARCHAR) IS 'Enqueue a message into the queue as a cloud event';

--changeset rat:0200-4
CREATE OR REPLACE FUNCTION tlmt.queue_dequeue(p_name VARCHAR(1024), p_msg_count INTEGER DEFAULT 1) RETURNS json
AS
$$
DECLARE
    v_payload json;
BEGIN
    DELETE
    FROM tlmt.queue pse
    WHERE pse.id =
          (SELECT pse_inner.id
           FROM tlmt.queue pse_inner
           WHERE pse_inner.name = p_name
           ORDER BY pse_inner.inserted_at
               FOR UPDATE SKIP LOCKED
           LIMIT p_msg_count)
    RETURNING pse.payload INTO v_payload;
    RETURN v_payload;
END;
$$ LANGUAGE plpgsql;

GRANT USAGE ON SCHEMA tlmt TO tlmt_user, susy_user, ppm_user, lifecycle_user;
GRANT SELECT, INSERT, UPDATE, DELETE ON tlmt.queue TO tlmt_user, susy_user, ppm_user, lifecycle_user;
