package com.javacodes.usersystem.bean;

public class User {
	
	private int id;
	private String name;
	private String email;
	private String country;
	private String state;
	private String city;
	private String pincode;
	private String phoneNo;
	
	
	
	public User(String name, String email, String country, String state, String city, String pincode, String phoneNo) {
		super();
		this.name = name;
		this.email = email;
		this.country = country;
		this.state = state;
		this.city = city;
		this.pincode = pincode;
		this.phoneNo = phoneNo;
	}
	public User(int id, String name, String email, String country, String state, String city, String pincode,
			String phoneNo) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.country = country;
		this.state = state;
		this.city = city;
		this.pincode = pincode;
		this.phoneNo = phoneNo;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getPincode() {
		return pincode;
	}
	public void setPincode(String pincode) {
		this.pincode = pincode;
	}
	public String getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}
	
	

}
