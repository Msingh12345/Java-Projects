package com.jsp.spring.productdb.service;

import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jsp.spring.productdb.entity.Product;
import com.jsp.spring.productdb.repository.ProductRepository;

@Service
public class ProductService {
	Scanner sc = new Scanner(System.in);

	@Autowired
	private ProductRepository productRepository;

	public void addProduct() {
		Product product = new Product();
		System.out.println("Enter ProductId: ");
		product.setProductId(sc.nextInt());
		System.out.println("Enter ProductName: ");
		product.setProductName(sc.next());
		System.out.println("Enter ProductBrand: ");
		product.setProductBrand(sc.next());
		System.out.println("Enter ProductPrice: ");
		product.setProductPrice(sc.nextInt());

		productRepository.addProduct(product);

		System.out.println("Data Inserted Successfully!");

	}

	public void findAllProducts() {
		List<Product> products = productRepository.findAll();
		System.out.println("All Product Details");
		for(Product product : products) {
			System.out.println(product);
		}

	}
	public void findProductById() {
		System.out.println("Enter ProductId");
		Product product = productRepository.findProductById(sc.nextInt());

		System.out.println(product);

	}


	public void updateProduct() {
		System.out.println("Enter ProductId");
		Product product = productRepository.findProductById(sc.nextInt());
		System.out.println("Enter productPrice to update");
		product.setProductPrice(sc.nextInt());
		productRepository.updateProduct(product);
		System.out.println("Product updated successfully");

	}
	public void deleteProductById() {
		System.out.println("Enter ProductId");
		productRepository.deleteProductById(sc.nextInt());

		System.out.println("Product Deleted!");

	}



}

