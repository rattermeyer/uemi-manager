/*
 * This file is generated by jOOQ.
 */
package com.opitzconsulting.tlmt.jooqmigration.jooq.tlmt.udt;


import com.opitzconsulting.tlmt.jooqmigration.jooq.tlmt.Tlmt;
import com.opitzconsulting.tlmt.jooqmigration.jooq.tlmt.udt.records.ItemSummaryRecord;

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
public class ItemSummary extends UDTImpl<ItemSummaryRecord> {

    private static final long serialVersionUID = 1L;

    /**
     * The reference instance of <code>tlmt.item_summary</code>
     */
    public static final ItemSummary ITEM_SUMMARY = new ItemSummary();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<ItemSummaryRecord> getRecordType() {
        return ItemSummaryRecord.class;
    }

    /**
     * The attribute <code>tlmt.item_summary.name</code>.
     */
    public static final UDTField<ItemSummaryRecord, String> NAME = createField(DSL.name("name"), SQLDataType.CLOB, ITEM_SUMMARY, "");

    /**
     * The attribute <code>tlmt.item_summary.uuid</code>.
     */
    public static final UDTField<ItemSummaryRecord, java.util.UUID> UUID = createField(DSL.name("uuid"), SQLDataType.UUID, ITEM_SUMMARY, "");

    /**
     * No further instances allowed
     */
    private ItemSummary() {
        super(DSL.name("item_summary"), null, null, false);
    }

    @Override
    public Schema getSchema() {
        return Tlmt.TLMT != null ? Tlmt.TLMT : new SchemaImpl(DSL.name("tlmt"));
    }
}
