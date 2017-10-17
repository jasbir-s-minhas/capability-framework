package com.sdm.hw.common.capability;

import org.junit.Test;

public class CapabilityManagerTest extends CapabilityTest {
    @Test
    public void getBoolean() throws Exception {
        for (CapabilityBooleanKey key : CapabilityBooleanKey.values()) {
            buildTestOutput(key, String.valueOf(capabilityManager.getBoolean(key)));
        }
    }

    @Test
    public void getString() throws Exception {
        for (CapabilityStringKey key : CapabilityStringKey.values()) {
            buildTestOutput(key, capabilityManager.getString(key));
        }
    }
}