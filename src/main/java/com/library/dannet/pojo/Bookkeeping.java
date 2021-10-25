package com.library.dannet.pojo;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Bookkeeping {

	@Id
	private int bookid;
	private int totalcopies;
	private int bookedcopies;
	private int availablecopies;
	public int getBookid() {
		return bookid;
	}
	public void setBookid(int bookid) {
		this.bookid = bookid;
	}
	public int getTotalcopies() {
		return totalcopies;
	}
	public void setTotalcopies(int totalcopies) {
		this.totalcopies = totalcopies;
	}
	public int getBookedcopies() {
		return bookedcopies;
	}
	public void setBookedcopies(int bookedcopies) {
		this.bookedcopies = bookedcopies;
	}
	public int getAvailablecopies() {
		return availablecopies;
	}
	public void setAvailablecopies(int availablecopies) {
		this.availablecopies = availablecopies;
	}
	@Override
	public String toString() {
		return "Bookkeeping [bookid=" + bookid + ", totalcopies=" + totalcopies + ", bookedcopies=" + bookedcopies
				+ ", availablecopies=" + availablecopies + "]";
	}
	
}
