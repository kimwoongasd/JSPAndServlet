<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:if test="${userID ==null}">
		<a href="login.do">로그인</a>
	</c:if>
	<c:if test="${userID !=null}">
		<a href="/day0105/logout.do">로그아웃</a>
		<a href="/day0105/member/myListBoard.do">내글보기</a>
	</c:if>
	
	<a href="listBoard.do">목록으로</a>
	
</body>
</html>