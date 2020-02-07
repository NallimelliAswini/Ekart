package com.aswini.Ecommerce;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.aswini.Ecommerce.DAO.ProductDaoImpl;
import com.aswini.Ecommerce.DAO.UserDaoImpl;
import com.aswini.Ecommerce.model.Product;
@Component
@Controller
public class ProductController 
{
	
	    //UserDaoImpl  userDaoimpl;
	/*
		@RequestMapping("/showproducts")
		public ModelAndView test3()
		{
			userDaoimpl.testSessionFactory();
			System.out.println("at hi request @test3");
			Product p1 = new Product();
			Product p2 = new Product();
			Product p3 = new Product();
		    ArrayList arrlst = new ArrayList();
		    arrlst.add(p1);
			arrlst.add(p2);
			arrlst.add(p3);
			p1.setProductId(303);
			p1.setProductName("Realme");
			p1.setProductPrice(17000);
			p1.setProductDescription("2gb ram,3000ram");
			p2.setProductId(404);
			p2.setProductName("vivo");
			p2.setProductPrice(18000);
			p2.setProductDescription("3gb ram,3500ram");
			p3.setProductId(505);
			p3.setProductName("Oppo");
			p3.setProductPrice(21000);
			p3.setProductDescription("4gb ram,4000ram");
			//ModelAndView modelview = new ModelAndView("xyz");
		
			p1.setProduct(303, "Realme", 17000);
			p2.setProduct(404, "vivo", 18000);
			p3.setProduct(505, "Oppo", 21000);
			
			ModelAndView modelview = new ModelAndView("displayproducts");
			modelview.addObject("prodata",arrlst);
			return modelview;
		
		}
*/
@Autowired
@RequestMapping("/AdminHome")
 public String test()
 {    
  ModelAndView modelview = new ModelAndView("AdminHome");
  return "AdminHome";
 }
	
@Autowired
//ProductDaoImpl productdaoimpl;
@RequestMapping("/addproduct")
 public ModelAndView addProduct()
 {
 Product product  = new Product();
 ModelAndView modelview = new ModelAndView("addproducts");
 product.setProductName("lenovo");
 modelview.addObject("add",product);
 return modelview;
 /*
 Users users = new Users();
 users.setEmail("aswini@gmail.com");
 modelview.addObject("usrs",users);
 */
 }
@Autowired
ProductDaoImpl productdaoimpl;
SessionFactory sessionFactory;
@RequestMapping(value="/carryproduct",method=RequestMethod.POST)
 public String ProductForm(@ModelAttribute("add") Product product ) 
 {
	/*
	System.out.println(product.getProductId());
    System.out.println(product.getProductName());
    System.out.println(product.getProductPrice());
    */
	System.out.println(product.getProductId());
	System.out.println(product.getProductImage());
	productdaoimpl.InsertProduct(product);
	MultipartFile image = product.getProductImage();//get product data
	//cut image into bytes
	try 
	{
	byte[] imagearr = image.getBytes();
	System.out.println(imagearr.length);
	String path = "F://pgp/Ecommerce/src/main/webapp/ImagePath/" + product.getProductId()+".jpg";
	System.out.println("***productimage****"+image);
    FileOutputStream fileOutputStream = new FileOutputStream(path);
    BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(fileOutputStream);
	bufferedOutputStream.write(imagearr);
    bufferedOutputStream.close();
	}
	catch(IOException e)
	{
		e.printStackTrace();
	}
	return "AdminHome";
 }
@RequestMapping("/showproducts")
 public ModelAndView displayProduct()
 {
	System.out.println("at display product");
	Product product = new Product();
	List list = productdaoimpl.getProducts(product);
	ModelAndView modelview = new ModelAndView("displayproducts");
	modelview.addObject("productList",list);
	return modelview;
 }
@GetMapping("/info")
public ModelAndView GoToSingleProduct(@RequestParam("pid") int proid)
{
	System.out.println(proid);
	Product product = productdaoimpl.getProductInfo(proid);
	System.out.println("==="+product);
	ModelAndView modelAndView = new ModelAndView("SingleProduct");
	modelAndView.addObject("pro",product);
	return modelAndView;
}
//-----------------
@RequestMapping("/ShowProductsAdmin")
   public ModelAndView displayProductAdmin()
   {
      Product product1 = new Product();
      List list = productdaoimpl.getProductsAdmin(product1);
      ModelAndView modelAndView = new ModelAndView("DisplayProductsAdmin");
      modelAndView.addObject("prolist",list);
      return modelAndView;
   }  
@GetMapping("/delete")
public String GoToSingleProductDeleteUser(@RequestParam("proid") int proId)
{
	System.out.println(proId);
	Product product1 = productdaoimpl.getProductinfodelete(proId);
	System.out.println("==="+product1);
	ModelAndView modelAndView = new ModelAndView("DeleteProduct");
	modelAndView.addObject("prod",product1);
	return "redirect:ShowProductsAdmin";
}
}

	
