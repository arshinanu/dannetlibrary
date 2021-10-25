package com.library.dannet.pojo;

import java.sql.Date;
import java.util.Iterator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Orders {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int orderid;
	private int bookid ;
	private String aadharid;
	private Date bookingdate;
	
	private String status;
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public int getOrderid() {
		return orderid;
	}
	public void setOrderid(int orderid) {
		this.orderid = orderid;
	}
	public int getBookid() {
		return bookid;
	}
	public void setBookid(int bookid) {
		this.bookid = bookid;
	}
	public String getAadharid() {
		return aadharid;
	}
	public void setAadharid(String aadharid) {
		this.aadharid = aadharid;
	}
	public Date getBookingdate() {
		return bookingdate;
	}
	public void setBookingdate(Date bookingdate) {
		this.bookingdate = bookingdate;
	}
	@Override
	public String toString() {
		return "Orders [orderid=" + orderid + ", bookid=" + bookid + ", aadharid=" + aadharid + ", bookingdate="
				+ bookingdate + ", status=" + status + "]";
	}
	

}
