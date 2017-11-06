package com.sdm.hw.common.capability;

import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

abstract public class CapabilityTest {
    private static Logger LOGGER = Logger.getLogger(CapabilityTest.class.getName());
    protected static File illFormedConfig = null;
    protected static File validConfig = null;
    protected static File invalidConfig = null;
    protected static File capabilityConfig = null;
    protected static String tempDirPath = null;
    protected static CapabilityManager capabilityManager = CapabilityManager.getInstance();
    protected static ProvinceCodeProvider provinceCodeProvider = ProvinceCodeProvider.getInstance();
    protected static final int DELAY = ThreadLocalRandom.current().nextInt(0, 30);
    ;

    protected static String VALID_CONFIG_NAME = "capability-valid.xml";
    protected static String ILLFORMED_CONFIG_NAME = "capability-illformed.xml";
    protected static String INVALID_CONFIG_NAME = "capability-invalid.xml";
    protected static String CAPABILITY_CONFIG_NAME = "capability.xml";

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(System.lineSeparator());
        ClassLoader classLoader = CapabilityTest.class.getClassLoader();
        validConfig = new File(classLoader.getResource(VALID_CONFIG_NAME).getFile());
        illFormedConfig = new File(classLoader.getResource(ILLFORMED_CONFIG_NAME).getFile());
        invalidConfig = new File(classLoader.getResource(INVALID_CONFIG_NAME).getFile());

        String parentPath = validConfig.getParent();

        // create capability file in the same directory as other test files
        capabilityConfig = new File(parentPath + File.separator + "capability.xml");
        tempDirPath = parentPath + File.separator + "tmp";


        stringBuilder.append("Using Delay                     : "
                + DELAY + System.lineSeparator());
        stringBuilder.append("InvalidCapabilityFile                     : "
                + illFormedConfig.getAbsolutePath() + System.lineSeparator());
        stringBuilder.append("Valid Config File NS allergy Status True  : "
                + validConfig.getAbsolutePath() + System.lineSeparator());
        stringBuilder.append("Duplicate Element Capability File         : "
                + invalidConfig.getAbsolutePath() + System.lineSeparator());
        stringBuilder.append("CapabilityFile                            : "
                + capabilityConfig.getAbsolutePath() + System.lineSeparator());

        LOGGER.info(stringBuilder.toString());
    }

    @AfterClass
    public static void tearDownAfterClass() {
        // cleanup/delete files and directories which were created during
        // execution of the this test suite.
        FileUtils.deleteQuietly(new File(tempDirPath));
        FileUtils.deleteQuietly(capabilityConfig);
    }

    @Before
    public void setUp() throws Exception {
        copyFile(validConfig, capabilityConfig);
        provinceCodeProvider.setCurrentProvinceCode(ProvinceCode.NOVA_SCOTIA);
        capabilityManager.clearCache();
    }

    @After
    public void tearDown() throws Exception {
    }

    void touchCapabilityFile() throws IOException {
        FileUtils.touch(capabilityConfig);
    }

    void moveCapabilityToTempDir() throws IOException {
        File tempConfig = new File(tempDirPath + File.pathSeparator + CAPABILITY_CONFIG_NAME);
        if (capabilityConfig.exists() && !tempConfig.exists()) {
            // create capability file in the same directory as other test files
            FileUtils.moveFileToDirectory(capabilityConfig, new File(tempDirPath), true);
        }
    }

    void deleteTempDir() throws IOException {
        FileUtils.forceDelete(new File(tempDirPath));
    }

    void deleteCapabilityFile() throws IOException {
        if (capabilityConfig.exists()) {
            FileUtils.forceDelete(capabilityConfig);
        }
    }

    /**
     * Following is a common method used for copying files
     *
     * @param src  Source File
     * @param dest Destination File
     * @throws IOException
     */
    protected void copyFile(final File src, final File dest) throws IOException {
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
    protected void copyFile(final File src, final File dest, final TimeUnit timeUnit, final long delay) throws IOException {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        executorService.execute(new Runnable() {
            public void run() {
                try {
                    sleep(timeUnit, delay);
                    copyFile(src, dest);
                } catch (Exception ex) {
                    LOGGER.log(Level.SEVERE, ex.getMessage(), ex);
                }
            }
        });
        executorService.shutdown();
    }

    /**
     * @param timeUnit
     * @param delay
     */

    protected void sleep(final TimeUnit timeUnit, final long delay) {
        try {
            timeUnit.sleep(delay);
        } catch (InterruptedException ex) {
            LOGGER.log(Level.SEVERE, ex.getMessage(), ex);
        }
    }

    protected void buildTestOutput(CapabilityKey key, String keyVal) {
        StringBuilder sb = new StringBuilder();
        sb.append(key.getClass().getSimpleName());
        sb.append(":");
        sb.append(key);
        sb.append(keyVal);
        sb.append(System.lineSeparator());
    }
}
