/*
 * This file is generated by jOOQ.
 */
package com.opitzconsulting.tlmt.jooqmigration.jooq.tlmt.tables;


import com.opitzconsulting.tlmt.jooqmigration.jooq.tlmt.Keys;
import com.opitzconsulting.tlmt.jooqmigration.jooq.tlmt.Tlmt;
import com.opitzconsulting.tlmt.jooqmigration.jooq.tlmt.enums.EJoblevel;
import com.opitzconsulting.tlmt.jooqmigration.jooq.tlmt.enums.ERegion;
import com.opitzconsulting.tlmt.jooqmigration.jooq.tlmt.tables.Skill.SkillPath;
import com.opitzconsulting.tlmt.jooqmigration.jooq.tlmt.tables.records.SkillDistributionRecord;

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
public class SkillDistribution extends TableImpl<SkillDistributionRecord> {

    private static final long serialVersionUID = 1L;

    /**
     * The reference instance of <code>tlmt.skill_distribution</code>
     */
    public static final SkillDistribution SKILL_DISTRIBUTION = new SkillDistribution();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<SkillDistributionRecord> getRecordType() {
        return SkillDistributionRecord.class;
    }

    /**
     * The column <code>tlmt.skill_distribution.id</code>.
     */
    public final TableField<SkillDistributionRecord, Long> ID = createField(DSL.name("id"), SQLDataType.BIGINT.nullable(false), this, "");

    /**
     * The column <code>tlmt.skill_distribution.skill_id</code>.
     */
    public final TableField<SkillDistributionRecord, Long> SKILL_ID = createField(DSL.name("skill_id"), SQLDataType.BIGINT, this, "");

    /**
     * The column <code>tlmt.skill_distribution.region</code>.
     */
    public final TableField<SkillDistributionRecord, ERegion> REGION = createField(DSL.name("region"), SQLDataType.VARCHAR.asEnumDataType(ERegion.class), this, "");

    /**
     * The column <code>tlmt.skill_distribution.skill</code>.
     */
    public final TableField<SkillDistributionRecord, String> SKILL = createField(DSL.name("skill"), SQLDataType.VARCHAR(128), this, "");

    /**
     * The column <code>tlmt.skill_distribution.joblevel</code>.
     */
    public final TableField<SkillDistributionRecord, EJoblevel> JOBLEVEL = createField(DSL.name("joblevel"), SQLDataType.VARCHAR.asEnumDataType(EJoblevel.class), this, "");

    /**
     * The column <code>tlmt.skill_distribution.skill_level</code>.
     */
    public final TableField<SkillDistributionRecord, Integer> SKILL_LEVEL = createField(DSL.name("skill_level"), SQLDataType.INTEGER, this, "");

    /**
     * The column <code>tlmt.skill_distribution.count</code>.
     */
    public final TableField<SkillDistributionRecord, Long> COUNT = createField(DSL.name("count"), SQLDataType.BIGINT, this, "");

    private SkillDistribution(Name alias, Table<SkillDistributionRecord> aliased) {
        this(alias, aliased, (Field<?>[]) null, null);
    }

    private SkillDistribution(Name alias, Table<SkillDistributionRecord> aliased, Field<?>[] parameters, Condition where) {
        super(alias, null, aliased, parameters, DSL.comment(""), TableOptions.table(), where);
    }

    /**
     * Create an aliased <code>tlmt.skill_distribution</code> table reference
     */
    public SkillDistribution(String alias) {
        this(DSL.name(alias), SKILL_DISTRIBUTION);
    }

    /**
     * Create an aliased <code>tlmt.skill_distribution</code> table reference
     */
    public SkillDistribution(Name alias) {
        this(alias, SKILL_DISTRIBUTION);
    }

    /**
     * Create a <code>tlmt.skill_distribution</code> table reference
     */
    public SkillDistribution() {
        this(DSL.name("skill_distribution"), null);
    }

