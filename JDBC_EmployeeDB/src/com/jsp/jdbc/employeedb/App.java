package com.jsp.jdbc.employeedb;

public class App {
	public static void main(String[] args) {
	   EmployeeDao dao=new EmployeeDao();
//       dao.addEmployee();
	   dao.findEmployeeById(1);
	   dao.findEmployeeById(2);
	   dao.findEmployeeById(3);
	   dao.findEmployeeById(4);
	   
//	   dao.deleteEmployeeById(4);
//	   dao.updatemployeeById(4);
	   System.out.println();
       System.out.println("end");
       
//       dao.updateSalaryBetweenAge();
	}
}
