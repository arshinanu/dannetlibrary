package com.library.dannet.service;

import java.sql.Date;

import org.hibernate.internal.build.AllowSysOut;
import org.springframework.beans.factory.annotation.Autowired;

import com.library.dannet.dao.Duestatusrepo;
import com.library.dannet.pojo.Duestatus;

public class Dueimplementationservice implements Dueservices {
	
	@Autowired
	Duestatusrepo dsr;
	
	@Autowired
	Duesericechecker dsc;

	public Dueimplementationservice() {
		super();
		
	}

	@Override
	public void createdue() {
		Duestatus ds = new Duestatus();
		 long now = System.currentTimeMillis();
		Date sqlDate = new Date(now);
		ds.setCurrentdate(sqlDate);
		Duestatus Duestatus1=null;
		try {
		 Duestatus1 = dsc.find(ds);
		
		}
		catch (Exception e) {
			System.out.println("hii");
		}
		System.out.println(Duestatus1);
		if(Duestatus1== null)
		{
			System.out.println("present11");
			
			ds.setStatus("created");
			dsr.save(ds);
			
		}
		else
		{
			System.out.println("present1233");
			
		}
		
		
	}

}
