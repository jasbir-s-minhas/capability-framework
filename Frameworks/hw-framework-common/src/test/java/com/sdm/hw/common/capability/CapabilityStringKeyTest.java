package com.sdm.hw.common.capability;

import org.junit.Test;

/**
 * This is JUnit test class for testing CapabilityStringKeyTest classs
 *
 * @author Jasbir Minhas
 * @version 1.0
 * @since 2017-11-07
 */

public class CapabilityStringKeyTest extends CapabilityTest{

    @Test
    public void getString() throws Exception {
        for (CapabilityStringKey key : CapabilityStringKey.values()) {
            buildTestOutput(key, key.getString());
        }
    }
}