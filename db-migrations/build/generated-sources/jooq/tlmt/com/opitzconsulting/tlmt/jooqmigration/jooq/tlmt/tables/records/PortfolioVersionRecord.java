/*
 * This file is generated by jOOQ.
 */
package com.opitzconsulting.tlmt.jooqmigration.jooq.tlmt.tables.records;


import com.opitzconsulting.tlmt.jooqmigration.jooq.tlmt.tables.PortfolioVersion;

import java.time.OffsetDateTime;
import java.util.UUID;

import org.jooq.Record1;
import org.jooq.impl.UpdatableRecordImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes", "this-escape" })
public class PortfolioVersionRecord extends UpdatableRecordImpl<PortfolioVersionRecord> {

    private static final long serialVersionUID = 1L;

    /**
     * Setter for <code>tlmt.portfolio_version.id</code>.
     */
    public void setId(Long value) {
        set(0, value);
    }

    /**
     * Getter for <code>tlmt.portfolio_version.id</code>.
     */
    public Long getId() {
        return (Long) get(0);
    }

    /**
     * Setter for <code>tlmt.portfolio_version.published</code>.
     */
    public void setPublished(Boolean value) {
        set(1, value);
    }

    /**
     * Getter for <code>tlmt.portfolio_version.published</code>.
     */
    public Boolean getPublished() {
        return (Boolean) get(1);
    }

    /**
     * Setter for <code>tlmt.portfolio_version.published_timestamp</code>.
     */
    public void setPublishedTimestamp(OffsetDateTime value) {
        set(2, value);
    }

    /**
     * Getter for <code>tlmt.portfolio_version.published_timestamp</code>.
     */
    public OffsetDateTime getPublishedTimestamp() {
        return (OffsetDateTime) get(2);
    }

    /**
     * Setter for <code>tlmt.portfolio_version.uuid</code>.
     */
    public void setUuid(UUID value) {
        set(3, value);
    }

    /**
     * Getter for <code>tlmt.portfolio_version.uuid</code>.
     */
    public UUID getUuid() {
        return (UUID) get(3);
    }

    /**
     * Setter for <code>tlmt.portfolio_version.version</code>.
     */
    public void setVersion(String value) {
        set(4, value);
    }

    /**
     * Getter for <code>tlmt.portfolio_version.version</code>.
     */
    public String getVersion() {
        return (String) get(4);
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
     * Create a detached PortfolioVersionRecord
     */
    public PortfolioVersionRecord() {
        super(PortfolioVersion.PORTFOLIO_VERSION);
    }

    /**
     * Create a detached, initialised PortfolioVersionRecord
     */
    public PortfolioVersionRecord(Long id, Boolean published, OffsetDateTime publishedTimestamp, UUID uuid, String version) {
        super(PortfolioVersion.PORTFOLIO_VERSION);

        setId(id);
        setPublished(published);
        setPublishedTimestamp(publishedTimestamp);
        setUuid(uuid);
        setVersion(version);
        resetChangedOnNotNull();
    }
}
