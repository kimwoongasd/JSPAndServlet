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
	String id = request.getParameter("id");
	String pwd = request.getParameter("pwd");
	// 세션에 상태유지를 위한 값을 설정
	session.setAttribute("idKey", id);
	
	// 세션의 유효기간을 초단위로 설정
	// 기본값은 30분
	session.setMaxInactiveInterval(60 * 5);
%>
	<h1>Session Exam</h1>
	<form method="post" action="session1_1.jsp">
		1. 가장 좋아하는 계절은?<br>
		<input type="radio" value="봄" name="seasion">봄
		<input type="radio" value="여름" name="seasion">여름
		<input type="radio" value="가을" name="seasion">가을
		<input type="radio" value="겨울" name="seasion">겨울
		<br>
		2. 가장 좋아하는 과일은?<br>
		<input type="radio" value="watermelon" name="fruit">수박
		<input type="radio" value="melon" name="fruit">멜론
		<input type="radio" value="apple" name="fruit">사과
		<input type="radio" value="orange" name="fruit">오렌지
		<br>
		<input type="submit" value="결과보기">
	</form>
</body>
</html>