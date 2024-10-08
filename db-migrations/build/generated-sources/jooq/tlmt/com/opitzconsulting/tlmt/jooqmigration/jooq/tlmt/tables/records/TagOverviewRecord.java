/*
 * This file is generated by jOOQ.
 */
package com.opitzconsulting.tlmt.jooqmigration.jooq.tlmt.tables.records;


import com.opitzconsulting.tlmt.jooqmigration.jooq.tlmt.enums.TagGroupRule;
import com.opitzconsulting.tlmt.jooqmigration.jooq.tlmt.tables.TagOverview;
import com.opitzconsulting.tlmt.jooqmigration.jooq.tlmt.udt.records.TagSummaryRecord;

import java.util.UUID;

import org.jooq.JSON;
import org.jooq.impl.TableRecordImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes", "this-escape" })
public class TagOverviewRecord extends TableRecordImpl<TagOverviewRecord> {

    private static final long serialVersionUID = 1L;

    /**
     * Setter for <code>tlmt.tag_overview.tag</code>.
     */
    public void setTag(String value) {
        set(0, value);
    }

    /**
     * Getter for <code>tlmt.tag_overview.tag</code>.
     */
    public String getTag() {
        return (String) get(0);
    }

    /**
     * Setter for <code>tlmt.tag_overview.taggrouptitle</code>.
     */
    public void setTaggrouptitle(String value) {
        set(1, value);
    }

    /**
     * Getter for <code>tlmt.tag_overview.taggrouptitle</code>.
     */
    public String getTaggrouptitle() {
        return (String) get(1);
    }

    /**
     * Setter for <code>tlmt.tag_overview.backgroundcolor</code>.
     */
    public void setBackgroundcolor(String value) {
        set(2, value);
    }

    /**
     * Getter for <code>tlmt.tag_overview.backgroundcolor</code>.
     */
    public String getBackgroundcolor() {
        return (String) get(2);
    }

    /**
     * Setter for <code>tlmt.tag_overview.rule</code>.
     */
    public void setRule(TagGroupRule value) {
        set(3, value);
    }

    /**
     * Getter for <code>tlmt.tag_overview.rule</code>.
     */
    public TagGroupRule getRule() {
        return (TagGroupRule) get(3);
    }

    /**
     * Setter for <code>tlmt.tag_overview.tag_group_uuid</code>.
     */
    public void setTagGroupUuid(UUID value) {
        set(4, value);
    }

    /**
     * Getter for <code>tlmt.tag_overview.tag_group_uuid</code>.
     */
    public UUID getTagGroupUuid() {
        return (UUID) get(4);
    }

    /**
     * Setter for <code>tlmt.tag_overview.tag_summary</code>.
     */
    public void setTagSummary(TagSummaryRecord value) {
        set(5, value);
    }

    /**
     * Getter for <code>tlmt.tag_overview.tag_summary</code>.
     */
    public TagSummaryRecord getTagSummary() {
        return (TagSummaryRecord) get(5);
    }

    /**
     * Setter for <code>tlmt.tag_overview.tag_summary_json</code>.
     */
    public void setTagSummaryJson(JSON value) {
        set(6, value);
    }

    /**
     * Getter for <code>tlmt.tag_overview.tag_summary_json</code>.
     */
    public JSON getTagSummaryJson() {
        return (JSON) get(6);
    }

    /**
     * Setter for <code>tlmt.tag_overview.count</code>.
     */
    public void setCount(Long value) {
        set(7, value);
    }

    /**
     * Getter for <code>tlmt.tag_overview.count</code>.
     */
    public Long getCount() {
        return (Long) get(7);
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached TagOverviewRecord
     */
    public TagOverviewRecord() {
        super(TagOverview.TAG_OVERVIEW);
    }

    /**
     * Create a detached, initialised TagOverviewRecord
     */
    public TagOverviewRecord(String tag, String taggrouptitle, String backgroundcolor, TagGroupRule rule, UUID tagGroupUuid, TagSummaryRecord tagSummary, JSON tagSummaryJson, Long count) {
        super(TagOverview.TAG_OVERVIEW);

        setTag(tag);
        setTaggrouptitle(taggrouptitle);
        setBackgroundcolor(backgroundcolor);
        setRule(rule);
        setTagGroupUuid(tagGroupUuid);
        setTagSummary(tagSummary);
        setTagSummaryJson(tagSummaryJson);
        setCount(count);
        resetChangedOnNotNull();
    }
}
