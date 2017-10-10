package com.sdm.hw.common.capability;

/**
 * This enum working with capability framework class. Following steps should be performed to add a new
 * Boolean capability:
 * <pre>
 *  Step 1. Create a new Enum and corresponding to a string in the format of capabilityGroup[.capabiityGroup].capbility
 *  	e.g.: testGroup1L1.testGroup1L2.testBooleanCapability
 *  Step 2. Add addition group and capability in the corresponding capability XML. The XML must conforms to capability
 *  	XML Schema Definition.
 *  	e.g.:
 *  ===============================
 *      <capabilityGroup name="testGroup1L1" enabled="true">
 *      	<capabilityGroup name="testGroup1L2" enabled="true">
 *      		<capability>
 *      			<name>testStringCapability</name>
 *      			<value type="string">TestString</value>
 *      		</capability>
 *      		<capability>
 *      			<name>testBooleanCapability</name>
 *      			<value type="boolean">true</value>
 *      		</capability>
 *      		<capability>
 *      			<name>testIntCapability</name>
 *      			<value type="int">999</value>
 *      		</capability>
 *      		<capability>
 *      			<name>testFloatCapability</name>
 *      			<value type="float">10.9</value>
 *      		</capability>\
 *      	</capabilityGroup>
 *      </capabilityGroup>
 *  ===============================
 * </pre>
 *
 * @author Jasbir Minhas
 * @version 1.0
 * @since 2017-10-10
 */
public enum CapabilityBooleanKey implements CapabilityKey {
    // the following enum is for testing multilevel of groups with boolean capability during development process.
    TEST_2_LEVEL_GROUP("testGroup1L1.testGroup1L2.testBooleanCapability"),

