package com.jsp.hibernate.shoping_cart;

import com.jsp.hibernate.shoping_cart.dao.*;

public class App {
	public static void main(String[] args) {
      ShopingCartDao sh=new ShopingCartDao();
//      sh.addProduct();  
      sh.addUserWithCart();
//      sh.addProductToCart();
//      sh.removeProductFromCart();
	}
}
