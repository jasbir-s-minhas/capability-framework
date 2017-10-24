/**
 * Enumeration of SubEhealth Rules
 */

package com.sdm.hw.store.dto;

import com.sdm.hw.common.capability.CapabilityBooleanKey;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

public enum SubEHealthConfigConstants {

    SUB_EHEALTH ("SUB_EHEALTH"),
    EPRESCRIBING ("SUB_EHEALTH_EPRESCRIBING"){
        @Override
        public boolean isEnabled(){
            return CapabilityBooleanKey.EPRESCRIBING.isEnabled();
        }
    },
    PRINT_RX_ORDER_ID ("SUB_EHEALTH_PRINTRXORDERID"){
        @Override
        public boolean isEnabled(){
            return CapabilityBooleanKey.PRINT_RX_ORDER_ID.isEnabled();
        }
    },
    MANAGE_CONSENT ("SUB_EHEALTH_MANAGECONSENT"){
        @Override
        public boolean isEnabled(){
            return CapabilityBooleanKey.MANAGE_CONSENT.isEnabled();
        }
    },
    @Deprecated
    ADD_DIS_PROVINCIAL_CONDITION("SUB_EHEALTH_PROVINCIAL_CONDITION"), // not being used anymore
    YES("Y"),
	SUB_EHEALTH_REASON_TO_ACCESS_POPUP("SUB_EHEALTH_REASON_TO_ACCESS_POPUP"){
        @Override
        public boolean isEnabled(){
            return CapabilityBooleanKey.REASON_TO_ACCESS_POPUP.isEnabled();
        }
    },
	SUB_EHEALTH_LINK_PROVINCIALRX("SUB_EHEALTH_LINK_PROVINCIALRX"){
        @Override
        public boolean isEnabled(){
            return CapabilityBooleanKey.LINK_PROVINCIAL_RX.isEnabled();
        }
    },
	SUB_EHEALTH_VIEW_STATUS_CHANGE("SUB_EHEALTH_VIEW_STATUS_CHANGE"),
    @Deprecated
	SUB_EHEALTH_TRIGGER_DIS_ONOK("SUB_EHEALTH_TRIGGER_DIS_ONOK"), // not being used anymore
	SUB_EHEALTH_ALLERGY_STATUS("SUB_EHEALTH_ALLERGY_STATUS"){
        @Override
        public boolean isEnabled(){
            return CapabilityBooleanKey.ALLERGY_STATUS.isEnabled();
        }
    },
	SUB_EHEALTH_INTOL_STATUS("SUB_EHEALTH_INTOL_STATUS"){
        @Override
        public boolean isEnabled(){
            return CapabilityBooleanKey.INTOL_STATUS.isEnabled();
        }
    },
	SUB_EHEALTH_ADR_STATUS("SUB_EHEALTH_ADR_STATUS"){
        @Override
        public boolean isEnabled(){
            return CapabilityBooleanKey.ADR_STATUS.isEnabled();
        }
    },
    @Deprecated
	SUB_EHEALTH_STORE_PROVINCE_OPTION("SUB_EHEALTH_STORE_PROVINCE_OPTION"), // not being used
	SUB_EHEALTH_PATIENT_SEARCH ("SUB_EHEALTH_PATIENT_SEARCH"){
        @Override
        public boolean isEnabled(){
            return CapabilityBooleanKey.PATIENT_SEARCH.isEnabled();
        }
    },
    SUB_EHEALTH_PATIENT_LINKAGE ("SUB_EHEALTH_PATIENT_LINKAGE"){
        @Override
        public boolean isEnabled(){
            return CapabilityBooleanKey.PATIENT_LINKAGE.isEnabled();
        }
    },
	PROVINCIAL_RX_NON_FILL_ACTIONS_REQUIRE_INTAKE ("SUB_EHEALTH_PROVINCIAL_RX_REQUIRE_INTAKE"){
        @Override
        public boolean isEnabled(){
            return CapabilityBooleanKey.PROVINCIAL_RX_REQUIRE_INTAKE.isEnabled();
        }
    },
	PATIENT_PROFILE_REVIEW_IS_MANDATORY_AT_CV("SUB_EHEALTH_PATIENT_PRO_REV_IS_MANDATORY_AT_CV"){
        @Override
        public boolean isEnabled(){
            return CapabilityBooleanKey.PATIENT_PRO_REV_IS_MANDATORY_AT_CV.isEnabled();
        }
    },
	SUB_EHEALTH_DISPLAY_MANAGEMENT_HISTORY_AT_CV ("SUB_EHEALTH_DISPLAY_MANAGEMENT_HISTORY_AT_CV"){
        @Override
	    public boolean isEnabled() {
	        return CapabilityBooleanKey.DISPLAY_MANAGEMENT_HISTORY_AT_CV.isEnabled();
        }
    },
	DISPLAY_TX_FOR_PROVINCIAL_RX("SUB_EHEALTH_DISPLAY_TX_FOR_PROVINCIAL_RX"){
        @Override
        public boolean isEnabled(){
            return CapabilityBooleanKey.DISPLAY_TX_FOR_PROVINCIAL_RX.isEnabled();
        }
    },
	COMPREHENSIVE_MODIFIER("SUB_EHEALTH_COMPREHENSIVE_MODIFIER"){
        @Override
        public boolean isEnabled(){
            return CapabilityBooleanKey.COMPREHENSIVE_MODIFIER.isEnabled();
        }
    },
	DISPLAY_PROVINCIAL_DATA("SUB_EHEALTH_DISPLAY_PROVINCIAL_DATA"){
        @Override
        public boolean isEnabled(){
            return CapabilityBooleanKey.DISPLAY_PROVINCIAL_DATA.isEnabled();
        }
    },
	SUB_EHEALTH_PROV_MEDICATION_PROFILE("SUB_EHEALTH_PROV_MEDICATION_PROFILE"){
        @Override
        public boolean isEnabled(){
            return CapabilityBooleanKey.PROV_MEDICATION_PROFILE.isEnabled();
        }
    },
	/** Start BP 350 Changes **/ 
    SEND_PATIENT_NOTE("SUB_EHEALTH_SEND_PATIENT_NOTE"){
        @Override
        public boolean isEnabled(){
            return CapabilityBooleanKey.SEND_PATIENT_NOTE.isEnabled();
        }
    },
    /** End BP 350 Changes **/
    /** Start code EHR1.BP.310 for Query DIS Prescriber Record.**/
    PROVIDER_SEARCH("SUB_EHEALTH_PROVIDER_SEARCH"){
        @Override
        public boolean isEnabled(){
            return CapabilityBooleanKey.PROVIDER_SEARCH.isEnabled();
        }
    },
    /** End code EHR1.BP.310 for Query DIS Prescriber Record. **/    
    /**Start code EHR1.BP.320 for Query DIS Location Record.**/
    LOCATION_SEARCH("SUB_EHEALTH_LOCATION_SEARCH"){
        @Override
        public boolean isEnabled(){
            return CapabilityBooleanKey.LOCATION_SEARCH.isEnabled();
        }
    },
    /**End code EHR1.BP.320 for Query DIS Location Record.**/
	/** Start BP 580 Changes **/ 
	SUB_EHEALTH_QUERY_PROVINCIAL_OBSERVATIONS("SUB_EHEALTH_QUERY_PROVINCIAL_OBSERVATIONS"){
        @Override
        public boolean isEnabled(){
            return CapabilityBooleanKey.QUERY_PROVINCIAL_OBSERVATIONS.isEnabled();
        }
    },
    /** End BP 580 Changes **/
	SUB_EHEALTH_VIEW_PROVINCIAL_REACTIONS("SUB_EHEALTH_VIEW_PROVINCIAL_REACTIONS"){
        @Override
        public boolean isEnabled(){
            return CapabilityBooleanKey.VIEW_PROVINCIAL_REACTIONS.isEnabled();
        }
    },
	SUB_EHEALTH_VIEW_PROVINCIAL_ALLERGIES("SUB_EHEALTH_VIEW_PROVINCIAL_ALLERGIES"){
        @Override
        public boolean isEnabled(){
            return CapabilityBooleanKey.VIEW_PROVINCIAL_ALLERGIES.isEnabled();
        }
    },
	SUB_EHEALTH_VIEW_PROV_MEDICAL_CONDITIONS("SUB_EHEALTH_VIEW_PROV_MEDICAL_CONDITIONS"){
        @Override
        public boolean isEnabled(){
            return CapabilityBooleanKey.VIEW_PROV_MEDICAL_CONDITIONS.isEnabled();
        }
    },
	SUB_EHEALTH_VIEW_ALLERGIES_MANDATORY("SUB_EHEALTH_VIEW_ALLERGIES_MANDATORY"){
        @Override
        public boolean isEnabled(){
            return CapabilityBooleanKey.VIEW_ALLERGIES_MANDATORY.isEnabled();
        }
    },
	SUB_EHEALTH_CONDITION_REPLACED_VERSION("SUB_EHEALTH_CONDITION_REPLACED_VERSION"){
        @Override
        public boolean isEnabled(){
            return CapabilityBooleanKey.CONDITION_REPLACED_VERSION.isEnabled();
        }
    },
	SUB_EHEALTH_VIEW_PROVINCIAL_ADRS("SUB_EHEALTH_VIEW_PROVINCIAL_ADRS"){
        @Override
        public boolean isEnabled(){
            return CapabilityBooleanKey.VIEW_PROVINCIAL_ADRS.isEnabled();
        }
    },
	SUB_EHEALTH_ALLERGY_REPLACED_VERSION("SUB_EHEALTH_ALLERGY_REPLACED_VERSION"){
        @Override
        public boolean isEnabled(){
            return CapabilityBooleanKey.ALLERGY_REPLACED_VERSION.isEnabled();
        }
    },
	SUB_EHEALTH_PHONE_ENABLED("SUB_EHEALTH_PHONE_ENABLED"){
        @Override
        public boolean isEnabled(){
            return CapabilityBooleanKey.PHONE_ENABLED.isEnabled();
        }
    },
	SUB_EHEALTH_POSTAL_CODE_ENABLED("SUB_EHEALTH_POSTAL_CODE_ENABLED"){
        @Override
        public boolean isEnabled(){
            return CapabilityBooleanKey.POSTAL_CODE_ENABLED.isEnabled();
        }
    },
	SUB_EHEALTH_CHEMICAL_DIN_CHECK("SUB_EHEALTH_CHEMICAL_DIN_CHECK"){
        @Override
        public boolean isEnabled(){
            return CapabilityBooleanKey.CHEMICAL_DIN_CHECK.isEnabled();
        }
    },
//	HW_COPY_PATIENT_CONFIG("HW_COPY_PATIENT_CONFIG"),
	
