<%@page import="com.sist.vo.GoodsVO"%>
<%@page import="com.sist.dao.GoodsDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		int no = Integer.parseInt(request.getParameter("no"));
		GoodsDAO dao = new GoodsDAO();
		GoodsVO g = dao.
		dao.updateGoods(g);
	%>
	
	<h2>상품수정</h2>
	<hr>
	<form action="updateGoodsOK.jsp" method="post" enctype="multipart/form-data">
		<table width="80%">
			<tr>
				<td width="20%">상품번호</td>
				<td width="70%">
					<input type="text" name="no" required="required" value="<%= %>">
				</td>
			</tr>
		</table>
	</form>
</body>
</html>