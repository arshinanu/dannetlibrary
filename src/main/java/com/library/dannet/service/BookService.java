package com.library.dannet.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.library.dannet.dao.BooksRepo;
import com.library.dannet.pojo.Books;

@Service
public class BookService {
	
	@Autowired
	BooksRepo br;
	
	public List<Books> getBookList()
	{
		
		return br.findAll();
	}

}
