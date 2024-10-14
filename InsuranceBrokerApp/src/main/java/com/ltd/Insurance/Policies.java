package com.ltd.Insurance;

public class Policies {

	private String policyID;
	private String customerID;
	private String brokerID;
	private String policyType;
	
	public Policies(String policyID, String customerID, String brokerID, String policyType) {
		
		this.setPolicyID(policyID);
		this.setCustomerID(customerID);
		this.setBrokerID(brokerID);
		this.setPolicyType(policyType);
		
	}

	/**
	 * @return the policyID
	 */
	public String getpolicyID() {
		return policyID;
	}

	/**
	 * @param policyID the policyID to set
	 */
	public void setPolicyID(String policyID) {
		this.policyID = policyID;
	}

	/**
	 * @return the customerID
	 */
	public String getCustomerID() {
		return customerID;
	}

	/**
	 * @param customerID the customerID to set
	 */
	public void setCustomerID(String customerID) {
		this.customerID = customerID;
	}

	/**
	 * @return the brokerID
	 */
	public String getBrokerID() {
		return brokerID;
	}

	/**
	 * @param brokerID the brokerID to set
	 */
	public void setBrokerID(String brokerID) {
		this.brokerID = brokerID;
	}

	/**
	 * @return the policyDetail
	 */
	public String getPolicyType() {
		return policyType;
	}

	/**
	 * @param policyDetail the policyDetail to set
	 */
	public void setPolicyType(String policyType) {
		this.policyType = policyType;
	}
	
}
