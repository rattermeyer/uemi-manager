/*
 * This file is generated by jOOQ.
 */
package com.opitzconsulting.tlmt.jooqmigration.jooq.extensions.routines;


import com.opitzconsulting.tlmt.jooqmigration.jooq.extensions.Extensions;

import org.jooq.Field;
import org.jooq.Parameter;
import org.jooq.impl.AbstractRoutine;
import org.jooq.impl.Internal;
import org.jooq.impl.SQLDataType;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes", "this-escape" })
public class ArrayIntersect extends AbstractRoutine<Object[]> {

    private static final long serialVersionUID = 1L;

    /**
     * The parameter <code>extensions.array_intersect.RETURN_VALUE</code>.
     */
    public static final Parameter<Object[]> RETURN_VALUE = Internal.createParameter("RETURN_VALUE", SQLDataType.OTHER.array(), false, false);

    /**
     * The parameter <code>extensions.array_intersect.a</code>.
     */
    public static final Parameter<Object[]> A = Internal.createParameter("a", SQLDataType.OTHER.array(), false, false);

    /**
     * The parameter <code>extensions.array_intersect.b</code>.
     */
    public static final Parameter<Object[]> B = Internal.createParameter("b", SQLDataType.OTHER.array(), false, false);

    /**
     * Create a new routine call instance
     */
    public ArrayIntersect() {
        super("array_intersect", Extensions.EXTENSIONS, SQLDataType.OTHER.array());

        setReturnParameter(RETURN_VALUE);
        addInParameter(A);
        addInParameter(B);
    }

    /**
     * Set the <code>a</code> parameter IN value to the routine
     */
    public void setA(Object[] value) {
        setValue(A, value);
    }

    /**
     * Set the <code>a</code> parameter to the function to be used with a {@link
     * org.jooq.Select} statement
     */
    public void setA(Field<Object[]> field) {
        setField(A, field);
    }

    /**
     * Set the <code>b</code> parameter IN value to the routine
     */
    public void setB(Object[] value) {
        setValue(B, value);
    }

    /**
     * Set the <code>b</code> parameter to the function to be used with a {@link
     * org.jooq.Select} statement
     */
    public void setB(Field<Object[]> field) {
        setField(B, field);
    }
}
