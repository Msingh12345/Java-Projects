package com.jsp.spring.productdb;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.jsp.spring.productdb.controller.ProductController;

public class App 
{
    public static void main( String[] args )
    {
        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
        ProductController pc = ac.getBean(ProductController.class);
        pc.addProduct();
       // pc.findProductById();
       // pc.deleteProduct();
        //pc.findAll();
       // pc.updateProduct();
    
    }
}
