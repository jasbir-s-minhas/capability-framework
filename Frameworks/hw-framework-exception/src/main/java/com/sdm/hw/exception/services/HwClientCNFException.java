package com.sdm.hw.exception.services;

/**
 * A Base class for all exceptions that is used for getting a confirmation from
 * the end user for executing a specific task. All user Confirmation exceptions
 * should inherit from HwClientCNFException. Exceptions can be defined based on
 * user confirmation.
 * 
 * @author TCS
 * 
 */
public class HwClientCNFException
        extends HwBaseAppException {

    /**
     * Generated Serial version UID
     */
    private static final long serialVersionUID = 1L;

    /**
     * Parameterised constructor of HwClientCNFException
     * 
     * @param msg
     *            in string form
     */
    public HwClientCNFException(final String msg) {
        super(msg);
    }

    /**
     * Parameterised constructor of HwClientCNFException
     * 
     * @param msg
     *            in string from
     * @param exp
     *            an object of Throwable
     */
    public HwClientCNFException(final String msg, final Throwable exp) {
        super(msg, exp);
    }

    /**
     * Parameterised constructor of HwClientCNFException
     * 
     * @param exp
     *            an object of Throwable
     */
    public HwClientCNFException(final Throwable exp) {
        super(exp);
    }
}
