--liquibase formatted sql
--changeset rat:tlmt-0060-1
ALTER TABLE tlmt.item_link
    ADD COLUMN order_number INT DEFAULT 0 NOT NULL,
    DROP CONSTRAINT item_link_pkey,
    DROP COLUMN id,
    ADD CONSTRAINT pk_item_link PRIMARY KEY (portfolioitem_id, name, url) ;
