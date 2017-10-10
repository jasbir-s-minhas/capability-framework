package com.sdm.hw.common.capability;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.logging.Logger;

import static org.junit.Assert.*;

/**
 * This is JUnit test class for testing CapabilityIntKeyTest classs
 *
 * @author Jasbir Minhas
 * @version 1.0
 * @since 2017-10-10
 */

public class CapabilityIntKeyTest {

    private static Logger LOGGER = Logger.getLogger(CapabilityIntKeyTest.class.getName());

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void getInt() throws Exception {
        LOGGER.info("getString...: " + CapabilityManager.getInstance()
                .getFloat(CapabilityIntKey.TEST_2_LEVEL_GROUP));
    }

}