    public <O extends Record> SkillDistribution(Table<O> path, ForeignKey<O, SkillDistributionRecord> childPath, InverseForeignKey<O, SkillDistributionRecord> parentPath) {
        super(path, childPath, parentPath, SKILL_DISTRIBUTION);
    }

    /**
     * A subtype implementing {@link Path} for simplified path-based joins.
     */
    public static class SkillDistributionPath extends SkillDistribution implements Path<SkillDistributionRecord> {

        private static final long serialVersionUID = 1L;
        public <O extends Record> SkillDistributionPath(Table<O> path, ForeignKey<O, SkillDistributionRecord> childPath, InverseForeignKey<O, SkillDistributionRecord> parentPath) {
            super(path, childPath, parentPath);
        }
        private SkillDistributionPath(Name alias, Table<SkillDistributionRecord> aliased) {
            super(alias, aliased);
        }

        @Override
        public SkillDistributionPath as(String alias) {
            return new SkillDistributionPath(DSL.name(alias), this);
        }

        @Override
        public SkillDistributionPath as(Name alias) {
            return new SkillDistributionPath(alias, this);
        }

        @Override
        public SkillDistributionPath as(Table<?> alias) {
            return new SkillDistributionPath(alias.getQualifiedName(), this);
        }
    }

    @Override
    public Schema getSchema() {
        return aliased() ? null : Tlmt.TLMT;
    }

    @Override
    public UniqueKey<SkillDistributionRecord> getPrimaryKey() {
        return Keys.SKILL_ASSESSMENT_PKEY;
    }

    @Override
    public List<ForeignKey<SkillDistributionRecord, ?>> getReferences() {
        return Arrays.asList(Keys.SKILL_DISTRIBUTION__SKILL_DISTRIBUTION_SKILL_ID_FKEY);
    }

    private transient SkillPath _skill;

    /**
     * Get the implicit join path to the <code>tlmt.skill</code> table.
     */
    public SkillPath skill() {
        if (_skill == null)
            _skill = new SkillPath(this, Keys.SKILL_DISTRIBUTION__SKILL_DISTRIBUTION_SKILL_ID_FKEY, null);

        return _skill;
    }

    @Override
    public SkillDistribution as(String alias) {
        return new SkillDistribution(DSL.name(alias), this);
    }

    @Override
    public SkillDistribution as(Name alias) {
        return new SkillDistribution(alias, this);
    }

    @Override
    public SkillDistribution as(Table<?> alias) {
        return new SkillDistribution(alias.getQualifiedName(), this);
    }

    /**
     * Rename this table
     */
    @Override
    public SkillDistribution rename(String name) {
        return new SkillDistribution(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public SkillDistribution rename(Name name) {
        return new SkillDistribution(name, null);
    }

    /**
     * Rename this table
     */
    @Override
    public SkillDistribution rename(Table<?> name) {
        return new SkillDistribution(name.getQualifiedName(), null);
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    public SkillDistribution where(Condition condition) {
        return new SkillDistribution(getQualifiedName(), aliased() ? this : null, null, condition);
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    public SkillDistribution where(Collection<? extends Condition> conditions) {
        return where(DSL.and(conditions));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    public SkillDistribution where(Condition... conditions) {
        return where(DSL.and(conditions));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    public SkillDistribution where(Field<Boolean> condition) {
        return where(DSL.condition(condition));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    @PlainSQL
    public SkillDistribution where(SQL condition) {
        return where(DSL.condition(condition));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    @PlainSQL
    public SkillDistribution where(@Stringly.SQL String condition) {
        return where(DSL.condition(condition));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    @PlainSQL
    public SkillDistribution where(@Stringly.SQL String condition, Object... binds) {
        return where(DSL.condition(condition, binds));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    @PlainSQL
    public SkillDistribution where(@Stringly.SQL String condition, QueryPart... parts) {
        return where(DSL.condition(condition, parts));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    public SkillDistribution whereExists(Select<?> select) {
        return where(DSL.exists(select));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    public SkillDistribution whereNotExists(Select<?> select) {
        return where(DSL.notExists(select));
    }
}
