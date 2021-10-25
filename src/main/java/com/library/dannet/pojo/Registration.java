package com.library.dannet.pojo;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Registration {
	
	@Id
	private String aadharid;
	private String name;
	private String emailid;
	private String password;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmailid() {
		return emailid;
	}
	
	public void setEmailid(String emailid) {
		this.emailid = emailid;
	}
	public String getAadharid() {
		return aadharid;
	}
	public void setAadharid(String aadharid) {
		this.aadharid = aadharid;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "Registration [ aadharid=" + aadharid + ", name=" + name + ", emailid=" + emailid
				+ ", password=" + password + "]";
	}
}
