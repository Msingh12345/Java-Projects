package com.jsp.servlet.calculator;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class AdditionServlet extends GenericServlet {

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		String n1 = req.getParameter("num1");

		int num1=Integer.parseInt(n1);
		int num2=Integer.parseInt(req.getParameter("num2"));
		int sum=num1+num2;
		// To print on the browser
		PrintWriter out = res.getWriter();
		out.print("<h1>The sum of the numbers is:  "+sum+"  !!</h1>");

	}

}
