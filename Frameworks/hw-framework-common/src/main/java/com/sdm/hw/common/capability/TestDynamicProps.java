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

import java.io.File;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class TestDynamicProps {

    private static final String CAPABILITY_CONFIG_FILE = "capability-Test.xml";

    public static void main(String[] args) throws Exception {
        ClassLoader cl = ClassLoader.getSystemClassLoader();

        URL[] urls = ((URLClassLoader)cl).getURLs();

        for(URL url: urls){
            System.out.println(url.getFile());
        }


//        try {
//            test1();
//            test2();
            test3();
//        } catch (Exception ex){
//            ex.printStackTrace();
//        }
    }

    private static void test1() throws Exception {

        List<FileLocationStrategy> subs = Arrays.asList(
                new ProvidedURLLocationStrategy(),
                new FileSystemLocationStrategy(),
                new ClasspathLocationStrategy());
        FileLocationStrategy strategy = new CombinedLocationStrategy(subs);
        Parameters params = new Parameters();

        ReloadingFileBasedConfigurationBuilder<XMLConfiguration> builder =
                new ReloadingFileBasedConfigurationBuilder<>(XMLConfiguration.class)
                        .configure(params.xml()
                                .setLocationStrategy(strategy)
                                .setFileName(CAPABILITY_CONFIG_FILE)
                                .setSchemaValidation(true));

        try {
            // This will throw a ConfigurationException if the XML document does not
            // conform to its schema.
            builder.getConfiguration().setExpressionEngine(new XPathExpressionEngine());
        } catch (ConfigurationException cex) {
            // loading of the configuration file failed
            cex.printStackTrace();
        }
        PeriodicReloadingTrigger trigger = new PeriodicReloadingTrigger(builder.getReloadingController(),
                null, 1, TimeUnit.SECONDS);
        trigger.start();

        builder.addEventListener(ConfigurationBuilderEvent.ANY, new EventListener<ConfigurationBuilderEvent>() {
            public void onEvent(ConfigurationBuilderEvent event) {
                System.out.println("Event:" + event);
            }
        });
        String string = "capabilityGroup[@name='eHealth']/capability[@name='decnBusinessEntityType']/value[@code='NS']";
        execute(builder, string);
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

    private static void test2() throws Exception{
        Parameters params = new Parameters();
        ReloadingFileBasedConfigurationBuilder<PropertiesConfiguration> builder =
                new ReloadingFileBasedConfigurationBuilder<PropertiesConfiguration>(PropertiesConfiguration.class)
                        .configure(params.fileBased()
                                .setFile(new File("C:\\workspace\\Delta\\capability-framework\\config\\override_ext.properties")));
        PeriodicReloadingTrigger trigger = new PeriodicReloadingTrigger(builder.getReloadingController(),
                null, 1, TimeUnit.SECONDS);
        trigger.start();

        builder.addEventListener(ConfigurationBuilderEvent.ANY, new EventListener<ConfigurationBuilderEvent>() {

            public void onEvent(ConfigurationBuilderEvent event) {
                System.out.println("Event:" + event);
            }
        });
        execute(builder, "property1");
    }

    private static void test3() throws Exception{
        Parameters params = new Parameters();
        final ReloadingFileBasedConfigurationBuilder<XMLConfiguration> builder =
                new ReloadingFileBasedConfigurationBuilder<XMLConfiguration>(XMLConfiguration.class)
//                        .configure(params.fileBased()
//                                .setFile(new File("C:\\workspace\\Delta\\capability-framework\\config\\database_ext.xml")));
//                                .setFileName(CAPABILITY_CONFIG_FILE));
//                                .setSchemaValidation(true))
                        .configure(params.xml()
                                    .setFileName(CAPABILITY_CONFIG_FILE)
                                    .setSchemaValidation(true));





//        builder.getConfiguration().setSchemaValidation(true);
        builder.getConfiguration().setExpressionEngine(new XPathExpressionEngine());
        System.out.println("Expression Engine:" + builder.getConfiguration().getExpressionEngine().getClass().getName());

        PeriodicReloadingTrigger trigger = new PeriodicReloadingTrigger(builder.getReloadingController(),
                null, 1, TimeUnit.SECONDS);
        trigger.start();

//        builder.addEventListener(ConfigurationBuilderEvent.ANY, new EventListener<ConfigurationBuilderEvent>() {
//            public void onEvent(ConfigurationBuilderEvent event) {
//                System.out.println("Event:" + event);
//                try {
//                    System.out.println(builder.getConfiguration().getExpressionEngine().getClass().getName());
//                } catch (Exception ex) {
//                    ex.printStackTrace();
//                }
//            }
//        });

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


//        String string = "tables.table(0).name";
//        String string = "tables/table[1]/name";
        String string = "capabilityGroup[@name='eHealth']/capability[@name='decnBusinessEntityType']/value[@code='NS']";
        execute(builder, string);
    }
}
