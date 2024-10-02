/*
 * This file is generated by jOOQ.
 */
package com.opitzconsulting.tlmt.jooqmigration.jooq.extensions.tables.records;


import com.opitzconsulting.tlmt.jooqmigration.jooq.extensions.tables.PgStatStatementsInfo;

import java.time.OffsetDateTime;

import org.jooq.impl.TableRecordImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes", "this-escape" })
public class PgStatStatementsInfoRecord extends TableRecordImpl<PgStatStatementsInfoRecord> {

    private static final long serialVersionUID = 1L;

    /**
     * Setter for <code>extensions.pg_stat_statements_info.dealloc</code>.
     */
    public void setDealloc(Long value) {
        set(0, value);
    }

    /**
     * Getter for <code>extensions.pg_stat_statements_info.dealloc</code>.
     */
    public Long getDealloc() {
        return (Long) get(0);
    }

    /**
     * Setter for <code>extensions.pg_stat_statements_info.stats_reset</code>.
     */
    public void setStatsReset(OffsetDateTime value) {
        set(1, value);
    }

    /**
     * Getter for <code>extensions.pg_stat_statements_info.stats_reset</code>.
     */
    public OffsetDateTime getStatsReset() {
        return (OffsetDateTime) get(1);
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached PgStatStatementsInfoRecord
     */
    public PgStatStatementsInfoRecord() {
        super(PgStatStatementsInfo.PG_STAT_STATEMENTS_INFO);
    }

    /**
     * Create a detached, initialised PgStatStatementsInfoRecord
     */
    public PgStatStatementsInfoRecord(Long dealloc, OffsetDateTime statsReset) {
        super(PgStatStatementsInfo.PG_STAT_STATEMENTS_INFO);

        setDealloc(dealloc);
        setStatsReset(statsReset);
        resetChangedOnNotNull();
    }
}
