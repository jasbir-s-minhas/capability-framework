package com.sdm.hw.exception.services;

/**
 * A base class for all exception that occurs while interacting with services
 * like patient service, Drug services in HW application. All exceptions related
 * to HW application services should inherit from HwServicesException.
 * 
 * @author TCS
 * 
 */
public class HwServicesException
        extends HwBaseAppException {

    /**
     * Generated Serial version UID
     */
    private static final long serialVersionUID = 1L;

    /**
     * Parameterised constructor of HwServicesException
     * 
     * @param msg
     *            exception message in string form
     */
    public HwServicesException(final String msg) {
        super(msg);
    }

    /**
     * Parameterised constructor of HwServicesException
     * 
     * @param msg
     *            msg exception message in string form
     * @param exp
     *            object of Throwable
     */
    public HwServicesException(final String msg, final Throwable exp) {
        super(msg, exp);
    }

    /**
     * Parameterised constructor of HwServicesException
     * 
     * @param exp
     *            object of Throwable
     */
    public HwServicesException(final Throwable exp) {
        super(exp);
    }
}