--liquibase formatted sql
--changeset rat:tlmt-1302
CREATE TYPE tlmt.tag_summary AS
(
    tag             VARCHAR(32),
    taggrouptitle   VARCHAR(255),
    backgroundcolor VARCHAR(255)
);

--changeset rat:tlmt-1002 runOnChange:true
DROP VIEW IF EXISTS portfolioitem_status_history;
CREATE OR REPLACE VIEW portfolioitem_status_history AS
(
SELECT DISTINCT n.portfolioitem_id,
                t.id      AS portfolio_version_id,
                t.version AS portfolio_version,
                n.id      AS status_change_id,
                n.new_status,
                n.reason
FROM tlmt.statuschange n
         LEFT JOIN tlmt.statuschange p
                   ON n.portfolioitem_id = p.portfolioitem_id AND n.portfolio_version_id = p.portfolio_version_id AND
                      n.timestamp > p.timestamp
         JOIN tlmt.portfolio_version t ON n.portfolio_version_id = t.id
WHERE p.timestamp IS NULL);
ALTER VIEW portfolioitem_status_history OWNER TO tlmt_admin;

--changeset rat:tlmt-1201 runOnChange:true
CREATE OR REPLACE VIEW tlmt.tag_overview AS
(
SELECT tg.tag,
       tg.taggrouptitle,
       tg.backgroundcolor,
       tg.rule,
       tg.uuid                               AS                        tag_group_uuid,
       ((tg.tag, taggrouptitle, tg.backgroundcolor)::tlmt.tag_summary) tag_summary,
       json_build_object('tag', tg.tag, 'taggroup', taggrouptitle, 'backgroundcolor',
                         tg.backgroundcolor) AS                        tag_summary_json,
       (SELECT (count(*)) AS count
        FROM tlmt.portfolioitem pi
        WHERE ARRAY [tg.tag] <@ pi.tags
          AND pi.active = TRUE)              AS                        count
FROM (SELECT taggrouptitle, backgroundcolor, rule, unnest(tags) AS tag, uuid FROM tlmt.taggroup) tg);
ALTER VIEW tlmt.tag_overview OWNER TO tlmt_admin;
CREATE INDEX idx_portfolioitem_tags ON tlmt.portfolioitem USING GIN (tags);


--changeset rat:tlmt-0050-1005 runOnChange:true
CREATE OR REPLACE VIEW tlmt.portfolio_item_qs AS
(
WITH rule_and_count AS (SELECT pi.uuid,
                               pi.id,
                               pi.name,
                               pi.tags,
                               tg.taggrouptitle,
                               tg.rule,
                               coalesce(array_length(extensions.array_intersect(pi.tags, tg.tags), 1), 0) AS tag_count
                        FROM tlmt.portfolioitem pi,
                             tlmt.taggroup tg)
SELECT *,
       CASE
           WHEN rule = 'NONE' AND tag_count > 0 THEN TRUE
           WHEN rule = 'EXACTLY_ONE' AND tag_count != 1 THEN TRUE
           WHEN rule = 'AT_LEAST_ONE' AND tag_count < 1 THEN TRUE
           WHEN rule = 'AT_MOST_ONE' AND tag_count > 1 THEN TRUE
           ELSE FALSE
           END AS rule_violated
FROM rule_and_count);
ALTER VIEW tlmt.portfolio_item_qs OWNER TO tlmt_admin;

--changeset rat:tlmt-0050-1006 runOnChange:true
CREATE OR REPLACE VIEW tlmt.portfolio_changes_extended AS
WITH trindex AS (
    SELECT *, row_number() OVER () AS index FROM (
                                                     SELECT * from tlmt.portfolio_version order by published_timestamp asc) as sub)
SELECT links.portfolioitem_id                                  AS id,
       pi.name                                                 AS name,
       trl.version                                             AS old_version,
       links.new_status                                        AS old_status,
       rechts.new_status                                       AS new_status,
       trr.version                                             AS new_version,
       trr.published                                           AS new_published,
       CASE
           WHEN links.new_status = 'NEW' THEN 0
           WHEN links.new_status = 'END_OF_LIFE' THEN 1
           WHEN links.new_status = 'NOT_IN_FOCUS' THEN 2
           WHEN links.new_status = 'ASSESS' THEN 3
           WHEN links.new_status = 'TRIAL' THEN 4
           WHEN links.new_status = 'PORTFOLIO' THEN 5
           WHEN links.new_status = 'ON_HOLD' THEN 6
           ELSE -1 END                                         AS old_status_value,
       CASE
           WHEN rechts.new_status = 'NEW' THEN 0
           WHEN rechts.new_status = 'END_OF_LIFE' THEN 1
           WHEN rechts.new_status = 'NOT_IN_FOCUS' THEN 2
           WHEN rechts.new_status = 'ASSESS' THEN 3
           WHEN rechts.new_status = 'TRIAL' THEN 4
           WHEN rechts.new_status = 'PORTFOLIO' THEN 5
           WHEN rechts.new_status = 'ON_HOLD' THEN 6
           ELSE -1 END                                         AS rechts_status_value,
       (SELECT index FROM trindex WHERE version = trr.version) -
       (SELECT index FROM trindex WHERE version = trl.version) AS distance
