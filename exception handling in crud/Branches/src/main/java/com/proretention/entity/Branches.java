package com.proretention.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Branches {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	 private long branchId;
	 private String branchKey;
	 private long organizationId;
	 private String branchName;
	 private String address;
	 private String country;
	 private String city;
	 private String state;
	 private long zipCode;
	 
	public long getBranchId() {
		return branchId;
	}
	public void setBranchId(long branchId) {
		this.branchId = branchId;
	}
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
	public Branches(long branchId, String branchKey, long organizationId, String branchName, String address,
			String country, String city, String state, long zipCode) {
		super();
		this.branchId = branchId;
		this.branchKey = branchKey;
		this.organizationId = organizationId;
		this.branchName = branchName;
		this.address = address;
		this.country = country;
		this.city = city;
		this.state = state;
		this.zipCode = zipCode;
	}
	public Branches() {
		super();
	}
	
	 
	 

}
