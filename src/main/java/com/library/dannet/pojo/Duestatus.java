package com.library.dannet.pojo;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Duestatus {
	
	@Id
	private Date currentdate;
	private String status;
	public Date getCurrentdate() {
		return currentdate;
	}
	public void setCurrentdate(Date currentdate) {
		this.currentdate = currentdate;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}

}
