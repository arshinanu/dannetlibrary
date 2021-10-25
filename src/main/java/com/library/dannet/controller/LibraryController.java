package com.library.dannet.controller;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionContext;
import javax.validation.Valid;

import org.hibernate.internal.build.AllowSysOut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.library.dannet.dao.BooksRepo;
import com.library.dannet.dao.RegistrationRepo;
import com.library.dannet.pojo.Book;
import com.library.dannet.pojo.BookListContainer;
import com.library.dannet.pojo.Books;
import com.library.dannet.pojo.FileBeans;
import com.library.dannet.pojo.Login;
import com.library.dannet.pojo.Registration;
import com.library.dannet.service.BookService;
import com.library.dannet.service.Importserinceintf;
import com.library.dannet.service.Registerservice;

@Controller
public class LibraryController {
	
	@Autowired(required=false)
	RegistrationRepo rep;
	
	@Autowired
	FileBeans fb; 
	
	
	@Autowired
	Importserinceintf isi;
	
	@Autowired
	BookService bs;
	
	@Autowired
	Registerservice rs;
	
	@RequestMapping("home")
	public String home() {
		
		System.out.println("hi");
		
		return "home";
	}

	@RequestMapping(value="/registration", method = RequestMethod.GET)
    public ModelAndView showLoginPage(ModelMap model){
		 return new ModelAndView("registration", "registration", new Registration());
    }
	
	@RequestMapping(value="/registration", method = RequestMethod.POST)
    public String showWelcomePage(@Valid @ModelAttribute("registration") Registration registration,BindingResult result,  ModelMap model,Model m ){

		
		if(result.hasErrors())
		{
			System.out.println(result.getErrorCount());
			return "error";
		}
		else
		{
		
			Registration rst=null;
		 try {
			 rst=rep.getRegistrations(registration.getAadharid());
			// System.out.println(rst);
		 }
		 catch (Exception e) {
			 System.out.println("no record");
		}
		if(rst!=null)
		{
			
			m.addAttribute("message", "invalid Aadhar");
			return "registration";
		}
		else
		{
		model.addAttribute("name", registration.getName());
        model.addAttribute("emailid", registration.getEmailid());
        model.addAttribute("aadharid", registration.getAadharid());
        model.addAttribute("password", registration.getPassword());
        model.addAttribute("message","registration succesfull");
        rep.save(registration);
		
        return "success";
		}
		}
		
		
		 
    }
	
	@RequestMapping(value="/login", method = RequestMethod.GET)
    public ModelAndView getLoginPage(ModelMap model){
		 return new ModelAndView("login", "login", new Login());
    }
	
	@RequestMapping(value="/welcome", method = RequestMethod.GET)
    public String getwelcomePage(ModelMap model ,HttpServletRequest reg){
		// ModelAndView mv=new ModelAndView();
		HttpSession session=reg.getSession();
		 session.setAttribute("username", null);
		// mv.setViewName("welcome");
		 return "welcome";
    }
	
	@RequestMapping(value="/login", method = RequestMethod.POST)
	 public String showMyLogin(@Valid @ModelAttribute("login") Login login,BindingResult result,  ModelMap model,HttpSession session ){

			System.out.println("entering login");
			/*if(result.hasErrors())
			{
				System.out.println(result.getErrorCount());
				return "error";
			}
			else
			{
			*/
			
			model.addAttribute("aadharid",login.getAadharid() );
	        model.addAttribute("password", login.getPassword());
	       
	        Registration rs1=new Registration();
	        rs1.setAadharid(login.getAadharid());
	        rs1.setPassword(login.getPassword());
	        
	     //   Registration rst = rep.getRegistration(login.getAadharid(), login.getPassword());
	        Registration rst = null;
	        try {
	        	rst=rs.find(rs1);
	        }
	        catch (Exception e) {
				System.out.println();
			}
	        if(rst==null)
	        {
	        	model.addAttribute("message", "invalid login");
	        	return "login";
	        }
	        else
	        {
	        	System.out.println("arshin here");
	        model.addAttribute("name", rst.getName());
	        if(rst.getName().contains("admin"))
	        {
	        	return "admin";
	        }
	        else
	        {
			System.out.println(rst);
			session.setAttribute("username", login.getAadharid());
	        return "welcome";
	        }
	        }
			//}
			
			
			 
	    }
	
	
	@GetMapping("/uploadFile")
    public String index() {
		System.out.println("enntering here");
        return "uploadFile";
    }
	
	@RequestMapping(value="/bookStore", method = RequestMethod.GET)
	public String getBooks(Model model) {
		
	    List<Books> books = bs.getBookList();
	    List<Book> bklist=new ArrayList<Book>();
	   Iterator<Books> itr=books.iterator();
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
		  bklist.add(bk);
	}
	 // bklist.forEach(p->System.out.println(p));
	    BookListContainer bookcontainer =new BookListContainer();
	    bookcontainer.setBook(bklist);
	    //System.out.println(bookcontainer.getBook());
	    model.addAttribute("Book", bookcontainer);
	    return "bookStore";
	  }
	/*
	 @RequestMapping(value ="/booking", method = RequestMethod.POST)
	    public String bookOrder(@RequestParam(value = "bookid", required = false) int[] bookids) {
		 for (int i=0;i<bookids.length;i++)
		 {
			 System.out.println(bookids[i]);
		 }
			 
	        // process your list
			return null;
	    }
	*/
	
	@PostMapping("/uploadFile")
	 public String uploadFile(@RequestParam("file") CommonsMultipartFile file, RedirectAttributes redirectAttributes)
	 {
		System.out.println("entering here");

		 fb.setfileData(file);
		 isi.importfile(fb);

		System.out.println("entering here");
		String msg;
		msg="You have successfully uploaded ";
		System.out.println(msg);
		
		
		
		
		
		redirectAttributes.addFlashAttribute("message",msg);

	       	      	
	        
	      return  "redirect:/uploadFile.jsp";
			
	    }
	
	@GetMapping("/logout")
    public ModelAndView getLogout(HttpServletRequest request,HttpSession session){
		System.out.println("entering logout");
		//System.out.println(session.getAttribute("username"));
		session.removeAttribute("username");
		session.invalidate();
		 return new ModelAndView("login", "login", new Login());
    }
	
}
