<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
#op, #s_pub {
	display: none;
}
</style>
</style>
<script type="text/javascript"
	src="https://code.jquery.com/jquery-3.7.1.min.js"></script>
<script type="text/javascript">
	$(function(){
		$("#cname").change(function(){
			var v = $(this).val();
			if(v == "price"){
				$("#op").css("display","inline-block");
			}else{
				$("#op").css("display","none");
			}
			
			if (v == "publisher") {
				$("#s_pub").css("display","inline-block");
				$("#search").css("display","none");
				$("#s_pub").attr("name", "search");
				$("#search").attr("name", null);
			} else {
				$("#s_pub").css("display","none");
				$("#search").css("display","inline-block");
				$("#s_pub").attr("name", null);
				$("#search").attr("name", "search");
			}
			
		});
		
		$.ajax({
			url: "listPublisher.do",
			success: function(result) {
				$.each(result, function() {
					var option = $("<option></option>").html(this);
					$(option).attr("value", this);
					$("#s_pub").append(option);
				});
			}
		});	
	
	});
</script>
</head>
<body>
	<form action="listBook.do" method="post">
		<select name="cname" id="cname">
			<option value="bookname">도서명</option>
			<option value="publisher">출판사</option>
			<option value="price" name="price">가격</option>
		</select> <select id="op" name="op">
			<option value=">">></option>
			<option value=">=">>=</option>
			<option value="<"><</option>
			<option value="<="><=</option>
			<option value="=">=</option>
		</select>
		 <input type="search" name="search" id="search"> 
		<select id="s_pub">
		</select>
		 <input type="submit" value="검색">
	</form>
	<h2>도서목록</h2>
	<hr>
	<table>
		<tr>
			<c:if test="${search != null }">
				<th><a
					href="listBook.do?sort=bookid&cname=${cname }&search=${search }&op=${op }">도서번호</a></th>
				<th><a
					href="listBook.do?sort=bookname&cname=${cname }&search=${search }&op=${op }">도서명</a></th>
				<th><a
					href="listBook.do?sort=price&cname=${cname }&search=${search }&op=${op }">가격</a></th>
				<th><a
					href="listBook.do?sort=publisher&cname=${cname }&search=${search }&op=${op }">출판사</a></th>
			</c:if>
			<c:if test="${search == null }">
				<th><a href="listBook.do?sort=bookid">도서번호</a></th>
				<th><a href="listBook.do?sort=bookname">도서명</a></th>
				<th><a href="listBook.do?sort=price">가격</a></th>
				<th><a href="listBook.do?sort=publisher">출판사</a></th>
			</c:if>
		</tr>
		<c:forEach var="b" items="${list }">
			<tr>
				<td>${b.bookid }</td>
				<td>${b.bookname }</td>
				<td>${b.price }</td>
				<td>${b.publisher }</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>