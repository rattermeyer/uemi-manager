--liquibase formatted sql
--changeset rat:tlmt-1301 runOnChange:true
DROP VIEW IF EXISTS tlmt.tlmt.portfolio_changes CASCADE;
CREATE OR REPLACE VIEW tlmt.portfolio_changes AS
(
WITH most_relevant_sc AS (SELECT *,
                                 row_number()
                                 OVER (PARTITION BY portfolioitem_id, portfolio_version_id ORDER BY timestamp DESC) AS rn
                          FROM tlmt.statuschange
                          WHERE portfolio_version_uuid IS NOT NULL),
     trindex AS (SELECT *, row_number() OVER () AS index
                 FROM (SELECT *
                       FROM tlmt.portfolio_version
                       ORDER BY published_timestamp ASC) AS sub)
SELECT pi.uuid                                                      AS portfolioitem_uuid,
       pi.id                                                        AS portfolioitem_id,
       pi.name                                                      AS portfolioitem_name,
       pi.last_updated                                              AS last_updated,
       links.id                                                     AS links_change_id,
       links_tr.id                                                  AS links_portfolio_version_id,
       links_tr.uuid                                                AS links_portfolio_version_uuid,
       links_tr.version                                             AS links_version,
       links.new_status                                             AS links_status,
       rechts.new_status                                            AS rechts_status,
       rechts_tr.version                                            AS rechts_version,
       rechts_tr.id                                                 AS rechts_portfolio_version_id,
       rechts_tr.uuid                                               AS rechts_portfolio_version_uuid,
       rechts.reason                                                AS reason,
       rechts.id                                                    AS rechts_change_id,
       tags.tags                                                    AS tags_raw,
       CASE WHEN array_length(tags.tags, 1) = 1 AND tags.tags[1] is NULL THEN '[]' ELSE
           to_json(tags.tags)
           END AS tags,
       links.new_status <> rechts.new_status                        AS status_changed,
       CASE
           WHEN links.new_status = 'NEW' THEN 0
           WHEN links.new_status = 'END_OF_LIFE' THEN 1
           WHEN links.new_status = 'NOT_IN_FOCUS' THEN 2
           WHEN links.new_status = 'ASSESS' THEN 3
           WHEN links.new_status = 'TRIAL' THEN 4
           WHEN links.new_status = 'PORTFOLIO' THEN 5
           WHEN links.new_status = 'ON_HOLD' THEN 6
           ELSE -1 END                                              AS links_status_value,
       CASE
           WHEN rechts.new_status = 'NEW' THEN 0
           WHEN rechts.new_status = 'END_OF_LIFE' THEN 1
           WHEN rechts.new_status = 'NOT_IN_FOCUS' THEN 2
           WHEN rechts.new_status = 'ASSESS' THEN 3
           WHEN rechts.new_status = 'TRIAL' THEN 4
           WHEN rechts.new_status = 'PORTFOLIO' THEN 5
           WHEN rechts.new_status = 'ON_HOLD' THEN 6
           ELSE -1 END                                              AS rechts_status_value,
       (SELECT index FROM trindex WHERE version = rechts_tr.version) -
       (SELECT index FROM trindex WHERE version = links_tr.version) AS distance
FROM most_relevant_sc rechts
         JOIN tlmt.portfolio_version rechts_tr
              ON rechts.portfolio_version_uuid = rechts_tr.uuid AND rechts_tr.version IS NOT NULL
         JOIN tlmt.portfolioitem pi ON rechts.portfolioitem_id = pi.id
         JOIN (SELECT pi.id                                                                          AS portfolioitem_id,
                      array_agg((tov.tag, tov.taggrouptitle, tov.backgroundcolor)::tlmt.tag_summary) AS tags
               FROM (SELECT *,
                            unnest(
                                    CASE WHEN "tags" <> '{}' THEN "tags" ELSE '{null}' END
                            ) AS tag
                     FROM tlmt.portfolioitem pi) AS pi
                        LEFT JOIN tlmt.tag_overview tov ON pi.tag = tov.tag
               GROUP BY pi.id) AS tags ON tags.portfolioitem_id = pi.id
         LEFT JOIN most_relevant_sc links ON rechts.portfolioitem_id = links.portfolioitem_id
         JOIN tlmt.portfolio_version links_tr
              ON links.portfolio_version_uuid = links_tr.uuid AND
                 links_tr.version IS NOT NULL
WHERE rechts.rn = 1
  AND links.rn = 1
  AND links.timestamp <= rechts.timestamp
  AND links.portfolioitem_id = rechts.portfolioitem_id
  AND pi.active = TRUE
    );
ALTER VIEW tlmt.portfolio_changes OWNER TO tlmt_admin;
CREATE INDEX idx_statuschange_timestamp ON tlmt.statuschange (timestamp DESC);
CREATE INDEX idx_portfolio_version_published_timestamp ON tlmt.portfolio_version (published_timestamp DESC);
