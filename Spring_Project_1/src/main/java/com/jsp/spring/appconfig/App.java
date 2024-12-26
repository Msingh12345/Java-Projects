package com.jsp.spring.appconfig;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {
	public static void main( String[] args ){
		ApplicationContext ac=new AnnotationConfigApplicationContext(AppConfig.class);
		Product p1=ac.getBean(Product.class);
		System.out.println(p1);
		
		Product p2=(Product)ac.getBean("product");
		System.out.println(p2);
		
		Product p3=ac.getBean(Product.class);
		System.out.println(p3);
		
		Product p4=ac.getBean(Product.class);
		System.out.println(p4);

	}
}
