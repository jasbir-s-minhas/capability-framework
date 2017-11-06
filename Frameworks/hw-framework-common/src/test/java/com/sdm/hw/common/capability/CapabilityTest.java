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
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

abstract public class CapabilityTest {
    private static Logger LOGGER = Logger.getLogger(CapabilityTest.class.getName());
    protected static File illFormedConfig = null;
    protected static File validConfig = null;
    protected static File invalidConfig = null;
    protected static File capabilityFile = null;
    protected static File tempDir = null;
    protected static CapabilityManager capabilityManager = CapabilityManager.getInstance();
    protected static ProvinceCodeProvider provinceCodeProvider = ProvinceCodeProvider.getInstance();

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(System.lineSeparator());
        ClassLoader classLoader = CapabilityTest.class.getClassLoader();
        validConfig = new File(classLoader.getResource("capability-valid.xml").getFile());
        illFormedConfig = new File(classLoader.getResource("capability-illformed.xml").getFile());
        invalidConfig = new File(classLoader.getResource("capability-invalid.xml").getFile());

        String parentPath = validConfig.getParent();

        // create capability file in the same directory as other test files
        capabilityFile = new File(parentPath + File.separator + "capability.xml");

        stringBuilder.append("InvalidCapabilityFile                     : "
                + illFormedConfig.getAbsolutePath() + System.lineSeparator());
        stringBuilder.append("Valid Config File NS allergy Status True  : "
                + validConfig.getAbsolutePath() + System.lineSeparator());
        stringBuilder.append("Duplicate Element Capability File         : "
                + invalidConfig.getAbsolutePath() + System.lineSeparator());
        stringBuilder.append("CapabilityFile                            : "
                + capabilityFile.getAbsolutePath() + System.lineSeparator());

        LOGGER.info(stringBuilder.toString());
    }
    @AfterClass
    public static void tearDownAfterClass() throws Exception{

    }

    @Before
    public void setUp() throws Exception{
        capabilityManager.clearCache();
        provinceCodeProvider.setCurrentProvinceCode(ProvinceCode.NOVA_SCOTIA);
        copyFile(validConfig, capabilityFile);
    }

    @After
    public void tearDown() throws Exception {
    }

    void touchCapabilityFile() throws IOException {
        FileUtils.touch(capabilityFile);
    }

    void moveCapabilityToTempDir() throws IOException {
        if (isCapabilityFileExit()){
            String parentPath = validConfig.getParent();
            // create capability file in the same directory as other test files
            capabilityFile = new File(parentPath + File.separator + "capability.xml");
            tempDir = new File(parentPath + File.separator + "tmp");
            FileUtils.moveFileToDirectory(capabilityFile, tempDir, true);
        }
    }

    void deleteTempDir() throws IOException {
        FileUtils.forceDelete(tempDir);
    }

    void  deleteCapabilityFile()  throws IOException{
        if (isCapabilityFileExit()){
            FileUtils.forceDelete(capabilityFile);
        }
    }

    boolean isCapabilityFileExit(){
        return FileUtils.waitFor(capabilityFile, 20);
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
     *
     * @param timeUnit
     * @param delay
     */

    protected void sleep(final TimeUnit timeUnit, final long delay){
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
