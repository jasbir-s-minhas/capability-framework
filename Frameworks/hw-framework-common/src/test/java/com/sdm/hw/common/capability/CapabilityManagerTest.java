package com.sdm.hw.common.capability;

import org.apache.commons.configuration2.ex.ConfigurationException;
import org.apache.commons.io.FileUtils;
import org.junit.Test;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;


public class CapabilityManagerTest extends CapabilityTest {
//    @Test
//    public void listBooleans() throws Exception {
//        for (CapabilityBooleanKey key : CapabilityBooleanKey.values()) {
//            buildTestOutput(key, String.valueOf(capabilityManager.getBoolean(key)));
//        }
//    }
//
//    @Test
//    public void listStrings() throws Exception {
//        for (CapabilityStringKey key : CapabilityStringKey.values()) {
//            buildTestOutput(key, capabilityManager.getString(key));
//        }
//    }

//    @Test
//    public void testBoolean() throws Exception {
//
//        provinceCodeProvider.setCurrentProvinceCode(ProvinceCode.NOVA_SCOTIA);
//        capabilityManager.clearCache();
//        assertEquals(true, capabilityManager.getBoolean(CapabilityBooleanKey.ALLERGY_STATUS));
//
//        provinceCodeProvider.setCurrentProvinceCode(ProvinceCode.NEW_BRUNSWICK);
//        capabilityManager.clearCache();
//        assertEquals(true, capabilityManager.getBoolean(CapabilityBooleanKey.ALLERGY_STATUS));
//
//        provinceCodeProvider.setCurrentProvinceCode(ProvinceCode.ONTARIO);
//        capabilityManager.clearCache();
//        assertEquals(false, capabilityManager.getBoolean(CapabilityBooleanKey.ALLERGY_STATUS));
//   }

//    @Test (expected = ConfigurationException.class)
    @Test
    public void testConfigIllFormedness() throws Exception {

        provinceCodeProvider.setCurrentProvinceCode(ProvinceCode.NOVA_SCOTIA);
        // copy ill-Formed file into config file
        FileUtils.copyFile(illFormedCapabilityFile, capabilityFile);
        TimeUnit.SECONDS.sleep(10);
        capabilityManager.clearCache();
        assertEquals(true, capabilityManager.getBoolean(CapabilityBooleanKey.ALLERGY_STATUS));
        // Copy the valid file in config
        FileUtils.copyFile(validCapabilityFile, capabilityFile);
    }

}