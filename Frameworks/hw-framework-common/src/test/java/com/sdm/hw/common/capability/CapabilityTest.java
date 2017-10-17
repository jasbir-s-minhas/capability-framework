package com.sdm.hw.common.capability;

import org.junit.After;
import org.junit.Before;

import java.util.logging.Logger;

abstract public class CapabilityTest {
    private static Logger LOGGER = Logger.getLogger(CapabilityTest.class.getName());

    protected StringBuilder stringBuilder = new StringBuilder();

    protected CapabilityManager capabilityManager = CapabilityManager.getInstance();

    @Before
    public void setUp() throws Exception {
        stringBuilder.append(System.lineSeparator());
    }

    @After
    public void tearDown() throws Exception {
        LOGGER.info(stringBuilder.toString());
    }

    protected void buildTestOutput(CapabilityKey key, String keyVal){
        stringBuilder.append(key.getClass().getSimpleName());
        stringBuilder.append(":");
        stringBuilder.append(key);
        stringBuilder.append("->");
        stringBuilder.append(keyVal);
        stringBuilder.append(System.lineSeparator());
    }
}
