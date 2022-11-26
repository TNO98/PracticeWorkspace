<%@page import="com.malay.dao.EmployeeDao"%>
<%@page import="com.malay.entity.Employee"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" errorPage="error.jsp"%>
    
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<%
	List<Employee> employees =EmployeeDao.listEmployees();
	request.setAttribute("emplist", employees);
	
	%>
	
	<table style ="border: 1px solid black;">
		<tr>
			<th>Employee ID </th>
			<th>First Name</th>
			<th>Last Name </th>
			<th>Salary</th>
			<th>Department </th>				
		</tr>
		
		<core:forEach items="${emplist}" var="emp">
		
			<tr>
				<td>${emp.getId()} </td>
				<td>${emp.getFirstName()} </td>
				<td>${emp.getLastName()} </td>
				<td>${emp.getSalary()} </td>
				<td>${emp.getDepartment()} </td>
			
			</tr>
		
		</core:forEach>
	
	
	</table>

</body>
</html>