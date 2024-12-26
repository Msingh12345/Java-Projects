package com.jsp.hibernate;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Company {
	@Id
	private int compantId;
	private String companyName;

	@OneToMany(mappedBy = "company")
	private List<Employee> employee;

	public int getCompantId() {
		return compantId;
	}

	public void setCompantId(int compantId) {
		this.compantId = compantId;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public List<Employee> getEmployee() {
		return employee;
	}

	public void setEmployee(List<Employee> employee) {
		this.employee = employee;
	}
}
