<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<jsp:include page="header.jsp"></jsp:include>

<jsp:useBean id="product" class="com.malay.model.EProduct" scope="session">
</jsp:useBean>

<jsp:setProperty property="id" name="product" value="${80*5}"/>
<jsp:setProperty property="name" name="product" value="Apple laptop"/>
<jsp:setProperty property="price" name="product" value="150000"/>
<jsp:setProperty property="description" name="product" value="this is the apple laptop "/>

<%--  forward to another page using jsp action --%>
<%-- <jsp:forward page="forward-page.jsp"></jsp:forward>--%>

<a href="show-bean.jsp">Click here to view bean details</a>
<jsp:include page="footer.jsp"></jsp:include>

</body>
</html>