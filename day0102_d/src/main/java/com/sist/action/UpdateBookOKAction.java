package com.sist.action;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.sist.dao.BookDAO;
import com.sist.vo.BookVO;

public class UpdateBookOKAction implements SistAction {

	@Override
	public String pro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path = request.getRealPath("data");
		String viewPage = "updateBookOK.jsp";
		
		MultipartRequest multi = new MultipartRequest(
				request,
				path,
				1024*1024*5,
				"UTF-8",
				new DefaultFileRenamePolicy());
		
		
		BookDAO dao = new BookDAO();
		BookVO b = new BookVO();
		b.setBookid(Integer.parseInt(multi.getParameter("bookid")));
		b.setBookname(multi.getParameter("bookname"));
		b.setPrice(Integer.parseInt(multi.getParameter("price")));
		String oldFname = multi.getParameter("fname");
		String fname = multi.getOriginalFileName("upload");
		b.setFname(fname);
		if (fname == null) {
			b.setFname(oldFname);
		}
		
		int re = dao.update(b);
		
		if (re == 1) {
			if (fname != null) {
				File file = new File(path+"/"+oldFname);
				file.delete();
			}
		} else {
			viewPage = "error.jsp";
			request.setAttribute("msg", "수정실패");
		}
		
		return viewPage;
	}

}
