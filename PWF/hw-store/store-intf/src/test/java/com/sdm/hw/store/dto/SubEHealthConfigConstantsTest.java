package com.sdm.hw.store.dto;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.logging.Logger;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class SubEHealthConfigConstantsTest {

    private static Logger LOGGER = Logger.getLogger(SubEHealthConfigConstantsTest.class.getName());

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void getRuleName() throws Exception {
    }

    @Test
    public void contains() throws Exception {
        for (SubEHealthConfigConstants subEHealthConfigConstants : SubEHealthConfigConstants.values()){
            LOGGER.info("...value of capability \"" + subEHealthConfigConstants.getRuleName()
                    + "\" : " + subEHealthConfigConstants.isEnabled());
        }
    }
}