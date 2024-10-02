/*
 * This file is generated by jOOQ.
 */
package com.opitzconsulting.tlmt.jooqmigration.jooq.tlmt.tables;


import com.opitzconsulting.tlmt.jooqmigration.jooq.tlmt.Tlmt;
import com.opitzconsulting.tlmt.jooqmigration.jooq.tlmt.tables.records.PortfolioitemStatusHistoryRecord;

import java.util.Collection;

import org.jooq.Condition;
import org.jooq.Field;
import org.jooq.Name;
import org.jooq.PlainSQL;
import org.jooq.QueryPart;
import org.jooq.SQL;
import org.jooq.Schema;
import org.jooq.Select;
import org.jooq.Stringly;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.TableOptions;
import org.jooq.impl.DSL;
import org.jooq.impl.SQLDataType;
import org.jooq.impl.TableImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes", "this-escape" })
public class PortfolioitemStatusHistory extends TableImpl<PortfolioitemStatusHistoryRecord> {

    private static final long serialVersionUID = 1L;

    /**
     * The reference instance of <code>tlmt.portfolioitem_status_history</code>
     */
    public static final PortfolioitemStatusHistory PORTFOLIOITEM_STATUS_HISTORY = new PortfolioitemStatusHistory();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<PortfolioitemStatusHistoryRecord> getRecordType() {
        return PortfolioitemStatusHistoryRecord.class;
    }

    /**
     * The column
     * <code>tlmt.portfolioitem_status_history.portfolioitem_id</code>.
     */
    public final TableField<PortfolioitemStatusHistoryRecord, Long> PORTFOLIOITEM_ID = createField(DSL.name("portfolioitem_id"), SQLDataType.BIGINT, this, "");

    /**
     * The column
     * <code>tlmt.portfolioitem_status_history.portfolio_version_id</code>.
     */
    public final TableField<PortfolioitemStatusHistoryRecord, Long> PORTFOLIO_VERSION_ID = createField(DSL.name("portfolio_version_id"), SQLDataType.BIGINT, this, "");

    /**
     * The column
     * <code>tlmt.portfolioitem_status_history.portfolio_version</code>.
     */
    public final TableField<PortfolioitemStatusHistoryRecord, String> PORTFOLIO_VERSION = createField(DSL.name("portfolio_version"), SQLDataType.VARCHAR(255), this, "");

    /**
     * The column
     * <code>tlmt.portfolioitem_status_history.status_change_id</code>.
     */
    public final TableField<PortfolioitemStatusHistoryRecord, Long> STATUS_CHANGE_ID = createField(DSL.name("status_change_id"), SQLDataType.BIGINT, this, "");

    /**
     * The column <code>tlmt.portfolioitem_status_history.new_status</code>.
     */
    public final TableField<PortfolioitemStatusHistoryRecord, String> NEW_STATUS = createField(DSL.name("new_status"), SQLDataType.VARCHAR(32), this, "");

    /**
     * The column <code>tlmt.portfolioitem_status_history.reason</code>.
     */
    public final TableField<PortfolioitemStatusHistoryRecord, String> REASON = createField(DSL.name("reason"), SQLDataType.VARCHAR(255), this, "");

    private PortfolioitemStatusHistory(Name alias, Table<PortfolioitemStatusHistoryRecord> aliased) {
        this(alias, aliased, (Field<?>[]) null, null);
    }

    private PortfolioitemStatusHistory(Name alias, Table<PortfolioitemStatusHistoryRecord> aliased, Field<?>[] parameters, Condition where) {
        super(alias, null, aliased, parameters, DSL.comment(""), TableOptions.view("""
        create view "portfolioitem_status_history" as  SELECT DISTINCT n.portfolioitem_id,
          t.id AS portfolio_version_id,
          t.version AS portfolio_version,
          n.id AS status_change_id,
          n.new_status,
          n.reason
         FROM ((tlmt.statuschange n
           LEFT JOIN tlmt.statuschange p ON (((n.portfolioitem_id = p.portfolioitem_id) AND (n.portfolio_version_id = p.portfolio_version_id) AND (n."timestamp" > p."timestamp"))))
           JOIN tlmt.portfolio_version t ON ((n.portfolio_version_id = t.id)))
        WHERE (p."timestamp" IS NULL);
        """), where);
    }

    /**
     * Create an aliased <code>tlmt.portfolioitem_status_history</code> table
     * reference
     */
    public PortfolioitemStatusHistory(String alias) {
        this(DSL.name(alias), PORTFOLIOITEM_STATUS_HISTORY);
    }

    /**
     * Create an aliased <code>tlmt.portfolioitem_status_history</code> table
     * reference
     */
    public PortfolioitemStatusHistory(Name alias) {
        this(alias, PORTFOLIOITEM_STATUS_HISTORY);
    }

    /**
     * Create a <code>tlmt.portfolioitem_status_history</code> table reference
     */
    public PortfolioitemStatusHistory() {
        this(DSL.name("portfolioitem_status_history"), null);
    }

    @Override
    public Schema getSchema() {
        return aliased() ? null : Tlmt.TLMT;
    }

    @Override
    public PortfolioitemStatusHistory as(String alias) {
        return new PortfolioitemStatusHistory(DSL.name(alias), this);
    }

    @Override
    public PortfolioitemStatusHistory as(Name alias) {
        return new PortfolioitemStatusHistory(alias, this);
    }

    @Override
    public PortfolioitemStatusHistory as(Table<?> alias) {
        return new PortfolioitemStatusHistory(alias.getQualifiedName(), this);
    }

    /**
     * Rename this table
     */
    @Override
    public PortfolioitemStatusHistory rename(String name) {
        return new PortfolioitemStatusHistory(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public PortfolioitemStatusHistory rename(Name name) {
        return new PortfolioitemStatusHistory(name, null);
    }

    /**
     * Rename this table
     */
    @Override
    public PortfolioitemStatusHistory rename(Table<?> name) {
        return new PortfolioitemStatusHistory(name.getQualifiedName(), null);
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    public PortfolioitemStatusHistory where(Condition condition) {
        return new PortfolioitemStatusHistory(getQualifiedName(), aliased() ? this : null, null, condition);
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    public PortfolioitemStatusHistory where(Collection<? extends Condition> conditions) {
        return where(DSL.and(conditions));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    public PortfolioitemStatusHistory where(Condition... conditions) {
        return where(DSL.and(conditions));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    public PortfolioitemStatusHistory where(Field<Boolean> condition) {
        return where(DSL.condition(condition));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    @PlainSQL
    public PortfolioitemStatusHistory where(SQL condition) {
        return where(DSL.condition(condition));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    @PlainSQL
    public PortfolioitemStatusHistory where(@Stringly.SQL String condition) {
        return where(DSL.condition(condition));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    @PlainSQL
    public PortfolioitemStatusHistory where(@Stringly.SQL String condition, Object... binds) {
        return where(DSL.condition(condition, binds));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    @PlainSQL
    public PortfolioitemStatusHistory where(@Stringly.SQL String condition, QueryPart... parts) {
        return where(DSL.condition(condition, parts));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    public PortfolioitemStatusHistory whereExists(Select<?> select) {
        return where(DSL.exists(select));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    public PortfolioitemStatusHistory whereNotExists(Select<?> select) {
        return where(DSL.notExists(select));
    }
}
