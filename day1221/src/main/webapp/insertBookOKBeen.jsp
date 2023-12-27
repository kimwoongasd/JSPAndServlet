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
	%>
	
	<jsp:useBean id="b" class="com.sist.vo.BookVO"/>
	<jsp:useBean id="dao" class="com.sist.dao.BookDAO"/>
	
	<jsp:setProperty property="*" name="b"/>
	<!-- form 태그에 입력한 값을 한꺼번에 been객체 b에 다 담아준다
		property="*"은 모든 속성의 값을 다 담으라는 의미이다
		이렇게 하기 위해서 만족해야하는 조건은 form태그의 이름들이 been의
		속성이름과 일치해야한다
	 -->
	<%
		dao.insertBook(b);
	%>
	OK
</body>
</html>