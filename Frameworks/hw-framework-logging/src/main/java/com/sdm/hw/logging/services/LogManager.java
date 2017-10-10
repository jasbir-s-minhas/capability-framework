package com.sdm.hw.logging.services;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ch.qos.logback.classic.LoggerContext;
import ch.qos.logback.classic.joran.JoranConfigurator;
import ch.qos.logback.core.joran.spi.JoranException;

import com.sdm.hw.logging.intf.HwLogger;

/**
 * This class will configure logback by reading properties from classpath. It
 * will also return a ApplicationLogger object for hw application.
 * 
 * @author TCS
 * 
 */
public class LogManager {
	public static final String FATAL_MSG = "FATAL";
	public static final String TRACE_MSG = "TRACE";
	private static Properties properties = new Properties();
	private static final String LOG_CONFIG_FILE_NAME = "logback_config.properties";
	private static final Logger LOGGER = LoggerFactory
			.getLogger(LogManager.class);
	/**
	 * Static block to initialize the Logback configuration for the Application
	 */
	static {
		loadLogConfiguration();
	}

	/**
	 * This is used to get HwLogger class
	 * 
	 * @param clazz
	 *            reference of class
	 * @return an instance of HwLogger
	 */
	public static HwLogger getLogger(final Class<?> clazz) {
return new ApplicationLogger(clazz);
	}

	/**
	 * Used to read properties file from the classpath. From that properties
	 * file the external logback configuration file will be loaded and logback
	 * framework will be configured
	 */
	private static void loadLogConfiguration() {
		String hwLogConfigLoc = null;

		try {
			InputStream resourceAsStream = Thread.currentThread()
					.getContextClassLoader()
					.getResourceAsStream(LOG_CONFIG_FILE_NAME);
			if (null != resourceAsStream) {
				properties.load(resourceAsStream);
				hwLogConfigLoc = properties
						.getProperty("HW_LOG_CONFIG_LOCATION");
				final File hwLogConfigFile = new File(hwLogConfigLoc);
				if (hwLogConfigFile.exists() && hwLogConfigFile.isFile()
						&& hwLogConfigFile.canRead()) {
					final LoggerContext loggerContext = (LoggerContext) LoggerFactory
							.getILoggerFactory();
					final JoranConfigurator configurator = new JoranConfigurator();
					configurator.setContext(loggerContext);
					loggerContext.reset();
					configurator.doConfigure(hwLogConfigLoc);
					LOGGER.info(
							"Logback logger is Configured with config file from: {}",
							hwLogConfigLoc);

				} else {
					throw new IOException(
							"Logback External Config File(\"{}\") exists and is a file, but cannot be read.");
				}
			} else {
				throw new IOException(
						"Logback external property file is not present in classpath");
			}
		} catch (final IOException ioe) {
			LOGGER.error(
					new StringBuilder(
							"Hw Logger is not initialized due to the below exception : \n")
							.append(ioe.getMessage()).toString(),
					hwLogConfigLoc);
		} catch (final JoranException je) {
			LOGGER.error("Hw Logger is not initialized : ", je);
		}

	}

	/**
	 * This method retrieves the vale of a log property and return that value to
	 * the caller method. During the first load of this class the property file
	 * is loaded and cached into the memory.
	 * 
	 * @param key
	 * @return value for the key from properties file.
	 */
	public static String getLogProperty(String key) {
		return properties.getProperty(key);
	}
}
