package com.aswini.Ecommerce;

import org.hibernate.mapping.Value;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.aswini.Ecommerce.DAO.LoginDaoImpl;

import com.aswini.Ecommerce.model.User;
@Component
@Controller
public class LoginController 
{
    
	public ModelAndView LoginController()
	{
		ModelAndView modelAndView = new ModelAndView("AdminHome");
		return modelAndView;
	}
	
	@Autowired
	@RequestMapping("/login")
	public ModelAndView login() 
	{
		ModelAndView modelAndView = new ModelAndView("Login");
		User user = new User();
		user.setUserName("Edward");
		user.setMobileNo("8096935000");
		modelAndView.addObject("log",user);
		return modelAndView;
	}
	@Autowired
	LoginDaoImpl logindaoimpl;
	@RequestMapping(value="/loginUser",method=RequestMethod.POST)
    public String readLogin(@ModelAttribute("log") User user )
    {
		//String page = null;
		//boolean page = logindaoimpl.validateUser(user);
		User page = logindaoimpl.validateUser(user);
		if(page!= null)
		{
    	//page = "home";
		   if(page.getRole().equals("ROLE_ADMIN"))
		   {
			   return "AdminHome";
		   }
		   else if(page.getRole().equals("ROLE_USER"))
		   {
			 // System.out.println("========"+user.getRole());
			  return "UserHome";
		   }
		}
	    else if(page==null)
		  {
		       return "redirect:login";
		  }
		return "";
		}
    }

