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
		request.setCharacterEncoding("UTF-8");
	%>
	<h1> Forward Tag Exam1</h1>
	Forward Tag의 포워딩 되기 전의 페이지
	<jsp:forward page="forwardTag1_2.jsp"/>
</body>
</html>