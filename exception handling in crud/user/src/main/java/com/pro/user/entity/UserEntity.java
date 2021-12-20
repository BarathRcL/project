package com.pro.user.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class UserEntity {
	
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
private long userId;
private String userKey;
private String firstName;
private String lastName;
private String phoneNumber;
private String organization;
private String designation;
private String domain;
private String createdBy;
private String updatedBy;
@Column(name="createdAt")
private final  LocalDateTime now1 = LocalDateTime.now(); 
@Column(name="updatedAt")
private final  LocalDateTime now= LocalDateTime.now();
public long getUserId() {
	return userId;
}
public void setUserId(long userId) {
	this.userId = userId;
}
public String getUserKey() {
	return userKey;
}
public void setUserKey(String userKey) {
	this.userKey = userKey;
}
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
public String getPhoneNumber() {
	return phoneNumber;
}
public void setPhoneNumber(String phoneNumber) {
	this.phoneNumber = phoneNumber;
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
public String getDomain() {
	return domain;
}
public void setDomain(String domain) {
	this.domain = domain;
}
public String getCreatedBy() {
	return createdBy;
}
public void setCreatedBy(String createdBy) {
	this.createdBy = createdBy;
}
public String getUpdatedBy() {
	return updatedBy;
}
public void setUpdatedBy(String updatedBy) {
	this.updatedBy = updatedBy;
}
public LocalDateTime getNow1() {
	return now1;
}
public LocalDateTime getNow() {
	return now;
}




}

