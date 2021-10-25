package com.library.dannet.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.library.dannet.dao.BookkeepingRepo;
import com.library.dannet.dao.OrderRepo;
import com.library.dannet.pojo.Bookkeeping;
import com.library.dannet.pojo.Login;
import com.library.dannet.pojo.Orders;
import com.library.dannet.service.BookKeepingListContainer;
import com.library.dannet.service.OrderListContainer;

@Controller
public class AdminController {
	
	
	@Autowired
	BookkeepingRepo bkr;
	
	@Autowired
	OrderRepo or;
	
	@RequestMapping(value="/dashboard", method = RequestMethod.GET)
    public String getDashboard(Model model){
		
		
		List<Bookkeeping> bkplist=bkr.findAll();
		//bkplist.forEach(p-> System.out.println(p));
		BookKeepingListContainer bkkList=new BookKeepingListContainer();
		bkkList.setBookkeeping(bkplist);
		model.addAttribute("Book", bkkList);
		// return "dashboard";
    //}
	//@RequestMapping(value="/orderdashboard", method = RequestMethod.GET)
    //public String getOrderdashboard(Model model){
		
		
		List<Orders> orlist=or.getAvailOrders();
		orlist.forEach(p-> System.out.println(p));
		OrderListContainer orderListContainer=new OrderListContainer();
		orderListContainer.setOrderlist(orlist);
		model.addAttribute("Order", orderListContainer);
		 return "dashboard";
    }
}
