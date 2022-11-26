<%@page import="com.malay.dao.EmployeeDao"%>
<%@page import="com.malay.entity.Employee"%>
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
	String firstName= request.getParameter("firstname");
	String lastName= request.getParameter("lastname");
	String salary= request.getParameter("salary");
	String department= request.getParameter("department");

	Employee e = new Employee();
	e.setFirstName(firstName);
	e.setLastName(lastName);
	e.setSalary(Double.valueOf(salary));
	e.setDepartment(department);
	
	EmployeeDao.addEmployee(e);
	out.println("Data inserted successfully");
	response.setHeader("Refresh", "5;url=index.jsp"); 
	
%>

</body>
</html>