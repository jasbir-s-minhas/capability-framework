package com.sdm.hw.exception.services.helper;

import com.sdm.hw.exception.intf.IHwExceptionHandler;

/**
 * This is a factory implementation for creating the concrete implementation of
 * ExceptionHandler interface. This factory class must be singleton.
 * 
 * @author TCS
 * 
 */
public final class HwExceptionHandlerFactory {

    public static final String EXP_HANDLER_KEY = "hw.exceptionhandler.type";
    public static final String EXP_HANDLER_FILE = "hwfileexceptionhandler";

    private static final HwExceptionHandlerFactory EXPHANDLERFACTORY = new HwExceptionHandlerFactory();

    /**
     * private constructor of HwExceptionHandlerFactory class for implementing
     * singleton pattern
     */
    private HwExceptionHandlerFactory() {
    }

    /**
     * Get instance of HwExceptionHandlerFactory class
     * 
     * @return EXPFRAMEWORKFACTORY an instance of HwExceptionHandlerFactory
     */
    public static HwExceptionHandlerFactory getInstance() {
        return EXPHANDLERFACTORY;
    }

    /**
     * Get Exception handler on the basis of Exception handler type
     * 
     * @return IHwExceptionHandler
     */
    public IHwExceptionHandler getExceptionHandler() {

        if (EXP_HANDLER_FILE.equals(HwFrameworkConfig.getInstance().get(
                EXP_HANDLER_KEY))) {
            return new HwExceptionHandler();
        }
        else {
            return null;
        }

    }

}