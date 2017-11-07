package com.sdm.hw.common.capability;

/**
 * This enum works with CapabilityManager class. Following steps should be performed to add a new
 * double capability:
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
 *      			<name>testLongCapability</name>
 *      			<value type="long">999</value>
 *      		</capability>
 *      		<capability>
 *      			<name>testDoubleCapability</name>
 *      			<value type="double">10.9</value>
 *      		</capability>\
 *      	</capabilityGroup>
 *      </capabilityGroup>
 *  ===============================
 * </pre>
 *
 * @author Jasbir Minhas
 * @version 1.0
 * @since 2017-11-07
 */

public enum CapabilityDoubleKey implements CapabilityKey {
    // the following enum is for testing multilevel of groups with double capability during development process.
    TEST_2_LEVEL_GROUP("testGroup1L1.testGroup1L2.testDoubleCapability");

    /**
     * a string representing a path to the capability
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
    CapabilityDoubleKey(final String capabilityPath) {
        this.capabilityPath = capabilityPath;
    }

    /**
     * @see Enum#toString()
     */
    @Override
    public String toString() {
        return capabilityPath;
    }

    /**
     * This method returns the capability long value based on the key of current enum instance
     *
     * @return capability string
     */
    public double getDouble() {
        return CapabilityManager.getInstance().getDouble(this);
    }

    /**
     * This method returns true if this capability is a group
     * TODO: Due to Java 7 limitation this method can't be implemented in the CapabilityKey interface.
     * TODO: This method should be moved to CapabilityKey interface and deleted from the CapabilityKey subclasses
     * @return true if the current expression represents a group
     */
    @Override
    public boolean isGroup() {
        return capabilityPath.endsWith(EXPRESSION_DELIMITOR);
    }
}