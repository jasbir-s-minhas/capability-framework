package com.sdm.hw.common.capability;

import org.apache.commons.configuration2.XMLConfiguration;
import org.apache.commons.configuration2.builder.FileBasedConfigurationBuilder;
import org.apache.commons.configuration2.builder.fluent.Parameters;
import org.apache.commons.configuration2.ex.ConfigurationException;
import org.apache.commons.configuration2.tree.xpath.XPathExpressionEngine;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * This framework class is implemented as a singleton pattern. It is the main class for loading and caching Capability
 * related information used by the application.
 *
 * @author Jasbir Minhas
 * @version 1.0
 * @since 2017-10-10
 */
public class CapabilityManager {
    // Singleton Class initialization
    private static final CapabilityManager _instance;
    private static Logger LOGGER = Logger.getLogger(CapabilityManager.class.getName());

    static {
        _instance = new CapabilityManager();
        _instance.init();
    }

    // Loaded XMLConfiguraiton
    private XMLConfiguration config = null;

    // Following tokens are used for building XPath for a capability.
    // e.g.: capabilityGroup[@name='eHealth']/capability[name='correlationService']/value
    private static final String XPATH_PREFIX = "capabilityGroup[@name='";
    private static final String CLOSE_BRACKET = "']/";
    private static final String DELIMITER = "\\.";
    private static final String ENABLED_TAG = "@enabled";
    private static final String CAPABILITY_NAME_TAG ="capability[name='";
    private static final String VALUE_TAG="value";

    /**
     * Private constructor for singleton
     */
    private CapabilityManager() {
    }

    public static CapabilityManager getInstance() {
        return _instance;
    }

    private void init() {
        initConfig("capability.xml", true);
        config.setExpressionEngine(new XPathExpressionEngine());
    }

    private void initConfig(String xmlConfigFile, boolean validate) {
        Parameters params = new Parameters();
        try {
            FileBasedConfigurationBuilder<XMLConfiguration> builder =
                    new FileBasedConfigurationBuilder<>(XMLConfiguration.class)
                            .configure(params.xml()
                                    .setFileName(xmlConfigFile)
                                    .setSchemaValidation(validate));
            // This will throw a ConfigurationException if the XML document does not
            // conform to its schema.
            config = builder.getConfiguration();
        } catch (ConfigurationException cex) {
            // loading of the configuration file failed
            LOGGER.log(Level.SEVERE, cex.getMessage(), cex);
        }

    }

    /**
     * This method is used to determine if a capability is enable or not
     * @param key an enum of CapabilityKey type
     * @return boolean true or false
     */
    public boolean getBoolean(CapabilityKey key) {
        boolean capbilityEnabled = false;
        if (isGroupEnabled(key)){
            capbilityEnabled = config.getBoolean(getCapabiltyXpath(key));
        }
        return capbilityEnabled;
    }

    /**
     * This method is used to return a text of the Capability
     * @param key an enum of CapabilityKey type
     * @return String a text value of the capability
     */
    public String getString(CapabilityKey key) {
        return config.getString(getCapabiltyXpath(key));
    }

    /**
     * This method is used to return a int value of a Capability
     * @param key an enum of CapabilityKey type
     * @return int an int value of the capability
     */
    public int getInt(CapabilityKey key) {
        return config.getInt(getCapabiltyXpath(key));
    }

    /**
     * This method is used to return a float value of a Capability
     * @param key an enum of CapabilityKey type
     * @return float a float value of the capability
     */
    public float getFloat(CapabilityKey key) {
        return config.getFloat(getCapabiltyXpath(key));
    }

    private String getGroupXPath(CapabilityKey key) {
        StringBuilder groupXpath = new StringBuilder();

        String[] tokens = key.toString().split(DELIMITER);
        int numOfGroups = tokens.length - 1; // last one is not a group
        for(int i=0; i < numOfGroups; i++){
            groupXpath.append(XPATH_PREFIX);
            groupXpath.append(tokens[i]);
            groupXpath.append(CLOSE_BRACKET);
        }
        return groupXpath.toString();
    }

    private String getCapabiltyXpath(CapabilityKey key){
        String[] tokens = key.toString().split(DELIMITER);
        String capability = tokens[tokens.length - 1];
        StringBuilder capabilityXPath = new StringBuilder();
        capabilityXPath.append(getGroupXPath(key));
        capabilityXPath.append(CAPABILITY_NAME_TAG);
        capabilityXPath.append(capability);
        capabilityXPath.append(CLOSE_BRACKET);
        capabilityXPath.append(VALUE_TAG);
        return  capabilityXPath.toString();
    }

    private boolean isGroupEnabled(CapabilityKey key) {
        boolean groupEnable = true;

        StringBuilder groupXPath = new StringBuilder();

        String[] tokens = key.toString().split(DELIMITER);
        int numOfGroups = tokens.length - 1; // last one is not a group
        for(int i=0; i < numOfGroups; i++){
            groupXPath.append(XPATH_PREFIX);
            groupXPath.append(tokens[i]);
            groupXPath.append(CLOSE_BRACKET);
            if (! config.getBoolean(groupXPath.toString()+ ENABLED_TAG)){
                // if any of the groups in hierarchy is disabled, all the sub group will be considered disabled
                groupEnable = false;
                break;
            }
        }
        return groupEnable;
    }
}
