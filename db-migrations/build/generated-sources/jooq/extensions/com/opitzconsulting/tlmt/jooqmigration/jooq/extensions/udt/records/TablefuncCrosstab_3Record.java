/*
 * This file is generated by jOOQ.
 */
package com.opitzconsulting.tlmt.jooqmigration.jooq.extensions.udt.records;


import com.opitzconsulting.tlmt.jooqmigration.jooq.extensions.udt.TablefuncCrosstab_3;

import org.jooq.impl.UDTRecordImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes", "this-escape" })
public class TablefuncCrosstab_3Record extends UDTRecordImpl<TablefuncCrosstab_3Record> {

    private static final long serialVersionUID = 1L;

    /**
     * Setter for <code>extensions.tablefunc_crosstab_3.row_name</code>.
     */
    public void setRowName(String value) {
        set(0, value);
    }

    /**
     * Getter for <code>extensions.tablefunc_crosstab_3.row_name</code>.
     */
    public String getRowName() {
        return (String) get(0);
    }

    /**
     * Setter for <code>extensions.tablefunc_crosstab_3.category_1</code>.
     */
    public void setCategory_1(String value) {
        set(1, value);
    }

    /**
     * Getter for <code>extensions.tablefunc_crosstab_3.category_1</code>.
     */
    public String getCategory_1() {
        return (String) get(1);
    }

    /**
     * Setter for <code>extensions.tablefunc_crosstab_3.category_2</code>.
     */
    public void setCategory_2(String value) {
        set(2, value);
    }

    /**
     * Getter for <code>extensions.tablefunc_crosstab_3.category_2</code>.
     */
    public String getCategory_2() {
        return (String) get(2);
    }

    /**
     * Setter for <code>extensions.tablefunc_crosstab_3.category_3</code>.
     */
    public void setCategory_3(String value) {
        set(3, value);
    }

    /**
     * Getter for <code>extensions.tablefunc_crosstab_3.category_3</code>.
     */
    public String getCategory_3() {
        return (String) get(3);
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached TablefuncCrosstab_3Record
     */
    public TablefuncCrosstab_3Record() {
        super(TablefuncCrosstab_3.TABLEFUNC_CROSSTAB_3);
    }

    /**
     * Create a detached, initialised TablefuncCrosstab_3Record
     */
    public TablefuncCrosstab_3Record(String rowName, String category_1, String category_2, String category_3) {
        super(TablefuncCrosstab_3.TABLEFUNC_CROSSTAB_3);

        setRowName(rowName);
        setCategory_1(category_1);
        setCategory_2(category_2);
        setCategory_3(category_3);
        resetChangedOnNotNull();
    }
}
