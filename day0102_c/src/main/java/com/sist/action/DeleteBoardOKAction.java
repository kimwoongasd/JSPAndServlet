package com.sist.action;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sist.dao.BoardDAO;

public class DeleteBoardOKAction implements SistAction {

	@Override
	public String pro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BoardDAO dao = new BoardDAO();
		String viewPage = "deleteBoardOK.jsp";
		String path = request.getRealPath("data");
		int no = Integer.parseInt(request.getParameter("no"));
		String pwd = request.getParameter("pwd");
		String fname = dao.detail(no).getFname();
		int re = dao.delete(no, pwd);
		if (re == 1) {
			File file = new File(path+"/"+fname);
			file.delete();
		} else {
			viewPage = "error.jsp";
			request.setAttribute("msg", "삭제실패");
		}
		return viewPage;
	}

}
