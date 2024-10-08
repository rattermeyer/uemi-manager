/*
 * This file is generated by jOOQ.
 */
package com.opitzconsulting.tlmt.jooqmigration.jooq.tlmt.routines;


import com.opitzconsulting.tlmt.jooqmigration.jooq.tlmt.Tlmt;

import java.util.UUID;

import org.jooq.Field;
import org.jooq.JSON;
import org.jooq.Parameter;
import org.jooq.impl.AbstractRoutine;
import org.jooq.impl.Internal;
import org.jooq.impl.SQLDataType;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes", "this-escape" })
public class QueueEnqueue extends AbstractRoutine<UUID> {

    private static final long serialVersionUID = 1L;

    /**
     * The parameter <code>tlmt.queue_enqueue.RETURN_VALUE</code>.
     */
    public static final Parameter<UUID> RETURN_VALUE = Internal.createParameter("RETURN_VALUE", SQLDataType.UUID, false, false);

    /**
     * The parameter <code>tlmt.queue_enqueue.p_name</code>.
     */
    public static final Parameter<String> P_NAME = Internal.createParameter("p_name", SQLDataType.VARCHAR, false, false);

    /**
     * The parameter <code>tlmt.queue_enqueue.p_payload</code>.
     */
    public static final Parameter<JSON> P_PAYLOAD = Internal.createParameter("p_payload", SQLDataType.JSON, false, false);

    /**
     * The parameter <code>tlmt.queue_enqueue.p_type</code>.
     */
    public static final Parameter<String> P_TYPE = Internal.createParameter("p_type", SQLDataType.VARCHAR, false, false);

    /**
     * Create a new routine call instance
     */
    public QueueEnqueue() {
        super("queue_enqueue", Tlmt.TLMT, SQLDataType.UUID);

        setReturnParameter(RETURN_VALUE);
        addInParameter(P_NAME);
        addInParameter(P_PAYLOAD);
        addInParameter(P_TYPE);
    }

    /**
     * Set the <code>p_name</code> parameter IN value to the routine
     */
    public void setPName(String value) {
        setValue(P_NAME, value);
    }

    /**
     * Set the <code>p_name</code> parameter to the function to be used with a
     * {@link org.jooq.Select} statement
     */
    public void setPName(Field<String> field) {
        setField(P_NAME, field);
    }

    /**
     * Set the <code>p_payload</code> parameter IN value to the routine
     */
    public void setPPayload(JSON value) {
        setValue(P_PAYLOAD, value);
    }

    /**
     * Set the <code>p_payload</code> parameter to the function to be used with
     * a {@link org.jooq.Select} statement
     */
    public void setPPayload(Field<JSON> field) {
        setField(P_PAYLOAD, field);
    }

    /**
     * Set the <code>p_type</code> parameter IN value to the routine
     */
    public void setPType(String value) {
        setValue(P_TYPE, value);
    }

    /**
     * Set the <code>p_type</code> parameter to the function to be used with a
     * {@link org.jooq.Select} statement
     */
    public void setPType(Field<String> field) {
        setField(P_TYPE, field);
    }
}
