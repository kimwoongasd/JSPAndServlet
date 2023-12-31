<%@page import="com.oreilly.servlet.MultipartRequest"%>
<%@page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
<%@page import="com.sist.dao.GoodsDAO"%>
<%@page import="com.sist.vo.GoodsVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<%
	// 파일을 업로드할 실제경로를 알아온다
	String path = request.getRealPath("upload");
	System.out.println(path);

	request.setCharacterEncoding("UTF-8");
	
	MultipartRequest multi 
	= new MultipartRequest(request, 
			path, 
			1024*1024*5, 
			"UTF-8", 
			new DefaultFileRenamePolicy());
	
	GoodsVO g = new GoodsVO();
	g.setNo(Integer.parseInt(multi.getParameter("no")));
	g.setName(multi.getParameter("name"));
	g.setPrice(Integer.parseInt(multi.getParameter("price")));
	g.setQty(Integer.parseInt(multi.getParameter("qty")));
	g.setFname(multi.getOriginalFileName("upload"));
	
	GoodsDAO dao = new GoodsDAO();
	int re = dao.insertGoods(g);
	if(re == 1) {
		out.println("등록");
	} else {
		out.println("실패");
	}	
%>
<body>
<a href="insertGoods.jsp">상품등록</a>
<a href="loadGoods.jsp">상품목록</a>
</body>
</html>