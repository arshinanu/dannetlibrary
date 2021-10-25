package com.library.dannet.pojo;

public class Book {

	private boolean select;
	private int bookid;
	private String books;
	private String bookname;
	private String author;
	private String contry;
	private String language;
	public boolean isSelect() {
		return select;
	}
	public void setSelect(boolean select) {
		this.select = select;
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
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getContry() {
		return contry;
	}
	public void setContry(String contry) {
		this.contry = contry;
	}
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	@Override
	public String toString() {
		return "Book [select=" + select + ", bookid=" + bookid + ", books=" + books + ", bookname=" + bookname
				+ ", author=" + author + ", contry=" + contry + ", language=" + language + "]";
	}
	
	
	
}
