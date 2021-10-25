package com.library.dannet.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.library.dannet.dao.BookkeepingRepo;
import com.library.dannet.pojo.Bookkeeping;

@Service
public class BookCopieService {
	
	
	@Autowired
	BookkeepingRepo bkr;
	public Bookkeeping findcopies(int bid)
	{
		
		Bookkeeping bkk=new Bookkeeping();
		bkk=bkr.getById(bid);
		System.out.println(bkk);
		
		return bkk;
	}
	
	public int updateCopies(Bookkeeping bkp)
	{
		
		int s=bkr.updateBookkeeping(bkp.getBookid(), bkp.getAvailablecopies(),bkp.getBookedcopies());
		
		return s;
	}

}
