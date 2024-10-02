/*
 * This file is generated by jOOQ.
 */
package com.opitzconsulting.tlmt.jooqmigration.jooq.tlmt.tables;


import com.opitzconsulting.tlmt.jooqmigration.jooq.tlmt.Keys;
import com.opitzconsulting.tlmt.jooqmigration.jooq.tlmt.Tlmt;
import com.opitzconsulting.tlmt.jooqmigration.jooq.tlmt.enums.EProcessStatus;
import com.opitzconsulting.tlmt.jooqmigration.jooq.tlmt.tables.ItemProcess.ItemProcessPath;
import com.opitzconsulting.tlmt.jooqmigration.jooq.tlmt.tables.records.ItemProcessChangeRecord;

import java.time.OffsetDateTime;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.jooq.Condition;
import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.InverseForeignKey;
import org.jooq.Name;
import org.jooq.Path;
import org.jooq.PlainSQL;
import org.jooq.QueryPart;
import org.jooq.Record;
import org.jooq.SQL;
import org.jooq.Schema;
import org.jooq.Select;
import org.jooq.Stringly;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.TableOptions;
import org.jooq.UniqueKey;
import org.jooq.impl.DSL;
import org.jooq.impl.SQLDataType;
import org.jooq.impl.TableImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes", "this-escape" })
public class ItemProcessChange extends TableImpl<ItemProcessChangeRecord> {

    private static final long serialVersionUID = 1L;

    /**
     * The reference instance of <code>tlmt.item_process_change</code>
     */
    public static final ItemProcessChange ITEM_PROCESS_CHANGE = new ItemProcessChange();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<ItemProcessChangeRecord> getRecordType() {
        return ItemProcessChangeRecord.class;
    }

    /**
     * The column <code>tlmt.item_process_change.id</code>.
     */
    public final TableField<ItemProcessChangeRecord, Long> ID = createField(DSL.name("id"), SQLDataType.BIGINT.nullable(false), this, "");

    /**
     * The column <code>tlmt.item_process_change.process_id</code>.
     */
    public final TableField<ItemProcessChangeRecord, Long> PROCESS_ID = createField(DSL.name("process_id"), SQLDataType.BIGINT.nullable(false), this, "");

    /**
     * The column <code>tlmt.item_process_change.reason</code>.
     */
    public final TableField<ItemProcessChangeRecord, String> REASON = createField(DSL.name("reason"), SQLDataType.VARCHAR(1024).nullable(false), this, "");

    /**
     * The column <code>tlmt.item_process_change.process_status</code>.
     */
    public final TableField<ItemProcessChangeRecord, EProcessStatus> PROCESS_STATUS = createField(DSL.name("process_status"), SQLDataType.VARCHAR.asEnumDataType(EProcessStatus.class), this, "");

    /**
     * The column <code>tlmt.item_process_change.created_at</code>.
     */
    public final TableField<ItemProcessChangeRecord, OffsetDateTime> CREATED_AT = createField(DSL.name("created_at"), SQLDataType.TIMESTAMPWITHTIMEZONE(6).defaultValue(DSL.field(DSL.raw("statement_timestamp()"), SQLDataType.TIMESTAMPWITHTIMEZONE)), this, "");

    /**
     * The column <code>tlmt.item_process_change.last_updated</code>.
     */
    public final TableField<ItemProcessChangeRecord, OffsetDateTime> LAST_UPDATED = createField(DSL.name("last_updated"), SQLDataType.TIMESTAMPWITHTIMEZONE(6), this, "");

    /**
     * The column <code>tlmt.item_process_change.updated_by</code>.
     */
    public final TableField<ItemProcessChangeRecord, String> UPDATED_BY = createField(DSL.name("updated_by"), SQLDataType.VARCHAR(64), this, "");

    private ItemProcessChange(Name alias, Table<ItemProcessChangeRecord> aliased) {
        this(alias, aliased, (Field<?>[]) null, null);
    }

    private ItemProcessChange(Name alias, Table<ItemProcessChangeRecord> aliased, Field<?>[] parameters, Condition where) {
        super(alias, null, aliased, parameters, DSL.comment(""), TableOptions.table(), where);
    }

    /**
     * Create an aliased <code>tlmt.item_process_change</code> table reference
     */
    public ItemProcessChange(String alias) {
        this(DSL.name(alias), ITEM_PROCESS_CHANGE);
    }

    /**
     * Create an aliased <code>tlmt.item_process_change</code> table reference
     */
    public ItemProcessChange(Name alias) {
        this(alias, ITEM_PROCESS_CHANGE);
    }

