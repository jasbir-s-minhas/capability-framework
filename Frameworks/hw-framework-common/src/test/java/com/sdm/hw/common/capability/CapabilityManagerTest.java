package com.sdm.hw.common.capability;

import org.junit.Test;

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
        capabilityManager.reset();
        assertEquals(true, capabilityManager.getBoolean(CapabilityBooleanKey.ALLERGY_STATUS));

        provinceCodeProvider.setCurrentProvinceCode(ProvinceCode.NEW_BRUNSWICK);
        capabilityManager.reset();
        assertEquals(true, capabilityManager.getBoolean(CapabilityBooleanKey.ALLERGY_STATUS));

        provinceCodeProvider.setCurrentProvinceCode(ProvinceCode.ONTARIO);
        capabilityManager.reset();
        assertEquals(false, capabilityManager.getBoolean(CapabilityBooleanKey.ALLERGY_STATUS));
    }

    @Test
    public void testIllFormednessConfigDuringExec() throws Exception {

        provinceCodeProvider.setCurrentProvinceCode(ProvinceCode.NOVA_SCOTIA);
        // Following line copies an ill-Formed config file into config file. This will cause a ConfigurationException
        // and put the framework in a loop util the configuration is fixed.
        copyFile(illFormedConfigFile, capabilityFile);
        // Following line copies a valid file into config file in a separate thread which will break the above loop.
        copyFile(validConfigFileNSallergyStatusTrue, capabilityFile, TimeUnit.SECONDS, 10);
        assertEquals(true, capabilityManager.getBoolean(CapabilityBooleanKey.ALLERGY_STATUS));
    }
    @Test
    public void testIllFormednessConfigAtStart() throws Exception {

        provinceCodeProvider.setCurrentProvinceCode(ProvinceCode.NOVA_SCOTIA);
        // Following line copies an ill-Formed config file into config file. This will cause a ConfigurationException
        // and put the framework in a loop util the configuration is fixed.
        copyFile(illFormedConfigFile, capabilityFile);
        // Following line copies a valid file into config file in a separate thread which will break the above loop.
        copyFile(validConfigFileNSallergyStatusTrue, capabilityFile, TimeUnit.SECONDS, 10);
        assertEquals(true, capabilityManager.getBoolean(CapabilityBooleanKey.ALLERGY_STATUS));
    }
}