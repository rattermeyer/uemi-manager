/*
 * This file is generated by jOOQ.
 */
package com.opitzconsulting.tlmt.jooqmigration.jooq.tlmt.tables.records;


import com.opitzconsulting.tlmt.jooqmigration.jooq.tlmt.tables.PortfolioitemAssessment;

import org.jooq.Record1;
import org.jooq.impl.UpdatableRecordImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes", "this-escape" })
public class PortfolioitemAssessmentRecord extends UpdatableRecordImpl<PortfolioitemAssessmentRecord> {

    private static final long serialVersionUID = 1L;

    /**
     * Setter for <code>tlmt.portfolioitem_assessment.id</code>.
     */
    public void setId(Long value) {
        set(0, value);
    }

    /**
     * Getter for <code>tlmt.portfolioitem_assessment.id</code>.
     */
    public Long getId() {
        return (Long) get(0);
    }

    /**
     * Setter for <code>tlmt.portfolioitem_assessment.four_stars</code>.
     */
    public void setFourStars(Integer value) {
        set(1, value);
    }

    /**
     * Getter for <code>tlmt.portfolioitem_assessment.four_stars</code>.
     */
    public Integer getFourStars() {
        return (Integer) get(1);
    }

    /**
     * Setter for <code>tlmt.portfolioitem_assessment.portfolioitem_id</code>.
     */
    public void setPortfolioitemId(Long value) {
        set(2, value);
    }

    /**
     * Getter for <code>tlmt.portfolioitem_assessment.portfolioitem_id</code>.
     */
    public Long getPortfolioitemId() {
        return (Long) get(2);
    }

    /**
     * Setter for <code>tlmt.portfolioitem_assessment.portfolioitem_name</code>.
     */
    public void setPortfolioitemName(String value) {
        set(3, value);
    }

    /**
     * Getter for <code>tlmt.portfolioitem_assessment.portfolioitem_name</code>.
     */
    public String getPortfolioitemName() {
        return (String) get(3);
    }

    /**
     * Setter for <code>tlmt.portfolioitem_assessment.joblevel</code>.
     */
    public void setJoblevel(String value) {
        set(4, value);
    }

    /**
     * Getter for <code>tlmt.portfolioitem_assessment.joblevel</code>.
     */
    public String getJoblevel() {
        return (String) get(4);
    }

    /**
     * Setter for <code>tlmt.portfolioitem_assessment.one_star</code>.
     */
    public void setOneStar(Integer value) {
        set(5, value);
    }

    /**
     * Getter for <code>tlmt.portfolioitem_assessment.one_star</code>.
     */
    public Integer getOneStar() {
        return (Integer) get(5);
    }

    /**
     * Setter for <code>tlmt.portfolioitem_assessment.three_stars</code>.
     */
    public void setThreeStars(Integer value) {
        set(6, value);
    }

    /**
     * Getter for <code>tlmt.portfolioitem_assessment.three_stars</code>.
     */
    public Integer getThreeStars() {
        return (Integer) get(6);
    }

    /**
     * Setter for <code>tlmt.portfolioitem_assessment.two_stars</code>.
     */
    public void setTwoStars(Integer value) {
        set(7, value);
    }

    /**
     * Getter for <code>tlmt.portfolioitem_assessment.two_stars</code>.
     */
    public Integer getTwoStars() {
        return (Integer) get(7);
    }

    /**
     * Setter for <code>tlmt.portfolioitem_assessment.radar_id</code>.
     */
    public void setRadarId(Long value) {
        set(8, value);
    }

    /**
     * Getter for <code>tlmt.portfolioitem_assessment.radar_id</code>.
     */
    public Long getRadarId() {
        return (Long) get(8);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    @Override
    public Record1<Long> key() {
        return (Record1) super.key();
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached PortfolioitemAssessmentRecord
     */
    public PortfolioitemAssessmentRecord() {
        super(PortfolioitemAssessment.PORTFOLIOITEM_ASSESSMENT);
    }

    /**
     * Create a detached, initialised PortfolioitemAssessmentRecord
     */
    public PortfolioitemAssessmentRecord(Long id, Integer fourStars, Long portfolioitemId, String portfolioitemName, String joblevel, Integer oneStar, Integer threeStars, Integer twoStars, Long radarId) {
        super(PortfolioitemAssessment.PORTFOLIOITEM_ASSESSMENT);

        setId(id);
        setFourStars(fourStars);
        setPortfolioitemId(portfolioitemId);
        setPortfolioitemName(portfolioitemName);
        setJoblevel(joblevel);
        setOneStar(oneStar);
        setThreeStars(threeStars);
        setTwoStars(twoStars);
        setRadarId(radarId);
        resetChangedOnNotNull();
    }
}
