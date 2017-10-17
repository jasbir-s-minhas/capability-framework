package com.sdm.hw.common.capability;
/**
 *
 * This is a marker interface which is used by Capability Framework to make sure that an appropriate type of enum
 * is passed to CapabilityManager.
 *
 * @author Jasbir Minhas
 * @version 1.0
 * @since 2017-10-10
 */

public interface CapabilityKey {

    // The regEx delimiter used in the expression
    public static final String EXPRESSION_DELIMITOR = ".";
    // indicates if current capability key represents a group or not.
    boolean isGroup();
}
