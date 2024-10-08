/*
 * This file is generated by jOOQ.
 */
package com.opitzconsulting.tlmt.jooqmigration.jooq.tlmt;


import com.opitzconsulting.tlmt.jooqmigration.jooq.tlmt.tables.FlywaySchemaHistory;
import com.opitzconsulting.tlmt.jooqmigration.jooq.tlmt.tables.Item;
import com.opitzconsulting.tlmt.jooqmigration.jooq.tlmt.tables.ItemLink;
import com.opitzconsulting.tlmt.jooqmigration.jooq.tlmt.tables.ItemProcess;
import com.opitzconsulting.tlmt.jooqmigration.jooq.tlmt.tables.ItemProcessChange;
import com.opitzconsulting.tlmt.jooqmigration.jooq.tlmt.tables.JobLevelMapping;
import com.opitzconsulting.tlmt.jooqmigration.jooq.tlmt.tables.LatestStatusChangeView;
import com.opitzconsulting.tlmt.jooqmigration.jooq.tlmt.tables.Mergehistory;
import com.opitzconsulting.tlmt.jooqmigration.jooq.tlmt.tables.Outbox;
import com.opitzconsulting.tlmt.jooqmigration.jooq.tlmt.tables.PortfolioChanges;
import com.opitzconsulting.tlmt.jooqmigration.jooq.tlmt.tables.PortfolioChangesExtended;
import com.opitzconsulting.tlmt.jooqmigration.jooq.tlmt.tables.PortfolioDevOpsCount;
import com.opitzconsulting.tlmt.jooqmigration.jooq.tlmt.tables.PortfolioItemQs;
import com.opitzconsulting.tlmt.jooqmigration.jooq.tlmt.tables.PortfolioVersion;
import com.opitzconsulting.tlmt.jooqmigration.jooq.tlmt.tables.Portfolioitem;
import com.opitzconsulting.tlmt.jooqmigration.jooq.tlmt.tables.PortfolioitemActive;
import com.opitzconsulting.tlmt.jooqmigration.jooq.tlmt.tables.PortfolioitemAssessment;
import com.opitzconsulting.tlmt.jooqmigration.jooq.tlmt.tables.PortfolioitemAssessmentOverview;
import com.opitzconsulting.tlmt.jooqmigration.jooq.tlmt.tables.PortfolioitemAssessmentTransposed;
import com.opitzconsulting.tlmt.jooqmigration.jooq.tlmt.tables.PortfolioitemAssessmentView;
import com.opitzconsulting.tlmt.jooqmigration.jooq.tlmt.tables.PortfolioitemCountByStatus;
import com.opitzconsulting.tlmt.jooqmigration.jooq.tlmt.tables.PortfolioitemQsWithTags;
import com.opitzconsulting.tlmt.jooqmigration.jooq.tlmt.tables.PortfolioitemSkillAssoc;
import com.opitzconsulting.tlmt.jooqmigration.jooq.tlmt.tables.PortfolioitemStatusHistory;
import com.opitzconsulting.tlmt.jooqmigration.jooq.tlmt.tables.PortfolioitemTag;
import com.opitzconsulting.tlmt.jooqmigration.jooq.tlmt.tables.PortfolioitemTotalsPerJoblevel;
import com.opitzconsulting.tlmt.jooqmigration.jooq.tlmt.tables.Queue;
import com.opitzconsulting.tlmt.jooqmigration.jooq.tlmt.tables.Skill;
import com.opitzconsulting.tlmt.jooqmigration.jooq.tlmt.tables.SkillDistribution;
import com.opitzconsulting.tlmt.jooqmigration.jooq.tlmt.tables.Statuschange;
import com.opitzconsulting.tlmt.jooqmigration.jooq.tlmt.tables.Tag;
import com.opitzconsulting.tlmt.jooqmigration.jooq.tlmt.tables.TagDistribution;
import com.opitzconsulting.tlmt.jooqmigration.jooq.tlmt.tables.TagGroupOverview;
import com.opitzconsulting.tlmt.jooqmigration.jooq.tlmt.tables.TagOverview;
import com.opitzconsulting.tlmt.jooqmigration.jooq.tlmt.tables.Taggroup;


