/*
 * This file is generated by jOOQ.
 */
package com.opitzconsulting.tlmt.jooqmigration.jooq.tlmt.tables.records;


import com.opitzconsulting.tlmt.jooqmigration.jooq.tlmt.enums.TagGroupRule;
import com.opitzconsulting.tlmt.jooqmigration.jooq.tlmt.tables.TagGroupOverview;
import com.opitzconsulting.tlmt.jooqmigration.jooq.tlmt.udt.records.ItemSummaryRecord;

import java.util.UUID;

import org.jooq.JSON;
import org.jooq.impl.TableRecordImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes", "this-escape" })
public class TagGroupOverviewRecord extends TableRecordImpl<TagGroupOverviewRecord> {

    private static final long serialVersionUID = 1L;

    /**
     * Setter for <code>tlmt.tag_group_overview.taggrouptitle</code>.
     */
    public void setTaggrouptitle(String value) {
        set(0, value);
    }

    /**
     * Getter for <code>tlmt.tag_group_overview.taggrouptitle</code>.
     */
    public String getTaggrouptitle() {
        return (String) get(0);
    }

    /**
     * Setter for <code>tlmt.tag_group_overview.rule</code>.
     */
    public void setRule(TagGroupRule value) {
        set(1, value);
    }

    /**
     * Getter for <code>tlmt.tag_group_overview.rule</code>.
     */
    public TagGroupRule getRule() {
        return (TagGroupRule) get(1);
    }

    /**
     * Setter for <code>tlmt.tag_group_overview.tag_group_uuid</code>.
     */
    public void setTagGroupUuid(UUID value) {
        set(2, value);
    }

    /**
     * Getter for <code>tlmt.tag_group_overview.tag_group_uuid</code>.
     */
    public UUID getTagGroupUuid() {
        return (UUID) get(2);
    }

    /**
     * Setter for <code>tlmt.tag_group_overview.backgroundcolor</code>.
     */
    public void setBackgroundcolor(String value) {
        set(3, value);
    }

    /**
     * Getter for <code>tlmt.tag_group_overview.backgroundcolor</code>.
     */
    public String getBackgroundcolor() {
        return (String) get(3);
    }

    /**
     * Setter for <code>tlmt.tag_group_overview.items_raw</code>.
     */
    public void setItemsRaw(ItemSummaryRecord[] value) {
        set(4, value);
    }

    /**
     * Getter for <code>tlmt.tag_group_overview.items_raw</code>.
     */
    public ItemSummaryRecord[] getItemsRaw() {
        return (ItemSummaryRecord[]) get(4);
    }

    /**
     * Setter for <code>tlmt.tag_group_overview.items</code>.
     */
    public void setItems(JSON value) {
        set(5, value);
    }

    /**
     * Getter for <code>tlmt.tag_group_overview.items</code>.
     */
    public JSON getItems() {
        return (JSON) get(5);
    }

    /**
     * Setter for <code>tlmt.tag_group_overview.number_of_items</code>.
     */
    public void setNumberOfItems(Integer value) {
        set(6, value);
    }

    /**
     * Getter for <code>tlmt.tag_group_overview.number_of_items</code>.
     */
    public Integer getNumberOfItems() {
        return (Integer) get(6);
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached TagGroupOverviewRecord
     */
    public TagGroupOverviewRecord() {
        super(TagGroupOverview.TAG_GROUP_OVERVIEW);
    }

    /**
     * Create a detached, initialised TagGroupOverviewRecord
     */
    public TagGroupOverviewRecord(String taggrouptitle, TagGroupRule rule, UUID tagGroupUuid, String backgroundcolor, ItemSummaryRecord[] itemsRaw, JSON items, Integer numberOfItems) {
        super(TagGroupOverview.TAG_GROUP_OVERVIEW);

        setTaggrouptitle(taggrouptitle);
        setRule(rule);
        setTagGroupUuid(tagGroupUuid);
        setBackgroundcolor(backgroundcolor);
        setItemsRaw(itemsRaw);
        setItems(items);
        setNumberOfItems(numberOfItems);
        resetChangedOnNotNull();
    }
}
