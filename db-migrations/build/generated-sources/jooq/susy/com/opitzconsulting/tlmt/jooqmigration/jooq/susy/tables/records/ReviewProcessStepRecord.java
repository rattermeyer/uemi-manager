/*
 * This file is generated by jOOQ.
 */
package com.opitzconsulting.tlmt.jooqmigration.jooq.susy.tables.records;


import com.opitzconsulting.tlmt.jooqmigration.jooq.susy.enums.ItemType;
import com.opitzconsulting.tlmt.jooqmigration.jooq.susy.enums.ProcessStatus;
import com.opitzconsulting.tlmt.jooqmigration.jooq.susy.tables.ReviewProcessStep;

import java.time.OffsetDateTime;
import java.util.UUID;

import org.jooq.Record2;
import org.jooq.impl.UpdatableRecordImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes", "this-escape" })
public class ReviewProcessStepRecord extends UpdatableRecordImpl<ReviewProcessStepRecord> {

    private static final long serialVersionUID = 1L;

    /**
     * Setter for <code>susy.review_process_step.review_process_uuid</code>.
     */
    public void setReviewProcessUuid(UUID value) {
        set(0, value);
    }

    /**
     * Getter for <code>susy.review_process_step.review_process_uuid</code>.
     */
    public UUID getReviewProcessUuid() {
        return (UUID) get(0);
    }

    /**
     * Setter for <code>susy.review_process_step.step_number</code>.
     */
    public void setStepNumber(Integer value) {
        set(1, value);
    }

    /**
     * Getter for <code>susy.review_process_step.step_number</code>.
     */
    public Integer getStepNumber() {
        return (Integer) get(1);
    }

    /**
     * Setter for <code>susy.review_process_step.status</code>.
     */
    public void setStatus(ProcessStatus value) {
        set(2, value);
    }

    /**
     * Getter for <code>susy.review_process_step.status</code>.
     */
    public ProcessStatus getStatus() {
        return (ProcessStatus) get(2);
    }

    /**
     * Setter for <code>susy.review_process_step.next_status_decision</code>.
     */
    public void setNextStatusDecision(String value) {
        set(3, value);
    }

    /**
     * Getter for <code>susy.review_process_step.next_status_decision</code>.
     */
    public String getNextStatusDecision() {
        return (String) get(3);
    }

    /**
     * Setter for <code>susy.review_process_step.type_decision</code>.
     */
    public void setTypeDecision(ItemType value) {
        set(4, value);
    }

    /**
     * Getter for <code>susy.review_process_step.type_decision</code>.
     */
    public ItemType getTypeDecision() {
        return (ItemType) get(4);
    }

    /**
     * Setter for <code>susy.review_process_step.reason</code>.
     */
    public void setReason(String value) {
        set(5, value);
    }

    /**
     * Getter for <code>susy.review_process_step.reason</code>.
     */
    public String getReason() {
        return (String) get(5);
    }

    /**
     * Setter for <code>susy.review_process_step.created_at</code>.
     */
    public void setCreatedAt(OffsetDateTime value) {
        set(6, value);
    }

    /**
     * Getter for <code>susy.review_process_step.created_at</code>.
     */
    public OffsetDateTime getCreatedAt() {
        return (OffsetDateTime) get(6);
    }

    /**
     * Setter for <code>susy.review_process_step.created_by</code>.
     */
    public void setCreatedBy(String value) {
        set(7, value);
    }

    /**
     * Getter for <code>susy.review_process_step.created_by</code>.
     */
    public String getCreatedBy() {
        return (String) get(7);
    }

    /**
     * Setter for <code>susy.review_process_step.modified_at</code>.
     */
    public void setModifiedAt(OffsetDateTime value) {
        set(8, value);
    }

    /**
     * Getter for <code>susy.review_process_step.modified_at</code>.
     */
    public OffsetDateTime getModifiedAt() {
        return (OffsetDateTime) get(8);
    }

    /**
     * Setter for <code>susy.review_process_step.modified_by</code>.
     */
    public void setModifiedBy(String value) {
        set(9, value);
    }

    /**
     * Getter for <code>susy.review_process_step.modified_by</code>.
     */
    public String getModifiedBy() {
        return (String) get(9);
    }

    /**
     * Setter for <code>susy.review_process_step.status_entered_at</code>.
     */
    public void setStatusEnteredAt(OffsetDateTime value) {
        set(10, value);
    }

    /**
     * Getter for <code>susy.review_process_step.status_entered_at</code>.
     */
    public OffsetDateTime getStatusEnteredAt() {
        return (OffsetDateTime) get(10);
    }

    /**
     * Setter for <code>susy.review_process_step.status_exited_at</code>.
     */
    public void setStatusExitedAt(OffsetDateTime value) {
        set(11, value);
    }

    /**
     * Getter for <code>susy.review_process_step.status_exited_at</code>.
     */
    public OffsetDateTime getStatusExitedAt() {
        return (OffsetDateTime) get(11);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    @Override
    public Record2<UUID, Integer> key() {
        return (Record2) super.key();
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached ReviewProcessStepRecord
     */
    public ReviewProcessStepRecord() {
        super(ReviewProcessStep.REVIEW_PROCESS_STEP);
    }

    /**
     * Create a detached, initialised ReviewProcessStepRecord
     */
    public ReviewProcessStepRecord(UUID reviewProcessUuid, Integer stepNumber, ProcessStatus status, String nextStatusDecision, ItemType typeDecision, String reason, OffsetDateTime createdAt, String createdBy, OffsetDateTime modifiedAt, String modifiedBy, OffsetDateTime statusEnteredAt, OffsetDateTime statusExitedAt) {
        super(ReviewProcessStep.REVIEW_PROCESS_STEP);

        setReviewProcessUuid(reviewProcessUuid);
        setStepNumber(stepNumber);
        setStatus(status);
        setNextStatusDecision(nextStatusDecision);
        setTypeDecision(typeDecision);
        setReason(reason);
        setCreatedAt(createdAt);
        setCreatedBy(createdBy);
        setModifiedAt(modifiedAt);
        setModifiedBy(modifiedBy);
        setStatusEnteredAt(statusEnteredAt);
        setStatusExitedAt(statusExitedAt);
        resetChangedOnNotNull();
    }
}
