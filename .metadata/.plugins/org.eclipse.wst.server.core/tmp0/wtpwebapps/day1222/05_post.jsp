<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Post Servlet 방식</h1>
	<form method="post" action="postServelt">
		id : <input type="text" name="id"><br>
		pwd : <input type="password" name="pwd"><br>
		emial : <input type="email" name="email"><br>
		<input type="submit" value="로그인">
	</form>
</body>
</html>