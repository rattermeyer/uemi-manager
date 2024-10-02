--liquibase formatted sql
--changeset rat:tlmt-1501 runOnChange:true
CREATE OR REPLACE VIEW portfolioitem_qs AS
(
SELECT
    pi.uuid,
    pi.id,
    pi.name,
    tag_overview.taggrouptitle,
    tag_overview.rule AS rule,
    count(*)             tag_count,
    CASE
        WHEN
            tag_overview.rule = 'NONE' AND count(*) > 0 THEN TRUE
        WHEN
            tag_overview.rule = 'EXACTLY_ONE' AND count(*) != 1 THEN TRUE
        WHEN
            tag_overview.rule = 'AT_LEAST_ONE' AND count(*) < 1 THEN TRUE
        WHEN
            tag_overview.rule = 'AT_MOST_ONE' AND count(*) > 1 THEN TRUE
        ELSE FALSE
        END           AS rule_violated
FROM tlmt.portfolioitem pi
         LEFT JOIN tlmt.portfolioitem_tag pt ON pi.id = pt.portfolioitem_id
         LEFT JOIN tlmt.tag ON pt.tag_id = tag.id
         JOIN tlmt.taggroup ON taggroup.id = tag.taggroupid
         LEFT JOIN tlmt.tag_overview ON tlmt.tag_overview.tag = tag.tag
WHERE tag.active = TRUE
  AND pi.active = TRUE
GROUP BY pi.id, pi.name, tlmt.tag_overview.taggrouptitle, tlmt.tag_overview.rule
ORDER BY pi.name);
ALTER VIEW portfolioitem_qs OWNER TO tlmt_admin;

--changeset rat:tlmt-1502 runOnChange:true
CREATE OR REPLACE VIEW portfolioitem_qs_with_tags AS
(
SELECT
    pqs.uuid,
    pqs.id,
    pqs.name,
    pqs.taggrouptitle,
    pqs.rule,
    pqs.tag_count,
    pqs.rule_violated,
    tg.tags,
    tg.backgroundcolor
FROM portfolioitem_qs pqs LEFT JOIN tlmt.taggroup tg ON pqs.taggrouptitle = tg.taggrouptitle);
ALTER TABLE portfolioitem_qs_with_tags OWNER TO tlmt_admin;
