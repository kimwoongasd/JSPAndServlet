<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    errorPage="myError.jsp"
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		int one = 1;
		int zero = 0;
	%>
	<h1>Directive Exam</h1>
	one과 zero의 사칙연산
	one + zero = <%=one+zero %><br>
	one - zero = <%=one-zero %><br>
	one * zero = <%=one*zero %><br>
	one / zero = <%=one/zero %>
</body>
</html>