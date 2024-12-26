package com.jsp.spring.applicatincontext;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.FileSystemResource;

public class App 
{
    public static void main( String[] args ){
        
//    BeanFactory bf=new XmlBeanFactory(new FileSystemResource("spring.xml"));
//    Product product=bf.getBean(Product.class);
//    System.out.println(product);
    
    ApplicationContext ac=new ClassPathXmlApplicationContext("spring.xml");
    Product product=ac.getBean(Product.class);
  System.out.println(product);
    }
}
