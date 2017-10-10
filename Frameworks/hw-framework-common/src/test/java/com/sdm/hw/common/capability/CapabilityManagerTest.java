package com.sdm.hw.common.capability;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.logging.Logger;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class CapabilityManagerTest {

    private static Logger LOGGER = Logger.getLogger(CapabilityManagerTest.class.getName());

    private CapabilityManager capabilityManager;
    @Before
    public void setUp() throws Exception {
        capabilityManager = CapabilityManager.getInstance();
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void getBoolean() throws Exception {

        for (CapabilityBooleanKey capabilityBooleanKey : CapabilityBooleanKey.values()){
            LOGGER.info("...value of capability \"" + capabilityBooleanKey + "\" : " + capabilityManager.getBoolean(capabilityBooleanKey));
        }
    }

    @Test
    public void getString() throws Exception {
        LOGGER.info("getString...: " + capabilityManager.getString(CapabilityBooleanKey.TEST_2_LEVEL_GROUP));
    }

}