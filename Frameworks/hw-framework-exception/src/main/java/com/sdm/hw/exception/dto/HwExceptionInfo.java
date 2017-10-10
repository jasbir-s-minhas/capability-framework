package com.sdm.hw.exception.dto;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * This class provides details of Exception in exception information file
 * i.e.hw-exp-info.xml
 * 
 * @author TCS
 */

@SuppressWarnings("restriction")
@XmlRootElement(name = "hwexceptioninfo")
public class HwExceptionInfo {

    private HwException hwException;
    private List<HwException> listException = null;

    public HwExceptionInfo() {
        super();
        this.setListException(new ArrayList<HwException>());
    }

    /**
     * getter method for hwException
     * 
     * @return hwException object of HwException
     */
    public HwException getHwException() {
        return hwException;
    }

    /**
     * setter method for hwException
     * 
     * @param hwException
     *            object of HwException
     */
    @XmlElement(name = "exception")
    public void setHwException(final HwException hwException) {
        this.hwException = hwException;
        listException.add(hwException);
    }

    /**
     * 
     * @return List of HwException
     */
    public List<HwException> getListException() {
        return listException;
    }

    /**
     * @param listException
     *            the listException to set
     */
    private void setListException(final List<HwException> listException) {
        this.listException = listException;
    }
}