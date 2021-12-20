package com.proretention.responce;

public class BranchesResponse {
	 private String branchKey;
	 private long organizationId;
	 private String branchName;
	 private String address;
	 private String country;
	 private String city;
	 private String state;
	 private long zipCode;
	public String getBranchKey() {
		return branchKey;
	}
	public void setBranchKey(String branchKey) {
		this.branchKey = branchKey;
	}
	public long getOrganizationId() {
		return organizationId;
	}
	public void setOrganizationId(long organizationId) {
		this.organizationId = organizationId;
	}
	public String getBranchName() {
		return branchName;
	}
	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public long getZipCode() {
		return zipCode;
	}
	public void setZipCode(long zipCode) {
		this.zipCode = zipCode;
	}
	public BranchesResponse(String branchKey, long organizationId, String branchName, String address, String country,
			String city, String state, long zipCode) {
		super();
		this.branchKey = branchKey;
		this.organizationId = organizationId;
		this.branchName = branchName;
		this.address = address;
		this.country = country;
		this.city = city;
		this.state = state;
		this.zipCode = zipCode;
	}
	public BranchesResponse() {
		super();
	}
	 

}
