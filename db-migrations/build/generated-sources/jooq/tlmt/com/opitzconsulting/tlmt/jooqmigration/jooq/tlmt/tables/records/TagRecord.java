/*
 * This file is generated by jOOQ.
 */
package com.opitzconsulting.tlmt.jooqmigration.jooq.tlmt.tables.records;


import com.opitzconsulting.tlmt.jooqmigration.jooq.tlmt.tables.Tag;

import java.time.LocalDateTime;

import org.jooq.Record1;
import org.jooq.impl.UpdatableRecordImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes", "this-escape" })
public class TagRecord extends UpdatableRecordImpl<TagRecord> {

    private static final long serialVersionUID = 1L;

    /**
     * Setter for <code>tlmt.tag.id</code>.
     */
    public void setId(Long value) {
        set(0, value);
    }

    /**
     * Getter for <code>tlmt.tag.id</code>.
     */
    public Long getId() {
        return (Long) get(0);
    }

    /**
     * Setter for <code>tlmt.tag.color</code>.
     */
    public void setColor(String value) {
        set(1, value);
    }

    /**
     * Getter for <code>tlmt.tag.color</code>.
     */
    public String getColor() {
        return (String) get(1);
    }

    /**
     * Setter for <code>tlmt.tag.tag</code>.
     */
    public void setTag(String value) {
        set(2, value);
    }

    /**
     * Getter for <code>tlmt.tag.tag</code>.
     */
    public String getTag() {
        return (String) get(2);
    }

    /**
     * Setter for <code>tlmt.tag.type</code>.
     */
    public void setType(String value) {
        set(3, value);
    }

    /**
     * Getter for <code>tlmt.tag.type</code>.
     */
    public String getType() {
        return (String) get(3);
    }

    /**
     * Setter for <code>tlmt.tag.active</code>.
     */
    public void setActive(Boolean value) {
        set(4, value);
    }

    /**
     * Getter for <code>tlmt.tag.active</code>.
     */
    public Boolean getActive() {
        return (Boolean) get(4);
    }

    /**
     * Setter for <code>tlmt.tag.last_updated</code>.
     */
    public void setLastUpdated(LocalDateTime value) {
        set(5, value);
    }

    /**
     * Getter for <code>tlmt.tag.last_updated</code>.
     */
    public LocalDateTime getLastUpdated() {
        return (LocalDateTime) get(5);
    }

    /**
     * Setter for <code>tlmt.tag.created_at</code>.
     */
    public void setCreatedAt(LocalDateTime value) {
        set(6, value);
    }

    /**
     * Getter for <code>tlmt.tag.created_at</code>.
     */
    public LocalDateTime getCreatedAt() {
        return (LocalDateTime) get(6);
    }

    /**
     * Setter for <code>tlmt.tag.taggroupid</code>.
     */
    public void setTaggroupid(Long value) {
        set(7, value);
    }

    /**
     * Getter for <code>tlmt.tag.taggroupid</code>.
     */
    public Long getTaggroupid() {
        return (Long) get(7);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    @Override
    public Record1<Long> key() {
        return (Record1) super.key();
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached TagRecord
     */
    public TagRecord() {
        super(Tag.TAG);
    }

    /**
     * Create a detached, initialised TagRecord
     */
    public TagRecord(Long id, String color, String tag, String type, Boolean active, LocalDateTime lastUpdated, LocalDateTime createdAt, Long taggroupid) {
        super(Tag.TAG);

        setId(id);
        setColor(color);
        setTag(tag);
        setType(type);
        setActive(active);
        setLastUpdated(lastUpdated);
        setCreatedAt(createdAt);
        setTaggroupid(taggroupid);
        resetChangedOnNotNull();
    }
}
