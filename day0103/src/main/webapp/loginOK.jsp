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
로그인 성공 <br>
아이디 : ${m.id }<br>
이름 : ${m.name }<br>
이메일 : ${m.email }<br>
전화번호 : ${m.phone }<br>
<a href="member/listBoard.do">목록으로</a>
</body>
</html>