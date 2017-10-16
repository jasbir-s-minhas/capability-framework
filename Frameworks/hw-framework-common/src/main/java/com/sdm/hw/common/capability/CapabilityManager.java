package com.sdm.hw.common.capability;

import org.apache.commons.configuration2.XMLConfiguration;
import org.apache.commons.configuration2.builder.FileBasedConfigurationBuilder;
import org.apache.commons.configuration2.builder.fluent.Parameters;
import org.apache.commons.configuration2.ex.ConfigurationException;
import org.apache.commons.configuration2.tree.xpath.XPathExpressionEngine;

import java.util.HashMap;
import java.util.Map;
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
    private static String currentProvCode;

    static {
        _instance = new CapabilityManager();
        _instance.init();
    }

    // Loaded XMLConfiguraiton
    private XMLConfiguration config = null;

    private CapabilityCache capabilityCache = new CapabilityCache();

    // Following tokens are used for building XPath for a capability.
    // e.g.: capabilityGroup[@name='eHealth']/capability[name='correlationService']/value
    // e.g.: capabilityGroup[@name='eHealth']/capability[@name='adrStatus']/value[@code='ON']
    private static final String PROV_CODE_XPATH="currentProv";
    private static final String XPATH_PREFIX = "capabilityGroup[@name='";
    private static final String CLOSE_BRACKET = "']";
    private static final String FORWARD_SLASH ="/";
    private static final String DELIMITER = "\\.";
    private static final String ENABLED_TAG = "enabled[@code='";
    private static final String CAPABILITY_NAME_TAG ="capability[@name='";
    private static final String VALUE_TAG="value[@code='";

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
        currentProvCode = config.getString(PROV_CODE_XPATH);
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
        Boolean capbilityEnabled = capabilityCache.getBoolean(key);
        if (capbilityEnabled == null){ // capability is not cached yet.
            if (isGroupEnabled(key)){
                capbilityEnabled = config.getBoolean(getCapabiltyXpath(key));
            } else {
                capbilityEnabled = false;
            }
            // add capability value to the cache
            capabilityCache.setBoolean(key,capbilityEnabled);
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
            groupXpath.append(FORWARD_SLASH);
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
        capabilityXPath.append(FORWARD_SLASH);
        capabilityXPath.append(VALUE_TAG);
        capabilityXPath.append(currentProvCode);
        capabilityXPath.append(CLOSE_BRACKET);
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
            groupXPath.append(FORWARD_SLASH);
            if (! config.getBoolean(groupXPath.toString()+ENABLED_TAG+currentProvCode+CLOSE_BRACKET)){
                // if any of the groups in hierarchy is disabled, all the sub group will be considered disabled
                groupEnable = false;
                break;
            }
        }
        return groupEnable;
    }

    /**
     * Inner class encapsulating capability cache
     */
    private class CapabilityCache{
        // Hash map storing capability cache
        private Map<CapabilityKey, Object> cacheMap = new HashMap<>();

        // getters and setters
        public Boolean getBoolean(CapabilityKey key){
            return (Boolean) cacheMap.get(key);
        }
        public void setBoolean(CapabilityKey key, Boolean val){
            cacheMap.put(key, val);
        }

        private String getString(String key){
            return (String) cacheMap.get(key);
        }
        private void setString(CapabilityKey key, String val){
            cacheMap.put(key, val);
        }

        private Integer getInt(CapabilityKey key){
            return (Integer) cacheMap.get(key);
        }
        private void setInt(CapabilityKey key, Integer val){
            cacheMap.put(key, val);
        }

        private Float getFloat(CapabilityKey key){
            return (Float) cacheMap.get(key);
        }
        private void setFloat(CapabilityKey key, Float val){
            cacheMap.put(key, val);
        }
        private boolean isCached(CapabilityKey key){
            return  cacheMap.containsKey(key);
        }
    }
}
