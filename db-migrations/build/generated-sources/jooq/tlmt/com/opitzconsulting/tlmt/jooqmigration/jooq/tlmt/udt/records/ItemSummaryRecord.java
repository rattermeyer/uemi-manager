/*
 * This file is generated by jOOQ.
 */
package com.opitzconsulting.tlmt.jooqmigration.jooq.tlmt.udt.records;


import com.opitzconsulting.tlmt.jooqmigration.jooq.tlmt.udt.ItemSummary;

import java.util.UUID;

import org.jooq.impl.UDTRecordImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes", "this-escape" })
public class ItemSummaryRecord extends UDTRecordImpl<ItemSummaryRecord> {

    private static final long serialVersionUID = 1L;

    /**
     * Setter for <code>tlmt.item_summary.name</code>.
     */
    public void setName(String value) {
        set(0, value);
    }

    /**
     * Getter for <code>tlmt.item_summary.name</code>.
     */
    public String getName() {
        return (String) get(0);
    }

    /**
     * Setter for <code>tlmt.item_summary.uuid</code>.
     */
    public void setUuid(UUID value) {
        set(1, value);
    }

    /**
     * Getter for <code>tlmt.item_summary.uuid</code>.
     */
    public UUID getUuid() {
        return (UUID) get(1);
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached ItemSummaryRecord
     */
    public ItemSummaryRecord() {
        super(ItemSummary.ITEM_SUMMARY);
    }

    /**
     * Create a detached, initialised ItemSummaryRecord
     */
    public ItemSummaryRecord(String name, UUID uuid) {
        super(ItemSummary.ITEM_SUMMARY);

        setName(name);
        setUuid(uuid);
        resetChangedOnNotNull();
    }
}
