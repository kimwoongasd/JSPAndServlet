<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- <form method="post" action="insertBookOK.jsp"> --> 
<form method="post" action="insertBookOKBeen.jsp">
	도서번호 : <input type="text" name="bookid"><br>
	도서이름 : <input type="text" name="bookname"><br>
	도서가격 : <input type="text" name="price"><br>
	출판사 : <input type="text" name="publisher"><br>
	<input type="submit" value="등록">
	<input type="reset" value="취소">
</form>
</body>
</html>