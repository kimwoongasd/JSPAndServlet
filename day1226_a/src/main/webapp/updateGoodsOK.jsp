<%@page import="java.io.File"%>
<%@page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
<%@page import="com.oreilly.servlet.MultipartRequest"%>
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
		// multipart/form-data 사용지 request.getParameter 사용 불가능
		// multipart/form-data는 인코딩을 하지 않고 보낸다
		// MultipartRequest를 사용하여 값을 가져온다
		String path = request.getRealPath("upload");
	
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
		String oldFname = multi.getParameter("fname");
		String fname = multi.getOriginalFileName("upload");
		g.setFname(oldFname);
		if (fname == null) {
			out.print("파일 수정 안함");
		} else {
			out.print("파일 수정");
			g.setFname(fname);
		}

		GoodsDAO dao = new GoodsDAO();
		int re = dao.updateGoods(g);
		
		if (re == 1) {
			if (fname != null) {
				File file = new File(path+"/"+oldFname);
				System.out.println(file);
				file.delete();
			}
			out.print("상품수정 성공");
		} else {
			out.print("상품수정 실패");
		}
	%>
	
	<a href="loadGoods.jsp">목록으로</a>
</body>
</html>