package com.sdm.hw.exception.services;

/**
 * A base class for all exceptions which occurs while performing security
 * operations. All exceptions related to HW application security should inherit
 * from HwSecurityException.
 * 
 * @author TCS
 * 
 */
public class HwSecurityException
        extends HwBaseAppException {

    /**
     * Generated Serial version UID
     */
    private static final long serialVersionUID = 1L;

    /**
     * Parameterised constructor of HwSecurityException
     * 
     * @param msg
     *            exception message in string form
     */
    public HwSecurityException(final String msg) {
        super(msg);
    }

    /**
     * Parameterised constructor of HwSecurityException
     * 
     * @param msg
     *            exception message in string form
     * @param exp
     *            object of Throwable
     */
    public HwSecurityException(final String msg, final Throwable exp) {
        super(msg, exp);
    }

    /**
     * Parameterised constructor of HwSecurityException
     * 
     * @param exp
     *            object of Throwable
     */
    public HwSecurityException(final Throwable exp) {
        super(exp);
    }
}
