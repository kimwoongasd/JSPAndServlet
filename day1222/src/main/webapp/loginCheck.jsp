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
		if(session.getAttribute("idKey") == null) {
			response.sendRedirect("login.html");
		}
		
		String id = (String)session.getAttribute("idKey");
	%>
	
	<%=id %>님 로그인 하였습니다
	<a href="Logout.jsp">로그아웃</a>
	<hr>
</body>
</html>