package com.sdm.hw.common.capability;

import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Before;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

abstract public class CapabilityTest {
    private static Logger LOGGER = Logger.getLogger(CapabilityTest.class.getName());
    protected File illFormedConfigFile = null;
    protected File validConfigFileNSallergyStatusTrue = null;
    protected File validConfigFileNSallergyStatusFalse = null;
    protected File duplicateElementConfigFile = null;
    protected File capabilityFile = null;
    protected CapabilityManager capabilityManager = CapabilityManager.getInstance();
    protected ProvinceCodeProvider provinceCodeProvider = ProvinceCodeProvider.getInstance();
    private StringBuilder stringBuilder = new StringBuilder();

    @Before
    public void setUp() throws Exception {
        stringBuilder.append(System.lineSeparator());
        ClassLoader classLoader = getClass().getClassLoader();
        illFormedConfigFile = new File(classLoader.getResource("capability-ill-formed.xml").getFile());
        validConfigFileNSallergyStatusTrue = new File(classLoader.getResource("capability-valid-NSallergyStatusTrue-.xml").getFile());
        validConfigFileNSallergyStatusFalse = new File(classLoader.getResource("capability-valid-NSallergyStatusFalse-.xml").getFile());
        duplicateElementConfigFile = new File(classLoader.getResource("capability-duplicate-element.xml").getFile());

        String parentPath = validConfigFileNSallergyStatusTrue.getParent();


        // create capability file in the same directory as other test files
        capabilityFile = new File(parentPath + File.separator + "capability.xml");

        FileUtils.copyFile(validConfigFileNSallergyStatusTrue, capabilityFile);

        LOGGER.info("InvalidCapabilityFile : " + illFormedConfigFile.getAbsolutePath());
        LOGGER.info("ValidCapabilityFile : " + validConfigFileNSallergyStatusTrue.getAbsolutePath());
        LOGGER.info("Duplicate Element Capability File : " + duplicateElementConfigFile.getAbsolutePath());
        LOGGER.info("CapabilityFile : " + capabilityFile.getAbsolutePath());
    }

    @After
    public void tearDown() throws Exception {
        LOGGER.info(stringBuilder.toString());
    }

    void touchCapabilityFile() throws IOException {
        FileUtils.touch(capabilityFile);
    }

    /**
     * Following is a common method used for copying files
     *
     * @param src  Source File
     * @param dest Destination File
     * @throws IOException
     */
    void copyFile(final File src, final File dest) throws IOException {
        FileUtils.copyFile(src, dest);
    }

    /**
     * Following is a common method used for copying files on with a delay on separate thread
     *
     * @param src
     * @param dest
     * @param timeUnit
     * @param delay
     * @throws IOException
     */
    void copyFile(final File src, final File dest, final TimeUnit timeUnit, final int delay) throws IOException {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        executorService.execute(new Runnable() {
            public void run() {
                try {
                    timeUnit.sleep(delay);
                    copyFile(src, dest);
                } catch (Exception ex) {
                    LOGGER.log(Level.SEVERE, ex.getMessage(), ex);
                }
            }
        });
        executorService.shutdown();
    }

    void buildTestOutput(CapabilityKey key, String keyVal) {
        stringBuilder.append(key.getClass().getSimpleName());
        stringBuilder.append(":");
        stringBuilder.append(key);
        stringBuilder.append("->");
        stringBuilder.append(keyVal);
        stringBuilder.append(System.lineSeparator());
    }
}
