<%@page import="java.io.File"%>
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
		String fname = dao.findByNo(no).getFname();
		int re = dao.deleteGoods(no);
		
		if (re == 1) {
			String path = request.getRealPath("upload");
			File file = new File(path+"/"+fname);
			file.delete();
			System.out.println("성공");
		} else {
			System.out.println("살패");
		}
	%>
	<a href="loadGoods.jsp">목록으로</a>
</body>
</html>