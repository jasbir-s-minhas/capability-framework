package com.sdm.hw.store.dto;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.logging.Logger;

public class SubEHealthConfigConstantsTest {

    private static Logger LOGGER = Logger.getLogger(SubEHealthConfigConstantsTest.class.getName());

    protected StringBuilder stringBuilder = new StringBuilder();

    @Before
    public void setUp() throws Exception {
        stringBuilder.append(System.lineSeparator());
    }

    @After
    public void tearDown() throws Exception {
        LOGGER.info(stringBuilder.toString());
    }

    @Test
    public void contains() throws Exception {
        for (SubEHealthConfigConstants subEHealthConfigConstants : SubEHealthConfigConstants.values()){
            stringBuilder.append(this.getClass().getSimpleName());
            stringBuilder.append(":");
            stringBuilder.append(subEHealthConfigConstants.getRuleName());
            stringBuilder.append("->");
            stringBuilder.append(subEHealthConfigConstants.isEnabled());
            stringBuilder.append(System.lineSeparator());
        }
    }
}