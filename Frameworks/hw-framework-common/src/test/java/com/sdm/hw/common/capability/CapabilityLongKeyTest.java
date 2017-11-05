package com.sdm.hw.common.capability;

import org.junit.Test;

/**
 * This is JUnit test class for testing CapabilityLongKeyTest classs
 *
 * @author Jasbir Minhas
 * @version 1.0
 * @since 2017-10-10
 */

public class CapabilityLongKeyTest extends CapabilityTest{
    @Test
    public void getLong() throws Exception {
        for (CapabilityLongKey key : CapabilityLongKey.values()) {
            buildTestOutput(key, String.valueOf(key.getLong()));
        }
    }
}