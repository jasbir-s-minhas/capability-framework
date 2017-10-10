package com.sdm.hw.exception.services.helper;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

import com.sdm.hw.exception.dto.HwException;
import com.sdm.hw.exception.util.HwExceptionUnmarshaller;

/**
 * This class is used Extract exception data from exception Info file which are
 * different for different module
 * 
 * @author TCS
 * 
 */
public final class HwExceptionInfoProvider {

    private static ConcurrentMap<String, Map<String, HwException>> hwExpcache = new ConcurrentHashMap<String, Map<String, HwException>>();
    private static ConcurrentMap<String, HwException> moduleExpcache = new ConcurrentHashMap<String, HwException>();

    private static final HwExceptionInfoProvider HWEXPINFOPROVIDER = new HwExceptionInfoProvider();
    private static final String HW_APP = "hw";
    public static final String HW_DEFAULT_EXCEPTION = "Module Component Exception Info XML file is Missing";
    private static HwException hwExceptionInfo = null;

    /**
     * Private constructor for HwExceptionInfoProvider class
     */
    private HwExceptionInfoProvider() {
        if (null != hwExpcache && hwExpcache.isEmpty()) {
            loadHwDefinedExceptions();
        }

    }

    /**
     * This will get Instance of class HwExceptionInfoProvider
     * 
     * @return hwExceptionInfoProvider an instance of HwExceptionInfoProvider
     */
    public static HwExceptionInfoProvider getInstance() {
        return HWEXPINFOPROVIDER;
    }

    /**
     * Fetch Exception details from exception cache
     * 
     * @param businessComponent
     *            a message in string
     * @param filePath
     * @param exceptionId
     * @return HwException i.e Exception DTO which contains all details as given
     *         exception info file
     */
    public static HwException fetchExceptionInfo(
        final String businessComponent, final String exceptionId) {

        final boolean isAvailable = moduleExpcache.containsKey(exceptionId);
        String businessComponentKey = (businessComponent != null && !businessComponent
                .equalsIgnoreCase(HW_APP)) ? businessComponent : HW_APP;
        if (isAvailable) {
            HwExceptionInfoProvider.hwExceptionInfo = findCachedException(businessComponentKey,//Sonar Fix S2444 on 13 Jan 2017 by Khushboo
                    exceptionId);
        }
        else {
        	// File path would be picked from business component context
            final String filePath = new StringBuilder("/hw-")
                    .append(businessComponent).append("-exception-info.xml")
                    .toString();
            HwExceptionInfoProvider.hwExceptionInfo = loadFindBusinessComponentDefineException(//Sonar Fix S2444 on 13 Jan 2017 by Khushboo
                    businessComponent, exceptionId, filePath);

        }
        return hwExceptionInfo;

    }

    /**
     * Load and fetch custom exception defined by business component as per
     * their business module
     * 
     * @param businessComponent
     *            in string form
     * @param exceptionId
     *            in string form
     * @param filePath
     *            in string form
     * @return HwException a DTO object
     */
    private static HwException loadFindBusinessComponentDefineException(
        final String businessComponent, final String exceptionId,
        final String filePath) {
        // Load Business component Data
        loadBusinessComponentExceptions(businessComponent, filePath);

        return hwExpcache.get(businessComponent).get(exceptionId);
    }

    /**
     * Fetch HwDefined or Module Defined Exception
     * 
     * @param exceptionId
     * @return an exception DTO which contains all details
     */
    private static HwException findCachedException(String businessComponent,
        String exceptionId) {
        if (hwExpcache.containsKey(businessComponent)) {
            return hwExpcache.get(businessComponent).get(exceptionId);
        }
        else {
            return new HwException();
        }
    }

    /**
     * Load Hw defined exceptions i.e provided by framework
     */
    private static void loadHwDefinedExceptions() {
        final List<HwException> hwExpList = new HwExceptionUnmarshaller()
                .parseExceptionXml("");

        for (final HwException exception : hwExpList) {
            moduleExpcache.put(exception.getName(), exception);
        }
        hwExpcache.put(HW_APP, moduleExpcache);
    }

    /**
     * Load business component exceptions
     * 
     * @param businessComponent
     *            a message in string
     * @param filePath
     *            a path in string for loading exception in a file
     */
    private static void loadBusinessComponentExceptions(
        final String businessComponent, final String filePath) {
        final List<HwException> businessExpList = new HwExceptionUnmarshaller()
                .parseExceptionXml(filePath);

        for (final HwException exception : businessExpList) {
            moduleExpcache.put(exception.getName(), exception);
        }
        hwExpcache.put(businessComponent, moduleExpcache);
    }

}
