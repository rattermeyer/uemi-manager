/*
 * This file is generated by jOOQ.
 */
package com.opitzconsulting.tlmt.jooqmigration.jooq.tlmt.tables;


import com.opitzconsulting.tlmt.jooqmigration.jooq.tlmt.Tlmt;
import com.opitzconsulting.tlmt.jooqmigration.jooq.tlmt.tables.records.TagDistributionRecord;

import java.util.Collection;

import org.jooq.Condition;
import org.jooq.Field;
import org.jooq.JSON;
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
public class TagDistribution extends TableImpl<TagDistributionRecord> {

    private static final long serialVersionUID = 1L;

    /**
     * The reference instance of <code>tlmt.tag_distribution</code>
     */
    public static final TagDistribution TAG_DISTRIBUTION = new TagDistribution();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<TagDistributionRecord> getRecordType() {
        return TagDistributionRecord.class;
    }

    /**
     * The column <code>tlmt.tag_distribution.name</code>.
     */
    public final TableField<TagDistributionRecord, String> NAME = createField(DSL.name("name"), SQLDataType.VARCHAR(255), this, "");

    /**
     * The column <code>tlmt.tag_distribution.value</code>.
     */
    public final TableField<TagDistributionRecord, Long> VALUE = createField(DSL.name("value"), SQLDataType.BIGINT, this, "");

    /**
     * The column <code>tlmt.tag_distribution.children</code>.
     */
    public final TableField<TagDistributionRecord, JSON> CHILDREN = createField(DSL.name("children"), SQLDataType.JSON, this, "");

    private TagDistribution(Name alias, Table<TagDistributionRecord> aliased) {
        this(alias, aliased, (Field<?>[]) null, null);
    }

    private TagDistribution(Name alias, Table<TagDistributionRecord> aliased, Field<?>[] parameters, Condition where) {
        super(alias, null, aliased, parameters, DSL.comment(""), TableOptions.view("""
        create view "tag_distribution" as  SELECT taggrouptitle AS name,
          taggroupcount AS value,
          json_agg(json_build_object('name', tag, 'value', tagcount)) AS children
         FROM ( WITH tags_aggregated AS (
                       SELECT tg_1.taggrouptitle,
                          tag.tag AS label,
                          count(*) AS count
                         FROM (((tlmt.portfolioitem
                           JOIN tlmt.portfolioitem_tag ON ((portfolioitem.id = portfolioitem_tag.portfolioitem_id)))
                           JOIN tlmt.tag ON ((portfolioitem_tag.tag_id = tag.id)))
                           JOIN tlmt.taggroup tg_1 ON ((tag.taggroupid = tg_1.id)))
                        GROUP BY tg_1.taggrouptitle, tag.tag
                      ), taggroup_aggregated AS (
                       SELECT qs.taggrouptitle AS label,
                          count(*) AS count
                         FROM tlmt.portfolio_item_qs qs
                        GROUP BY qs.taggrouptitle
                      )
               SELECT tg.taggrouptitle,
                  tga.count AS taggroupcount,
                  tg.label AS tag,
                  tg.count AS tagcount
                 FROM (taggroup_aggregated tga
                   JOIN tags_aggregated tg ON (((tga.label)::text = (tg.taggrouptitle)::text)))
                ORDER BY tg.taggrouptitle) r
        GROUP BY taggrouptitle, taggroupcount;
        """), where);
    }

    /**
     * Create an aliased <code>tlmt.tag_distribution</code> table reference
     */
    public TagDistribution(String alias) {
        this(DSL.name(alias), TAG_DISTRIBUTION);
    }

    /**
     * Create an aliased <code>tlmt.tag_distribution</code> table reference
     */
    public TagDistribution(Name alias) {
        this(alias, TAG_DISTRIBUTION);
    }

    /**
     * Create a <code>tlmt.tag_distribution</code> table reference
     */
    public TagDistribution() {
        this(DSL.name("tag_distribution"), null);
    }

    @Override
    public Schema getSchema() {
        return aliased() ? null : Tlmt.TLMT;
    }

    @Override
    public TagDistribution as(String alias) {
        return new TagDistribution(DSL.name(alias), this);
    }

    @Override
    public TagDistribution as(Name alias) {
        return new TagDistribution(alias, this);
    }

    @Override
    public TagDistribution as(Table<?> alias) {
        return new TagDistribution(alias.getQualifiedName(), this);
    }

    /**
     * Rename this table
     */
    @Override
    public TagDistribution rename(String name) {
        return new TagDistribution(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public TagDistribution rename(Name name) {
        return new TagDistribution(name, null);
    }

    /**
     * Rename this table
     */
    @Override
    public TagDistribution rename(Table<?> name) {
        return new TagDistribution(name.getQualifiedName(), null);
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    public TagDistribution where(Condition condition) {
        return new TagDistribution(getQualifiedName(), aliased() ? this : null, null, condition);
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    public TagDistribution where(Collection<? extends Condition> conditions) {
        return where(DSL.and(conditions));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    public TagDistribution where(Condition... conditions) {
        return where(DSL.and(conditions));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    public TagDistribution where(Field<Boolean> condition) {
        return where(DSL.condition(condition));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    @PlainSQL
    public TagDistribution where(SQL condition) {
        return where(DSL.condition(condition));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    @PlainSQL
    public TagDistribution where(@Stringly.SQL String condition) {
        return where(DSL.condition(condition));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    @PlainSQL
    public TagDistribution where(@Stringly.SQL String condition, Object... binds) {
        return where(DSL.condition(condition, binds));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    @PlainSQL
    public TagDistribution where(@Stringly.SQL String condition, QueryPart... parts) {
        return where(DSL.condition(condition, parts));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    public TagDistribution whereExists(Select<?> select) {
        return where(DSL.exists(select));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    public TagDistribution whereNotExists(Select<?> select) {
        return where(DSL.notExists(select));
    }
}
