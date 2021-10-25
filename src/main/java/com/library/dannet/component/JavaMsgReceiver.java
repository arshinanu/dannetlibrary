package com.library.dannet.component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import com.library.dannet.dao.BookkeepingRepo;
import com.library.dannet.dao.BooksRepo;
import com.library.dannet.pojo.Bookkeeping;
import com.library.dannet.pojo.Books;

@Component
public class JavaMsgReceiver {
	
	@Autowired
	BooksRepo br;
	
	@Autowired
	BookkeepingRepo bkr;
	
	@JmsListener(destination = "java")
	 public void receiveJavaMessage(Books  bb) {
		    System.out.println("Received: of" + bb);
		    Bookkeeping bkp=new Bookkeeping();
		    bkp.setBookid(bb.getBookid());
		    bkp.setBookedcopies(0);
		    bkp.setAvailablecopies(1);
		    bkp.setTotalcopies(1);
		    br.save(bb);
		    bkr.save(bkp);
		  } 

}
