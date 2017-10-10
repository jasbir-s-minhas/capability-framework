package com.sdm.hw.exception.dto;

/**
 * Contains the exception data to be used by Exception handler client classes
 * 
 * @author TCS
 * 
 */
public class HwExceptionDTO extends HwBaseDTO {

	/**
	 * Generated Serial version UID
	 */
	private static final long serialVersionUID = 1L;

	private String loggingType;
	private String exceptionMessage;
	private boolean showToUI;
	private String messagePropFile;

	/**
	 * @return the exceptionMessage in string
	 */
	public String getExceptionMessage() {
		return exceptionMessage;
	}

	/**
	 * @param exceptionMessage
	 *            ,the exceptionMessage to set
	 */
	public void setExceptionMessage(final String exceptionMessage) {
		this.exceptionMessage = exceptionMessage;
	}

	/**
	 * Default constructor
	 */
	public HwExceptionDTO() {
		super();
	}

	/**
	 * Parameterised constructor
	 * 
	 * @param expMessage
	 *            in String form
	 * @param showAsAlert
	 *            a boolean type parameter
	 * @param loggingType
	 *            a boolean type parameter
	 */
	public HwExceptionDTO(final String expMessage, final String loggingType,
			final boolean showGUI, final String messagePropFile) {
		super();
		this.exceptionMessage = expMessage;
		this.loggingType = loggingType;
		this.showToUI = showGUI;
		this.messagePropFile = messagePropFile;
	}

	public String getLoggingType() {
		return loggingType;
	}

	public void setLoggingType(String loggingType) {
		this.loggingType = loggingType;
	}

	/**
	 * @return the showToUI
	 */
	public boolean isShowToUI() {
		return showToUI;
	}

	/**
	 * @param showToUI
	 *            the showToUI to set
	 */
	public void setShowToUI(boolean showToUI) {
		this.showToUI = showToUI;
	}

	/**
	 * Getter method of messagePropFile
	 * 
	 * @return
	 */
	public String getMessagePropFile() {
		return messagePropFile;
	}

	/**
	 * Setter method of messagePropFile
	 * 
	 * @param messagePropFile
	 */
	public void setMessagePropFile(String messagePropFile) {
		this.messagePropFile = messagePropFile;
	}

}