	/** start - Code changes for BP 640 Request DIS Provide Sent/Not Sent Report - Release- 16.2 **/
	SUB_EHEALTH_SEND_PROVINCIAL_NOT_SENT_REPORT("SUB_EHEALTH_SEND_PROVINCIAL_NOT_SENT_REPORT"){
        @Override
        public boolean isEnabled(){
            return CapabilityBooleanKey.SEND_PROVINCIAL_NOT_SENT_REPORT.isEnabled();
        }
    },
	/** End - Code changes for BP 640 Request DIS Provide Sent/Not Sent Report - Release- 16.2 **/
	
	/** start - Code changes for BP 350 Add Rx Tx Notes - Release- 16.2 **/

	SEND_RX_TX_NOTES("SUB_EHEALTH_SEND_RX_TX_NOTES"){
        @Override
        public boolean isEnabled(){
            return CapabilityBooleanKey.SEND_RX_TX_NOTES.isEnabled();
        }
    },

	/** End - Code changes for BP 350 Add Rx Tx Notes - Release- 16.2 **/

	/** Start code changes for BP 2000 Import Provincial Rx Release 16.2 on 29/04/2016**/
	SUB_EHEALTH_IMPORT_PROVINCIAL_PRESCRIPTION("SUB_EHEALTH_IMPORT_PROVINCIAL_PRESCRIPTIONS"){
        @Override
        public boolean isEnabled(){
            return CapabilityBooleanKey.IMPORT_PROVINCIAL_PRESCRIPTIONS.isEnabled();
        }
    },

