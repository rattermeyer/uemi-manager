-- liquibase formatted sql
-- changeset rat:tlmt-0070-002
ALTER TABLE tlmt.portfolioitem_assessment
    DROP COLUMN IF EXISTS sum_of_assessments,
    DROP COLUMN IF EXISTS average;
