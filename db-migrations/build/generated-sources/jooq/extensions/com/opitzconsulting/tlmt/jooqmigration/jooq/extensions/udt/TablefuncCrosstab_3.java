/*
 * This file is generated by jOOQ.
 */
package com.opitzconsulting.tlmt.jooqmigration.jooq.extensions.udt;


import com.opitzconsulting.tlmt.jooqmigration.jooq.extensions.Extensions;
import com.opitzconsulting.tlmt.jooqmigration.jooq.extensions.udt.records.TablefuncCrosstab_3Record;

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
public class TablefuncCrosstab_3 extends UDTImpl<TablefuncCrosstab_3Record> {

    private static final long serialVersionUID = 1L;

    /**
     * The reference instance of <code>extensions.tablefunc_crosstab_3</code>
     */
    public static final TablefuncCrosstab_3 TABLEFUNC_CROSSTAB_3 = new TablefuncCrosstab_3();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<TablefuncCrosstab_3Record> getRecordType() {
        return TablefuncCrosstab_3Record.class;
    }

    /**
     * The attribute <code>extensions.tablefunc_crosstab_3.row_name</code>.
     */
    public static final UDTField<TablefuncCrosstab_3Record, String> ROW_NAME = createField(DSL.name("row_name"), SQLDataType.CLOB, TABLEFUNC_CROSSTAB_3, "");

    /**
     * The attribute <code>extensions.tablefunc_crosstab_3.category_1</code>.
     */
    public static final UDTField<TablefuncCrosstab_3Record, String> CATEGORY_1 = createField(DSL.name("category_1"), SQLDataType.CLOB, TABLEFUNC_CROSSTAB_3, "");

    /**
     * The attribute <code>extensions.tablefunc_crosstab_3.category_2</code>.
     */
    public static final UDTField<TablefuncCrosstab_3Record, String> CATEGORY_2 = createField(DSL.name("category_2"), SQLDataType.CLOB, TABLEFUNC_CROSSTAB_3, "");

    /**
     * The attribute <code>extensions.tablefunc_crosstab_3.category_3</code>.
     */
    public static final UDTField<TablefuncCrosstab_3Record, String> CATEGORY_3 = createField(DSL.name("category_3"), SQLDataType.CLOB, TABLEFUNC_CROSSTAB_3, "");

    /**
     * No further instances allowed
     */
    private TablefuncCrosstab_3() {
        super(DSL.name("tablefunc_crosstab_3"), null, null, false);
    }

    @Override
    public Schema getSchema() {
        return Extensions.EXTENSIONS != null ? Extensions.EXTENSIONS : new SchemaImpl(DSL.name("extensions"));
    }
}