/**
 * Convenience access to all tables in tlmt.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes", "this-escape" })
public class Tables {

    /**
     * The table <code>tlmt.flyway_schema_history</code>.
     */
    public static final FlywaySchemaHistory FLYWAY_SCHEMA_HISTORY = FlywaySchemaHistory.FLYWAY_SCHEMA_HISTORY;

    /**
     * The table <code>tlmt.item</code>.
     */
    public static final Item ITEM = Item.ITEM;

    /**
     * The table <code>tlmt.item_link</code>.
     */
    public static final ItemLink ITEM_LINK = ItemLink.ITEM_LINK;

    /**
     * The table <code>tlmt.item_process</code>.
     */
    public static final ItemProcess ITEM_PROCESS = ItemProcess.ITEM_PROCESS;

    /**
     * The table <code>tlmt.item_process_change</code>.
     */
    public static final ItemProcessChange ITEM_PROCESS_CHANGE = ItemProcessChange.ITEM_PROCESS_CHANGE;

    /**
     * The table <code>tlmt.job_level_mapping</code>.
     */
    public static final JobLevelMapping JOB_LEVEL_MAPPING = JobLevelMapping.JOB_LEVEL_MAPPING;

    /**
     * The table <code>tlmt.latest_status_change_view</code>.
     */
    public static final LatestStatusChangeView LATEST_STATUS_CHANGE_VIEW = LatestStatusChangeView.LATEST_STATUS_CHANGE_VIEW;

    /**
     * The table <code>tlmt.mergehistory</code>.
     */
    public static final Mergehistory MERGEHISTORY = Mergehistory.MERGEHISTORY;

    /**
     * The table <code>tlmt.outbox</code>.
     */
    public static final Outbox OUTBOX = Outbox.OUTBOX;

    /**
     * The table <code>tlmt.portfolio_changes</code>.
     */
    public static final PortfolioChanges PORTFOLIO_CHANGES = PortfolioChanges.PORTFOLIO_CHANGES;

    /**
     * The table <code>tlmt.portfolio_changes_extended</code>.
     */
    public static final PortfolioChangesExtended PORTFOLIO_CHANGES_EXTENDED = PortfolioChangesExtended.PORTFOLIO_CHANGES_EXTENDED;

    /**
     * The table <code>tlmt.portfolio_dev_ops_count</code>.
     */
    public static final PortfolioDevOpsCount PORTFOLIO_DEV_OPS_COUNT = PortfolioDevOpsCount.PORTFOLIO_DEV_OPS_COUNT;

    /**
     * The table <code>tlmt.portfolio_item_qs</code>.
     */
    public static final PortfolioItemQs PORTFOLIO_ITEM_QS = PortfolioItemQs.PORTFOLIO_ITEM_QS;

    /**
     * The table <code>tlmt.portfolio_version</code>.
     */
    public static final PortfolioVersion PORTFOLIO_VERSION = PortfolioVersion.PORTFOLIO_VERSION;

    /**
     * The table <code>tlmt.portfolioitem</code>.
     */
    public static final Portfolioitem PORTFOLIOITEM = Portfolioitem.PORTFOLIOITEM;

    /**
     * The table <code>tlmt.portfolioitem_active</code>.
     */
    public static final PortfolioitemActive PORTFOLIOITEM_ACTIVE = PortfolioitemActive.PORTFOLIOITEM_ACTIVE;

    /**
     * The table <code>tlmt.portfolioitem_assessment</code>.
     */
    public static final PortfolioitemAssessment PORTFOLIOITEM_ASSESSMENT = PortfolioitemAssessment.PORTFOLIOITEM_ASSESSMENT;

    /**
     * The table <code>tlmt.portfolioitem_assessment_overview</code>.
     */
    public static final PortfolioitemAssessmentOverview PORTFOLIOITEM_ASSESSMENT_OVERVIEW = PortfolioitemAssessmentOverview.PORTFOLIOITEM_ASSESSMENT_OVERVIEW;

    /**
     * The table <code>tlmt.portfolioitem_assessment_transposed</code>.
     */
    public static final PortfolioitemAssessmentTransposed PORTFOLIOITEM_ASSESSMENT_TRANSPOSED = PortfolioitemAssessmentTransposed.PORTFOLIOITEM_ASSESSMENT_TRANSPOSED;

    /**
     * The table <code>tlmt.portfolioitem_assessment_view</code>.
     */
    public static final PortfolioitemAssessmentView PORTFOLIOITEM_ASSESSMENT_VIEW = PortfolioitemAssessmentView.PORTFOLIOITEM_ASSESSMENT_VIEW;

    /**
     * The table <code>tlmt.portfolioitem_count_by_status</code>.
     */
    public static final PortfolioitemCountByStatus PORTFOLIOITEM_COUNT_BY_STATUS = PortfolioitemCountByStatus.PORTFOLIOITEM_COUNT_BY_STATUS;

    /**
     * The table <code>tlmt.portfolioitem_qs_with_tags</code>.
     */
    public static final PortfolioitemQsWithTags PORTFOLIOITEM_QS_WITH_TAGS = PortfolioitemQsWithTags.PORTFOLIOITEM_QS_WITH_TAGS;

    /**
     * The table <code>tlmt.portfolioitem_skill_assoc</code>.
     */
    public static final PortfolioitemSkillAssoc PORTFOLIOITEM_SKILL_ASSOC = PortfolioitemSkillAssoc.PORTFOLIOITEM_SKILL_ASSOC;

    /**
     * The table <code>tlmt.portfolioitem_status_history</code>.
     */
    public static final PortfolioitemStatusHistory PORTFOLIOITEM_STATUS_HISTORY = PortfolioitemStatusHistory.PORTFOLIOITEM_STATUS_HISTORY;

    /**
     * The table <code>tlmt.portfolioitem_tag</code>.
     */
    public static final PortfolioitemTag PORTFOLIOITEM_TAG = PortfolioitemTag.PORTFOLIOITEM_TAG;

    /**
     * The table <code>tlmt.portfolioitem_totals_per_joblevel</code>.
     */
    public static final PortfolioitemTotalsPerJoblevel PORTFOLIOITEM_TOTALS_PER_JOBLEVEL = PortfolioitemTotalsPerJoblevel.PORTFOLIOITEM_TOTALS_PER_JOBLEVEL;

    /**
     * The table <code>tlmt.queue</code>.
     */
    public static final Queue QUEUE = Queue.QUEUE;

    /**
     * The table <code>tlmt.skill</code>.
     */
    public static final Skill SKILL = Skill.SKILL;

    /**
     * The table <code>tlmt.skill_distribution</code>.
     */
    public static final SkillDistribution SKILL_DISTRIBUTION = SkillDistribution.SKILL_DISTRIBUTION;

    /**
     * The table <code>tlmt.statuschange</code>.
     */
    public static final Statuschange STATUSCHANGE = Statuschange.STATUSCHANGE;

    /**
     * The table <code>tlmt.tag</code>.
     */
    public static final Tag TAG = Tag.TAG;

    /**
     * The table <code>tlmt.tag_distribution</code>.
     */
    public static final TagDistribution TAG_DISTRIBUTION = TagDistribution.TAG_DISTRIBUTION;

    /**
     * The table <code>tlmt.tag_group_overview</code>.
     */
    public static final TagGroupOverview TAG_GROUP_OVERVIEW = TagGroupOverview.TAG_GROUP_OVERVIEW;

    /**
     * The table <code>tlmt.tag_overview</code>.
     */
    public static final TagOverview TAG_OVERVIEW = TagOverview.TAG_OVERVIEW;

    /**
     * The table <code>tlmt.taggroup</code>.
     */
    public static final Taggroup TAGGROUP = Taggroup.TAGGROUP;
}
