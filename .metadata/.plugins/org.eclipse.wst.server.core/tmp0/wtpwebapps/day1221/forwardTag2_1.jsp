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
		String name = "JSPStudy";
		String bloodType = request.getParameter("bloodType");
	%>
	<h1> Forward Tag Exam2</h1>
	<jsp:forward page='<%=bloodType+".jsp" %>'>
		<jsp:param value="<%=name %>" name="name"/>
	</jsp:forward>
</body>
</html>