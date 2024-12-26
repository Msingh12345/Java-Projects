package com.jsp.servlet.cardb;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class AddCar extends GenericServlet {

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		int carId =Integer.parseInt(req.getParameter("carId"));
		String carModel=req.getParameter("carModel");
		String carBrand=req.getParameter("carBrand");
		int carPrice =Integer.parseInt(req.getParameter("carPrice"));

		//JDBC LOGIC
		Connection conn=null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/servlet_cardb","root","msingh12345@");
			PreparedStatement pst=conn.prepareStatement("insert into car values(?,?,?,?)");
			pst.setInt(1, carId);
			pst.setString(2,carModel);
			pst.setString(3,carBrand);
			pst.setInt(4, carPrice);
			int rowsInserted=pst.executeUpdate();
			PrintWriter out=res.getWriter();
			if(rowsInserted>0) {
				out.print("<h1>"+rowsInserted+"data successfully inserted!!</h1>");
			}
			else {
				out.print("not inserted");
			}

		}
		catch(ClassNotFoundException |SQLException e){
			e.printStackTrace();

		}
		finally {
			if(conn!=null) {
				try {
					conn.close();
				}catch(SQLException e) {
					e.printStackTrace();
				}
			}
		}

	}
}
