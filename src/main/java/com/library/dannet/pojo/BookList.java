package com.library.dannet.pojo;

import java.util.List;

public class BookList {
	
	private List<Book> bookList;

	public BookList(List<Book> bookList) {
		super();
		this.bookList = bookList;
	}

	public List<Book> getBookList() {
		return bookList;
	}

	public void setBookList(List<Book> bookList) {
		this.bookList = bookList;
	}

}
