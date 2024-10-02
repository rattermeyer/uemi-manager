/*
 * This file is generated by jOOQ.
 */
package com.opitzconsulting.tlmt.jooqmigration.jooq.extensions.tables.records;


import com.opitzconsulting.tlmt.jooqmigration.jooq.extensions.tables.Each;

import org.jooq.impl.TableRecordImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes", "this-escape" })
public class EachRecord extends TableRecordImpl<EachRecord> {

    private static final long serialVersionUID = 1L;

    /**
     * Setter for <code>extensions.each.key</code>.
     */
    public void setKey(String value) {
        set(0, value);
    }

    /**
     * Getter for <code>extensions.each.key</code>.
     */
    public String getKey() {
        return (String) get(0);
    }

    /**
     * Setter for <code>extensions.each.value</code>.
     */
    public void setValue(String value) {
        set(1, value);
    }

    /**
     * Getter for <code>extensions.each.value</code>.
     */
    public String getValue() {
        return (String) get(1);
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached EachRecord
     */
    public EachRecord() {
        super(Each.EACH);
    }

    /**
     * Create a detached, initialised EachRecord
     */
    public EachRecord(String key, String value) {
        super(Each.EACH);

        setKey(key);
        setValue(value);
        resetChangedOnNotNull();
    }
}
