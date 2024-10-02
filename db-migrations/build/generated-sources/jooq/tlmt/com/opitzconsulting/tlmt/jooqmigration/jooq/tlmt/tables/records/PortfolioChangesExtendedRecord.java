/*
 * This file is generated by jOOQ.
 */
package com.opitzconsulting.tlmt.jooqmigration.jooq.tlmt.tables.records;


import com.opitzconsulting.tlmt.jooqmigration.jooq.tlmt.tables.PortfolioChangesExtended;

import org.jooq.impl.TableRecordImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes", "this-escape" })
public class PortfolioChangesExtendedRecord extends TableRecordImpl<PortfolioChangesExtendedRecord> {

    private static final long serialVersionUID = 1L;

    /**
     * Setter for <code>tlmt.portfolio_changes_extended.id</code>.
     */
    public void setId(Long value) {
        set(0, value);
    }

    /**
     * Getter for <code>tlmt.portfolio_changes_extended.id</code>.
     */
    public Long getId() {
        return (Long) get(0);
    }

    /**
     * Setter for <code>tlmt.portfolio_changes_extended.name</code>.
     */
    public void setName(String value) {
        set(1, value);
    }

    /**
     * Getter for <code>tlmt.portfolio_changes_extended.name</code>.
     */
    public String getName() {
        return (String) get(1);
    }

    /**
     * Setter for <code>tlmt.portfolio_changes_extended.old_version</code>.
     */
    public void setOldVersion(String value) {
        set(2, value);
    }

    /**
     * Getter for <code>tlmt.portfolio_changes_extended.old_version</code>.
     */
    public String getOldVersion() {
        return (String) get(2);
    }

    /**
     * Setter for <code>tlmt.portfolio_changes_extended.old_status</code>.
     */
    public void setOldStatus(String value) {
        set(3, value);
    }

    /**
     * Getter for <code>tlmt.portfolio_changes_extended.old_status</code>.
     */
    public String getOldStatus() {
        return (String) get(3);
    }

    /**
     * Setter for <code>tlmt.portfolio_changes_extended.new_status</code>.
     */
    public void setNewStatus(String value) {
        set(4, value);
    }

    /**
     * Getter for <code>tlmt.portfolio_changes_extended.new_status</code>.
     */
    public String getNewStatus() {
        return (String) get(4);
    }

    /**
     * Setter for <code>tlmt.portfolio_changes_extended.new_version</code>.
     */
    public void setNewVersion(String value) {
        set(5, value);
    }

    /**
     * Getter for <code>tlmt.portfolio_changes_extended.new_version</code>.
     */
    public String getNewVersion() {
        return (String) get(5);
    }

    /**
     * Setter for <code>tlmt.portfolio_changes_extended.new_published</code>.
     */
    public void setNewPublished(Boolean value) {
        set(6, value);
    }

    /**
     * Getter for <code>tlmt.portfolio_changes_extended.new_published</code>.
     */
    public Boolean getNewPublished() {
        return (Boolean) get(6);
    }

    /**
     * Setter for <code>tlmt.portfolio_changes_extended.old_status_value</code>.
     */
    public void setOldStatusValue(Integer value) {
        set(7, value);
    }

    /**
     * Getter for <code>tlmt.portfolio_changes_extended.old_status_value</code>.
     */
    public Integer getOldStatusValue() {
        return (Integer) get(7);
    }

    /**
     * Setter for
     * <code>tlmt.portfolio_changes_extended.rechts_status_value</code>.
     */
    public void setRechtsStatusValue(Integer value) {
        set(8, value);
    }

    /**
     * Getter for
     * <code>tlmt.portfolio_changes_extended.rechts_status_value</code>.
     */
    public Integer getRechtsStatusValue() {
        return (Integer) get(8);
    }

    /**
     * Setter for <code>tlmt.portfolio_changes_extended.distance</code>.
     */
    public void setDistance(Long value) {
        set(9, value);
    }

    /**
     * Getter for <code>tlmt.portfolio_changes_extended.distance</code>.
     */
    public Long getDistance() {
        return (Long) get(9);
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached PortfolioChangesExtendedRecord
     */
    public PortfolioChangesExtendedRecord() {
        super(PortfolioChangesExtended.PORTFOLIO_CHANGES_EXTENDED);
    }

    /**
     * Create a detached, initialised PortfolioChangesExtendedRecord
     */
    public PortfolioChangesExtendedRecord(Long id, String name, String oldVersion, String oldStatus, String newStatus, String newVersion, Boolean newPublished, Integer oldStatusValue, Integer rechtsStatusValue, Long distance) {
        super(PortfolioChangesExtended.PORTFOLIO_CHANGES_EXTENDED);

        setId(id);
        setName(name);
        setOldVersion(oldVersion);
        setOldStatus(oldStatus);
        setNewStatus(newStatus);
        setNewVersion(newVersion);
        setNewPublished(newPublished);
        setOldStatusValue(oldStatusValue);
        setRechtsStatusValue(rechtsStatusValue);
        setDistance(distance);
        resetChangedOnNotNull();
    }
}
