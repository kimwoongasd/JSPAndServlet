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
<%
	BookVO b = new BookVO();
	b.setBookid(10);
	b.setBookname("재미있는 jsp");
	b.setPrice(30000);
	b.setPublisher("쌍용");
%>

도서번호 : <%=b.getBookid() %><br>
도서이름 : <%=b.getBookname() %><br>
도서가격 : <%=b.getPrice() %><br>
출판사 : <%=b.getPublisher() %><br>
</body>
</html>