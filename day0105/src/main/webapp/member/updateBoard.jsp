<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>게시물 등록</h2>
	<form action="UpdateBoard" method="post" enctype="multipart/form-data">
		<table>
		<tr>
			<td>제목</td>
			<input type="hidden" name="no" value="${b.no }"/>
			<td><input type="text" name="title" required="required" value="${b.title }"></td>
		</tr>
		<tr>
			<td>작성자</td>
			<td>${b.writer }</td>
		</tr>
		<tr>
			<td>글암호</td>
			<td><input type="text" name="pwd" required="required"></td>
		</tr>
		<tr>
			<td>글내용</td>
				<td><textarea rows="10" cols="60" 
				name="content" required="required">${b.content }</textarea> </td>
		</tr>
		<tr>
			<td>파일선택</td>
			<td>
				${b.fname }<br>
				<input type="hidden" name="fname" value="${b.fname }">
				<input type="file" name="upload">
				</td>
		</tr>
		<tr>
			<td>
				<input type="submit" value="수정">
				<input type="reset" value="다시입력">
			</td>	
		</tr>		
		</table>
	</form>
	
</body>
</html>