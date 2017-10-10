package com.sdm.hw.exception.services.helper;

import com.sdm.hw.exception.dto.HwExceptionDTO;
import com.sdm.hw.exception.intf.IHwExceptionHandler;
import com.sdm.hw.exception.util.HwExceptionUtil;

/**
 * This class is used for logging the exceptions in a file using a logger as
 * well as getting the exception details as HwExceptionDTO against a checked
 * application exception.This implements IHwExceptionHandler interface which
 * provides exception for handling HW exception.
 * 
 * @author TCS
 * 
 */
public class HwExceptionHandler implements IHwExceptionHandler {

    /**
     * Handle the exception and returns ExceptionDTO with exception details and
     * also log the exceptions as per logging type set in exception Info file.
     * 
     * @param businessComponent
     *            a message in String
     * @param exp
     *            an exception type
     * @param businessComponent
     * @return HwExceptionDTO contains exception data
     */
    public HwExceptionDTO handleException(final String businessComponent,
        final Throwable exp, final String businessCmpAttribute) {

        // Get Exception details
        final HwExceptionDTO hwexDTO = HwExceptionUtil.getExceptionDetails(
                businessComponent, exp, businessCmpAttribute);
        // Log Exception into a file
        HwExceptionUtil.logException(this.getClass(), exp, businessComponent,
                hwexDTO.getLoggingType());
        return hwexDTO;
    }

}