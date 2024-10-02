/*
 * This file is generated by jOOQ.
 */
package com.opitzconsulting.tlmt.jooqmigration.jooq.lifecycle.tables;


import com.opitzconsulting.tlmt.jooqmigration.jooq.lifecycle.Keys;
import com.opitzconsulting.tlmt.jooqmigration.jooq.lifecycle.Lifecycle;
import com.opitzconsulting.tlmt.jooqmigration.jooq.lifecycle.tables.PortfolioItem.PortfolioItemPath;
import com.opitzconsulting.tlmt.jooqmigration.jooq.lifecycle.tables.records.PortfolioRecord;

import java.time.OffsetDateTime;
import java.util.Collection;

import org.jooq.Condition;
import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Identity;
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
public class Portfolio extends TableImpl<PortfolioRecord> {

    private static final long serialVersionUID = 1L;

    /**
     * The reference instance of <code>lifecycle.portfolio</code>
     */
    public static final Portfolio PORTFOLIO = new Portfolio();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<PortfolioRecord> getRecordType() {
        return PortfolioRecord.class;
    }

    /**
     * The column <code>lifecycle.portfolio.uuid</code>.
     */
    public final TableField<PortfolioRecord, java.util.UUID> UUID = createField(DSL.name("uuid"), SQLDataType.UUID.defaultValue(DSL.field(DSL.raw("extensions.uuid_generate_v4()"), SQLDataType.UUID)), this, "");

    /**
     * The column <code>lifecycle.portfolio.id</code>.
     */
    public final TableField<PortfolioRecord, Long> ID = createField(DSL.name("id"), SQLDataType.BIGINT.nullable(false).identity(true), this, "");

    /**
     * The column <code>lifecycle.portfolio.published</code>.
     */
    public final TableField<PortfolioRecord, Boolean> PUBLISHED = createField(DSL.name("published"), SQLDataType.BOOLEAN.nullable(false), this, "");

    /**
     * The column <code>lifecycle.portfolio.published_timestamp</code>.
     */
    public final TableField<PortfolioRecord, OffsetDateTime> PUBLISHED_TIMESTAMP = createField(DSL.name("published_timestamp"), SQLDataType.TIMESTAMPWITHTIMEZONE(6), this, "");

    /**
     * The column <code>lifecycle.portfolio.version</code>.
     */
    public final TableField<PortfolioRecord, String> VERSION = createField(DSL.name("version"), SQLDataType.VARCHAR(255), this, "");

    private Portfolio(Name alias, Table<PortfolioRecord> aliased) {
        this(alias, aliased, (Field<?>[]) null, null);
    }

    private Portfolio(Name alias, Table<PortfolioRecord> aliased, Field<?>[] parameters, Condition where) {
        super(alias, null, aliased, parameters, DSL.comment(""), TableOptions.table(), where);
    }

    /**
     * Create an aliased <code>lifecycle.portfolio</code> table reference
     */
    public Portfolio(String alias) {
        this(DSL.name(alias), PORTFOLIO);
    }

    /**
     * Create an aliased <code>lifecycle.portfolio</code> table reference
     */
    public Portfolio(Name alias) {
        this(alias, PORTFOLIO);
    }

    /**
     * Create a <code>lifecycle.portfolio</code> table reference
     */
    public Portfolio() {
        this(DSL.name("portfolio"), null);
    }

    public <O extends Record> Portfolio(Table<O> path, ForeignKey<O, PortfolioRecord> childPath, InverseForeignKey<O, PortfolioRecord> parentPath) {
        super(path, childPath, parentPath, PORTFOLIO);
    }

    /**
     * A subtype implementing {@link Path} for simplified path-based joins.
     */
    public static class PortfolioPath extends Portfolio implements Path<PortfolioRecord> {

        private static final long serialVersionUID = 1L;
        public <O extends Record> PortfolioPath(Table<O> path, ForeignKey<O, PortfolioRecord> childPath, InverseForeignKey<O, PortfolioRecord> parentPath) {
            super(path, childPath, parentPath);
        }
        private PortfolioPath(Name alias, Table<PortfolioRecord> aliased) {
            super(alias, aliased);
        }

        @Override
        public PortfolioPath as(String alias) {
            return new PortfolioPath(DSL.name(alias), this);
        }

        @Override
        public PortfolioPath as(Name alias) {
            return new PortfolioPath(alias, this);
        }

        @Override
        public PortfolioPath as(Table<?> alias) {
            return new PortfolioPath(alias.getQualifiedName(), this);
        }
    }

    @Override
    public Schema getSchema() {
        return aliased() ? null : Lifecycle.LIFECYCLE;
    }

    @Override
    public Identity<PortfolioRecord, Long> getIdentity() {
        return (Identity<PortfolioRecord, Long>) super.getIdentity();
    }

    @Override
    public UniqueKey<PortfolioRecord> getPrimaryKey() {
        return Keys.PK_PORTFOLIO;
    }

    private transient PortfolioItemPath _portfolioItem;

    /**
     * Get the implicit to-many join path to the
     * <code>lifecycle.portfolio_item</code> table
     */
    public PortfolioItemPath portfolioItem() {
        if (_portfolioItem == null)
            _portfolioItem = new PortfolioItemPath(this, null, Keys.PORTFOLIO_ITEM__FK_PORTFOLIO_ITEM_PORTFOLIO.getInverseKey());

        return _portfolioItem;
    }

    @Override
    public Portfolio as(String alias) {
        return new Portfolio(DSL.name(alias), this);
    }

    @Override
    public Portfolio as(Name alias) {
        return new Portfolio(alias, this);
    }

    @Override
    public Portfolio as(Table<?> alias) {
        return new Portfolio(alias.getQualifiedName(), this);
    }

    /**
     * Rename this table
     */
    @Override
    public Portfolio rename(String name) {
        return new Portfolio(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public Portfolio rename(Name name) {
        return new Portfolio(name, null);
    }

    /**
     * Rename this table
     */
    @Override
    public Portfolio rename(Table<?> name) {
        return new Portfolio(name.getQualifiedName(), null);
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    public Portfolio where(Condition condition) {
        return new Portfolio(getQualifiedName(), aliased() ? this : null, null, condition);
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    public Portfolio where(Collection<? extends Condition> conditions) {
        return where(DSL.and(conditions));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    public Portfolio where(Condition... conditions) {
        return where(DSL.and(conditions));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    public Portfolio where(Field<Boolean> condition) {
        return where(DSL.condition(condition));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    @PlainSQL
    public Portfolio where(SQL condition) {
        return where(DSL.condition(condition));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    @PlainSQL
    public Portfolio where(@Stringly.SQL String condition) {
        return where(DSL.condition(condition));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    @PlainSQL
    public Portfolio where(@Stringly.SQL String condition, Object... binds) {
        return where(DSL.condition(condition, binds));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    @PlainSQL
    public Portfolio where(@Stringly.SQL String condition, QueryPart... parts) {
        return where(DSL.condition(condition, parts));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    public Portfolio whereExists(Select<?> select) {
        return where(DSL.exists(select));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    public Portfolio whereNotExists(Select<?> select) {
        return where(DSL.notExists(select));
    }
}
