package com.sdm.hw.exception.dto;

import java.io.Serializable;

import org.apache.commons.lang.builder.CompareToBuilder;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

/**
 * This is a Base class to Model data objects.
 * 
 * @author TCS
 */
public class HwBaseDTO implements Serializable, Comparable<HwBaseDTO> {

    protected static final long serialVersionUID = 1L;

    /**
     * Returns String representation of current object and override.
     * 
     * @return String
     */
    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this,
                ToStringStyle.MULTI_LINE_STYLE);
    }

    /**
     * Returns hashcode in integer form for object.
     * 
     * @return int
     */
    @Override
    public int hashCode() {
        return HashCodeBuilder.reflectionHashCode(this);
    }

    /**
     * Compare two HwBaseDTO objects and returns boolean value.
     * 
     * @return boolean value.
     * @param object
     *            to compare with this object
     */
    @Override
    public boolean equals(final Object object) {
        return EqualsBuilder.reflectionEquals(this, object);
    }

    /**
     * Compare two HwBaseDTO objects and returns integer value
     * 
     * @return integer it may be zero, positive or negative.
     * @param object
     *            of HwBaseDTO class to compare with this object
     */
    public int compareTo(final HwBaseDTO obj) {
        return CompareToBuilder.reflectionCompare(this, obj);
    }
}