package com.sdm.hw.exception.services;

/**
 * A base class for all business related exceptions. All business exceptions
 * should inherit from HwBusinessException. Exceptions can be defined based on
 * business scenarios.This extends HwBaseAppException class for all checked
 * exception in application.
 * 
 * @author TCS
 * 
 */
public class HwBusinessException
        extends HwBaseAppException {

    /**
     * Generated Serial version UID
     */
    private static final long serialVersionUID = 1L;

    /**
     * Parameterised constructor of HwBusinessException
     * 
     * @param msg
     *            exception message in string form
     */
    public HwBusinessException(final String msg) {
        super(msg);
    }

    /**
     * Parameterised constructor of HwBusinessException
     * 
     * @param msg
     *            msg exception message in string form
     * @param exp
     *            object of Throwable
     */
    public HwBusinessException(final String msg, final Throwable exp) {
        super(msg, exp);
    }

    /**
     * Parameterised constructor of HwBusinessException
     * 
     * @param exp
     *            object of Throwable
     */
    public HwBusinessException(final Throwable exp) {
        super(exp);
    }
}