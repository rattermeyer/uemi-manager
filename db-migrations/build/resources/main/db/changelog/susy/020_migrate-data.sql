--liquibase formatted sql
--changeset rat:susy-020
INSERT INTO susy.proposal (uuid, name, item_type, description, name_aliases, created_at, created_by, modified_at,
                           modified_by)
SELECT uuid,
       name,
       CASE
           WHEN type = 'NEW' THEN 'NEW'::susy.item_type
           WHEN type = 'PORTFOLIO' THEN 'LIFECYCLE_MANAGED'::susy.item_type
           WHEN type = 'SKILL' THEN 'LIFECYCLE_UNMANAGED'::susy.item_type
           ELSE 'IGNORED'
           END    AS item_type,
       description,
       name_aliases,
       created_at,
       'system',
       transaction_timestamp(),
       updated_by AS modified_by
FROM tlmt.item
ON CONFLICT DO NOTHING;

INSERT INTO susy.review_process (uuid, proposal_uuid, requester_email, status, created_at, finished_at)
SELECT p.uuid,
       item.uuid            AS proposal_uuid,
       p.email_notification AS requester_email,
       CASE
           WHEN
               item.type = 'PORTFOLIO' OR item.type = 'SKILL' OR item.type = 'IGNORED'
               THEN 'REVIEWED'::susy.process_status
           WHEN (SELECT process_status
                 FROM tlmt.item_process_change ipc
                 WHERE ipc.process_id = p.id
                 ORDER BY last_updated DESC
                 LIMIT 1) = 'SKILL_REVIEW' THEN 'SKILL_REVIEW'::susy.process_status
           WHEN (SELECT process_status
                 FROM tlmt.item_process_change ipc
                 WHERE ipc.process_id = p.id
                 ORDER BY last_updated DESC
                 LIMIT 1) = 'PORTFOLIO_REVIEW' THEN 'LIFECYCLE_REVIEW'::susy.process_status
           END              AS status,
       p.created_at         AS created_at,
       p.last_updated       AS finished_at
FROM tlmt.item_process p
         JOIN tlmt.item item ON p.item_id = item.id
ON CONFLICT DO NOTHING;

INSERT INTO susy.review_process_step (review_process_uuid, step_number, status, next_status_decision, type_decision,
                                      reason, created_at, created_by, modified_at, modified_by)
SELECT ip.uuid                                                            AS review_process_uid,
       row_number() OVER (PARTITION BY ip.uuid ORDER BY ipc.last_updated) AS step_number,
       CASE
           WHEN ipc.process_status = 'PORTFOLIO_REVIEW' THEN 'LIFECYCLE_REVIEW'::susy.process_status
           WHEN ipc.process_status = 'SKILL_REVIEW' THEN 'SKILL_REVIEW'::susy.process_status
           ELSE 'REVIEWED'::susy.process_status END                       AS status,
       ipc.reason                                                         AS next_status_decision,
       CASE
           WHEN rp.status = 'REVIEWED' THEN p.item_type END               AS type_decision,
       ipc.reason                                                         AS reason,
       ipc.created_at                                                     AS created_at,
       'system'                                                           AS created_by,
       ipc.last_updated                                                   AS modified_at,
       'system'                                                           AS modified_by
FROM tlmt.item_process_change ipc
         JOIN tlmt.item_process ip ON ipc.process_id = ip.id
         JOIN susy.review_process rp ON ip.uuid = rp.uuid
         JOIN susy.proposal p ON rp.proposal_uuid = p.uuid
ON CONFLICT DO NOTHING;

UPDATE susy.review_process
SET finished_at = (SELECT max(modified_at)
                   FROM susy.review_process_step
                   WHERE review_process_uuid = susy.review_process.uuid)
WHERE status = 'REVIEWED';

-- now we need to migrate the already managed items
UPDATE tlmt.portfolioitem p
SET uuid = (SELECT uuid
            FROM susy.proposal
            WHERE susy.proposal.name = p.name)
WHERE p.name IN (SELECT p.name AS name
                 FROM susy.proposal p,
                      tlmt.portfolioitem t
                 WHERE p.name = t.name
                   AND p.uuid <> t.uuid);

INSERT INTO susy.proposal (uuid, name, item_type, description, created_at, created_by, modified_at, modified_by)
SELECT uuid,
       name,
       'LIFECYCLE_MANAGED'::susy.item_type AS item_type,
       description,
       created_at,
       'system'                            AS created_by,
       p.last_updated                      AS modified_at,
       'system'                            AS modified_by
FROM tlmt.portfolioitem p
ON CONFLICT (uuid) DO UPDATE SET description = (SELECT description
                                                FROM tlmt.portfolioitem
                                                WHERE tlmt.portfolioitem.uuid = excluded.uuid),
                                 name        = (SELECT name
                                                FROM tlmt.portfolioitem
                                                WHERE tlmt.portfolioitem.uuid = excluded.uuid);

INSERT INTO susy.review_process (proposal_uuid, requester_email, status, created_at, finished_at)
SELECT p.uuid                          AS proposal_uuid,
       NULL                            AS requester_email,
       'REVIEWED'::susy.process_status AS status,
       p.created_at                    AS created_at,
       p.modified_at                   AS finished_at
FROM susy.proposal p
         LEFT OUTER JOIN susy.review_process rp ON p.uuid = rp.proposal_uuid
WHERE rp.uuid IS NULL;


INSERT INTO susy.review_process_step (review_process_uuid, step_number, status, type_decision, reason, created_at,
                                      created_by, modified_at, modified_by)
SELECT rp.uuid                          AS review_process_uuid,
       1                                AS step_number,
       'REVIEWED'::susy.process_status  AS status,
       p.item_type                      AS type_decision,
       'Migrating already managed item' AS reason,
       p.created_at                     AS created_at,
       'system'                         AS created_by,
       p.modified_at                    AS modified_at,
       'system'                         AS modified_by
FROM susy.review_process rp
         LEFT OUTER JOIN susy.review_process_step rps ON rp.uuid = rps.review_process_uuid
         LEFT JOIN susy.proposal p ON rp.proposal_uuid = p.uuid
WHERE rps.review_process_uuid IS NULL;