FROM tlmt.portfolioitem_status_history links,
     tlmt.portfolioitem_status_history rechts,
     tlmt.portfolio_version trl,
     tlmt.portfolio_version trr,
     tlmt.portfolioitem pi
WHERE links.portfolio_version = trl.version
  AND rechts.portfolio_version = trr.version
  AND links.portfolioitem_id = rechts.portfolioitem_id
  AND links.portfolioitem_id = pi.id
  AND rechts.portfolioitem_id = pi.id
  AND pi.active = TRUE
  AND (trl.published_timestamp <= trr.published_timestamp OR trr.published IS FALSE);
ALTER VIEW tlmt.portfolio_changes_extended OWNER TO tlmt_admin;


--changeset rat:tlmt-0050-1007 runOnChange:true
CREATE OR REPLACE VIEW tlmt.portfolioitem_count_by_status AS
(
SELECT vsc.version,
       max("count") FILTER (WHERE status = 'NEW')          AS new,
       max("count") FILTER (WHERE status = 'ASSESS')       AS assess,
       max("count") FILTER (WHERE status = 'TRIAL')        AS trial,
       max("count") FILTER (WHERE status = 'PORTFOLIO')    AS portfolio,
       max("count") FILTER (WHERE status = 'END_OF_LIFE')  AS end_of_life,
       max("count") FILTER (WHERE status = 'ON_HOLD')      AS on_hold,
       max("count") FILTER (WHERE status = 'NOT_IN_FOCUS') AS not_in_focus
FROM (SELECT portfolio_version version, new_status status, count(*) count
      FROM portfolioitem_status_history
      GROUP BY portfolio_version, new_status) AS vsc
WHERE version IS NOT NULL
GROUP BY vsc.version
ORDER BY vsc.version);
ALTER VIEW tlmt.portfolioitem_count_by_status OWNER TO tlmt_admin;

--changeset rat:tlmt-0050-1008 runOnChange:true
CREATE OR REPLACE VIEW tlmt.portfolioitem_assessment_view AS
SELECT pi.uuid, assessment_view.*
FROM (SELECT id, radar_id, portfolioitem_id, portfolioitem_name, joblevel, 1 AS stars, one_star AS value
      FROM tlmt.portfolioitem_assessment
      UNION
      SELECT id, radar_id, portfolioitem_id, portfolioitem_name, joblevel, 2 AS stars, two_stars AS value
      FROM tlmt.portfolioitem_assessment
      UNION
      SELECT id, radar_id, portfolioitem_id, portfolioitem_name, joblevel, 3 AS stars, three_stars AS value
      FROM tlmt.portfolioitem_assessment
      UNION
      SELECT id, radar_id, portfolioitem_id, portfolioitem_name, joblevel, 4 AS stars, four_stars AS value
      FROM tlmt.portfolioitem_assessment) AS assessment_view
         JOIN tlmt.portfolioitem pi ON assessment_view.portfolioitem_id = pi.id;
ALTER VIEW tlmt.portfolioitem_assessment_view OWNER TO tlmt_admin;

