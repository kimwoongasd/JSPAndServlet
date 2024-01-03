package com.sist.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sist.dao.MemberDAO;
import com.sist.vo.MemberVO;

public class LoginOKAction implements SistAction {

	@Override
	public String pro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String viewPage = "loginOK.jsp";
		String id = request.getParameter("id");
		System.out.println(id);
		String pwd = request.getParameter("pwd");
		MemberDAO dao = new MemberDAO();
		MemberVO m = dao.login(id, pwd);
		request.setAttribute("m", m);
		if (!pwd.equals(m.getPwd()) || !id.equals(m.getId())) {
			viewPage = "error.jsp";
			request.setAttribute("msg", "로그인실패");
		} else {
			HttpSession session = request.getSession();
			session.setAttribute("loginID", m.getId());
		}
		
		return viewPage;
	}
}
