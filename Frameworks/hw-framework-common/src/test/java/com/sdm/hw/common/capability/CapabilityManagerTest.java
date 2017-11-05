package com.sdm.hw.common.capability;

import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;

public class CapabilityManagerTest extends CapabilityTest {
    @Test
    public void listBooleans() throws Exception {
        for (CapabilityBooleanKey key : CapabilityBooleanKey.values()) {
            buildTestOutput(key, String.valueOf(capabilityManager.getBoolean(key)));
        }
    }

    @Test
    public void listStrings() throws Exception {
        for (CapabilityStringKey key : CapabilityStringKey.values()) {
            buildTestOutput(key, capabilityManager.getString(key));
        }
    }

    @Test
    public void testBoolean() throws Exception {
        provinceCodeProvider.setCurrentProvinceCode(ProvinceCode.NOVA_SCOTIA);
        capabilityManager.clearCache();
        assertEquals(true, capabilityManager.getBoolean(CapabilityBooleanKey.ALLERGY_STATUS));

        provinceCodeProvider.setCurrentProvinceCode(ProvinceCode.NEW_BRUNSWICK);
        capabilityManager.clearCache();
        assertEquals(true, capabilityManager.getBoolean(CapabilityBooleanKey.ALLERGY_STATUS));

        provinceCodeProvider.setCurrentProvinceCode(ProvinceCode.ONTARIO);
        capabilityManager.clearCache();
        assertEquals(false, capabilityManager.getBoolean(CapabilityBooleanKey.ALLERGY_STATUS));
    }

    @Test
    public void testString() throws Exception {
        provinceCodeProvider.setCurrentProvinceCode(ProvinceCode.NOVA_SCOTIA);
        capabilityManager.clearCache();
        assertEquals("NS-String", capabilityManager.getString(CapabilityStringKey.TEST_2_LEVEL_GROUP));

        provinceCodeProvider.setCurrentProvinceCode(ProvinceCode.NEW_BRUNSWICK);
        capabilityManager.clearCache();
        assertEquals("NB-String", capabilityManager.getString(CapabilityStringKey.TEST_2_LEVEL_GROUP));

        provinceCodeProvider.setCurrentProvinceCode(ProvinceCode.ONTARIO);
        capabilityManager.clearCache();
        assertEquals("ON-String", capabilityManager.getString(CapabilityStringKey.TEST_2_LEVEL_GROUP));
    }

    @Test
    public void testInt() throws Exception {
        provinceCodeProvider.setCurrentProvinceCode(ProvinceCode.NOVA_SCOTIA);
        capabilityManager.clearCache();
        assertEquals(100, capabilityManager.getInt(CapabilityIntKey.TEST_2_LEVEL_GROUP));

        provinceCodeProvider.setCurrentProvinceCode(ProvinceCode.NEW_BRUNSWICK);
        capabilityManager.clearCache();
        assertEquals(200, capabilityManager.getInt(CapabilityIntKey.TEST_2_LEVEL_GROUP));

        provinceCodeProvider.setCurrentProvinceCode(ProvinceCode.ONTARIO);
        capabilityManager.clearCache();
        assertEquals(999, capabilityManager.getInt(CapabilityIntKey.TEST_2_LEVEL_GROUP));
    }

    @Test
    public void testDouble() throws Exception {
        provinceCodeProvider.setCurrentProvinceCode(ProvinceCode.NOVA_SCOTIA);
        capabilityManager.clearCache();
        assertEquals(1.5, capabilityManager.getDouble(CapabilityDoubleKey.TEST_2_LEVEL_GROUP), 0.0);

        provinceCodeProvider.setCurrentProvinceCode(ProvinceCode.NEW_BRUNSWICK);
        capabilityManager.clearCache();
        assertEquals(2.5, capabilityManager.getDouble(CapabilityDoubleKey.TEST_2_LEVEL_GROUP), 0.0);

        provinceCodeProvider.setCurrentProvinceCode(ProvinceCode.ONTARIO);
        capabilityManager.clearCache();
        assertEquals(10.9, capabilityManager.getDouble(CapabilityDoubleKey.TEST_2_LEVEL_GROUP), 0.0);
    }

    @Test
    public void testIllFormednessConfigAtStart() throws Exception {
        badConfigAtStartExecTestHelper(illFormedConfigFile);
    }

    @Test
    public void testInvalidConfigAtStart() throws Exception {
        badConfigAtStartExecTestHelper(illFormedConfigFile);
    }

    private void badConfigAtStartExecTestHelper(File badConfig) throws Exception{
        // Following line copies an bad config file into config file. This will cause a ConfigurationException
        // and put the framework in a loop util the configuration is fixed.
        copyFile(badConfig, capabilityFile);
        provinceCodeProvider.setCurrentProvinceCode(ProvinceCode.NOVA_SCOTIA);
        // Reset the capability manager to simulate a behaviour which would be similar at the starting of the System.
        CapabilityManager.reset();
        CapabilityManager capabilityManager = CapabilityManager.getInstance();
        // Following line copies a valid file into config file in a separate thread which will break the above loop.
        copyFile(validConfigFileNSallergyStatusTrue, capabilityFile, TimeUnit.SECONDS, 10);
        assertEquals(true, capabilityManager.getBoolean(CapabilityBooleanKey.ALLERGY_STATUS));
    }
    
    @Test
    public void testIllFormedConfigMidExec() throws IOException {
        badConfigMidExecTestHelper(illFormedConfigFile);
    }

    @Test
    public void testInvalidConfigMidExec() throws IOException {
        badConfigMidExecTestHelper(duplicateElementConfigFile);
    }

    /**
     * Helper function to test IllFormed Configuraiton scenarios
     */
    private void badConfigMidExecTestHelper(File badConfig) throws IOException{
        provinceCodeProvider.setCurrentProvinceCode(ProvinceCode.NOVA_SCOTIA);
        CapabilityManager.reset();
        CapabilityManager capabilityManager = CapabilityManager.getInstance();
        assertEquals(true, capabilityManager.getBoolean(CapabilityBooleanKey.ALLERGY_STATUS));
        // Following line copies an ill-Formed config file into config file. This will cause a ConfigurationException
        // and put the framework in a loop util the configuration is fixed.
        copyFile(badConfig, capabilityFile);
        // Sleep for 30 seconds to let the system load ill-formed configuration file before processing it.
        sleep(TimeUnit.SECONDS, 10);
        // Following line copies a valid file into config file in a separate thread which will break the above loop.
        copyFile(validConfigFileNSallergyStatusTrue, capabilityFile, TimeUnit.SECONDS, 10);
        assertEquals(true, capabilityManager.getBoolean(CapabilityBooleanKey.ALLERGY_STATUS));
    }
}
