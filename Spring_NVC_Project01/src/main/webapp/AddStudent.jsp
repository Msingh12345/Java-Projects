<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>Enter Student Details</h1>
<form action="add-student" method="post">
<input type="number" placeholder="Enter StudentId " name="studentId">
<input type="text" placeholder="Enter StudentName " name="studentName">
<input type="text" placeholder="Enter StudentEmail " name="studentEmail">
<input type="number" placeholder="Enter StudentAge " name="studentAge">
<input type="text" placeholder="Enter StudentCourse" name="studentCourse">
<input type="submit" value="add">
</form>
</body>
</html>