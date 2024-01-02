<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="https://code.jquery.com/jquery-3.7.1.min.js"></script>
<script type="text/javascript">
	$(function() {
		$("#delete").click(function() {
			var bookid = $(this).attr("bookid");
			var res = confirm("삭제하시겠습니까?");
			
			if(res) {
				location.href = "deleteBookOK.do?bookid="+bookid;
			}
		})
	});
</script>
</head>
<body>
<h2>도서 상세</h2>
<hr>
도서번호 : ${b.bookid }<br>
도서명 : ${b.bookname }<br>0
가격 : ${b.price }<br>
출판사 : ${b.publisher }<br>
이미지 : <img src="./data/${b.fname }"/>
<br>
<a href="listBook.do">도서목록</a>
<a href="updateBook.do?bookid=${b.bookid }">수정하기</a>
<a href="#" id="delete" bookid="${b.bookid }">삭제하기</a>
</body>
</html>