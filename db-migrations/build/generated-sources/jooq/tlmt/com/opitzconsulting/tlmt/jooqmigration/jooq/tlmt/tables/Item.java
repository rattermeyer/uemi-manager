/*
 * This file is generated by jOOQ.
 */
package com.opitzconsulting.tlmt.jooqmigration.jooq.tlmt.tables;


import com.opitzconsulting.tlmt.jooqmigration.jooq.tlmt.Keys;
import com.opitzconsulting.tlmt.jooqmigration.jooq.tlmt.Tlmt;
import com.opitzconsulting.tlmt.jooqmigration.jooq.tlmt.enums.EItemType;
import com.opitzconsulting.tlmt.jooqmigration.jooq.tlmt.tables.ItemProcess.ItemProcessPath;
import com.opitzconsulting.tlmt.jooqmigration.jooq.tlmt.tables.records.ItemRecord;

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
public class Item extends TableImpl<ItemRecord> {

    private static final long serialVersionUID = 1L;

    /**
     * The reference instance of <code>tlmt.item</code>
     */
    public static final Item ITEM = new Item();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<ItemRecord> getRecordType() {
        return ItemRecord.class;
    }

    /**
     * The column <code>tlmt.item.id</code>.
     */
    public final TableField<ItemRecord, Long> ID = createField(DSL.name("id"), SQLDataType.BIGINT.nullable(false), this, "");

    /**
     * The column <code>tlmt.item.name</code>.
     */
    public final TableField<ItemRecord, String> NAME = createField(DSL.name("name"), SQLDataType.VARCHAR(128).nullable(false), this, "");

    /**
     * The column <code>tlmt.item.type</code>.
     */
    public final TableField<ItemRecord, EItemType> TYPE = createField(DSL.name("type"), SQLDataType.VARCHAR.asEnumDataType(EItemType.class), this, "");

    /**
     * The column <code>tlmt.item.name_aliases</code>.
     */
    public final TableField<ItemRecord, String[]> NAME_ALIASES = createField(DSL.name("name_aliases"), SQLDataType.CLOB.array(), this, "");

    /**
     * The column <code>tlmt.item.created_at</code>.
     */
    public final TableField<ItemRecord, OffsetDateTime> CREATED_AT = createField(DSL.name("created_at"), SQLDataType.TIMESTAMPWITHTIMEZONE(6), this, "");

    /**
     * The column <code>tlmt.item.last_updated</code>.
     */
    public final TableField<ItemRecord, OffsetDateTime> LAST_UPDATED = createField(DSL.name("last_updated"), SQLDataType.TIMESTAMPWITHTIMEZONE(6), this, "");

    /**
     * The column <code>tlmt.item.updated_by</code>.
     */
    public final TableField<ItemRecord, String> UPDATED_BY = createField(DSL.name("updated_by"), SQLDataType.VARCHAR(64), this, "");

    /**
     * The column <code>tlmt.item.description</code>.
     */
    public final TableField<ItemRecord, String> DESCRIPTION = createField(DSL.name("description"), SQLDataType.VARCHAR(1024), this, "");

    /**
     * The column <code>tlmt.item.uuid</code>.
     */
    public final TableField<ItemRecord, java.util.UUID> UUID = createField(DSL.name("uuid"), SQLDataType.UUID.nullable(false).defaultValue(DSL.field(DSL.raw("extensions.uuid_generate_v4()"), SQLDataType.UUID)), this, "");

    private Item(Name alias, Table<ItemRecord> aliased) {
        this(alias, aliased, (Field<?>[]) null, null);
    }

    private Item(Name alias, Table<ItemRecord> aliased, Field<?>[] parameters, Condition where) {
        super(alias, null, aliased, parameters, DSL.comment(""), TableOptions.table(), where);
    }

    /**
     * Create an aliased <code>tlmt.item</code> table reference
     */
    public Item(String alias) {
        this(DSL.name(alias), ITEM);
    }

