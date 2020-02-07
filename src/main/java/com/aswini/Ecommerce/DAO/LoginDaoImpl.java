package com.aswini.Ecommerce.DAO;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.aswini.Ecommerce.model.User;


@Component
public class LoginDaoImpl 
{
	@Autowired
	SessionFactory sessionFactory;
public User validateUser(User user)
{
	System.out.println("---------"+user.getUserName());
	System.out.println("........"+user.getPassword());
		  Session session= sessionFactory.openSession();
	   	  Query query = session.createQuery("from User where userName=:us and password=:pwd");
	   	  query.setParameter("us",user.getUserName());
	   	  query.setParameter("pwd", user.getPassword());
	   	  Object object = query.uniqueResult();
	   	  User user1 = (User)object;
	   	  System.out.println("========="+user1);
	   	  if(user1!=null)
	   	  {
	   		  //return true;
	   		  return user1;
	   	  }
	   	  else
	   	  {
	   		  //return false;
	   		  return null;
	   	  }
		  
  }

}
