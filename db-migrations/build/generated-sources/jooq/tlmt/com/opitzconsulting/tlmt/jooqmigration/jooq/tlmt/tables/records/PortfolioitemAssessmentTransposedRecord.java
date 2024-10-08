/*
 * This file is generated by jOOQ.
 */
package com.opitzconsulting.tlmt.jooqmigration.jooq.tlmt.tables.records;


import com.opitzconsulting.tlmt.jooqmigration.jooq.tlmt.tables.PortfolioitemAssessmentTransposed;

import java.util.UUID;

import org.jooq.impl.TableRecordImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes", "this-escape" })
public class PortfolioitemAssessmentTransposedRecord extends TableRecordImpl<PortfolioitemAssessmentTransposedRecord> {

    private static final long serialVersionUID = 1L;

    /**
     * Setter for <code>tlmt.portfolioitem_assessment_transposed.uuid</code>.
     */
    public void setUuid(UUID value) {
        set(0, value);
    }

    /**
     * Getter for <code>tlmt.portfolioitem_assessment_transposed.uuid</code>.
     */
    public UUID getUuid() {
        return (UUID) get(0);
    }

    /**
     * Setter for
     * <code>tlmt.portfolioitem_assessment_transposed.radar_id</code>.
     */
    public void setRadarId(Long value) {
        set(1, value);
    }

    /**
     * Getter for
     * <code>tlmt.portfolioitem_assessment_transposed.radar_id</code>.
     */
    public Long getRadarId() {
        return (Long) get(1);
    }

    /**
     * Setter for
     * <code>tlmt.portfolioitem_assessment_transposed.portfolioitem_id</code>.
     */
    public void setPortfolioitemId(Long value) {
        set(2, value);
    }

    /**
     * Getter for
     * <code>tlmt.portfolioitem_assessment_transposed.portfolioitem_id</code>.
     */
    public Long getPortfolioitemId() {
        return (Long) get(2);
    }

    /**
     * Setter for
     * <code>tlmt.portfolioitem_assessment_transposed.portfolioitem_name</code>.
     */
    public void setPortfolioitemName(String value) {
        set(3, value);
    }

    /**
     * Getter for
     * <code>tlmt.portfolioitem_assessment_transposed.portfolioitem_name</code>.
     */
    public String getPortfolioitemName() {
        return (String) get(3);
    }

    /**
     * Setter for <code>tlmt.portfolioitem_assessment_transposed.stars</code>.
     */
    public void setStars(Integer value) {
        set(4, value);
    }

    /**
     * Getter for <code>tlmt.portfolioitem_assessment_transposed.stars</code>.
     */
    public Integer getStars() {
        return (Integer) get(4);
    }

    /**
     * Setter for <code>tlmt.portfolioitem_assessment_transposed.ALL</code>.
     */
    public void setAll(Long value) {
        set(5, value);
    }

    /**
     * Getter for <code>tlmt.portfolioitem_assessment_transposed.ALL</code>.
     */
    public Long getAll() {
        return (Long) get(5);
    }

    /**
     * Setter for
     * <code>tlmt.portfolioitem_assessment_transposed.associate</code>.
     */
    public void setAssociate(Long value) {
        set(6, value);
    }

    /**
     * Getter for
     * <code>tlmt.portfolioitem_assessment_transposed.associate</code>.
     */
    public Long getAssociate() {
        return (Long) get(6);
    }

    /**
     * Setter for
     * <code>tlmt.portfolioitem_assessment_transposed.enterprise</code>.
     */
    public void setEnterprise(Long value) {
        set(7, value);
    }

    /**
     * Getter for
     * <code>tlmt.portfolioitem_assessment_transposed.enterprise</code>.
     */
    public Long getEnterprise() {
        return (Long) get(7);
    }

    /**
     * Setter for <code>tlmt.portfolioitem_assessment_transposed.lead</code>.
     */
    public void setLead(Long value) {
        set(8, value);
    }

    /**
     * Getter for <code>tlmt.portfolioitem_assessment_transposed.lead</code>.
     */
    public Long getLead() {
        return (Long) get(8);
    }

    /**
     * Setter for
     * <code>tlmt.portfolioitem_assessment_transposed.professional</code>.
     */
    public void setProfessional(Long value) {
        set(9, value);
    }

    /**
     * Getter for
     * <code>tlmt.portfolioitem_assessment_transposed.professional</code>.
     */
    public Long getProfessional() {
        return (Long) get(9);
    }

    /**
     * Setter for <code>tlmt.portfolioitem_assessment_transposed.senior</code>.
     */
    public void setSenior(Long value) {
        set(10, value);
    }

    /**
     * Getter for <code>tlmt.portfolioitem_assessment_transposed.senior</code>.
     */
    public Long getSenior() {
        return (Long) get(10);
    }

    /**
     * Setter for
     * <code>tlmt.portfolioitem_assessment_transposed.sonstige</code>.
     */
    public void setSonstige(Long value) {
        set(11, value);
    }

    /**
     * Getter for
     * <code>tlmt.portfolioitem_assessment_transposed.sonstige</code>.
     */
    public Long getSonstige() {
        return (Long) get(11);
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached PortfolioitemAssessmentTransposedRecord
     */
    public PortfolioitemAssessmentTransposedRecord() {
        super(PortfolioitemAssessmentTransposed.PORTFOLIOITEM_ASSESSMENT_TRANSPOSED);
    }

    /**
     * Create a detached, initialised PortfolioitemAssessmentTransposedRecord
     */
    public PortfolioitemAssessmentTransposedRecord(UUID uuid, Long radarId, Long portfolioitemId, String portfolioitemName, Integer stars, Long all, Long associate, Long enterprise, Long lead, Long professional, Long senior, Long sonstige) {
        super(PortfolioitemAssessmentTransposed.PORTFOLIOITEM_ASSESSMENT_TRANSPOSED);

        setUuid(uuid);
        setRadarId(radarId);
        setPortfolioitemId(portfolioitemId);
        setPortfolioitemName(portfolioitemName);
        setStars(stars);
        setAll(all);
        setAssociate(associate);
        setEnterprise(enterprise);
        setLead(lead);
        setProfessional(professional);
        setSenior(senior);
        setSonstige(sonstige);
        resetChangedOnNotNull();
    }
}
