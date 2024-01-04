package com.sist.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sist.dao.MemberDAO;

public class LoginOKAction implements SistAction {

	@Override
	public String pro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String viewPage = "loginOK.jsp";
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		MemberDAO dao = new MemberDAO();
		
		if (dao.login(id, pwd)) {
			HttpSession session = request.getSession();
			session.setAttribute("userID", id);
		} else {
			viewPage = "error.jsp";
			request.setAttribute("msg", "로그인 실패");
		}
		
		return viewPage;
	}

}
