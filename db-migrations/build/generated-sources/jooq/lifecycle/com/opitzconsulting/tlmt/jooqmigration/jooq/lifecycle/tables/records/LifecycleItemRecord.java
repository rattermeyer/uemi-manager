/*
 * This file is generated by jOOQ.
 */
package com.opitzconsulting.tlmt.jooqmigration.jooq.lifecycle.tables.records;


import com.opitzconsulting.tlmt.jooqmigration.jooq.lifecycle.tables.LifecycleItem;

import java.time.LocalDateTime;
import java.util.UUID;

import org.jooq.Record1;
import org.jooq.impl.UpdatableRecordImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes", "this-escape" })
public class LifecycleItemRecord extends UpdatableRecordImpl<LifecycleItemRecord> {

    private static final long serialVersionUID = 1L;

    /**
     * Setter for <code>lifecycle.lifecycle_item.uuid</code>.
     */
    public void setUuid(UUID value) {
        set(0, value);
    }

    /**
     * Getter for <code>lifecycle.lifecycle_item.uuid</code>.
     */
    public UUID getUuid() {
        return (UUID) get(0);
    }

    /**
     * Setter for <code>lifecycle.lifecycle_item.id</code>.
     */
    public void setId(Long value) {
        set(1, value);
    }

    /**
     * Getter for <code>lifecycle.lifecycle_item.id</code>.
     */
    public Long getId() {
        return (Long) get(1);
    }

    /**
     * Setter for <code>lifecycle.lifecycle_item.active</code>.
     */
    public void setActive(Boolean value) {
        set(2, value);
    }

    /**
     * Getter for <code>lifecycle.lifecycle_item.active</code>.
     */
    public Boolean getActive() {
        return (Boolean) get(2);
    }

    /**
     * Setter for <code>lifecycle.lifecycle_item.description</code>.
     */
    public void setDescription(String value) {
        set(3, value);
    }

    /**
     * Getter for <code>lifecycle.lifecycle_item.description</code>.
     */
    public String getDescription() {
        return (String) get(3);
    }

    /**
     * Setter for <code>lifecycle.lifecycle_item.name</code>.
     */
    public void setName(String value) {
        set(4, value);
    }

    /**
     * Getter for <code>lifecycle.lifecycle_item.name</code>.
     */
    public String getName() {
        return (String) get(4);
    }

    /**
     * Setter for <code>lifecycle.lifecycle_item.last_updated</code>.
     */
    public void setLastUpdated(LocalDateTime value) {
        set(5, value);
    }

    /**
     * Getter for <code>lifecycle.lifecycle_item.last_updated</code>.
     */
    public LocalDateTime getLastUpdated() {
        return (LocalDateTime) get(5);
    }

    /**
     * Setter for <code>lifecycle.lifecycle_item.created_at</code>.
     */
    public void setCreatedAt(LocalDateTime value) {
        set(6, value);
    }

    /**
     * Getter for <code>lifecycle.lifecycle_item.created_at</code>.
     */
    public LocalDateTime getCreatedAt() {
        return (LocalDateTime) get(6);
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
     * Create a detached LifecycleItemRecord
     */
    public LifecycleItemRecord() {
        super(LifecycleItem.LIFECYCLE_ITEM);
    }

    /**
     * Create a detached, initialised LifecycleItemRecord
     */
    public LifecycleItemRecord(UUID uuid, Long id, Boolean active, String description, String name, LocalDateTime lastUpdated, LocalDateTime createdAt) {
        super(LifecycleItem.LIFECYCLE_ITEM);

        setUuid(uuid);
        setId(id);
        setActive(active);
        setDescription(description);
        setName(name);
        setLastUpdated(lastUpdated);
        setCreatedAt(createdAt);
        resetChangedOnNotNull();
    }
}
