package com.library.dannet.controller;


import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.hibernate.internal.build.AllowSysOut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.library.dannet.dao.BooksRepo;
import com.library.dannet.dao.OrderRepo;
import com.library.dannet.pojo.Book;
import com.library.dannet.pojo.BookListContainer;
import com.library.dannet.pojo.Bookkeeping;
import com.library.dannet.pojo.Books;
import com.library.dannet.pojo.Login;
import com.library.dannet.pojo.MybookingListContainer;
import com.library.dannet.pojo.Orders;
import com.library.dannet.pojo.Registration;
import com.library.dannet.pojo.mybooking;
import com.library.dannet.service.BookCopieService;
import com.library.dannet.service.BookService;
import com.library.dannet.service.Dueservices;
import com.library.dannet.service.OrderManagement;



@Controller
public class OrderController {
	
	
	@Autowired
	BooksRepo br;
	
	@Autowired
	OrderRepo orp;
	
	@Autowired
	BookCopieService bcs;
	
	@Autowired
	OrderController oc;
	
	@Autowired
	OrderManagement orm;
	
	@Autowired
	BookService bss;
	
	@Autowired
	Dueservices ds;
	
	private Date sqlDatePlusDays(Date date, int days) {
	    return Date.valueOf(date.toLocalDate().plusDays(days));
	}
	
	
	@RequestMapping(value ="/booking", method = RequestMethod.POST)
    public String bookOrder(@RequestParam(value = "bookid", required = false) int[] bookids,HttpSession session,Model m ) {
		
		mybooking mbs=new mybooking();
		if(bookids==null)
		{
			System.out.println("hereeeee");
			m.addAttribute("message","no book selected");
			return "bookStore";
		}
		else
		{
		  long now = System.currentTimeMillis();
	        Date sqlDate = new Date(now);
	       String aadhar=(String) session.getAttribute("username");
        for (int i=0;i<bookids.length;i++)
        {
        	
        	Bookkeeping bkk=bcs.findcopies(bookids[i]);
        	Optional<Books> bk=br.findById(bookids[i]);
        	if(bkk.getAvailablecopies()==0)
        	{
        		//map.put("error", "No copies available");
        		
        		m.addAttribute("message","no copies available");
        		 return "bookStore";
        	}
        	else
        	{
        		
        	Orders ord=new Orders();
        	Books books1=br.getById(bookids[i]);
        	//ord.setOrderid(5);
        	ord.setAadharid(aadhar);
        	ord.setBookid(bookids[i]);
        	int p=orm.getOrders(aadhar, bookids[i]);
        	System.out.println(" value of p "+p);
        	if(p>0)
        	{
        		m.addAttribute("message","Booking unsuccesfull already a copy of book is booked");
        		return "confirmation";
        	}
        	else
        	{	
        		bkk.setAvailablecopies (bkk.getAvailablecopies()-1);
        		bkk.setBookedcopies (bkk.getBookedcopies()+1);
        		int bku=bcs.updateCopies(bkk);
        	ord.setBookingdate(sqlDate);
        	ord.setStatus("ACTIVE");
        	orp.save(ord);
        	mbs.setAadharid(ord.getAadharid());
			mbs.setBookid(ord.getBookid());
			
			mbs.setBookingdate(ord.getBookingdate());
			mbs.setEndDate(oc.sqlDatePlusDays(mbs.getBookingdate(), 10));
			mbs.setBookname(books1.getBookname());
			mbs.setBooks(books1.getBooks());
			mbs.setOrderid(ord.getOrderid());
        	
        	System.out.println(bk);
        	}
        	}
        }
        m.addAttribute("message","Booking succesfull");
        m.addAttribute("booking1",mbs);
        session.setAttribute("username", aadhar);
        return "confirmation";
		}
    }
	
