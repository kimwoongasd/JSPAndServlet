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
	// 문자열변수 name을 선언
	String name = "korea";
	int year = 2024;
	String title = "hello";
%>
<!-- html 주석 -->
<%--jsp 주석 소스보기에 노출되지 않는다 --%>
<%=name /*name 변수의 내용을 출력*/ %>
<hr>
<%-- <%=year %>--%>
<!-- <%=title %> -->
<!-- <h2>hello</h2> -->
</body>
</html>