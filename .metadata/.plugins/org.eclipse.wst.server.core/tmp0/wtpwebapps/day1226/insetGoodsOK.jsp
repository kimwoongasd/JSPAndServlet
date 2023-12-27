<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<%
	request.setCharacterEncoding("UTF-8");
%>
<jsp:useBean id="g" class="com.sist.vo.GoodsVO"/>
<jsp:useBean id="dao" class="com.sist.dao.GoodsDAO"/>
<jsp:setProperty property="*" name="g"/>
<body>
	<%
		int re = dao.insertGoods(g);
		if (re == 1) {
			out.print("성공");
		} else {
			out.print("실패");
		}
	%>
<a href="insertGoods.jsp">상품등록</a>
<a href="loadGoods.jsp">상품목록</a>
</body>
</html>