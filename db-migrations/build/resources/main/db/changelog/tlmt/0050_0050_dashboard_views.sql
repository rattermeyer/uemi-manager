--liquibase formatted sql
--changeset rat:tlmt-0050-1008 runOnChange:true
CREATE OR REPLACE VIEW tag_distribution AS
(
SELECT taggrouptitle name, taggroupcount value, json_agg(json_build_object('name', tag, 'value', tagcount)) children
FROM (WITH tags_aggregated AS (SELECT taggrouptitle, tlmt.tag.tag label, count(*) count
                               FROM tlmt.portfolioitem
                                        JOIN tlmt.portfolioitem_tag
                                             ON tlmt.portfolioitem.id = tlmt.portfolioitem_tag.portfolioitem_id
                                        JOIN tlmt.tag ON tlmt.portfolioitem_tag.tag_id = tlmt.tag.id
                                        JOIN tlmt.taggroup tg ON tlmt.tag.taggroupid = tg.id
                               GROUP BY tg.taggrouptitle, tlmt.tag.tag),
           taggroup_aggregated AS (SELECT qs.taggrouptitle label, count(*) AS count
                                   FROM tlmt.portfolio_item_qs qs
                                   GROUP BY qs.taggrouptitle)
      SELECT tg.taggrouptitle, tga.count taggroupcount, tg.label tag, tg.count tagcount
      FROM taggroup_aggregated tga
               JOIN tags_aggregated tg ON tga.label = tg.taggrouptitle
      ORDER BY tg.taggrouptitle) r
GROUP BY taggrouptitle, taggroupcount);
ALTER VIEW tag_distribution OWNER TO tlmt_admin;

--changeset rat:tlmt-0050-1009 runOnChange:true
CREATE OR REPLACE VIEW portfolio_dev_ops_count AS
(
SELECT (dev_count - combined_count) only_dev, (ops_clount - combined_count) only_ops, combined_count
FROM (SELECT (SELECT count(*) AS dev_count
              FROM tlmt.portfolioitem
              WHERE ARRAY ['portfolio:development']::VARCHAR[] <@ tags) dev_count,
             (SELECT count(*) AS ops_count
              FROM tlmt.portfolioitem
              WHERE ARRAY ['portfolio:operations']::VARCHAR[] <@ tags)  ops_clount,
             (SELECT count(*) AS combined_count
              FROM tlmt.portfolioitem
              WHERE ARRAY ['portfolio:development', 'portfolio:operations']::VARCHAR[] <@
                    tags))
    );
ALTER VIEW portfolio_dev_ops_count OWNER TO tlmt_admin;
