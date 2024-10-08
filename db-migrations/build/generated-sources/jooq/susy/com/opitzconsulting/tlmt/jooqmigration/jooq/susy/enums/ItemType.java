/*
 * This file is generated by jOOQ.
 */
package com.opitzconsulting.tlmt.jooqmigration.jooq.susy.enums;


import com.opitzconsulting.tlmt.jooqmigration.jooq.susy.Susy;

import org.jooq.Catalog;
import org.jooq.EnumType;
import org.jooq.Schema;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes", "this-escape" })
public enum ItemType implements EnumType {

    NEW("NEW"),

    LIFECYCLE_MANAGED("LIFECYCLE_MANAGED"),

    LIFECYCLE_UNMANAGED("LIFECYCLE_UNMANAGED"),

    IGNORED("IGNORED");

    private final String literal;

    private ItemType(String literal) {
        this.literal = literal;
    }

    @Override
    public Catalog getCatalog() {
        return getSchema().getCatalog();
    }

    @Override
    public Schema getSchema() {
        return Susy.SUSY;
    }

    @Override
    public String getName() {
        return "item_type";
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
    public static ItemType lookupLiteral(String literal) {
        return EnumType.lookupLiteral(ItemType.class, literal);
    }
}
