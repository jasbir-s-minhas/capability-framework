package com.sdm.hw.exception.services;

/**
 * A base class for all the exceptions that may occur accross the system.
 * All System exceptions related to HW application should inherit from
 * HwSystemException
 * 
 * @author TCS
 * 
 */
public class HwSystemException
        extends HwBaseAppException {

    /**
     * Generated Serial version UID
     */
    private static final long serialVersionUID = 1L;

    /**
     * Parameterised constructor of HwSystemException
     * 
     * @param message
     *            in string form
     */

    public HwSystemException(final String message) {
        super(message);
    }

    /**
     * Parameterised constructor of HwSystemException
     * 
     * @param msg
     *            in string form
     * @param throwable
     *            object of Throwable
     */
    public HwSystemException(final String msg, final Throwable throwable) {
        super(msg, throwable);
    }
}
