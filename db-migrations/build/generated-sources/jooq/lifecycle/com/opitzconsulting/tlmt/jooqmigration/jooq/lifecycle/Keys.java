/*
 * This file is generated by jOOQ.
 */
package com.opitzconsulting.tlmt.jooqmigration.jooq.lifecycle;


import com.opitzconsulting.tlmt.jooqmigration.jooq.lifecycle.tables.LifecycleItem;
import com.opitzconsulting.tlmt.jooqmigration.jooq.lifecycle.tables.LifecycleItemLink;
import com.opitzconsulting.tlmt.jooqmigration.jooq.lifecycle.tables.Portfolio;
import com.opitzconsulting.tlmt.jooqmigration.jooq.lifecycle.tables.PortfolioItem;
import com.opitzconsulting.tlmt.jooqmigration.jooq.lifecycle.tables.SkillAssessment;
import com.opitzconsulting.tlmt.jooqmigration.jooq.lifecycle.tables.SkillDistribution;
import com.opitzconsulting.tlmt.jooqmigration.jooq.lifecycle.tables.Tag;
import com.opitzconsulting.tlmt.jooqmigration.jooq.lifecycle.tables.TagGroup;
import com.opitzconsulting.tlmt.jooqmigration.jooq.lifecycle.tables.records.LifecycleItemLinkRecord;
import com.opitzconsulting.tlmt.jooqmigration.jooq.lifecycle.tables.records.LifecycleItemRecord;
import com.opitzconsulting.tlmt.jooqmigration.jooq.lifecycle.tables.records.PortfolioItemRecord;
import com.opitzconsulting.tlmt.jooqmigration.jooq.lifecycle.tables.records.PortfolioRecord;
import com.opitzconsulting.tlmt.jooqmigration.jooq.lifecycle.tables.records.SkillAssessmentRecord;
import com.opitzconsulting.tlmt.jooqmigration.jooq.lifecycle.tables.records.SkillDistributionRecord;
import com.opitzconsulting.tlmt.jooqmigration.jooq.lifecycle.tables.records.TagGroupRecord;
import com.opitzconsulting.tlmt.jooqmigration.jooq.lifecycle.tables.records.TagRecord;

import org.jooq.ForeignKey;
import org.jooq.TableField;
import org.jooq.UniqueKey;
import org.jooq.impl.DSL;
import org.jooq.impl.Internal;


