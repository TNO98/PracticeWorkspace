<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1>Show product bean value</h1>
	
	<jsp:useBean id="product" class="com.malay.model.EProduct" scope="session"></jsp:useBean>

	Product ID : <jsp:getProperty property="id" name="product"/><br>
	Product Name : <jsp:getProperty property="name" name="product"/><br>
	Product Price : <jsp:getProperty property="price" name="product"/><br>
	Product Description : <jsp:getProperty property="description" name="product"/><br>
</body>
</html>