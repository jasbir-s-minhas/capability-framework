package com.sdm.hw.common.capability;

import org.junit.Test;

/**
 * This is JUnit test class for testing CapabilityIntKeyTest classs
 *
 * @author Jasbir Minhas
 * @version 1.0
 * @since 2017-10-10
 */

public class CapabilityIntKeyTest extends CapabilityTest{
    @Test
    public void getInt() throws Exception {
        for (CapabilityIntKey key : CapabilityIntKey.values()) {
            buildTestOutput(key, String.valueOf(key.getInt()));
        }
    }
}