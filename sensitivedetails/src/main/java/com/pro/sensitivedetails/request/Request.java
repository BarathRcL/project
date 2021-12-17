package com.pro.sensitivedetails.request;

public class Request {

	private long userId;
	private String name;
	private String value;

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public Request(long userId, String name, String value) {
		super();
		this.userId = userId;
		this.name = name;
		this.value = value;
	}

	public Request() {
		super();
	}

}
