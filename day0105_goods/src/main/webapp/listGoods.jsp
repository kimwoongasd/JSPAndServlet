<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<meta name="viewport" content="width=device-width, height=device-height, initial-scale=1">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
  
  <style type="text/css">
  	.item{
  		border: 1px solid pink;
  		width: 600px;
  		height: 200px;
  		border-radius: 15px;
  		position: relative;
  		margin:20px; 
  	}
  	
  	.image, .info{
  		float: left;
  		margin: 10px;
  		padding: 20px;
  	}
  	
  </style>
  
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
<div class="container mt-3">
	<form action="listGoods.do" method="post">
		<input type="search" name="search">
		<input type="submit" value="검색">
	</form>
	<h2>상품목록</h2>	

	<c:forEach var="g" items="${list }">
		<div class="item">
			<div class="image">
				<img  src="images/${g.fname }" width="150" height="150">
			</div>
			<div class="info" style="vertical-align: center">
				<p><b>상품번호</b> : ${g.no }			<b>상품이름</b> : ${g.name }</p>
				<p><b>상품가격</b> : ${g.price } 		<b>상품수량</b> : ${g.qty }</p>
			</div>
		</div>
	</c:forEach>
	<c:forEach var="i" begin="1" end="${totalPage }">
		<c:if test="${search == null }">
			<a href="listGoods.do?pageNum=${i }">${i }&nbsp;</a>
		</c:if>
		<c:if test="${search != null }">
			<a href="listGoods.do?pageNum=${i }&search=${search }">${i }&nbsp;</a>
		</c:if>
	</c:forEach>
</div>
</body>