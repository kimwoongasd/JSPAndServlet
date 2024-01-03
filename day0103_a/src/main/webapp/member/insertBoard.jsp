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
	<form action="insertBoardOK.do" method="post" enctype="multipart/form-data">
		<table>
		<tr>
			<td>제목</td>
			<td><input type="text" name="title" required="required"></td>
		</tr>
		<tr>
			<td>글쓴이</td>
			<td><input type="text" name="writer" required="required" value="${userID }" disabled="disabled"></td>
		</tr>
		<tr>
			<td>비밀번호</td>
			<td><input type="password" name="pwd" required="required"></td>
		</tr>
		<tr>
			<td>내용</td>
			<td><textarea rows="10" cols="60" name="content" required="required"></textarea></td>
		</tr>
		<tr>
			<td>파일선택</td>
			<td><input type="file" name="upload" required="required"></td>
		</tr>
		<tr>
			<td>
				<input type="submit" value="등록">
				<input type="reset" value="다시입력">
			</td>	
		</tr>		
		</table>
	</form>
	
</body>
</html>