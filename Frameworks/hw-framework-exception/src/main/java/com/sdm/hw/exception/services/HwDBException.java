package com.sdm.hw.exception.services;

/**
 * A base class for all exceptions thrown while interacting with persistence
 * mechanism. All DB exceptions related to persistence layer should inherit from
 * HwDBException.
 * 
 * @author TCS
 * 
 */
public class HwDBException
        extends HwBaseAppException {

    /**
     * Generated Serial version UID
     */
    private static final long serialVersionUID = 1L;

    /**
     * Parameterised constructor of HwDBException
     * 
     * @param msg
     *            exception message in string form
     */
    public HwDBException(final String msg) {
        super(msg);
    }

    /**
     * Parameterised constructor of HwDBException
     * 
     * @param msg
     *            exception message in string form
     * @param exp
     *            object of Throwable
     */
    public HwDBException(final String msg, final Throwable exp) {
        super(msg, exp);
    }

    /**
     * Parameterised constructor of HwDBException
     * 
     * @param exp
     */
    public HwDBException(final Throwable exp) {
        super(exp);
    }
}
