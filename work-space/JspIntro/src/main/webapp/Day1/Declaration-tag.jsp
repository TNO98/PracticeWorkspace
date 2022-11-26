<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<%!
	int score= 21;
	
	private int showScore(){
		return score;
	}

%>
the score is : <%= score %>
the score is : <%= showScore() %>

</body>
</html>