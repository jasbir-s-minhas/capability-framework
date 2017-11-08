package com.sdm.hw.common.capability;

import org.junit.Test;

/**
 * This is JUnit test class for testing CapabilityDoubleKeyTest classs
 *
 * @author Jasbir Minhas
 * @version 1.0
 * @since 2017-11-07
 */

public class CapabilityDoubleKeyTest extends CapabilityTest {
    @Test
    public void getDouble() throws Exception {
        for (CapabilityDoubleKey key : CapabilityDoubleKey.values()) {
            buildTestOutput(key, String.valueOf(key.getDouble()));
        }
    }
}