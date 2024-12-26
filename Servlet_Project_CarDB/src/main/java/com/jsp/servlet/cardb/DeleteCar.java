package com.jsp.servlet.cardb;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class DeleteCar extends GenericServlet {

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		int carId=Integer.parseInt(req.getParameter("carId"));

		Connection conn=null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/servlet_cardb","root","msingh12345@");

			Statement st=conn.createStatement();
			String query = "delete FROM car where carId="+carId;
			int  result = st.executeUpdate(query);
			PrintWriter out=res.getWriter();
			if(result>0) {
				out.print("<h1>" +result +" data successfully deleted!!</h1>");
			}
			else {
				out.print("Data is not deleted");
			}
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
}