    /**
     * Create an aliased <code>tlmt.item</code> table reference
     */
    public Item(Name alias) {
        this(alias, ITEM);
    }

    /**
     * Create a <code>tlmt.item</code> table reference
     */
    public Item() {
        this(DSL.name("item"), null);
    }

    public <O extends Record> Item(Table<O> path, ForeignKey<O, ItemRecord> childPath, InverseForeignKey<O, ItemRecord> parentPath) {
        super(path, childPath, parentPath, ITEM);
    }

    /**
     * A subtype implementing {@link Path} for simplified path-based joins.
     */
    public static class ItemPath extends Item implements Path<ItemRecord> {

        private static final long serialVersionUID = 1L;
        public <O extends Record> ItemPath(Table<O> path, ForeignKey<O, ItemRecord> childPath, InverseForeignKey<O, ItemRecord> parentPath) {
            super(path, childPath, parentPath);
        }
        private ItemPath(Name alias, Table<ItemRecord> aliased) {
            super(alias, aliased);
        }

        @Override
        public ItemPath as(String alias) {
            return new ItemPath(DSL.name(alias), this);
        }

        @Override
        public ItemPath as(Name alias) {
            return new ItemPath(alias, this);
        }

        @Override
        public ItemPath as(Table<?> alias) {
            return new ItemPath(alias.getQualifiedName(), this);
        }
    }

    @Override
    public Schema getSchema() {
        return aliased() ? null : Tlmt.TLMT;
    }

    @Override
    public UniqueKey<ItemRecord> getPrimaryKey() {
        return Keys.ITEM_PKEY;
    }

    @Override
    public List<UniqueKey<ItemRecord>> getUniqueKeys() {
        return Arrays.asList(Keys.ITEM_NAME_UNIQUE, Keys.ITEM_UUID_UNIQUE);
    }

    private transient ItemProcessPath _itemProcess;

    /**
     * Get the implicit to-many join path to the <code>tlmt.item_process</code>
     * table
     */
    public ItemProcessPath itemProcess() {
        if (_itemProcess == null)
            _itemProcess = new ItemProcessPath(this, null, Keys.ITEM_PROCESS__ITEM_PROCESS_ITEM_ID_FKEY.getInverseKey());

        return _itemProcess;
    }

    @Override
    public Item as(String alias) {
        return new Item(DSL.name(alias), this);
    }

    @Override
    public Item as(Name alias) {
        return new Item(alias, this);
    }

    @Override
    public Item as(Table<?> alias) {
        return new Item(alias.getQualifiedName(), this);
    }

    /**
     * Rename this table
     */
    @Override
    public Item rename(String name) {
        return new Item(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public Item rename(Name name) {
        return new Item(name, null);
    }

    /**
     * Rename this table
     */
    @Override
    public Item rename(Table<?> name) {
        return new Item(name.getQualifiedName(), null);
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    public Item where(Condition condition) {
        return new Item(getQualifiedName(), aliased() ? this : null, null, condition);
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    public Item where(Collection<? extends Condition> conditions) {
        return where(DSL.and(conditions));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    public Item where(Condition... conditions) {
        return where(DSL.and(conditions));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    public Item where(Field<Boolean> condition) {
        return where(DSL.condition(condition));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    @PlainSQL
    public Item where(SQL condition) {
        return where(DSL.condition(condition));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    @PlainSQL
    public Item where(@Stringly.SQL String condition) {
        return where(DSL.condition(condition));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    @PlainSQL
    public Item where(@Stringly.SQL String condition, Object... binds) {
        return where(DSL.condition(condition, binds));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    @PlainSQL
    public Item where(@Stringly.SQL String condition, QueryPart... parts) {
        return where(DSL.condition(condition, parts));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    public Item whereExists(Select<?> select) {
        return where(DSL.exists(select));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    public Item whereNotExists(Select<?> select) {
        return where(DSL.notExists(select));
    }
}
