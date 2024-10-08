/*
 * This file is generated by jOOQ.
 */
package com.opitzconsulting.tlmt.jooqmigration.jooq.tlmt.enums;


import com.opitzconsulting.tlmt.jooqmigration.jooq.tlmt.Tlmt;

import org.jooq.Catalog;
import org.jooq.EnumType;
import org.jooq.Schema;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes", "this-escape" })
public enum ERegion implements EnumType {

    OC("OC"),

    NO("NO"),

    W("W"),

    SO("SO"),

    PO("PO");

    private final String literal;

    private ERegion(String literal) {
        this.literal = literal;
    }

    @Override
    public Catalog getCatalog() {
        return getSchema().getCatalog();
    }

    @Override
    public Schema getSchema() {
        return Tlmt.TLMT;
    }

    @Override
    public String getName() {
        return "e_region";
    }

    @Override
    public String getLiteral() {
        return literal;
    }

    /**
     * Lookup a value of this EnumType by its literal. Returns
     * <code>null</code>, if no such value could be found, see {@link
     * EnumType#lookupLiteral(Class, String)}.
     */
    public static ERegion lookupLiteral(String literal) {
        return EnumType.lookupLiteral(ERegion.class, literal);
    }
}
