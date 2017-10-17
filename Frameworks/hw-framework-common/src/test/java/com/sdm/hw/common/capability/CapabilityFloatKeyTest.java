package com.sdm.hw.common.capability;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.logging.Logger;

import static org.junit.Assert.*;

/**
 * This is JUnit test class for testing CapabilityFloatKeyTest classs
 *
 * @author Jasbir Minhas
 * @version 1.0
 * @since 2017-10-10
 */

public class CapabilityFloatKeyTest extends CapabilityTest {
    private static Logger LOGGER = Logger.getLogger(CapabilityFloatKeyTest.class.getName());

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void getFloat() throws Exception {
        for (CapabilityIntKey key : CapabilityIntKey.values()) {
            buildTestOutput(key, String.valueOf(capabilityManager.getFloat(key)));
        }
    }
}