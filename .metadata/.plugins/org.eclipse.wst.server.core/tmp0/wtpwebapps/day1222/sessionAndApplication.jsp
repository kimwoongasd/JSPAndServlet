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
		int a = 0;
		int b = 0;
		
		if (session.getAttribute("a") != null) {
			a = (Integer)session.getAttribute("a");
		}
		
		if (session.getAttribute("b") != null) {
			a = (Integer)session.getAttribute("b");
		}
		
		a++;
		b++;
		// 
		session.setAttribute("a", a);
		application.setAttribute("b", b);
	%>
	a : <%=a %>
	b : <%=b %>
</body>
</html>