    //View ADR Status
    ADR_STATUS("eHealth.adrStatus"),
    //View replaced version status Changes for Allergy/Intolerance
    ALLERGY_REPLACED_VERSION("eHealth.allergyReplacedVersion"),
    //Allergy Status Drop Down Option
    ALLERGY_STATUS("eHealth.allergyStatus"),
    //Sub E-health configurable capability to check whether DIN exists for the entered chemical or not
    CHEMICAL_DIN_CHECK("eHealth.chemicalDINCheck"),
    //There is a sub-ehealth configurable capability mode in HW (On/Off)  for the comprehensive profile to
    // be user selectable or mandatory.
    COMPREHENSIVE_MODIFIER("eHealth.comprehensiveModifier"),
    //View replaced version status Changes for medical condition
    CONDITION_REPLACED_VERSION("eHealth.conditionReplacedVersion"),
    //DECN Business entity type value
    DECN_BUSINESS_ENTITY_TYPE("eHealth.decnBusinessEntityType"),
    //TODO: Add comments.
    DISPLAY_PROVINCIAL_DATA("eHealth.displayProvincialData"),
    //TODO: Add comments.
    DISPLAY_MANAGEMENT_HISTORY_AT_CV("eHealth.displayManagementHistoryAtCv"),
    //There is a sub-ehealth configurable capability mode in HW (On/Off)  for the Tx of selected Provincial
    //Rx on Rx Table to be user viewable or not.
    DISPLAY_TX_FOR_PROVINCIAL_RX("eHealth.displayTxForProvincialRx"),
    //TODO: Add comments.
    ELIGIBLE_FOR_TRIAL("eHealth.eligibleForTrial"),
    //ePrescribing Enabled Check
    EPRESCRIBING("eHealth.ePrescribing"),
    //There is a sub-ehealth configurable capability mode in HW (On/Off) to enable importing
    //provincial prescriptions.
    IMPORT_PROVINCIAL_PRESCRIPTIONS("eHealth.importProvincialPrescriptions"),
    //Intolerance Status Dropdown Option
    INTOL_STATUS("eHealth.intolStatus"),
    //Link to Provincial Rx
    LINK_PROVINCIAL_RX("eHealth.linkProvincialRx"),
    //Enable Link to Prov Indicator
    LINK_STATUS_INDICATOR("eHealth.linkStatusIndicator"),
    //Provincial Location Search Enabled Check
    LOCATION_SEARCH("eHealth.locationSearch"),
    //Manage Consent Enabled Check
    MANAGE_CONSENT("eHealth.manageConsent"),
    //Provincial Patient Linking Is Required Or Not
    PATIENT_LINKAGE("eHealth.patientLinkage"),
    //There is a sub-ehealth configurable capability mode in HW (On/Off) to make the patient profile review
    //mandatory during CV.
    PATIENT_PRO_REV_IS_MANDATORY_AT_CV("eHealth.patientProRevIsMandatoryAtCV"),
    //Enable Provincial Patient Search On Client Registry
    PATIENT_SEARCH("eHealth.patientSearch"),
    //TODO: Add comments.
    PHONE_ENABLED("eHealth.phoneEnabled"),
    //TODO: Add comments.
    POSTAL_CODE_ENABLED("eHealth.postalCodeEnabled"),
    //Rx Order Id Enabled Check
    PRINT_RX_ORDER_ID("eHealth.printRxOrderId"),
    //There must be a sub-ehealth configuration capability (ON/OFF) in HW to allow the system to execute the
    //Producer ID check when linking provincial patient to local.
    PRODUCER_ID_CHECK("eHealth.producerIDCheck"),
    //Provincial Provider Search Enabled Check
    PROVIDER_SEARCH("eHealth.providerSearch"),
    //Non-Fill Actions on Provincial Rx require Intake Enabled
    PROVINCIAL_RX_REQUIRE_INTAKE("eHealth.provincialRxRequireIntake"),
    //There is a sub-ehealth configurable capability mode in HW (On/Off)  for the medication profile
    //to be user selectable or not.-->
    PROV_MEDICATION_PROFILE("eHealth.provMedicationProfile"),
    //View Provincial Observation
    QUERY_PROVINCIAL_OBSERVATIONS("eHealth.queryProvincialObservations"),
    //View Reason For Access Popup
    REASON_TO_ACCESS_POPUP("eHealth.reasonToAccessPopup"),
    //check for  Provincial Note
    SEND_PATIENT_NOTE("eHealth.sendPatientNote"),
    //Configuration Capability to disable/enable the not sent report from Action menu of Exception Queue.
    SEND_PROVINCIAL_NOT_SENT_REPORT("eHealth.sendProvincialNotSentReport"),
    //There is a sub-ehealth configurable capability mode in HW (On/Off)  for the user to select rx/tx note
    // to be sent to province from Data entry screen.
    SEND_RX_TX_NOTES("eHealth.sendRxTxNotes"),
    //View Provincial Allergies is Mandatory
    VIEW_ALLERGIES_MANDATORY("eHealth.viewAllergiesMandatory"),
    //Sub-Ehealth View Provincial ADRs
    VIEW_PROVINCIAL_ADRS("eHealth.viewProvincialAdrs"),
    //Sub-Ehealth View Provincial Allergies-->
    VIEW_PROVINCIAL_ALLERGIES("eHealth.viewProvincialAllergies"),
    //Sub-Ehealth View Provincial Reactions
    VIEW_PROVINCIAL_REACTIONS("eHealth.viewProvincialReactions"),
    //View Provincial Patient Conditions
    VIEW_PROV_MEDICAL_CONDITIONS("eHealth.viewProvMedicalConditions"),
    //TODO: Add comments.
    UNDISC_RX_ACTION("eHealth.undiscRxAction");

    /**
     * a String representing a path to the capability
     */
    private final String capabilityPath;

    /**
     * constructor for Enum
     * The capabilityPath passed as a parameter should in the the following format:
     * capabilityGroupName.[capabilityGroupName].capabiltyName
     * A capability name can be under one group level of multi-level groups
     *
     * @param capabilityPath String representing the capability path.
     */
    CapabilityBooleanKey(final String capabilityPath) {
        this.capabilityPath = capabilityPath;
    }

    /**
     * @see java.lang.Enum#toString()
     */
    @Override
    public String toString() {
        return capabilityPath;
    }

    /**
     * This method returns true or faslse based on the key of current enum instance
     *
     * @return capability string
     */
    public boolean isEnabled() {
        return CapabilityManager.getInstance().getBoolean(this);
    }
}