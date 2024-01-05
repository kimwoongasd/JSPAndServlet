<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
<title>Insert title here</title>
</head>
<body>
<a href="insertBoard.do"></a>
	<div class="container mt-3">
	<h2>게시물 목록</h2>
	<hr>
	<table border="1" width="80%" class="table table-hover">
		<tr>
			<th width="10%">글번호</th>
			<th width="80%">글제목</th>
			<th width="10%">작성자</th>
		</tr>
		<c:forEach var="b" items="${list }">
			<tr>
				<td>${b.no }</td>
				<td>
				<c:if test="${b.b_level >0 }">
						<c:forEach var="i" begin="1" end="${b.b_level }">
						&nbsp;&nbsp;
						</c:forEach>
						<img src="re.png" width="50">
					</c:if>
				<a href="detailBoard.do?no=${b.no}">${b.title }</a>
				</td>
				<td>${b.writer }</td>
			</tr>
		</c:forEach>
	</table>
	</div>
	<c:forEach var="i" begin="1" end="${totalPage }">
		<a href="listBoard.do?pageNUM=${i }">${i }&nbsp;</a>
	</c:forEach>
	<a href="insertBoard.do">추가하기</a>
</body>
</html>