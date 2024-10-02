/*
 * This file is generated by jOOQ.
 */
package com.opitzconsulting.tlmt.jooqmigration.jooq.tlmt.tables;


import com.opitzconsulting.tlmt.jooqmigration.jooq.tlmt.Keys;
import com.opitzconsulting.tlmt.jooqmigration.jooq.tlmt.Tlmt;
import com.opitzconsulting.tlmt.jooqmigration.jooq.tlmt.tables.records.PortfolioitemAssessmentRecord;

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
import org.jooq.UniqueKey;
import org.jooq.impl.DSL;
import org.jooq.impl.SQLDataType;
import org.jooq.impl.TableImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes", "this-escape" })
public class PortfolioitemAssessment extends TableImpl<PortfolioitemAssessmentRecord> {

    private static final long serialVersionUID = 1L;

    /**
     * The reference instance of <code>tlmt.portfolioitem_assessment</code>
     */
    public static final PortfolioitemAssessment PORTFOLIOITEM_ASSESSMENT = new PortfolioitemAssessment();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<PortfolioitemAssessmentRecord> getRecordType() {
        return PortfolioitemAssessmentRecord.class;
    }

    /**
     * The column <code>tlmt.portfolioitem_assessment.id</code>.
     */
    public final TableField<PortfolioitemAssessmentRecord, Long> ID = createField(DSL.name("id"), SQLDataType.BIGINT.nullable(false), this, "");

    /**
     * The column <code>tlmt.portfolioitem_assessment.four_stars</code>.
     */
    public final TableField<PortfolioitemAssessmentRecord, Integer> FOUR_STARS = createField(DSL.name("four_stars"), SQLDataType.INTEGER, this, "");

    /**
     * The column <code>tlmt.portfolioitem_assessment.portfolioitem_id</code>.
     */
    public final TableField<PortfolioitemAssessmentRecord, Long> PORTFOLIOITEM_ID = createField(DSL.name("portfolioitem_id"), SQLDataType.BIGINT, this, "");

    /**
     * The column <code>tlmt.portfolioitem_assessment.portfolioitem_name</code>.
     */
    public final TableField<PortfolioitemAssessmentRecord, String> PORTFOLIOITEM_NAME = createField(DSL.name("portfolioitem_name"), SQLDataType.VARCHAR(64), this, "");

    /**
     * The column <code>tlmt.portfolioitem_assessment.joblevel</code>.
     */
    public final TableField<PortfolioitemAssessmentRecord, String> JOBLEVEL = createField(DSL.name("joblevel"), SQLDataType.VARCHAR(32), this, "");

    /**
     * The column <code>tlmt.portfolioitem_assessment.one_star</code>.
     */
    public final TableField<PortfolioitemAssessmentRecord, Integer> ONE_STAR = createField(DSL.name("one_star"), SQLDataType.INTEGER, this, "");

    /**
     * The column <code>tlmt.portfolioitem_assessment.three_stars</code>.
     */
    public final TableField<PortfolioitemAssessmentRecord, Integer> THREE_STARS = createField(DSL.name("three_stars"), SQLDataType.INTEGER, this, "");

    /**
     * The column <code>tlmt.portfolioitem_assessment.two_stars</code>.
     */
    public final TableField<PortfolioitemAssessmentRecord, Integer> TWO_STARS = createField(DSL.name("two_stars"), SQLDataType.INTEGER, this, "");

    /**
     * The column <code>tlmt.portfolioitem_assessment.radar_id</code>.
     */
    public final TableField<PortfolioitemAssessmentRecord, Long> RADAR_ID = createField(DSL.name("radar_id"), SQLDataType.BIGINT, this, "");

    private PortfolioitemAssessment(Name alias, Table<PortfolioitemAssessmentRecord> aliased) {
        this(alias, aliased, (Field<?>[]) null, null);
    }

    private PortfolioitemAssessment(Name alias, Table<PortfolioitemAssessmentRecord> aliased, Field<?>[] parameters, Condition where) {
        super(alias, null, aliased, parameters, DSL.comment(""), TableOptions.table(), where);
    }

    /**
     * Create an aliased <code>tlmt.portfolioitem_assessment</code> table
     * reference
     */
    public PortfolioitemAssessment(String alias) {
        this(DSL.name(alias), PORTFOLIOITEM_ASSESSMENT);
    }

    /**
     * Create an aliased <code>tlmt.portfolioitem_assessment</code> table
     * reference
     */
    public PortfolioitemAssessment(Name alias) {
        this(alias, PORTFOLIOITEM_ASSESSMENT);
    }

    /**
     * Create a <code>tlmt.portfolioitem_assessment</code> table reference
     */
    public PortfolioitemAssessment() {
        this(DSL.name("portfolioitem_assessment"), null);
    }

    @Override
    public Schema getSchema() {
        return aliased() ? null : Tlmt.TLMT;
    }

    @Override
    public UniqueKey<PortfolioitemAssessmentRecord> getPrimaryKey() {
        return Keys.PORTFOLIOITEM_ASSESSMENT_PKEY;
    }

    @Override
    public PortfolioitemAssessment as(String alias) {
        return new PortfolioitemAssessment(DSL.name(alias), this);
    }

    @Override
    public PortfolioitemAssessment as(Name alias) {
        return new PortfolioitemAssessment(alias, this);
    }

    @Override
    public PortfolioitemAssessment as(Table<?> alias) {
        return new PortfolioitemAssessment(alias.getQualifiedName(), this);
    }

    /**
     * Rename this table
     */
    @Override
    public PortfolioitemAssessment rename(String name) {
        return new PortfolioitemAssessment(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public PortfolioitemAssessment rename(Name name) {
        return new PortfolioitemAssessment(name, null);
    }

    /**
     * Rename this table
     */
    @Override
    public PortfolioitemAssessment rename(Table<?> name) {
        return new PortfolioitemAssessment(name.getQualifiedName(), null);
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    public PortfolioitemAssessment where(Condition condition) {
        return new PortfolioitemAssessment(getQualifiedName(), aliased() ? this : null, null, condition);
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    public PortfolioitemAssessment where(Collection<? extends Condition> conditions) {
        return where(DSL.and(conditions));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    public PortfolioitemAssessment where(Condition... conditions) {
        return where(DSL.and(conditions));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    public PortfolioitemAssessment where(Field<Boolean> condition) {
        return where(DSL.condition(condition));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    @PlainSQL
    public PortfolioitemAssessment where(SQL condition) {
        return where(DSL.condition(condition));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    @PlainSQL
    public PortfolioitemAssessment where(@Stringly.SQL String condition) {
        return where(DSL.condition(condition));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    @PlainSQL
    public PortfolioitemAssessment where(@Stringly.SQL String condition, Object... binds) {
        return where(DSL.condition(condition, binds));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    @PlainSQL
    public PortfolioitemAssessment where(@Stringly.SQL String condition, QueryPart... parts) {
        return where(DSL.condition(condition, parts));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    public PortfolioitemAssessment whereExists(Select<?> select) {
        return where(DSL.exists(select));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    public PortfolioitemAssessment whereNotExists(Select<?> select) {
        return where(DSL.notExists(select));
    }
}
