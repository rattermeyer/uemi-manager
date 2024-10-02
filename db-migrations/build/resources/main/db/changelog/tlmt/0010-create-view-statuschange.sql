--liquibase formatted sql
--changeset rat:tlmt-1001 runOnChange:true
DROP VIEW IF EXISTS tlmt.portfolioitem_status_history;
CREATE OR REPLACE VIEW tlmt.portfolioitem_status_history
AS
(
SELECT DISTINCT n.portfolioitem_id,
                pi.uuid   AS portfolioitem_uuid,
                t.id      AS portfolio_version_id,
                t.version AS portfolio_version,
                n.id      AS status_change_id,
                n.new_status,
                n.reason
FROM tlmt.statuschange n
         LEFT JOIN tlmt.statuschange p
                   ON n.portfolioitem_id = p.portfolioitem_id AND n.portfolio_version_id = p.portfolio_version_id AND
                      n."timestamp" > p."timestamp"
         JOIN tlmt.portfolio_version t ON n.portfolio_version_id = t.id
         JOIN tlmt.portfolioitem pi ON n.portfolioitem_id = pi.id
WHERE p."timestamp" IS NULL
    );
ALTER VIEW tlmt.portfolioitem_status_history OWNER TO tlmt_admin;

--changeset rat:tlmt-1002 runOnChange:true
DROP VIEW IF EXISTS tlmt.latest_status_change_view;
CREATE OR REPLACE VIEW tlmt.latest_status_change_view AS
(
SELECT sc_new_radar.item_id          AS portfolioitem_id,
       portfolioitem.uuid            AS portfolioitem_uuid,
       sc_new_radar.techradar_id,
       sc_new_radar.item_name        AS portfolioitem_name,
       portfolioitem.tags            AS tags,
       sc_new_radar.status_id        AS new_status_id,
       sc_new_radar.status           AS new_status,
       sc_old_radar.status_id        AS old_status_id,
       sc_old_radar.status           AS old_status,
       sc_new_radar."timestamp",
       sc_new_radar.reason,
       sc_new_radar.item_is_active   AS portfolioitem_is_active,
       sc_new_radar.item_description AS portfolioitem_description
FROM (SELECT st_ch.id                   AS status_id,
             st_ch.new_status           AS status,
             st_ch.portfolio_version_id AS techradar_id,
             st_ch."timestamp",
             st_ch.reason,
             max_st_ch.id               AS item_id,
             max_st_ch.name             AS item_name,
             max_st_ch.active           AS item_is_active,
             max_st_ch.description      AS item_description
      FROM tlmt.statuschange st_ch
               JOIN (SELECT max(sc.id) AS max_id,
                            it.id,
                            it.name,
                            it.active,
                            it.description
                     FROM tlmt.statuschange sc
                              JOIN tlmt.portfolioitem it ON sc.portfolioitem_id = it.id
                     WHERE it.active = TRUE
                     GROUP BY sc.portfolio_version_id, it.id, it.name
                     HAVING (sc.portfolio_version_id IN (SELECT portfolio_version.id
                                                         FROM tlmt.portfolio_version
                                                         ORDER BY portfolio_version.id DESC
                                                         LIMIT 1))) max_st_ch
                    ON st_ch.id = max_st_ch.max_id) sc_new_radar
         FULL JOIN (SELECT st_ch.id                   AS status_id,
                           st_ch.new_status           AS status,
                           st_ch.portfolio_version_id AS techradar_id,
                           max_st_ch.id               AS item_id,
                           max_st_ch.name             AS item_name
                    FROM tlmt.statuschange st_ch
                             JOIN (SELECT max(sc.id) AS max_id,
                                          it.id,
                                          it.name
                                   FROM tlmt.statuschange sc
                                            JOIN tlmt.portfolioitem it ON sc.portfolioitem_id = it.id
                                   WHERE it.active = TRUE
                                   GROUP BY sc.portfolio_version_id, it.id, it.name
                                   HAVING (sc.portfolio_version_id IN (SELECT portfolio_version.id
                                                                       FROM tlmt.portfolio_version
                                                                       WHERE portfolio_version.id <
                                                                             ((SELECT max(techradar_1.id) AS max
                                                                               FROM tlmt.portfolio_version techradar_1))
                                                                       ORDER BY portfolio_version.id DESC
                                                                       LIMIT 1))) max_st_ch
                                  ON st_ch.id = max_st_ch.max_id) sc_old_radar
                   ON sc_new_radar.item_id = sc_old_radar.item_id
         JOIN tlmt.portfolioitem ON sc_new_radar.item_id = tlmt.portfolioitem.id);
ALTER VIEW tlmt.latest_status_change_view OWNER TO tlmt_admin;
