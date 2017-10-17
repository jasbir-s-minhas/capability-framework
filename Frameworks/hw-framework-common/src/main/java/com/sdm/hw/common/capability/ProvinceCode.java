package com.sdm.hw.common.capability;
/**
 * This enum representing ProvinceCode Code:
 *
 * @author Jasbir Minhas
 * @version 1.0
 * @since 2017-10-10
 */

public enum ProvinceCode{
	Alberta("AB"),
	BritishColumbia("BC"),
	Manitoba("MB"),
	NewBrunswick("NB"),
	NewfoundlandAndLabrador("NL"),
	NorthwestTerritories("NT"),
	NovaScotia("NS"),
	Nunavut("NU"),
	Ontario("ON"),
	PrinceEdwardIsland("PE"),
	Quebec("QC"),
	Saskatchewan("SK"),
	Yukon("YT");


	/**
     *  a String representing a path to the capability
     */
    private final String provinceCode;

    /**
     * constructor for Enum
	 *
     * @param provinceCode String representing the province code.
     *
     */
    ProvinceCode(final String provinceCode) {
        this.provinceCode = provinceCode;
    }

    /**
     * @see Enum#toString()
     */
    @Override
    public String toString() {
        return provinceCode;
    }
}