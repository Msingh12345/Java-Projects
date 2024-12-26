package com.jsp.servlet.cardb;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class DisplayCar extends GenericServlet{

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		int carId =Integer.parseInt(req.getParameter("carId"));
		
		Connection conn=null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/servlet_cardb","root","msingh12345@");
			Statement st=conn.createStatement();
			String query = "select * from car";
			ResultSet resultSet = st.executeQuery(query);
			
			PrintWriter out=res.getWriter();
			out.print("<h1>The Available Data!!</h1>");
			
			while (resultSet.next()) {
				carId = resultSet.getInt("carId");
				String carModel = resultSet.getString("carModel");
				String carBrand = resultSet.getString("carBrand");
				String carPrice = resultSet.getString("carPrice");
				
				String str="carId: "+carId+"   carModel: "+carModel+"   carBrand: "+
				carBrand+ "   carPrice: "+
						carPrice;
				
				out.print(str);
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

}
