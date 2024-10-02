/*
 * This file is generated by jOOQ.
 */
package com.opitzconsulting.tlmt.jooqmigration.jooq.extensions.udt;


import com.opitzconsulting.tlmt.jooqmigration.jooq.extensions.Extensions;
import com.opitzconsulting.tlmt.jooqmigration.jooq.extensions.udt.records.TablefuncCrosstab_4Record;

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
public class TablefuncCrosstab_4 extends UDTImpl<TablefuncCrosstab_4Record> {

    private static final long serialVersionUID = 1L;

    /**
     * The reference instance of <code>extensions.tablefunc_crosstab_4</code>
     */
    public static final TablefuncCrosstab_4 TABLEFUNC_CROSSTAB_4 = new TablefuncCrosstab_4();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<TablefuncCrosstab_4Record> getRecordType() {
        return TablefuncCrosstab_4Record.class;
    }

    /**
     * The attribute <code>extensions.tablefunc_crosstab_4.row_name</code>.
     */
    public static final UDTField<TablefuncCrosstab_4Record, String> ROW_NAME = createField(DSL.name("row_name"), SQLDataType.CLOB, TABLEFUNC_CROSSTAB_4, "");

    /**
     * The attribute <code>extensions.tablefunc_crosstab_4.category_1</code>.
     */
    public static final UDTField<TablefuncCrosstab_4Record, String> CATEGORY_1 = createField(DSL.name("category_1"), SQLDataType.CLOB, TABLEFUNC_CROSSTAB_4, "");

    /**
     * The attribute <code>extensions.tablefunc_crosstab_4.category_2</code>.
     */
    public static final UDTField<TablefuncCrosstab_4Record, String> CATEGORY_2 = createField(DSL.name("category_2"), SQLDataType.CLOB, TABLEFUNC_CROSSTAB_4, "");

    /**
     * The attribute <code>extensions.tablefunc_crosstab_4.category_3</code>.
     */
    public static final UDTField<TablefuncCrosstab_4Record, String> CATEGORY_3 = createField(DSL.name("category_3"), SQLDataType.CLOB, TABLEFUNC_CROSSTAB_4, "");

    /**
     * The attribute <code>extensions.tablefunc_crosstab_4.category_4</code>.
     */
    public static final UDTField<TablefuncCrosstab_4Record, String> CATEGORY_4 = createField(DSL.name("category_4"), SQLDataType.CLOB, TABLEFUNC_CROSSTAB_4, "");

    /**
     * No further instances allowed
     */
    private TablefuncCrosstab_4() {
        super(DSL.name("tablefunc_crosstab_4"), null, null, false);
    }

    @Override
    public Schema getSchema() {
        return Extensions.EXTENSIONS != null ? Extensions.EXTENSIONS : new SchemaImpl(DSL.name("extensions"));
    }
}
