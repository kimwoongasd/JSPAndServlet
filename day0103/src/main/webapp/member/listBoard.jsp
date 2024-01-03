<%@page import="com.sist.vo.BoardVO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <!-- 반복문이나 if문 대신 사용하는 태그 주소
    	http://java.sun.com/jsp/jstl/cor
    	
    	prefix="c"는 접두어를 c로 사용하겠다는 의미
     -->
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<a href="insertBoard.do"></a>
	<h2>게시물 목록</h2>
	<hr>
	<table border="1" width="80%">
		<tr>
			<th width="10%">글번호</th>
			<th width="80%">글제목</th>
			<th width="10%">작성자</th>
		</tr>
		<%-- items는 배열이름
			변수값을 사용해야한다
			변수이용시 ${값}
			
			var는 items에서 받아와 담을 변수
			
			${값}을 표현언어라고 한다
		 --%>
		<c:forEach var="b" items="${list }">
			<tr>
				<td>${b.no }</td>
				<td><a href="detailBoard.do?no=${b.no }">${b.title }</a></td>
				<td>${b.writer }</td>
			</tr>
		</c:forEach>
	</table>
	<a href="insertBoard.do">추가하기</a>
	<a href="../signUp.do">회원가입</a>
	<a href="../login.do">로그인</a>
</body>
</html>