package com.sdm.hw.exception.services;

/**
 * A base class for all exceptions that occurs while interfacing with devices
 * like ScriptPro, Automed, Fax machine and etc. All interface exceptions
 * related to communication with Device should inherit from
 * HwInterfaceException.
 * 
 * @author TCS
 * 
 */
public class HwInterfaceException
        extends HwBaseAppException {

    /**
     * Generated Serial version UID
     */
    private static final long serialVersionUID = 1L;

    /**
     * Parameterised constructor of HwInterfaceException
     * 
     * @param msg
     *            a message in string form
     */
    public HwInterfaceException(final String msg) {
        super(msg);
    }

    /**
     * Parameterised constructor of HwInterfaceException
     * 
     * @param msg
     *            a message in string form
     * @param e
     *            an object of Throwable class
     * 
     */
    public HwInterfaceException(final String msg, final Throwable exp) {
        super(msg, exp);
    }

    /**
     * Parameterised constructor of HwInterfaceException
     * 
     * @param exp
     *            an object of Throwable class
     */
    public HwInterfaceException(final Throwable exp) {
        super(exp);
    }
}
