package com.library.dannet.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.library.dannet.pojo.Books;
import com.library.dannet.pojo.Orders;

@Repository
@Transactional
public interface BooksRepo extends JpaRepository<Books, Integer> {
	
	@Query("from Books where  (  (bookid=:bookid ) or (:bookid =0) ) and  ( ( books=:books ) or :books is null ) and (  (bookname=:bookname ) or :bookname is null )  and ( ( author=:author ) or :author is  null )  and ( (contry=:contry) or :contry is  null)   and ( (language=:language ) or :language is  null ) ")
	public List<Books> getBooks(int bookid ,String books ,String bookname , String author , String contry, String language );

	
	

}
