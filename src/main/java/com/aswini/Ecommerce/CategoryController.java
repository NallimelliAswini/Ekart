package com.aswini.Ecommerce;
	import java.util.ArrayList;

import javax.servlet.RequestDispatcher;

import org.springframework.stereotype.Controller;
	import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


	@Controller
	public class CategoryController {
		public CategoryController() {
		System.out.println("Category Controller is loading");
		}
		@RequestMapping("/hi")
		public String test()
		{
			System.out.println("at hi request");
			return "hello";
		}
		@RequestMapping("/hey")
		public String test1()
		{
			System.out.println("at hi request @test1");
			return "abc";
		}
		@RequestMapping("/hayi")
			public String test2()
			{
				System.out.println("request at test2");
				return "xyz"; 
			}

}
