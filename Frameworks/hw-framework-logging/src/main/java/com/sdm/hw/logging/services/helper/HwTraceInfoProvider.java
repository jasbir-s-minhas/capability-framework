package com.sdm.hw.logging.services.helper;

import org.springframework.util.StringUtils;

import com.sdm.hw.logging.intf.HwLogger;
import com.sdm.hw.logging.services.LogManager;
/**
 * This classs is a helper class to the spring bean configuration xml.
 * This will retrieve the tracing property (HW_TRACING) from the property file
 * @author TCS
 *
 */
public class HwTraceInfoProvider {
	private static HwLogger logger = LogManager
			.getLogger(HwTraceInfoProvider.class);
	//This field indicates whether tracing will be on or off for the application
	private boolean tracingEnabled = false;
	//This is a default point cut which will be used if the tracing is off for the application
	private String defaultPointCut="execution(* com.sdm.hw.logging.services.helper.*.*(..))";
	/**
	 * This method initialize the tracing property.
	 * This method will be called during spring initialization.
	 */
	public void initTraccing() {
		//Retrieves the tracing property from the LogManager class. 
		String traceConfigValue = LogManager.getLogProperty("HW_TRACING");
		/*If the tracing property is set to ON then tracingEnabled flag will be set to true
		 * In any other case that flag will be set to false always.
		 */
		if (!StringUtils.isEmpty(traceConfigValue)
				&& traceConfigValue.equalsIgnoreCase("ON")) {
			tracingEnabled = true;
			logger.logInfo(
					"Tracing is on for the application. System will log trace info according to configuration.");
		} else {
			tracingEnabled = false;
			logger.logInfo(
					"Tracing is off for the application.");
		}
	}
	
	/**
	 * getter method of tracingEnabled property.
	 * @return
	 */
	public boolean isTracingEnabled() {
		return tracingEnabled;
	}
	
	/**
	 * setter method of tracingEnabled property.
	 * @param tracingEnabled
	 */
	public void setTracingEnabled(boolean tracingEnabled) {
		this.tracingEnabled = tracingEnabled;
	}

	public String getDefaultPointCut() {
		return defaultPointCut;
	}

	public void setDefaultPointCut(String defaultPointCut) {
		this.defaultPointCut = defaultPointCut;
	}

}
