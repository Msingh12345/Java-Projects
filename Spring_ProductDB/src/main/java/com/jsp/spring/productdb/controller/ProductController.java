package com.jsp.spring.productdb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.jsp.spring.productdb.service.ProductService;

@Controller
public class ProductController {
	@Autowired
	private ProductService productService;
	
	public void addProduct() {
		productService.addProduct();
	}
	
	public void findProductById() {
		productService.findProductById();
		
	}
	public void findAll() {
		productService.findAllProducts();
		
	}
	public void updateProduct() {
		productService.updateProduct();
		
	}
	public void deleteProduct() {
		productService.deleteProductById();
		
	}

	
}