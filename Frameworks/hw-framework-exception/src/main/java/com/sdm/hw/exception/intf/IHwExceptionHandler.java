package com.sdm.hw.exception.intf;

import com.sdm.hw.exception.dto.HwExceptionDTO;

/**
 * This interface provides abstraction for handling HW exceptions.
 * 
 * @author TCS
 * 
 */
public interface IHwExceptionHandler {
    /**
     * this is a concrete method to handle all exception
     * 
     * @param moduleContext
     * @param throwable
     * @return HwExceptionDTO
     */
    HwExceptionDTO handleException(String moduleContext, Throwable throwable,
        String businessCmpAttribute);
}