	/**End code changes for BP 2000 Import Provincial Rx Release 16.2 on 29/04/2016 **/
	/** Start - Code changes for BP 240 Configuration added Release-16.2 on 26/05/2016**/
	SUB_EHEALTH_PRODUCER_ID_CHECK("SUB_EHEALTH_PRODUCER_ID_CHECK"){
        @Override
        public boolean isEnabled(){
            return CapabilityBooleanKey.PRODUCER_ID_CHECK.isEnabled();
        }
    },
	/** End - Code changes for BP 240 Configuration added Release-16.2 on 26/05/2016**/
	/** Start - Code changes for Link To Prov. Indicator Configuration added Release-16.2 on 05/08/2016**/
	SUB_EHEALTH_LINK_STATUS_INDICATOR ("SUB_EHEALTH_LINK_STATUS_INDICATOR"){
        @Override
        public boolean isEnabled(){
            return CapabilityBooleanKey.LINK_STATUS_INDICATOR.isEnabled();
        }
    },
	/** End - Code changes for Link To Prov. Indicator Configuration added Release-16.2 on 05/08/2016**/
	
	
	/** Start - Code changes for CR 77**/
	SUB_EHEALTH_UNDISC_RX_ACTION ("SUB_EHEALTH_UNDISC_RX_ACTION"){
        public boolean isEnabled(){
            return CapabilityBooleanKey.UNDISC_RX_ACTION.isEnabled();
        }
    },
	/** End - Code changes for CR-77**/
	SUB_EHEALTH_ELIGIBLE_FOR_TRIAL ("SUB_EHEALTH_ELIGIBLE_FOR_TRIAL"){
        public boolean isEnabled(){
            return CapabilityBooleanKey.ELIGIBLE_FOR_TRIAL.isEnabled();
        }
    };
	private String rule_name_in_db; 
    private static final Map<String, SubEHealthConfigConstants> NAME_MAP;

    static {
        NAME_MAP = new HashMap<String, SubEHealthConfigConstants>();
        for (SubEHealthConfigConstants constant : EnumSet.allOf(SubEHealthConfigConstants.class)) {
            NAME_MAP.put(constant.getRuleName(), constant);
        }
    }

    public static SubEHealthConfigConstants getConstantObj(final String arg) {
        return NAME_MAP.get(arg);
    }

    // Constructor
    private SubEHealthConfigConstants(String str) {

        rule_name_in_db = str;
    }

	  public String getRuleName() {
	    return rule_name_in_db;
	  }
    /**
     * Method to confirm is a string translates to a valid SubEHealthConfigConstants enum
     * @return boolean true if name correctly translates to SubEHealthConfigConstants otherwise false
     */
    public static boolean contains (String constant){
        return NAME_MAP.containsKey(constant);
    }

    /**
     * This method provides a defeault implementation and supposed to be overridden by individual enums instance
     * @return boolean true if enabled otherwise false
     */
    public boolean isEnabled(){
        return false;
    }
}