package com.sdm.hw.common.capability;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.logging.Logger;

import static org.junit.Assert.*;

/**
 * This is JUnit test class for testing CapabilityBoolean classs
 *
 * @author Jasbir Minhas
 * @version 1.0
 * @since 2017-10-10
 */

public class CapabilityBooleanKeyTest extends CapabilityTest {

    @Test
    public void isEnabled() throws Exception {
        for (CapabilityBooleanKey key : CapabilityBooleanKey.values()) {
            buildTestOutput(key, String.valueOf(capabilityManager.getBoolean(key)));
        }
    }

}