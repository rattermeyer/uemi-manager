/*
 * This file is generated by jOOQ.
 */
package com.opitzconsulting.tlmt.jooqmigration.jooq.tlmt.tables.records;


import com.opitzconsulting.tlmt.jooqmigration.jooq.tlmt.enums.EJoblevel;
import com.opitzconsulting.tlmt.jooqmigration.jooq.tlmt.enums.ERegion;
import com.opitzconsulting.tlmt.jooqmigration.jooq.tlmt.tables.SkillDistribution;

import org.jooq.Record1;
import org.jooq.impl.UpdatableRecordImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes", "this-escape" })
public class SkillDistributionRecord extends UpdatableRecordImpl<SkillDistributionRecord> {

    private static final long serialVersionUID = 1L;

    /**
     * Setter for <code>tlmt.skill_distribution.id</code>.
     */
    public void setId(Long value) {
        set(0, value);
    }

    /**
     * Getter for <code>tlmt.skill_distribution.id</code>.
     */
    public Long getId() {
        return (Long) get(0);
    }

    /**
     * Setter for <code>tlmt.skill_distribution.skill_id</code>.
     */
    public void setSkillId(Long value) {
        set(1, value);
    }

    /**
     * Getter for <code>tlmt.skill_distribution.skill_id</code>.
     */
    public Long getSkillId() {
        return (Long) get(1);
    }

    /**
     * Setter for <code>tlmt.skill_distribution.region</code>.
     */
    public void setRegion(ERegion value) {
        set(2, value);
    }

    /**
     * Getter for <code>tlmt.skill_distribution.region</code>.
     */
    public ERegion getRegion() {
        return (ERegion) get(2);
    }

    /**
     * Setter for <code>tlmt.skill_distribution.skill</code>.
     */
    public void setSkill(String value) {
        set(3, value);
    }

    /**
     * Getter for <code>tlmt.skill_distribution.skill</code>.
     */
    public String getSkill() {
        return (String) get(3);
    }

    /**
     * Setter for <code>tlmt.skill_distribution.joblevel</code>.
     */
    public void setJoblevel(EJoblevel value) {
        set(4, value);
    }

    /**
     * Getter for <code>tlmt.skill_distribution.joblevel</code>.
     */
    public EJoblevel getJoblevel() {
        return (EJoblevel) get(4);
    }

    /**
     * Setter for <code>tlmt.skill_distribution.skill_level</code>.
     */
    public void setSkillLevel(Integer value) {
        set(5, value);
    }

    /**
     * Getter for <code>tlmt.skill_distribution.skill_level</code>.
     */
    public Integer getSkillLevel() {
        return (Integer) get(5);
    }

    /**
     * Setter for <code>tlmt.skill_distribution.count</code>.
     */
    public void setCount(Long value) {
        set(6, value);
    }

    /**
     * Getter for <code>tlmt.skill_distribution.count</code>.
     */
    public Long getCount() {
        return (Long) get(6);
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
     * Create a detached SkillDistributionRecord
     */
    public SkillDistributionRecord() {
        super(SkillDistribution.SKILL_DISTRIBUTION);
    }

    /**
     * Create a detached, initialised SkillDistributionRecord
     */
    public SkillDistributionRecord(Long id, Long skillId, ERegion region, String skill, EJoblevel joblevel, Integer skillLevel, Long count) {
        super(SkillDistribution.SKILL_DISTRIBUTION);

        setId(id);
        setSkillId(skillId);
        setRegion(region);
        setSkill(skill);
        setJoblevel(joblevel);
        setSkillLevel(skillLevel);
        setCount(count);
        resetChangedOnNotNull();
    }
}
