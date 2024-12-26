package com.jsp.hibernate2;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Car {
	@Override
	public String toString() {
		return "Car [Id=" + Id + ", Name=" + Name + ", Brand=" + Brand + ", Price=" + Price + "]";
	}
	@Id
	private int Id;
	private String Name;
	private String Brand;
	private int Price;
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getBrand() {
		return Brand;
	}
	public void setBrand(String brand) {
		Brand = brand;
	}
	public int getPrice() {
		return Price;
	}
	public void setPrice(int price) {
		Price = price;
	}

}
