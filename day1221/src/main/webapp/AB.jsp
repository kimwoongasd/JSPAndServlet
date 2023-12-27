<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>Forward Tag Exam2</h1>
<%
	String name = request.getParameter("name");
	String bloodType = request.getParameter("bloodType");
%>
<b><%=name %></b>님의 혈액형은<br>
<b><%=bloodType %></b>형이고
정확한 판단력을 가진 합리주의자입니다
</body>
</html>