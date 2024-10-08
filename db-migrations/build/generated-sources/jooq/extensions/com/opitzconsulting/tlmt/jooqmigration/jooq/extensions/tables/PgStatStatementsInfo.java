/*
 * This file is generated by jOOQ.
 */
package com.opitzconsulting.tlmt.jooqmigration.jooq.extensions.tables;


import com.opitzconsulting.tlmt.jooqmigration.jooq.extensions.Extensions;
import com.opitzconsulting.tlmt.jooqmigration.jooq.extensions.tables.records.PgStatStatementsInfoRecord;

import java.time.OffsetDateTime;
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
public class PgStatStatementsInfo extends TableImpl<PgStatStatementsInfoRecord> {

    private static final long serialVersionUID = 1L;

    /**
     * The reference instance of <code>extensions.pg_stat_statements_info</code>
     */
    public static final PgStatStatementsInfo PG_STAT_STATEMENTS_INFO = new PgStatStatementsInfo();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<PgStatStatementsInfoRecord> getRecordType() {
        return PgStatStatementsInfoRecord.class;
    }

    /**
     * The column <code>extensions.pg_stat_statements_info.dealloc</code>.
     */
    public final TableField<PgStatStatementsInfoRecord, Long> DEALLOC = createField(DSL.name("dealloc"), SQLDataType.BIGINT, this, "");

    /**
     * The column <code>extensions.pg_stat_statements_info.stats_reset</code>.
     */
    public final TableField<PgStatStatementsInfoRecord, OffsetDateTime> STATS_RESET = createField(DSL.name("stats_reset"), SQLDataType.TIMESTAMPWITHTIMEZONE(6), this, "");

    private PgStatStatementsInfo(Name alias, Table<PgStatStatementsInfoRecord> aliased) {
        this(alias, aliased, (Field<?>[]) null, null);
    }

    private PgStatStatementsInfo(Name alias, Table<PgStatStatementsInfoRecord> aliased, Field<?>[] parameters, Condition where) {
        super(alias, null, aliased, parameters, DSL.comment(""), TableOptions.view("""
        create view "pg_stat_statements_info" as  SELECT dealloc,
         stats_reset
        FROM extensions.pg_stat_statements_info() pg_stat_statements_info(dealloc, stats_reset);
        """), where);
    }

    /**
     * Create an aliased <code>extensions.pg_stat_statements_info</code> table
     * reference
     */
    public PgStatStatementsInfo(String alias) {
        this(DSL.name(alias), PG_STAT_STATEMENTS_INFO);
    }

    /**
     * Create an aliased <code>extensions.pg_stat_statements_info</code> table
     * reference
     */
    public PgStatStatementsInfo(Name alias) {
        this(alias, PG_STAT_STATEMENTS_INFO);
    }

    /**
     * Create a <code>extensions.pg_stat_statements_info</code> table reference
     */
    public PgStatStatementsInfo() {
        this(DSL.name("pg_stat_statements_info"), null);
    }

    @Override
    public Schema getSchema() {
        return aliased() ? null : Extensions.EXTENSIONS;
    }

    @Override
    public PgStatStatementsInfo as(String alias) {
        return new PgStatStatementsInfo(DSL.name(alias), this);
    }

    @Override
    public PgStatStatementsInfo as(Name alias) {
        return new PgStatStatementsInfo(alias, this);
    }

    @Override
    public PgStatStatementsInfo as(Table<?> alias) {
        return new PgStatStatementsInfo(alias.getQualifiedName(), this);
    }

    /**
     * Rename this table
     */
    @Override
    public PgStatStatementsInfo rename(String name) {
        return new PgStatStatementsInfo(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public PgStatStatementsInfo rename(Name name) {
        return new PgStatStatementsInfo(name, null);
    }

    /**
     * Rename this table
     */
    @Override
    public PgStatStatementsInfo rename(Table<?> name) {
        return new PgStatStatementsInfo(name.getQualifiedName(), null);
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    public PgStatStatementsInfo where(Condition condition) {
        return new PgStatStatementsInfo(getQualifiedName(), aliased() ? this : null, null, condition);
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    public PgStatStatementsInfo where(Collection<? extends Condition> conditions) {
        return where(DSL.and(conditions));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    public PgStatStatementsInfo where(Condition... conditions) {
        return where(DSL.and(conditions));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    public PgStatStatementsInfo where(Field<Boolean> condition) {
        return where(DSL.condition(condition));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    @PlainSQL
    public PgStatStatementsInfo where(SQL condition) {
        return where(DSL.condition(condition));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    @PlainSQL
    public PgStatStatementsInfo where(@Stringly.SQL String condition) {
        return where(DSL.condition(condition));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    @PlainSQL
    public PgStatStatementsInfo where(@Stringly.SQL String condition, Object... binds) {
        return where(DSL.condition(condition, binds));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    @PlainSQL
    public PgStatStatementsInfo where(@Stringly.SQL String condition, QueryPart... parts) {
        return where(DSL.condition(condition, parts));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    public PgStatStatementsInfo whereExists(Select<?> select) {
        return where(DSL.exists(select));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    public PgStatStatementsInfo whereNotExists(Select<?> select) {
        return where(DSL.notExists(select));
    }
}
