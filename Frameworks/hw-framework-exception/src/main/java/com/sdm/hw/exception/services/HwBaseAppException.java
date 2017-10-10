package com.sdm.hw.exception.services;

/**
 * A base class HwBaseAppException for all checked exceptions in the
 * application.
 * 
 * @author TCS
 * 
 */

public class HwBaseAppException
        extends Exception {

    /**
     * Generated Serial version UID
     */
    private static final long serialVersionUID = 1L;
    
    private String exceptionMessage;

    private String errorCode;

    private String messageSummary;
    /**
     * Default constructor of HwBaseAppException
     */
    public HwBaseAppException() {
        super();
    }

    /**
     * Parameterised constructor of HwBaseAppException
     * 
     * @param msg
     *            in string form
     */
    public HwBaseAppException(final String msg) {
        super(msg);
        this.exceptionMessage = msg;
    }

    /**
     * Parameterised constructor of HwBaseAppException
     * 
     * @param msg
     *            in string form
     * @param exp
     *            an object of Throwable
     */
    public HwBaseAppException(final String msg, final Throwable exp) {
        super(msg, exp);
        this.exceptionMessage = msg;
        //this.initCause(exp); /*This is commented for IllelegalStateException*/
    }

    /**
     * Parameterised constructor of HwBaseAppException
     * 
     * @param exp
     *            a object of Throwable class
     */
    public HwBaseAppException(final Throwable exp) {
        super(exp);
        //this.initCause(exp);
    }

    /**
     * Set cause of HwBaseAppException
     * 
     * @param exp
     *            object of Throwable
     */
    public void setCause(final Throwable exp) {
        this.initCause(exp);
    }

    /**
     * @return String, which contains the information of throwing exception.
     */
    @Override
    public String toString() {
        final String expMsg = getClass().getName();
        return expMsg + ": " + exceptionMessage;
    }

    /**
     * get Exception message
     * 
     * @return String an exception message
     */
    @Override
    public String getMessage() {
        return exceptionMessage;
    }
    
    /**
     * @return the exceptionMessage
     */
    public String getExceptionMessage() {
        return exceptionMessage;
    }

    /**
     * @param exceptionMessage
     *            the exceptionMessage to set
     */
    public void setExceptionMessage(final String exceptionMessage) {
        this.exceptionMessage = exceptionMessage;
    }

    public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	public String getMessageSummary() {
		return messageSummary;
	}

	public void setMessageSummary(String messageSummary) {
		this.messageSummary = messageSummary;
	}
    
    
}