	@RequestMapping(value="/myprofiile", method = RequestMethod.GET)
	public String mybookings(Model model,HttpSession session)
	{
		Calendar cal = Calendar.getInstance();
		 System.out.println("entering here orders");
		String aadhar=(String) session.getAttribute("username");
		
		System.out.println(aadhar);
		List<Orders> ord=orp.getOrders(aadhar);
		
		List<mybooking> mb=new ArrayList<mybooking>();
		Iterator<Orders> itr=ord.iterator();
		while (itr.hasNext())
		{
			mybooking mbs=new mybooking();
			Orders ordd=itr.next();
			Books book=br.getById(ordd.getBookid());
			
			mbs.setAadharid(ordd.getAadharid());
			mbs.setBookid(ordd.getBookid());
			
			mbs.setBookingdate(ordd.getBookingdate());
			mbs.setEndDate(oc.sqlDatePlusDays(mbs.getBookingdate(), 10));
			mbs.setBookname(book.getBookname());
			mbs.setBooks(book.getBooks());
			mbs.setOrderid(ordd.getOrderid());
			mb.add(mbs);
			
		}
		//mb.forEach(p->System.out.println(p));
		MybookingListContainer bookingcontainer=new MybookingListContainer();
		bookingcontainer.setBooking(mb);
		List<mybooking> mb1=bookingcontainer.getBooking();
		mb1.forEach(p->System.out.println(p));
		model.addAttribute("Mybooking", bookingcontainer);
		return "myprofiile";
	}
	@RequestMapping(value ="/returnbook", method = RequestMethod.POST)
    public String returnbook(@RequestParam("orderid") int orderid,Model m,HttpSession session )
    {
		String aadhar=(String) session.getAttribute("username");
		System.out.println(aadhar);
		System.out.println("entering book submit");
		Orders orr=orp.getById(orderid);
		System.out.println(orr);
		Bookkeeping bkk1=bcs.findcopies(orr.getBookid());
		bkk1.setAvailablecopies(bkk1.getAvailablecopies()+1);
		bkk1.setBookedcopies(bkk1.getBookedcopies()-1);
		int bku=bcs.updateCopies(bkk1);
		orr.setOrderid(orderid);
		System.out.println(orderid);
		int j=orm.manageorders(orr);
		return "redirect:/myprofiile";
    }
	
	
	@RequestMapping(value="/search", method = RequestMethod.GET)
    public ModelAndView searchbooksget(ModelMap model){
		//System.out.println("entering search page");
		 return new ModelAndView("search", "books1", new Books());
    }
	
	@RequestMapping(value="/search", method = RequestMethod.POST)
	 public String showMyBooks(@Valid @ModelAttribute("books1") Books books1,BindingResult result,  ModelMap model,Model m ){

		System.out.println("entering search page post");
		boolean isspecified;
		isspecified=false;
	System.out.println(books1);
		if(result.hasErrors())
		{
			System.out.println(result.getErrorCount());
			return "error";
		}
		
		Books bkc=new Books();
		if (books1.getBookid()!=0)
		{
			bkc.setBookid(books1.getBookid());
			System.out.println("bookid");
			isspecified=true;
		}
		else
		{
			bkc.setBookid(0);
			
		}
		
		if(!(books1.getBooks().isEmpty()))
		{
			bkc.setBooks(books1.getBooks());
			System.out.println("here books");
			isspecified=true;
		}
		else
		{
			bkc.setBooks(null);
			
		}

		if(books1.getBookname().length()!=0)
		{
			bkc.setBookname(books1.getBookname());
			isspecified=true;
		}
		else
		{
			bkc.setBookname(null);
			
		}
		if(books1.getAuthor().length()!=0)
		{
			bkc.setAuthor(books1.getAuthor());
			isspecified=true;
		}
		else
		{
			bkc.setAuthor(null);
			
		}
		if(books1.getContry().length()!=0)
		{
			bkc.setContry(books1.getContry());
			isspecified=true;
		}
		else
		{
			bkc.setContry(null);
			
		}
		if(books1.getLanguage().length()!=0)
		{
			bkc.setLanguage(books1.getLanguage());
			isspecified=true;
		}
		else
		{
			bkc.setLanguage(null);
			
		}
	
		System.out.println(isspecified);
		System.out.println(bkc);
		List<Books> bklist;
		if(isspecified==false)
		{
			
			 bklist=bss.getBookList();
			bklist.forEach(p-> System.out.println(p));
		}
		else
		{
			System.out.println(bkc.getBookid());
			bklist=br.getBooks(bkc.getBookid(),bkc.getBooks() ,bkc.getBookname() ,bkc.getAuthor(),bkc.getContry() ,bkc.getLanguage());
			bklist.forEach(p-> System.out.println(p));
		}
	
		
		 List<Book> bklist1=new ArrayList<Book>();
		   Iterator<Books> itr=bklist.iterator();
		  while (itr.hasNext()) {
			  Book bk=new Book();
			  Books b1=new Books();
			  b1=itr.next();
			  bk.setBookid(b1.getBookid());	
			  bk.setBooks(b1.getBooks());
			  bk.setBookname(b1.getBookname());
			  bk.setAuthor(b1.getAuthor());
			  bk.setLanguage(b1.getLanguage());
			  bk.setContry(b1.getContry());
			  bklist1.add(bk);
		}
		  BookListContainer bookcontainer =new BookListContainer();
		    bookcontainer.setBook(bklist1);
		    //System.out.println(bookcontainer.getBook());
		    model.addAttribute("Book", bookcontainer);
		//System.out.println(bkc);
		/*model.addAttribute("bookid", books.getBookid());
        model.addAttribute("books", books.getBooks());
        model.addAttribute("bookname", books.getBookname());
        model.addAttribute("author", books.getAuthor());
        model.addAttribute("contry", books.getContry());
        model.addAttribute("language", books.getLanguage());*/
		 return "search";
    }
	
	public void createdueorder()
	{
		ds.createdue();
	}

}
