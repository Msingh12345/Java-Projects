package com.jsp.hibernate.shoping_cart.dao;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.jsp.hibernate.shopping_cart.entity.Cart;
import com.jsp.hibernate.shopping_cart.entity.Product;
import com.jsp.hibernate.shopping_cart.entity.User;

public class ShopingCartDao {
	public static Session getSession() {
		Configuration cfg=new Configuration();
		cfg.configure();
		cfg.addAnnotatedClass(User.class);
		cfg.addAnnotatedClass(Product.class);
		cfg.addAnnotatedClass(Cart.class);
		SessionFactory sf=cfg.buildSessionFactory();
		Session session =sf.openSession();
		
		return session;
	}
	public void addProduct() {
		Scanner s=new Scanner(System.in);
		Product p1=new Product();
		System.out.print("Enter Product Id: ");
		p1.setProductId(s.nextInt());
		System.out.print("Enter Product Barnd: ");
		p1.setProductBrand(s.next());
		System.out.print("Enter Product Name: ");
		p1.setProductName(s.next());
		System.out.print("Enter Product Price: ");
		p1.setProductPrice(s.nextInt());
		
		
		Session session =getSession();
		
		Transaction tran=session.beginTransaction();
		session.save(p1);

		tran.commit();
		session.close();
	}
	public void addUserWithCart() {
		
		Scanner s=new Scanner(System.in);
		System.out.print("Enter userId: ");
		int id=s.nextInt();
		System.out.print("Enter userName");
		String name=s.next();
		System.out.print("Enter userEmail");
		String email=s.next();
		System.out.print("Enter userAge");
		int age=s.nextInt();
		System.out.print("Enter userCity");
		String city=s.next();
		
		User u1=new User();
		u1.setUserId(id);
		u1.setUserName(name);
		u1.setUserEmail(email);
		u1.setUserAge(age);
		u1.setUserCity(city);
		
		System.out.println("Enter Cart-Id:");
		int cartId=s.nextInt();
		Cart c1=new Cart();
		c1.setCartId(cartId);
		
		u1.setCart(c1);
	
		
		
		Session session =getSession();
		Transaction tran=session.beginTransaction();
		session.save(u1);
		session.save(c1);;
		
		tran.commit();
		session.close();
		s.close();

	}
	public void addProductToCart() {
		Scanner s=new Scanner(System.in);
		Session session = getSession();
		Transaction tran=session.beginTransaction();
		
		System.out.println("Enter product Id:");
		Product existingProduct=session.get(Product.class, s.nextInt());
		if(existingProduct!=null) {
			System.out.println("Enter User Id: ");
			User existingUser=session.get(User.class, s.nextInt());
			if(existingUser!=null) {
				Cart cart=existingUser.getCart();
				List<Product> plist=cart.getProduct();
				plist.add(existingProduct);
				session.save(cart);
			}else {
				System.err.println("User not Found!!");
			}
			
		}else {
			System.err.println("Product Not Found!!");
		}
		
		tran.commit();
		session.clear();
		s.close();

	}
	public void removeProductFromCart() {
		Scanner s=new Scanner(System.in);
		Session session = getSession();
		Transaction tran=session.beginTransaction();
		
		System.out.println("Enter User Id:");
		User existingUser=session.get(User.class, s.nextInt());
		if(existingUser!=null) {
			Cart cart=existingUser.getCart();
			if(cart!=null) {
				List<Product> products=cart.getProduct();
				System.out.println("enter product id: ");
				int productId=s.nextInt();
				Product productRemove=null;
				for(Product product:products) {
					if(product.getProductId()==productId) {
						productRemove=product;
						break;
					}
				}
				
				if(productRemove!=null) {
					products.remove(productRemove);
					cart.setProduct(products);
					session.update(cart);
					System.out.println("Product is removed");
				}else {
					System.out.println("product is not present in the cart");
				}
				
//				session.save(cart);
			}else {
				System.err.println("Cart is Empty!!");
			}
			
		}else {
			System.err.println("User Not Found!!");
		}
		
		tran.commit();
		session.clear();
		s.close();
	}
	public void findAllProductFromCart() {

	}
}
