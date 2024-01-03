<%@page import="com.sist.vo.BoardVO"%>
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

<%
	BoardVO b = (BoardVO)request.getAttribute("b");
%>
<h2>게시글 상세</h2>
<hr>
<p>글번호 : ${b.no }</p>
<p>글제목 : ${b.title }</p>
<p>글쓴이 : ${b.writer }</p>
<p>글내용 : <textarea rows="10" cols="20" readonly="readonly">${b.content }</textarea></p>
<p>조회수 : ${b.hit}</p>
<p>작성일 : ${b.regdate }</p>
<p>첨부파일 : ${b.fname }</p>
<hr>
<a href="ListBoard">목록으로</a>
<a href="InsertBoard">글등록</a>
<a href="UpdateBoard?no=${b.no }">글수정</a>
<a href="DeleteBoard?no=${b.no }">삭제</a>
</body>
</html>