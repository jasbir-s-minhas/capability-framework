package com.sdm.hw.common.capability;

import org.apache.commons.configuration2.XMLConfiguration;
import org.apache.commons.configuration2.builder.ConfigurationBuilderEvent;
import org.apache.commons.configuration2.builder.ReloadingFileBasedConfigurationBuilder;
import org.apache.commons.configuration2.builder.fluent.Parameters;
import org.apache.commons.configuration2.event.EventListener;
import org.apache.commons.configuration2.ex.ConfigurationException;
import org.apache.commons.configuration2.reloading.PeriodicReloadingTrigger;
import org.apache.commons.configuration2.tree.xpath.XPathExpressionEngine;

import java.io.File;
import java.util.concurrent.TimeUnit;

public class TestDynamicProps {

    private static final String CAPABILITY_CONFIG_FILE = "capability.xml";

    public static void main(String[] args) throws Exception {


        Parameters params = new Parameters();
//        ReloadingFileBasedConfigurationBuilder<XMLConfiguration> builder2 =
//                new ReloadingFileBasedConfigurationBuilder<>(XMLConfiguration.class)
//                        .configure(params.xml()
//                                .setFileName(CAPABILITY_CONFIG_FILE)
//                                .setSchemaValidation(true));

        final ReloadingFileBasedConfigurationBuilder<XMLConfiguration> builder =
                new ReloadingFileBasedConfigurationBuilder<XMLConfiguration>(XMLConfiguration.class)
                        .configure(params.xml()
                                .setFile(new File(CAPABILITY_CONFIG_FILE))
//                                .setFileName(CAPABILITY_CONFIG_FILE)
                                .setSchemaValidation(true));


        // Register an event listener for triggering reloading checks
//        builder.addEventListener(ConfigurationBuilderEvent.CONFIGURATION_REQUEST,
//                new EventListener<ConfigurationBuilderEvent>()
//                {
//                    @Override
//                    public void onEvent(ConfigurationBuilderEvent event)
//                    {
//                        builder.getReloadingController().checkForReloading(null);
//                    }
//                });

        try {
            // This will throw a ConfigurationException if the XML document does not
            // conform to its schema.
            XMLConfiguration config = null;
            config = builder.getConfiguration();
            config.setExpressionEngine(new XPathExpressionEngine());
        } catch (ConfigurationException cex) {
            // loading of the configuration file failed
            cex.printStackTrace();
        }

        ///
//        Parameters params = new Parameters();
//        ReloadingFileBasedConfigurationBuilder<PropertiesConfiguration> builder =
//                new ReloadingFileBasedConfigurationBuilder<PropertiesConfiguration>(PropertiesConfiguration.class)
//                        .configure(params.fileBased()
//                                .setFile(new File("override.properties")));
        PeriodicReloadingTrigger trigger = new PeriodicReloadingTrigger(builder.getReloadingController(),
                null, 1, TimeUnit.SECONDS);
        trigger.start();

        builder.addEventListener(ConfigurationBuilderEvent.ANY, new EventListener<ConfigurationBuilderEvent>() {

            public void onEvent(ConfigurationBuilderEvent event) {
                System.out.println("Event:" + event);
            }
        });
        while (true) {
            Thread.sleep(5000);
            System.out.println(builder.getConfiguration().getString("capabilityGroup[@name='eHealth']/capability[@name='decnBusinessEntityType']/value[@code='NS']"));
        }

    }
}
