<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>For exam</h1>
1~10까지의 합
<%
 	int i, sum = 0;
	for (i = 1; i <=10; i++){
		if (i < 10) {
			%>
			<%=i %>+
			<%
		} else {
			%>
			<%=i %>=
			<%
		}
		
		sum += i;
	}
%>
<%=sum %>
</body>
</html>