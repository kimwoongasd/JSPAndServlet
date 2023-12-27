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
		request.setCharacterEncoding("UTF-8");
		int no = Integer.parseInt(request.getParameter("no"));
		String name = request.getParameter("name");
		int price = Integer.parseInt(request.getParameter("price"));
		int qty = Integer.parseInt(request.getParameter("qty"));
		String fname = request.getParameter("fname");
	%>
	
	상품번호 : <%=no %><br>
	상품이름 : <%=name %><br>
	가격 : <%=price %><br>
	수량 : <%=qty %><br>
	상품파일 : <%=fname %>
</body>
</html>