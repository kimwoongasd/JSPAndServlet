<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="signUpOK.do" method="post" enctype="application/x-www-form-urlencoded">
	아이디 : <input type="text" name="id"><br>
	비밀번호 : <input type="password" name="pwd"><br>
	이름 : <input type="text" name="name"><br>
	이메일 : <input type="email" name="email"><br>
	전화번호 " <input type="text" name="phone"><br>
	<input type="submit" value="등록">
	<input type="reset" value="다시">
</form>
</body>
</html>