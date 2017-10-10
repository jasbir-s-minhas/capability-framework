package com.sdm.hw.exception.dto;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

/**
 * Exception DTO which contains all details as given exception info file i.e.
 * hw-exp-info.xml
 * 
 * @author TCS
 */

@SuppressWarnings("restriction")
public class HwException
        extends HwBaseDTO {

    /**
     * Generated Serial version UID
     */
    private static final long serialVersionUID = 1L;
    private String name;
    private String messageCode;
    private boolean contextReq;
    private String loggingType;
    private boolean showToUI;

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name
     *            the name to set
     */
    @XmlAttribute(name = "name")
    public void setName(final String name) {
        this.name = name;
    }

    /**
     * @return the messageCode
     */
    public String getMessageCode() {
        return messageCode;
    }

    /**
     * @param messageCode
     *            the messageCode to set
     */
    @XmlElement(name = "messagecode")
    public void setMessageCode(final String messageCode) {
        this.messageCode = messageCode;
    }

    /**
     * 
     * @return boolean value
     */
    public boolean isContextReq() {
        return contextReq;
    }

    /**
     * @param contextReq
     *            the contextReq to set
     */
    @XmlElement(name = "contextreq")
    public void setContextReq(final boolean contextReq) {
        this.contextReq = contextReq;
    }

    /**
     * 
     * @return loggingType
     */
    public String getLoggingType() {
        return loggingType;
    }

    /**
     * @param loggingType
     *            the loggingType to set
     */
    @XmlElement(name = "loggingtype")
    public void setLoggingType(final String loggingType) {
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
    @XmlElement(name = "showtoui")
    public void setShowToUI(boolean showToUI) {
        this.showToUI = showToUI;
    }

}
