package com.sdm.hw.exception.services;

/**
 * A base class for all exceptions that occurs while performing devices
 * technical fault. All exceptions related to HW application devices technical
 * fault should inherit from HwTechnicalException.
 * 
 * @author TCS
 * 
 */
public class HwTechnicalException
        extends HwBaseAppException {

    /**
     * Generated Serial version UID
     */
    private static final long serialVersionUID = 1L;

    /**
     * Parameterised constructor of HwTechnicalException
     * 
     * @param msg
     *            in string form
     */
    public HwTechnicalException(final String msg) {
        super(msg);
    }

    /**
     * Parameterised constructor of HwTechnicalException
     * 
     * @param msg
     *            in string form
     * @param exp
     *            object of Throwable
     */
    public HwTechnicalException(final String msg, final Throwable exp) {
        super(msg, exp);
    }

    /**
     * Parameterised constructor of HwTechnicalException
     * 
     * @param exp
     *            object of Throwable
     */
    public HwTechnicalException(final Throwable exp) {
        super(exp);
    }
}