--changeset rat:tlmt-0050-1009 runOnChange:true
CREATE OR REPLACE VIEW tlmt.portfolioitem_assessment_transposed AS
SELECT pi.uuid, assessment_transposed.*
FROM (SELECT radar_id,
             portfolioitem_id,
             portfolioitem_name,
             1                                                        AS stars,
             sum(CASE joblevel WHEN 'ALL' THEN one_star END)          AS "ALL",
             sum(CASE joblevel WHEN 'ASSOCIATE' THEN one_star END)    AS associate,
             sum(CASE joblevel WHEN 'ENTERPRISE' THEN one_star END)   AS enterprise,
             sum(CASE joblevel WHEN 'LEAD' THEN one_star END)         AS lead,
             sum(CASE joblevel WHEN 'PROFESSIONAL' THEN one_star END) AS professional,
             sum(CASE joblevel WHEN 'SENIOR' THEN one_star END)       AS senior,
             sum(CASE joblevel WHEN 'SONSTIGE' THEN one_star END)     AS sonstige
      FROM tlmt.portfolioitem_assessment
      GROUP BY radar_id, portfolioitem_id, portfolioitem_name
      UNION
      SELECT radar_id,
             portfolioitem_id,
             portfolioitem_name,
             2                                                         AS stars,
             sum(CASE joblevel WHEN 'ALL' THEN two_stars END)          AS "ALL",
             sum(CASE joblevel WHEN 'ASSOCIATE' THEN two_stars END)    AS associate,
             sum(CASE joblevel WHEN 'ENTERPRISE' THEN two_stars END)   AS enterprise,
             sum(CASE joblevel WHEN 'LEAD' THEN two_stars END)         AS lead,
             sum(CASE joblevel WHEN 'PROFESSIONAL' THEN two_stars END) AS professional,
             sum(CASE joblevel WHEN 'SENIOR' THEN two_stars END)       AS senior,
             sum(CASE joblevel WHEN 'SONSTIGE' THEN two_stars END)     AS sonstige
      FROM tlmt.portfolioitem_assessment
      GROUP BY radar_id, portfolioitem_id, portfolioitem_name
      UNION
      SELECT radar_id,
             portfolioitem_id,
             portfolioitem_name,
             3                                                           AS stars,
             sum(CASE joblevel WHEN 'ALL' THEN three_stars END)          AS "ALL",
             sum(CASE joblevel WHEN 'ASSOCIATE' THEN three_stars END)    AS associate,
             sum(CASE joblevel WHEN 'ENTERPRISE' THEN three_stars END)   AS enterprise,
             sum(CASE joblevel WHEN 'LEAD' THEN three_stars END)         AS lead,
             sum(CASE joblevel WHEN 'PROFESSIONAL' THEN three_stars END) AS professional,
             sum(CASE joblevel WHEN 'SENIOR' THEN three_stars END)       AS senior,
             sum(CASE joblevel WHEN 'SONSTIGE' THEN three_stars END)     AS sonstige
      FROM tlmt.portfolioitem_assessment
      GROUP BY radar_id, portfolioitem_id, portfolioitem_name
      UNION
      SELECT radar_id,
             portfolioitem_id,
             portfolioitem_name,
             4                                                          AS stars,
             sum(CASE joblevel WHEN 'ALL' THEN four_stars END)          AS "ALL",
             sum(CASE joblevel WHEN 'ASSOCIATE' THEN four_stars END)    AS associate,
             sum(CASE joblevel WHEN 'ENTERPRISE' THEN four_stars END)   AS enterprise,
             sum(CASE joblevel WHEN 'LEAD' THEN four_stars END)         AS lead,
             sum(CASE joblevel WHEN 'PROFESSIONAL' THEN four_stars END) AS professional,
             sum(CASE joblevel WHEN 'SENIOR' THEN four_stars END)       AS senior,
             sum(CASE joblevel WHEN 'SONSTIGE' THEN four_stars END)     AS sonstige
      FROM tlmt.portfolioitem_assessment
      GROUP BY radar_id, portfolioitem_id, portfolioitem_name) AS assessment_transposed
         JOIN tlmt.portfolioitem pi ON assessment_transposed.portfolioitem_id = pi.id;
ALTER VIEW tlmt.portfolioitem_assessment_transposed OWNER TO tlmt_admin;

--changeset rat:tlmt-0050-1010 runOnChange:true
CREATE OR REPLACE VIEW tlmt.portfolioitem_totals_per_joblevel AS
SELECT radar_id,
       portfolioitem_id,
       portfolioitem_name,
       sum("ALL")        AS total_all,
       sum(associate)    AS total_associate,
       sum(enterprise)   AS total_enterprise,
       sum(lead)         AS total_lead,
       sum(professional) AS total_professional,
       sum(senior)       AS total_senior,
       sum(sonstige)     AS total_sonstige
FROM tlmt.portfolioitem_assessment_transposed
GROUP BY radar_id, portfolioitem_id, portfolioitem_name;
ALTER VIEW tlmt.portfolioitem_totals_per_joblevel OWNER TO tlmt_admin;

--changeset rat:tlmt-0050-1011 runOnChange:true
CREATE TYPE tlmt.item_summary AS
(
    name TEXT,
    uuid uuid
);

--changeset rat:tlmt-0050-1012 runOnChange:true
CREATE OR REPLACE VIEW tlmt.tag_group_overview AS
(
SELECT taggrouptitle,
       rule,
       uuid                                               AS tag_group_uuid,
       backgroundcolor,
       items                                              AS items_raw,
       coalesce(array_to_json(items), json_build_array()) AS items,
       coalesce(array_length(items, 1), 0)                AS number_of_items
FROM (SELECT *,
             (SELECT array_agg((pi.name, pi.uuid)::tlmt.item_summary)
              FROM tlmt.portfolioitem pi
              WHERE tg.tags && pi.tags
                AND pi.active = TRUE) AS items
      FROM tlmt.taggroup tg) AS grouping
    );
ALTER VIEW tlmt.tag_group_overview OWNER TO tlmt_admin;

--changeset rat:tlmt-0050-1013 runOnChange:true
CREATE OR REPLACE VIEW portfolioitem_active AS
(
SELECT id,
       uuid,
       name,
       array_agg((tag, taggrouptitle, backgroundcolor)::tlmt.tag_summary) AS tags_raw,
       json_agg((tag, taggrouptitle, backgroundcolor)::tlmt.tag_summary)  AS tags
FROM (SELECT *
      FROM tlmt.portfolioitem pi
      WHERE ARRAY ['mostly-AWS']::VARCHAR[] <@ pi.tags) a
         JOIN tlmt.tag_overview tov ON a.tags && ARRAY [tov.tag]
WHERE a.active = TRUE
  AND a.merged = FALSE
GROUP BY id, uuid, name);
ALTER VIEW portfolioitem_active OWNER TO tlmt_admin;
