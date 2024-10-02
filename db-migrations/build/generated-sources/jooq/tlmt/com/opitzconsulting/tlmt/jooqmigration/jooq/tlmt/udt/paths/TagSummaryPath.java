/*
 * This file is generated by jOOQ.
 */
package com.opitzconsulting.tlmt.jooqmigration.jooq.tlmt.udt.paths;


import com.opitzconsulting.tlmt.jooqmigration.jooq.tlmt.udt.TagSummary;
import com.opitzconsulting.tlmt.jooqmigration.jooq.tlmt.udt.records.TagSummaryRecord;

import org.jooq.Binding;
import org.jooq.Comment;
import org.jooq.DataType;
import org.jooq.Name;
import org.jooq.Record;
import org.jooq.RecordQualifier;
import org.jooq.UDTField;
import org.jooq.impl.DSL;
import org.jooq.impl.Internal;
import org.jooq.impl.SQLDataType;
import org.jooq.impl.UDTPathTableFieldImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes", "this-escape" })
public class TagSummaryPath<R extends Record, T> extends UDTPathTableFieldImpl<R, TagSummaryRecord, T> {

    private static final long serialVersionUID = 1L;

    /**
     * The attribute <code>tlmt.tag_summary.tag</code>.
     */
    public final UDTField<TagSummaryRecord, String> TAG = Internal.createUDTPathField(DSL.name("tag"), SQLDataType.VARCHAR(32), this, "", UDTField.class);

    /**
     * The attribute <code>tlmt.tag_summary.taggrouptitle</code>.
     */
    public final UDTField<TagSummaryRecord, String> TAGGROUPTITLE = Internal.createUDTPathField(DSL.name("taggrouptitle"), SQLDataType.VARCHAR(255), this, "", UDTField.class);

    /**
     * The attribute <code>tlmt.tag_summary.backgroundcolor</code>.
     */
    public final UDTField<TagSummaryRecord, String> BACKGROUNDCOLOR = Internal.createUDTPathField(DSL.name("backgroundcolor"), SQLDataType.VARCHAR(255), this, "", UDTField.class);

    public TagSummaryPath(Name name, DataType<T> type, RecordQualifier<R> qualifier, Comment comment, Binding<?, T> binding) {
        super(name, type, qualifier, TagSummary.TAG_SUMMARY, comment, binding);
    }
}
