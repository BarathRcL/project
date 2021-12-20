package com.pro.user.request;

public class UserRequest {
	
	private String firstName;
	private String lastName;
	private String domain;
	private String organization;
	private String designation;
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getDomain() {
		return domain;
	}
	public void setDomain(String domain) {
		this.domain = domain;
	}
	public String getOrganization() {
		return organization;
	}
	public void setOrganization(String organization) {
		this.organization = organization;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public UserRequest(String firstName, String lastName, String domain,
			String organization, String designation) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		
		this.domain = domain;
		this.organization = organization;
		this.designation = designation;
	}
	public UserRequest() {
		super();
	}
	
	
	

}
