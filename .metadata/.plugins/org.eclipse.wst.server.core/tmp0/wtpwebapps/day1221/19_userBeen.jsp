<%@page import="com.sist.dao.BookDAO"%>
<%@page import="com.sist.vo.BookVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<jsp:useBean id="b" class="com.sist.vo.BookVO"/>
<jsp:useBean id="dao" class="com.sist.dao.BookDAO"/>

<jsp:setProperty property="bookid" name="b" value="100"/>
<jsp:setProperty property="bookname" name="b" value="재미있는 jsp"/>
<jsp:setProperty property="price" name="b" value="10000"/>
<jsp:setProperty property="publisher" name="b" value="쌍용"/>

<jsp:getProperty property="bookid" name="b"/><br>
<jsp:getProperty property="bookname" name="b"/><br>
<jsp:getProperty property="price" name="b"/><br>
<jsp:getProperty property="publisher" name="b"/><br>

<%
	dao.insertBook(b);
%>
</body>
</html>