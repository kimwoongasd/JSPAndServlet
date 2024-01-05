package com.sist.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LogoutAction implements SistAction {

	@Override
	public String pro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		HttpSession session = ((HttpServletRequest)request).getSession();
//		session.setAttribute("userID", null);
		
		
		HttpSession session = request.getSession();
		session.invalidate();
		return "login.jsp";
	}

}
