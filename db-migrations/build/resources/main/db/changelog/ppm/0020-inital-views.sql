--liquibase formatted sql
--changeset rat:ppm-0020-001
CREATE OR REPLACE VIEW ppm.v_available_project_items AS
(
SELECT item.*, pp.id as portfolio_id
FROM ppm.item item,
     ppm.project_portfolio pp
WHERE item.uuid NOT IN (SELECT item_uuid
                        FROM ppm.project p
                                 INNER JOIN ppm.project_portfolio pp ON p.id = pp.project_id
                                 INNER JOIN ppm.product_portfolio_item ppi ON pp.id = ppi.product_portfolio_id)
    )
