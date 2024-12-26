package com.jsp.jdbc.employeedb;

import java.sql.Statement;
import java.util.Scanner;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EmployeeDao {
	public static Connection buildConnection() {
		Connection conn=null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/employeedb", "root", "msingh12345@");
		} catch (ClassNotFoundException | SQLException e) {

			e.printStackTrace();
		}
		return conn;
	}
	public void addEmployee() {
		Connection conn=buildConnection();
		try {
			Statement st=conn.createStatement();
			boolean result=st.execute("INSERT INTO employee value"
					+ "(4,'Peter','peter@gmail.com','SDE',20,90000)");
			System.out.println(result);
			if(result==false) {
				System.out.println("Data inserted successfully!!");
			}else {
				System.out.println("Data not inserted!!");
			}

		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			if(conn!=null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}
	public void findEmployeeById(int id) {
		Connection conn=buildConnection();
		try {
			Statement st=conn.createStatement();
			String query = "SELECT * FROM employee where employeeId="+id;
			ResultSet resultSet = st.executeQuery(query);
			
			System.out.println("The Available Data\n");

			while (resultSet.next()) {
				int employeeId = resultSet.getInt("employeeId");
				String employeeName = resultSet.getString("employeeNmae");
				String employeeDesc = resultSet.getString("employeeDesc");
				String employeeEmail = resultSet.getString("employeeEmail");
				int employeeAge=resultSet.getInt("employeeAge");
				int employeeSalary=resultSet.getInt("employeeSalary");
				System.out.println("Id: "+employeeId+" Name: "+employeeName+" Email: "+
				employeeEmail+ " Desc "+employeeDesc+ " Age: "+employeeAge+" Salary: "+
						employeeSalary);
			}

			}catch(Exception e) {
				e.printStackTrace();
			}
		finally {
			if(conn!=null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		}
		public void updatemployeeById(int id) {
			Connection conn=buildConnection();
			Scanner sc=new Scanner(System.in);
			PreparedStatement ps=null;
			try {
				System.out.println("Enter empId to update");
				int employeeId=sc.nextInt();
				sc.nextLine();
				
			    System.out.println("Enter new desc");
			    String desc=sc.next();
			    String query="update employee set employeeDesc=? where employeeId=?";
			    ps=conn.prepareStatement(query);
			    ps.setString(1,desc);
			    ps.setInt(2, employeeId);
			    int ressult= ps.executeUpdate();
			


				}catch(Exception e) {
					e.printStackTrace();
				}
			finally {
				if(conn!=null) {
					try {
						conn.close();
						System.out.println("Data is updated!!!");
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
			}
			
		}
		public void deleteEmployeeById(int id) {
			Connection conn=buildConnection();
			try {
				Statement st=conn.createStatement();
				String query = "delete FROM employee where employeeId="+id;
				int  result = st.executeUpdate(query);

				}catch(Exception e) {
					e.printStackTrace();
				}
			finally {
				if(conn!=null) {
					try {
						conn.close();
						System.out.println("Data is deleted!!!");
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
			}
		}
		
		
		public void updateSalaryBetweenAge() {
			Connection conn=buildConnection();
			Scanner sc=new Scanner(System.in);
			PreparedStatement ps=null;
			try {
				System.out.println("Enter minimum age to update");
				int Age1=sc.nextInt();
				System.out.println("Enter maximum age to update");
				int Age2=sc.nextInt();
				sc.nextLine();
				
			    
			    
				PreparedStatement pst =conn.prepareStatement("SELECT * FROM employee "
						+ "where employeeAge between ? and ?");
                pst.setInt(1, Age1);
                pst.setInt(2, Age2);
				ResultSet resultSet = pst.executeQuery();
				

				while (resultSet.next()) {
					int employeeId = resultSet.getInt("employeeId");
					int employeeSalary=resultSet.getInt("employeeSalary");
					pst=conn.prepareStatement("update employee set employeeSalary=? where employeeId=?");
					
					pst.setInt(1, employeeSalary+100000);
					pst.setInt(2, employeeId);
					pst.execute();
				}
			      
				}catch(Exception e) {
					e.printStackTrace();
				}
			finally {
				if(conn!=null) {
					try {
						conn.close();
						System.out.println("Data is updated!!!");
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
			}
		}
	}
