package com.library.dannet.pojo;

import java.sql.Date;

public class mybooking {
	
	
	private String name;
	private String aadharid;
	private int bookid;
	private String books;
	private String bookname;
	private int orderid; 
	private Date bookingdate;
	private Date endDate;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAadharid() {
		return aadharid;
	}
	public void setAadharid(String aadharid) {
		this.aadharid = aadharid;
	}
	public int getBookid() {
		return bookid;
	}
	public void setBookid(int bookid) {
		this.bookid = bookid;
	}
	public String getBooks() {
		return books;
	}
	public void setBooks(String books) {
		this.books = books;
	}
	public String getBookname() {
		return bookname;
	}
	public void setBookname(String bookname) {
		this.bookname = bookname;
	}
	public int getOrderid() {
		return orderid;
	}
	public void setOrderid(int orderid) {
		this.orderid = orderid;
	}
	public Date getBookingdate() {
		return bookingdate;
	}
	public void setBookingdate(Date bookingdate) {
		this.bookingdate = bookingdate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	@Override
	public String toString() {
		return "mybooking [name=" + name + ", aadharid=" + aadharid + ", bookid=" + bookid + ", books=" + books
				+ ", bookname=" + bookname + ", orderid=" + orderid + ", bookingdate=" + bookingdate + ", endDate="
				+ endDate + "]";
	}
	
	
	
}
