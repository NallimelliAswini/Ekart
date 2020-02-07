package com.aswini.Ecommerce.DAO;

import java.util.List;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.aswini.Ecommerce.model.Product;
import com.aswini.Ecommerce.model.User;
@Component
public class ProductDaoImpl 
{
	@Autowired
	SessionFactory sessionFactory;
	public void InsertProduct(Product product)
	 {
		Session session = sessionFactory.openSession();
		session.save(product);
		Transaction transaction = session.beginTransaction();
		transaction.commit();
		session.close();
     }
	public List getProducts(Product product)
	{
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
	 	Query query = session.createQuery("from Product");
	  	 List list =query.list();
		 for(Object object : list)
		 {
			 Product pro =(Product)object;
			
		 }
		session.close();
		return list;
	}
	public Product getProductInfo(int proid)
	{
		Session session = sessionFactory.openSession();
	    Query  query = session.createQuery("from Product where productId=:pid ");
		query.setParameter("pid", proid);
		Product product = (Product)query.uniqueResult();
		return product;
		
	}
	//-----------------------
	public List getProductsAdmin(Product product1)
	{
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		Query query = session.createQuery("from Product");
		List list = query.list();
		for(Object object:list)
		{
			 Product pro =(Product)object;
		}
		session.close();
		return list;
		
	}
	public Product getProductinfodelete(int proId)
	{
		System.out.println("****************"+proId);
		Session session = sessionFactory.openSession();
		Query query = session.createQuery("from Product where productId=:proid ");
		query.setParameter("proid",proId);
		Product product = (Product)query.uniqueResult();
		session.delete(product);
		 Transaction transaction = session.beginTransaction();
		 transaction.commit();
		 System.out.println("deleted");
		session.close();
		return product;
	}
}
