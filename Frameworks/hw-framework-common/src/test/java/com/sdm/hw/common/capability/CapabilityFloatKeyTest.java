package com.sdm.hw.common.capability;

import org.junit.Test;

/**
 * This is JUnit test class for testing CapabilityFloatKeyTest classs
 *
 * @author Jasbir Minhas
 * @version 1.0
 * @since 2017-10-10
 */

public class CapabilityFloatKeyTest extends CapabilityTest {
    @Test
    public void getFloat() throws Exception {
        for (CapabilityFloatKey key : CapabilityFloatKey.values()) {
            buildTestOutput(key, String.valueOf(key.getFloat()));
        }
    }
}