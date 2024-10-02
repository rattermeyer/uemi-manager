--liquibase formatted sql
--changeset rat:tlmt-1401 runOnChange:true
DROP VIEW IF EXISTS tlmt.portfolioitem_assessment_overview;
CREATE OR REPLACE VIEW tlmt.portfolioitem_assessment_overview AS
(
SELECT pi.uuid                        AS portfolioitem_uuid,
       pi.id                          AS portfolioitem_id,
       pi.name                        AS portfolioitem_name,
       pc.links_portfolio_version_id  AS published_version_id,
       pc.links_version               AS published_version,
       pc.links_status                AS published_status,
       pc.rechts_status               AS wip_status,
       pc.rechts_version              AS wip_version,
       pc.rechts_portfolio_version_id AS wip_version_id,
       pc.reason                      AS reason,
       pi.tags                        AS tags_raw,
       pc.tags                        AS tags,
       pi.last_updated                AS last_updated
FROM tlmt.portfolioitem pi
         JOIN tlmt.portfolio_changes pc ON pi.id = pc.portfolioitem_id
    AND pc.rechts_portfolio_version_id = (SELECT id FROM tlmt.portfolio_version pv WHERE published = FALSE)
    AND pc.links_portfolio_version_id = (
        SELECT
            CASE WHEN (SELECT count(*) from tlmt.statuschange sc where sc.portfolioitem_id = pi.id) = 1 THEN (SELECT id FROM tlmt.portfolio_version pv where published = FALSE)
                 ELSE coalesce(
                         (SELECT id
                          FROM tlmt.portfolio_version pv
                          WHERE published = TRUE
                          ORDER BY published_timestamp DESC
                          LIMIT 1),
                         (SELECT id FROM tlmt.portfolio_version pv ORDER BY version DESC LIMIT 1)) END));
ALTER VIEW tlmt.portfolioitem_assessment_overview OWNER TO tlmt_admin;


SELECT coalesce(
(SELECT id from tlmt.portfolio_version pv WHERE published = TRUE ORDER BY published_timestamp DESC LIMIT 1),
(SELECT id from tlmt.portfolio_version pv LIMIT 1));
