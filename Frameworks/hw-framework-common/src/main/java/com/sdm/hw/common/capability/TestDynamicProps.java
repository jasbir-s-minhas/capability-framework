package com.sdm.hw.common.capability;

import org.apache.commons.configuration2.Configuration;
import org.apache.commons.configuration2.PropertiesConfiguration;
import org.apache.commons.configuration2.XMLConfiguration;
import org.apache.commons.configuration2.builder.ConfigurationBuilderEvent;
import org.apache.commons.configuration2.builder.FileBasedConfigurationBuilder;
import org.apache.commons.configuration2.builder.ReloadingFileBasedConfigurationBuilder;
import org.apache.commons.configuration2.builder.fluent.Parameters;
import org.apache.commons.configuration2.event.EventListener;
import org.apache.commons.configuration2.ex.ConfigurationException;
import org.apache.commons.configuration2.io.*;
import org.apache.commons.configuration2.reloading.PeriodicReloadingTrigger;
import org.apache.commons.configuration2.tree.xpath.XPathExpressionEngine;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class TestDynamicProps {

    private static final String CAPABILITY_CONFIG_FILE = "capability-Test.xml";

    public static void main(String[] args) throws Exception {
//        test1();
        test2();
    }


    private static void execute(FileBasedConfigurationBuilder builder, String string){

        while (true) {
            try {
                Thread.sleep(5000);
                System.out.println(System.currentTimeMillis() + " : " + builder.getConfiguration().getString(string));
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }

    private static void test1() throws Exception{
        Parameters params = new Parameters();
        final ReloadingFileBasedConfigurationBuilder<XMLConfiguration> builder =
                new ReloadingFileBasedConfigurationBuilder<XMLConfiguration>(XMLConfiguration.class)
                        .configure(params.xml()
                                    .setFileName(CAPABILITY_CONFIG_FILE)
                                    .setSchemaValidation(true));
        builder.getConfiguration().setExpressionEngine(new XPathExpressionEngine());
        System.out.println("Expression Engine:" + builder.getConfiguration().getExpressionEngine().getClass().getName());

        PeriodicReloadingTrigger trigger = new PeriodicReloadingTrigger(builder.getReloadingController(),
                null, 1, TimeUnit.SECONDS);
        trigger.start();

        builder.addEventListener(ConfigurationBuilderEvent.RESET, new EventListener<ConfigurationBuilderEvent>() {
            public void onEvent(ConfigurationBuilderEvent event) {
                System.out.println("Event:" + event);
                try {
                    builder.getConfiguration().setExpressionEngine(new XPathExpressionEngine());
                    builder.getConfiguration().setSchemaValidation(true);
                    System.out.println("Expression Engine:" + builder.getConfiguration().getExpressionEngine().getClass().getName());
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });
        String string = "capabilityGroup[@name='eHealth']/capability[@name='decnBusinessEntityType']/value[@code='NS']";
        execute(builder, string);
    }
    private static void test2(){
        ProvinceCodeProvider.getInstance().setCurrentProvinceCode(ProvinceCode.NOVA_SCOTIA);

        while (true){
            try {
                TimeUnit.SECONDS.sleep(5);
                System.out.println(CapabilityBooleanKey.ALLERGY_STATUS.isEnabled());
            } catch (InterruptedException ex){
                ex.printStackTrace();
            }
        }
    }
}
