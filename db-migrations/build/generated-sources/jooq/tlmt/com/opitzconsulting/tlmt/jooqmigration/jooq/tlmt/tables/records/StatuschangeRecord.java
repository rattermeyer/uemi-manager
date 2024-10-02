/*
 * This file is generated by jOOQ.
 */
package com.opitzconsulting.tlmt.jooqmigration.jooq.tlmt.tables.records;


import com.opitzconsulting.tlmt.jooqmigration.jooq.tlmt.tables.Statuschange;

import java.time.OffsetDateTime;
import java.util.UUID;

import org.jooq.Record1;
import org.jooq.impl.UpdatableRecordImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes", "this-escape" })
public class StatuschangeRecord extends UpdatableRecordImpl<StatuschangeRecord> {

    private static final long serialVersionUID = 1L;

    /**
     * Setter for <code>tlmt.statuschange.id</code>.
     */
    public void setId(Long value) {
        set(0, value);
    }

    /**
     * Getter for <code>tlmt.statuschange.id</code>.
     */
    public Long getId() {
        return (Long) get(0);
    }

    /**
     * Setter for <code>tlmt.statuschange.new_status</code>.
     */
    public void setNewStatus(String value) {
        set(1, value);
    }

    /**
     * Getter for <code>tlmt.statuschange.new_status</code>.
     */
    public String getNewStatus() {
        return (String) get(1);
    }

    /**
     * Setter for <code>tlmt.statuschange.reason</code>.
     */
    public void setReason(String value) {
        set(2, value);
    }

    /**
     * Getter for <code>tlmt.statuschange.reason</code>.
     */
    public String getReason() {
        return (String) get(2);
    }

    /**
     * Setter for <code>tlmt.statuschange.timestamp</code>.
     */
    public void setTimestamp(OffsetDateTime value) {
        set(3, value);
    }

    /**
     * Getter for <code>tlmt.statuschange.timestamp</code>.
     */
    public OffsetDateTime getTimestamp() {
        return (OffsetDateTime) get(3);
    }

    /**
     * Setter for <code>tlmt.statuschange.portfolioitem_id</code>.
     */
    public void setPortfolioitemId(Long value) {
        set(4, value);
    }

    /**
     * Getter for <code>tlmt.statuschange.portfolioitem_id</code>.
     */
    public Long getPortfolioitemId() {
        return (Long) get(4);
    }

    /**
     * Setter for <code>tlmt.statuschange.portfolio_version_id</code>.
     */
    public void setPortfolioVersionId(Long value) {
        set(5, value);
    }

    /**
     * Getter for <code>tlmt.statuschange.portfolio_version_id</code>.
     */
    public Long getPortfolioVersionId() {
        return (Long) get(5);
    }

    /**
     * Setter for <code>tlmt.statuschange.portfolio_version_uuid</code>.
     */
    public void setPortfolioVersionUuid(UUID value) {
        set(6, value);
    }

    /**
     * Getter for <code>tlmt.statuschange.portfolio_version_uuid</code>.
     */
    public UUID getPortfolioVersionUuid() {
        return (UUID) get(6);
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
     * Create a detached StatuschangeRecord
     */
    public StatuschangeRecord() {
        super(Statuschange.STATUSCHANGE);
    }

    /**
     * Create a detached, initialised StatuschangeRecord
     */
    public StatuschangeRecord(Long id, String newStatus, String reason, OffsetDateTime timestamp, Long portfolioitemId, Long portfolioVersionId, UUID portfolioVersionUuid) {
        super(Statuschange.STATUSCHANGE);

        setId(id);
        setNewStatus(newStatus);
        setReason(reason);
        setTimestamp(timestamp);
        setPortfolioitemId(portfolioitemId);
        setPortfolioVersionId(portfolioVersionId);
        setPortfolioVersionUuid(portfolioVersionUuid);
        resetChangedOnNotNull();
    }
}
