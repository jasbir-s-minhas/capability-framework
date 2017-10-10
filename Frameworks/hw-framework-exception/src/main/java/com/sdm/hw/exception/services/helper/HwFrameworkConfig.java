package com.sdm.hw.exception.services.helper;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import com.sdm.hw.logging.intf.HwLogger;
import com.sdm.hw.logging.services.LogManager;

/**
 * This class would load exception framework properties file
 * (exp-framework.properties) which contains Exception handler type along with
 * key. This factory class must be singleton Contains the configuration
 * information i.e exception handler type for exception framework.
 * 
 * @author TCS
 * 
 */
public final class HwFrameworkConfig {

    private static final HwLogger logger = LogManager
            .getLogger(HwFrameworkConfig.class);

    private final Properties configproperties;

    /**
     * A private constructor to create an HwFrameworkConfig instance.
     */
    private HwFrameworkConfig() {
        configproperties = new Properties();

        // exception framework properties
        final InputStream stream = HwFrameworkConfig.class
                .getResourceAsStream("/expframework-config.properties");

        if (null == stream) {
            logger.logError("Could not load expframework-config.properties.");
        }
        try {
            // Load expframework properties file
            configproperties.load(stream);

        }
        catch (final IOException exp) {
            logger.logError(
                    "An error occurred when reading from the input stream", exp);

        }
        finally {
            try {
                if (null != stream) {
                    stream.close();
                }
            }
            catch (final IOException exp) {
                logger.logError("An error occurred while closing stream.", exp);
            }
        }

    }

    /**
     * Get Instance of HwFrameworkConfig class
     * 
     * @return expframeconfig instance of HwFrameworkConfig
     */
    public static HwFrameworkConfig getInstance() {
        return new HwFrameworkConfig();
    }

    /**
     * get value from config properties on the basis of key i.e exception
     * handler type
     * 
     * @param key
     *            in string form
     * @return string value of property from property file.
     */
    public String get(final String key) {
        if (configproperties == null || key == null) {
            return null;
        }

        return (String) configproperties.get(key);

    }
}