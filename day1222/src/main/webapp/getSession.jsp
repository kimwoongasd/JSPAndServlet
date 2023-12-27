<%@page import="com.sist.vo.BookVO"%>
<%@page import="java.util.ArrayList"%>
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
		String title = (String)session.getAttribute("title");
		int year = (Integer)session.getAttribute("year");
		int[] data = (int[])session.getAttribute("data");
		DeptVO d = (DeptVO)session.getAttribute("d");
		ArrayList<BookVO> list = (ArrayList<BookVO>)session.getAttribute("list");
	%>
	
	<h2>세션 변수에 저장한 값 확인하기</h2>
	<hr>
	title : <%=title %><br>
	year : <%=year %><br>
	<hr>
	<h2>부서</h2>
	data : 
	<% for (int i = 0; i < data.length; i++) {
		out.print(data[i] + " ");
	} %><br>
	부서번호 : <%=d.getDno() %><br>
	부서명 : <%=d.getDname() %><br>
	부서위치 : <%=d.getDloc() %><br>
	<hr>
	<h2>도서목록</h2>
	<%
		for (BookVO vo : list) {
			%>
				도서번호 : <%=vo.getBookid() %> <br>
				도서명 : <%=vo.getBookname() %> <br>
				가격 : <%=vo.getPrice() %> <br>
				출판사 : <%=vo.getPublisher() %> <br>
			<%
		}
	%>
</body>
</html>