    /**
     * Create a <code>tlmt.item_process_change</code> table reference
     */
    public ItemProcessChange() {
        this(DSL.name("item_process_change"), null);
    }

    public <O extends Record> ItemProcessChange(Table<O> path, ForeignKey<O, ItemProcessChangeRecord> childPath, InverseForeignKey<O, ItemProcessChangeRecord> parentPath) {
        super(path, childPath, parentPath, ITEM_PROCESS_CHANGE);
    }

    /**
     * A subtype implementing {@link Path} for simplified path-based joins.
     */
    public static class ItemProcessChangePath extends ItemProcessChange implements Path<ItemProcessChangeRecord> {

        private static final long serialVersionUID = 1L;
        public <O extends Record> ItemProcessChangePath(Table<O> path, ForeignKey<O, ItemProcessChangeRecord> childPath, InverseForeignKey<O, ItemProcessChangeRecord> parentPath) {
            super(path, childPath, parentPath);
        }
        private ItemProcessChangePath(Name alias, Table<ItemProcessChangeRecord> aliased) {
            super(alias, aliased);
        }

        @Override
        public ItemProcessChangePath as(String alias) {
            return new ItemProcessChangePath(DSL.name(alias), this);
        }

        @Override
        public ItemProcessChangePath as(Name alias) {
            return new ItemProcessChangePath(alias, this);
        }

        @Override
        public ItemProcessChangePath as(Table<?> alias) {
            return new ItemProcessChangePath(alias.getQualifiedName(), this);
        }
    }

    @Override
    public Schema getSchema() {
        return aliased() ? null : Tlmt.TLMT;
    }

    @Override
    public UniqueKey<ItemProcessChangeRecord> getPrimaryKey() {
        return Keys.ITEM_PROCESS_CHANGE_PKEY;
    }

    @Override
    public List<ForeignKey<ItemProcessChangeRecord, ?>> getReferences() {
        return Arrays.asList(Keys.ITEM_PROCESS_CHANGE__ITEM_PROCESS_CHANGE_PROCESS_ID_FKEY);
    }

    private transient ItemProcessPath _itemProcess;

    /**
     * Get the implicit join path to the <code>tlmt.item_process</code> table.
     */
    public ItemProcessPath itemProcess() {
        if (_itemProcess == null)
            _itemProcess = new ItemProcessPath(this, Keys.ITEM_PROCESS_CHANGE__ITEM_PROCESS_CHANGE_PROCESS_ID_FKEY, null);

        return _itemProcess;
    }

    @Override
    public ItemProcessChange as(String alias) {
        return new ItemProcessChange(DSL.name(alias), this);
    }

    @Override
    public ItemProcessChange as(Name alias) {
        return new ItemProcessChange(alias, this);
    }

    @Override
    public ItemProcessChange as(Table<?> alias) {
        return new ItemProcessChange(alias.getQualifiedName(), this);
    }

    /**
     * Rename this table
     */
    @Override
    public ItemProcessChange rename(String name) {
        return new ItemProcessChange(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public ItemProcessChange rename(Name name) {
        return new ItemProcessChange(name, null);
    }

    /**
     * Rename this table
     */
    @Override
    public ItemProcessChange rename(Table<?> name) {
        return new ItemProcessChange(name.getQualifiedName(), null);
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    public ItemProcessChange where(Condition condition) {
        return new ItemProcessChange(getQualifiedName(), aliased() ? this : null, null, condition);
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    public ItemProcessChange where(Collection<? extends Condition> conditions) {
        return where(DSL.and(conditions));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    public ItemProcessChange where(Condition... conditions) {
        return where(DSL.and(conditions));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    public ItemProcessChange where(Field<Boolean> condition) {
        return where(DSL.condition(condition));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    @PlainSQL
    public ItemProcessChange where(SQL condition) {
        return where(DSL.condition(condition));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    @PlainSQL
    public ItemProcessChange where(@Stringly.SQL String condition) {
        return where(DSL.condition(condition));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    @PlainSQL
    public ItemProcessChange where(@Stringly.SQL String condition, Object... binds) {
        return where(DSL.condition(condition, binds));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    @PlainSQL
    public ItemProcessChange where(@Stringly.SQL String condition, QueryPart... parts) {
        return where(DSL.condition(condition, parts));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    public ItemProcessChange whereExists(Select<?> select) {
        return where(DSL.exists(select));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    public ItemProcessChange whereNotExists(Select<?> select) {
        return where(DSL.notExists(select));
    }
}
