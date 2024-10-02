--liquibase formatted sql


--changeset rat:0080-001: Add tags to taggroup
ALTER TABLE tlmt.taggroup
    ADD COLUMN IF NOT EXISTS "tags" VARCHAR[] DEFAULT ARRAY []::VARCHAR[],
    ADD COLUMN IF NOT EXISTS "uuid" uuid NOT NULL DEFAULT extensions.uuid_generate_v4();

--changeset rat:0080-002: Update tags in taggroup
UPDATE tlmt.taggroup tg
SET tags = (SELECT array_agg(tag) tags FROM tlmt.tag tag WHERE tag.taggroupid = tg.id GROUP BY taggroupid)

--changeset rat:0080-003: Add tags to portfolioitem
ALTER TABLE tlmt.portfolioitem
    ADD COLUMN IF NOT EXISTS "tags" VARCHAR[] DEFAULT ARRAY []::VARCHAR[];

--changeset rat:0080-004: Update tags in portfolioitem
UPDATE tlmt.portfolioitem pi
SET tags = (SELECT array_agg(tag) tags
            FROM tlmt.portfolioitem_tag pit
                     JOIN tlmt.tag tag ON pit.tag_id = tag.id
            WHERE pit.portfolioitem_id = pi.id
            GROUP BY portfolioitem_id);


--changeset rat:0080-005: create enum
CREATE TYPE tlmt.tag_group_rule AS ENUM ('OPTIONAL', 'AT_LEAST_ONE', 'AT_MOST_ONE', 'EXACTLY_ONE', 'NONE');

--changeset rat:0080-006: update rules
UPDATE tlmt.taggroup
SET rule =
        (CASE
             WHEN taggrouptitle = 'Partner' THEN 'AT_MOST_ONE'
             WHEN taggrouptitle = 'QS' THEN 'NONE'
             WHEN taggrouptitle = 'Prios' THEN 'AT_MOST_ONE'
             WHEN taggrouptitle = 'Typ' THEN 'EXACTLY_ONE'
             WHEN taggrouptitle = 'Wissensdomäne' THEN 'AT_LEAST_ONE'
             ELSE 'OPTIONAL' END);


--changeset rat:0080-007: alter type
ALTER TABLE tlmt.taggroup
    ALTER COLUMN rule TYPE tlmt.tag_group_rule USING rule::tlmt.tag_group_rule;

--changeset rat:0080-008: remove taggroups without tags
DELETE
FROM tlmt.taggroup
WHERE tags IS NULL
   OR array_length(tags, 1) = 0;

--changeset rat:0080-009: default id value
ALTER TABLE tlmt.taggroup
    ALTER COLUMN id SET DEFAULT nextval('tlmt.hibernate_sequence'),
    ALTER COLUMN taggrouptitle SET NOT NULL,
    ALTER COLUMN rule SET NOT NULL,
    ALTER COLUMN rule SET DEFAULT 'OPTIONAL',
    ALTER COLUMN backgroundcolor SET NOT NULL,
    ALTER COLUMN backgroundcolor SET DEFAULT '#FFFFFF',
    ADD CONSTRAINT uq_taggrouptitle UNIQUE (taggrouptitle);

--changeset rat:0080-010: default id value
ALTER TABLE tlmt.tag ALTER COLUMN id SET DEFAULT nextval('tlmt.hibernate_sequence');

--changeset rat:0080-011: default id value
ALTER TABLE tlmt.tag ADD CONSTRAINT uq_tag UNIQUE (tag);
