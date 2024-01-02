package com.sist.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.sist.dao.BookDAO;
import com.sist.vo.BookVO;

public class InsertBookOKAction implements SistAction {

	@Override
	public String pro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String viewPage = "insertBookOK.jsp";
		String path = request.getRealPath("data");
		
		BookDAO dao = new BookDAO();
		BookVO b = new BookVO();
		
		MultipartRequest multi = new MultipartRequest(
				request,
				path,
				1024*1024*5,
				"UTF-8",
				new DefaultFileRenamePolicy());
		
		b.setBookid(Integer.parseInt(multi.getParameter("bookid")));
		b.setBookname(multi.getParameter("bookname"));
		b.setPrice(Integer.parseInt(multi.getParameter("price")));
		b.setPublisher(multi.getParameter("publisher"));
		b.setFname(multi.getOriginalFileName("fname"));
		
		int re = dao.insert(b);
		
		if (re != 1) {
			viewPage = "error.jsp";
			request.setAttribute("msg", "등록 실패");
		}
		
		return viewPage;
	}

}
