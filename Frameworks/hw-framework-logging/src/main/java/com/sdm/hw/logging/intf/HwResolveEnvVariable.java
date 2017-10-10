package com.sdm.hw.logging.intf;

public class HwResolveEnvVariable {

	private static final String UNIX_DEFAULT_PATH = "/temp/sdmCode/config/";
	private static final String WIN_DEFAULT_PATH = "D:/SDM_HOME/";
	private static final String WINDOWS = "windows";
	private static final String OS_NAME = "os.name";
	private static String WIN_OS = System.getProperty(OS_NAME).toLowerCase();
	public static final String ENV_NAME = "SDM_HOME";

	public static String getEnvVariable(String envName) {
		String envVariableLoc = null;
		if (null != envName) {
			if (null != System.getProperty(envName)) {
				envVariableLoc = System.getProperty(envName);
			} else if (null != System.getenv(envName)) {
				envVariableLoc = System.getenv(envName);
			} else if (WIN_OS.startsWith(WINDOWS)) {
				System.setProperty(envName, WIN_DEFAULT_PATH);
				envVariableLoc = System.getProperty(envName);
			} else {
				System.setProperty(envName, UNIX_DEFAULT_PATH);
				envVariableLoc = System.getProperty(envName);
			}
		}
		return envVariableLoc;
	}
}
