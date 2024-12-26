<!-- Directive tag3 -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ include file ="hello.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!--  Declarative tag  -->
	<%!int a = 10;
	String name = "Mahendra";
	String[] names={"tom","jerry","tony"};
	%>

	<!-- Expression tag  -->
	<h2><%=a%></h2>
	<h2><%=name%></h2>
	
	<!-- Scriptlet tag -->
	<% for(String x: names){ %>
	    <h3><%= x %></h3>
	    <%} %>
</body>
</html>