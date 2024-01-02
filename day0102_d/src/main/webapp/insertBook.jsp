<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="insertBookOK.do" method="post" enctype="multipart/form-data">
	도서번호 : <input type="text" name="bookid"><br>
	도서명 : <input type="text" name="bookname"><br>
	가격 : <input type="text" name="price"><br>
	출판사 : <input type="text" name="publisher"><br>
	이미지 : <input type="file" name="fname"><br>
	<input type="submit" value="등록">
	<input type="reset" value="재등록">
</form>
</body>
</html>