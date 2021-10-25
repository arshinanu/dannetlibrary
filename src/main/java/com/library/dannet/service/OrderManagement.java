package com.library.dannet.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.library.dannet.dao.OrderRepo;
import com.library.dannet.pojo.Orders;

@Service
public class OrderManagement {
	
	
	@Autowired
	OrderRepo orp;
	
	public int manageorders(Orders ord)
	{
		int ord1=orp.updateOrders(ord.getOrderid());
		
		return ord1;
		
	}
	
	public int getOrders(String aadhar,int bookid)
	{
		int ord2=orp.getbookOrder(aadhar, bookid);
		return ord2;
	}

}
