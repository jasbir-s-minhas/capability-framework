package com.sdm.hw.common.capability;

/**
 * This enum representing ProvinceCode Code:
 *
 * @author Jasbir Minhas
 * @version 1.0
 * @since 2017-11-07
 */

public enum ProvinceCode {
    ALBERTA("AB"),
    BRITISH_COLUMBIA("BC"),
    MANITOBA("MB"),
    NEW_BRUNSWICK("NB"),
    NEWFOUNDLAND_AND_LABRADOR("NL"),
    NORTHWEST_TERRITORIES("NT"),
    NOVA_SCOTIA("NS"),
    NUNAVUT("NU"),
    ONTARIO("ON"),
    PRINCE_EDWARD_ISLAND("PE"),
    QUEBEC("QC"),
    SASKATCHEWAN("SK"),
    YUKON("YT");


    /**
     * a String representing a path to the capability
     */
    private final String code;

    /**
     * constructor for Enum
     *
     * @param provinceCode String representing the province code.
     */
    ProvinceCode(final String provinceCode) {
        this.code = provinceCode;
    }

    /**
     * @see Enum#toString()
     */
    @Override
    public String toString() {
        return code;
    }
}