package com.sist.action;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sist.dao.BookDAO;

public class DeleteBookOKAction implements SistAction {

	@Override
	public String pro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path = request.getRealPath("data");
		String viewPage = "deleteBookOK.jsp";
		int bookid = Integer.parseInt(request.getParameter("bookid"));
		
		BookDAO dao = new BookDAO();
		String fname = dao.detail(bookid).getFname();
		int re = dao.delete(bookid);
		
		if (re == 1) {
			if (fname != null) {
				File file = new File(path+"/"+fname);
				file.delete();
			}
		} else {
			viewPage = "error.jsp";
			request.setAttribute("msg", "삭제 실패");
		}
		
		return viewPage;
	}

}
