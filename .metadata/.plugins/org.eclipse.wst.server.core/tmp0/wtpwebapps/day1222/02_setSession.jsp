<%@page import="com.sist.vo.BookVO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.sist.dao.BookDAO"%>
<%@page import="com.sist.vo.DeptVO"%>
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
		String title = "hello session";
		int year = 2024;
		int[] data = {10, 20, 30};
		DeptVO d = new DeptVO(10, "개발1팀", "판교");
		
		BookDAO dao = new BookDAO();
		ArrayList<BookVO> list = dao.listBook();
		
		
		session.setAttribute("title", title);
		session.setAttribute("year", year);
		session.setAttribute("data", data);
		session.setAttribute("d", d);
		session.setAttribute("list", list);
	%>
	
	세션변수에 값은 저장하였다
	<hr>
	<a href="getSession.jsp">세션변수 값 확인하러 가기</a>
</body>
</html>