/**
 * A class modelling foreign key relationships and constraints of tables in
 * lifecycle.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes", "this-escape" })
public class Keys {

    // -------------------------------------------------------------------------
    // UNIQUE and PRIMARY KEY definitions
    // -------------------------------------------------------------------------

    public static final UniqueKey<LifecycleItemRecord> PK_LIFECYCLE_ITEM = Internal.createUniqueKey(LifecycleItem.LIFECYCLE_ITEM, DSL.name("pk_lifecycle_item"), new TableField[] { LifecycleItem.LIFECYCLE_ITEM.ID }, true);
    public static final UniqueKey<LifecycleItemRecord> UC_PORTFOLIO_ITEM_NAME = Internal.createUniqueKey(LifecycleItem.LIFECYCLE_ITEM, DSL.name("uc_portfolio_item_name"), new TableField[] { LifecycleItem.LIFECYCLE_ITEM.NAME }, true);
    public static final UniqueKey<LifecycleItemLinkRecord> PK_LIFECYCLE_ITEM_LINK = Internal.createUniqueKey(LifecycleItemLink.LIFECYCLE_ITEM_LINK, DSL.name("pk_lifecycle_item_link"), new TableField[] { LifecycleItemLink.LIFECYCLE_ITEM_LINK.LIFECYCLE_ITEM_ID, LifecycleItemLink.LIFECYCLE_ITEM_LINK.INDEX }, true);
    public static final UniqueKey<LifecycleItemLinkRecord> UC_PORTFOLIO_ITEM_LINK_NAME = Internal.createUniqueKey(LifecycleItemLink.LIFECYCLE_ITEM_LINK, DSL.name("uc_portfolio_item_link_name"), new TableField[] { LifecycleItemLink.LIFECYCLE_ITEM_LINK.LIFECYCLE_ITEM_ID, LifecycleItemLink.LIFECYCLE_ITEM_LINK.NAME }, true);
    public static final UniqueKey<PortfolioRecord> PK_PORTFOLIO = Internal.createUniqueKey(Portfolio.PORTFOLIO, DSL.name("pk_portfolio"), new TableField[] { Portfolio.PORTFOLIO.ID }, true);
    public static final UniqueKey<PortfolioItemRecord> PK_PORTFOLIO_ITEM = Internal.createUniqueKey(PortfolioItem.PORTFOLIO_ITEM, DSL.name("pk_portfolio_item"), new TableField[] { PortfolioItem.PORTFOLIO_ITEM.PORTFOLIO_ID, PortfolioItem.PORTFOLIO_ITEM.ITEM_NAME }, true);
    public static final UniqueKey<SkillDistributionRecord> PK_SKILL_DISTRIBUTION = Internal.createUniqueKey(SkillDistribution.SKILL_DISTRIBUTION, DSL.name("pk_skill_distribution"), new TableField[] { SkillDistribution.SKILL_DISTRIBUTION.ID }, true);
    public static final UniqueKey<TagRecord> PK_TAG = Internal.createUniqueKey(Tag.TAG, DSL.name("pk_tag"), new TableField[] { Tag.TAG.NAME }, true);
    public static final UniqueKey<TagGroupRecord> PK_TAG_GROUP = Internal.createUniqueKey(TagGroup.TAG_GROUP, DSL.name("pk_tag_group"), new TableField[] { TagGroup.TAG_GROUP.ID }, true);
    public static final UniqueKey<TagGroupRecord> UC_TAG_GROUP_TITLE = Internal.createUniqueKey(TagGroup.TAG_GROUP, DSL.name("uc_tag_group_title"), new TableField[] { TagGroup.TAG_GROUP.TITLE }, true);

    // -------------------------------------------------------------------------
    // FOREIGN KEY definitions
    // -------------------------------------------------------------------------

    public static final ForeignKey<LifecycleItemLinkRecord, LifecycleItemRecord> LIFECYCLE_ITEM_LINK__FK_LIFECYCLE_ITEM_LINK_ITEM = Internal.createForeignKey(LifecycleItemLink.LIFECYCLE_ITEM_LINK, DSL.name("fk_lifecycle_item_link_item"), new TableField[] { LifecycleItemLink.LIFECYCLE_ITEM_LINK.LIFECYCLE_ITEM_ID }, Keys.PK_LIFECYCLE_ITEM, new TableField[] { LifecycleItem.LIFECYCLE_ITEM.ID }, true);
    public static final ForeignKey<PortfolioItemRecord, PortfolioRecord> PORTFOLIO_ITEM__FK_PORTFOLIO_ITEM_PORTFOLIO = Internal.createForeignKey(PortfolioItem.PORTFOLIO_ITEM, DSL.name("fk_portfolio_item_portfolio"), new TableField[] { PortfolioItem.PORTFOLIO_ITEM.PORTFOLIO_ID }, Keys.PK_PORTFOLIO, new TableField[] { Portfolio.PORTFOLIO.ID }, true);
    public static final ForeignKey<SkillAssessmentRecord, SkillDistributionRecord> SKILL_ASSESSMENT__FK_SKILL_ASSESSMENT_DISTRIBUTION = Internal.createForeignKey(SkillAssessment.SKILL_ASSESSMENT, DSL.name("fk_skill_assessment_distribution"), new TableField[] { SkillAssessment.SKILL_ASSESSMENT.SKILL_DISTRIBUTION_ID }, Keys.PK_SKILL_DISTRIBUTION, new TableField[] { SkillDistribution.SKILL_DISTRIBUTION.ID }, true);
    public static final ForeignKey<TagRecord, TagGroupRecord> TAG__FK_TAG_TAG_GROUP = Internal.createForeignKey(Tag.TAG, DSL.name("fk_tag_tag_group"), new TableField[] { Tag.TAG.TAG_GROUP_ID }, Keys.PK_TAG_GROUP, new TableField[] { TagGroup.TAG_GROUP.ID }, true);
}
