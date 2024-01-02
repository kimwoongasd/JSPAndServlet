<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>도서 목록</h2>
	<hr>
	<table border="1" width="80%">
		<tr>
			<th width="10%">도서번호</th>
			<th width="50%">도서명</th>
		</tr>
		<c:forEach var="b" items="${list }">
			<tr>
				<td>${b.bookid }</td>
				<td><a href="detailBook.do?bookid=${b.bookid }">${b.bookname }</a></td>
			</tr>
		</c:forEach>
	</table>
	<a href="insertBook.do">추가하기</a>
</body>
</html>