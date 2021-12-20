package com.pro.user.dto;

import java.time.LocalDateTime;

public class UserDto {
	
          private String userId;
          private String userKey;
          private String domain;
		  private String firstName;
          private String lastName;
          private String organization;
          private String designation;
          private LocalDateTime now1;
          private LocalDateTime now;
          private String createdBy="ADMIN";
          private String UpdatedBy="ADMINS";
          
		public String getUserId() {
			return userId;
		}
		public void setUserId(String userId) {
			this.userId = userId;
		}
		public String getUserKey() {
			return userKey;
		}
		public void setUserKey(String userKey) {
			this.userKey = userKey;
		}
	    	public String getDomain() {
			return domain;
		}
		public void setDomain(String domain) {
			this.domain = domain;
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
		public LocalDateTime getNow1() {
			return now1;
		}
		public void setNow1(LocalDateTime now1) {
			this.now1 = now1;
		}
		public LocalDateTime getNow() {
			return now;
		}
		public void setNow(LocalDateTime now) {
			this.now = now;
		}
		public String getCreatedBy() {
			return createdBy;
		}
		public void setCreatedBy(String createdBy) {
			this.createdBy = createdBy;
		}
		public String getUpdatedBy() {
			return UpdatedBy;
		}
		public void setUpdatedBy(String updatedBy) {
			UpdatedBy = updatedBy;
		}
         
          
          
}
