package com.sdm.hw.common.capability;

import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Before;

import java.io.File;
import java.io.IOException;
import java.util.logging.Logger;

abstract public class CapabilityTest {
    private static Logger LOGGER = Logger.getLogger(CapabilityTest.class.getName());

    private StringBuilder stringBuilder = new StringBuilder();

    protected File illFormedCapabilityFile = null;
    protected File validCapabilityFile = null;
    protected File duplicateElementCapabilityFile = null;
    protected File capabilityFile = null;

    protected CapabilityManager capabilityManager = CapabilityManager.getInstance();
    protected ProvinceCodeProvider provinceCodeProvider = ProvinceCodeProvider.getInstance();


    @Before
    public void setUp() throws Exception {
        stringBuilder.append(System.lineSeparator());
        ClassLoader classLoader = getClass().getClassLoader();
        illFormedCapabilityFile = new File(classLoader.getResource("capability-ill-formed.xml").getFile());
        validCapabilityFile = new File(classLoader.getResource("capability-valid.xml").getFile());

        duplicateElementCapabilityFile = new File(classLoader.getResource("capability-duplicate-element.xml").getFile());

        String parentPath = validCapabilityFile.getParent();


        // create capability file in the same directory as other test files
        capabilityFile = new File(parentPath + File.separator + "capability.xml");

        FileUtils.copyFile(validCapabilityFile, capabilityFile);

        LOGGER.info("InvalidCapabilityFile : " + illFormedCapabilityFile.getAbsolutePath());
        LOGGER.info("ValidCapabilityFile : " + validCapabilityFile.getAbsolutePath());
        LOGGER.info("Duplicate Element Capability File : " + duplicateElementCapabilityFile.getAbsolutePath());
        LOGGER.info("CapabilityFile : " + capabilityFile.getAbsolutePath());
    }

    @After
    public void tearDown() throws Exception {
        LOGGER.info(stringBuilder.toString());
    }

    void touchCapabilityFile() throws IOException{
        FileUtils.touch(capabilityFile);
    }

    void buildTestOutput(CapabilityKey key, String keyVal){
        stringBuilder.append(key.getClass().getSimpleName());
        stringBuilder.append(":");
        stringBuilder.append(key);
        stringBuilder.append("->");
        stringBuilder.append(keyVal);
        stringBuilder.append(System.lineSeparator());
    }
}
