package com.sdm.hw.common.capability;

import org.junit.Test;

import java.io.File;
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
    public void testIllFormednessConfigAtStart() throws Exception {
        copyFile(illFormedConfigFile, capabilityFile);
        provinceCodeProvider.setCurrentProvinceCode(ProvinceCode.NOVA_SCOTIA);
        CapabilityManager.reset();
        CapabilityManager capabilityManager = CapabilityManager.getInstance();
        // Following line copies an ill-Formed config file into config file. This will cause a ConfigurationException
        // and put the framework in a loop util the configuration is fixed.
        // Following line copies a valid file into config file in a separate thread which will break the above loop.
        copyFile(validConfigFileNSallergyStatusTrue, capabilityFile, TimeUnit.SECONDS, 10);
        assertEquals(true, capabilityManager.getBoolean(CapabilityBooleanKey.ALLERGY_STATUS));
    }

    @Test
    public void testIllFormednessConfigDuringExec() throws Exception {
        invalidConfigFileTestHelper(illFormedConfigFile);
    }
    @Test
    public void testInvalidConfigDuringExec() throws Exception {
        invalidConfigFileTestHelper(duplicateElementConfigFile);
    }
    /**
     * Helper function to test
     */
    private void invalidConfigFileTestHelper(File invalidFile) throws Exception{
        provinceCodeProvider.setCurrentProvinceCode(ProvinceCode.NOVA_SCOTIA);
        CapabilityManager.reset();
        CapabilityManager capabilityManager = CapabilityManager.getInstance();
        assertEquals(true, capabilityManager.getBoolean(CapabilityBooleanKey.ALLERGY_STATUS));
        // Following line copies an ill-Formed config file into config file. This will cause a ConfigurationException
        // and put the framework in a loop util the configuration is fixed.
        copyFile(invalidFile, capabilityFile);
        // Sleep for 30 seconds to let the system load ill-formed configuration file before processing it.
        sleep(TimeUnit.SECONDS, 10);
        // Following line copies a valid file into config file in a separate thread which will break the above loop.
        copyFile(validConfigFileNSallergyStatusTrue, capabilityFile, TimeUnit.SECONDS, 10);
        assertEquals(true, capabilityManager.getBoolean(CapabilityBooleanKey.ALLERGY_STATUS));
    }
}
