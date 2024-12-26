<%@page import="com.jsp.spring_mvc.studentdb.entity.Student"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>


	<%
  List<Student> st=(List) request.getAttribute("studentList");
  %>

	<table border="">
		<tr>
			<td>StudentId</td>
			<td>StudentName</td>
			<td>StudentEmail</td>
			<td>StudentAge</td>
			<td>StudentCourse</td>
		</tr>
        
       
          
          
       <% for(Student s: st){ %>
		<tr>
			<td><%= s.getStudentAge() %></td>
			<td><%= s.getStudentName() %></td>
			<td><%= s.getStudentEmail() %></td>
			<td><%= s.getStudentAge() %></td>
			<td><%= s.getStudentCourse() %></td>
		</tr>
		<% 
		}
		%>
          



	</table>

</body>
</html>