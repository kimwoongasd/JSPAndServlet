<%@page import="com.sist.vo.GoodsVO"%>
<%@page import="com.sist.dao.GoodsDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function checkDelete(no) {
		re = confirm("삭제하시겠습니까??");
		if(re) {
			location.href = "deleteGoods.jsp?no="+no;
		} else {
			return false;
		}
		
	}
</script>
</head>
<body>
<%
	int no = Integer.parseInt(request.getParameter("no"));
	GoodsDAO dao = new GoodsDAO();
	GoodsVO g = dao.findByNo(no);
%>
상품번호 : <%=g.getNo() %><br>
상품이름 : <%=g.getName() %><br>
가격 : <%=g.getPrice() %><br>
수량 : <%=g.getQty() %><br>
<img src="./upload/<%=g.getFname() %>">
<!-- <a href="deleteGoods.jsp?no=<%=g.getNo() %>">삭제</a> -->
<a href="#" onclick="checkDelete(<%=g.getNo() %>)">삭제</a>
<a  href="updateGoods.jsp?no=<%=g.getNo() %>">수정</a>
</body>
</html>