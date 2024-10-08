/*
 * This file is generated by jOOQ.
 */
package com.opitzconsulting.tlmt.jooqmigration.jooq.extensions.udt;


import com.opitzconsulting.tlmt.jooqmigration.jooq.extensions.Extensions;
import com.opitzconsulting.tlmt.jooqmigration.jooq.extensions.udt.records.TablefuncCrosstab_2Record;

import org.jooq.Schema;
import org.jooq.UDTField;
import org.jooq.impl.DSL;
import org.jooq.impl.SQLDataType;
import org.jooq.impl.SchemaImpl;
import org.jooq.impl.UDTImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes", "this-escape" })
public class TablefuncCrosstab_2 extends UDTImpl<TablefuncCrosstab_2Record> {

    private static final long serialVersionUID = 1L;

    /**
     * The reference instance of <code>extensions.tablefunc_crosstab_2</code>
     */
    public static final TablefuncCrosstab_2 TABLEFUNC_CROSSTAB_2 = new TablefuncCrosstab_2();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<TablefuncCrosstab_2Record> getRecordType() {
        return TablefuncCrosstab_2Record.class;
    }

    /**
     * The attribute <code>extensions.tablefunc_crosstab_2.row_name</code>.
     */
    public static final UDTField<TablefuncCrosstab_2Record, String> ROW_NAME = createField(DSL.name("row_name"), SQLDataType.CLOB, TABLEFUNC_CROSSTAB_2, "");

    /**
     * The attribute <code>extensions.tablefunc_crosstab_2.category_1</code>.
     */
    public static final UDTField<TablefuncCrosstab_2Record, String> CATEGORY_1 = createField(DSL.name("category_1"), SQLDataType.CLOB, TABLEFUNC_CROSSTAB_2, "");

    /**
     * The attribute <code>extensions.tablefunc_crosstab_2.category_2</code>.
     */
    public static final UDTField<TablefuncCrosstab_2Record, String> CATEGORY_2 = createField(DSL.name("category_2"), SQLDataType.CLOB, TABLEFUNC_CROSSTAB_2, "");

    /**
     * No further instances allowed
     */
    private TablefuncCrosstab_2() {
        super(DSL.name("tablefunc_crosstab_2"), null, null, false);
    }

    @Override
    public Schema getSchema() {
        return Extensions.EXTENSIONS != null ? Extensions.EXTENSIONS : new SchemaImpl(DSL.name("extensions"));
    }
}
