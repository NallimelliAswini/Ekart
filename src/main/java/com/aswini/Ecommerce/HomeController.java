package com.aswini.Ecommerce;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.aswini.Ecommerce.DAO.ConnectDB;
import com.aswini.Ecommerce.DAO.UserDaoImpl;
import com.aswini.Ecommerce.model.User;
@Component
@Controller
public class HomeController 
{
 public ModelAndView  HomeController()
 {
	ModelAndView modelandview = new ModelAndView("AdminHome");
	return modelandview;
	
 }
 @Autowired
 //UserDaoImpl userdaoimpl;
 @RequestMapping("/register")

 public ModelAndView  reg()
 {
	 
	ModelAndView modelandview = new ModelAndView("reg");
	User user = new User();
	user.setMobileNo("8096935000");
	modelandview.addObject("usr",user);
	return modelandview;
	
 }
 @Autowired
 UserDaoImpl userdaoimpl;
 @RequestMapping(value="/carryuser", method=RequestMethod.POST)
	public String readProductForm(@ModelAttribute("usr") User user)
	{
	 /*
		System.out.println(user.getUserName());
		System.out.println(user.getPassword());
		System.out.println(user.getEmail());
		System.out.println(user.getMobileNo());//
		ConnectDB con = new ConnectDB();
		String s1 = user.getUserName();
		String s2= user.getPassword();
		String s3= user.getEmail();
		String s4= user.getMobileNo();
		con.ConnectDataBase(s1,s2,s3,s4); 
		*/
	    userdaoimpl.insertUser(user);
		return "AdminHome";
	}
 
}

