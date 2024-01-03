package com.sist.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.sist.dao.MemberDAO;
import com.sist.vo.MemberVO;

public class SignUpOKAction implements SistAction {

	@Override
	public String pro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String viewPage = "signUpOK.jsp";
		
		MemberVO s = new MemberVO();
		s.setId(request.getParameter("id"));
		System.out.println(request.getParameter("id"));
		s.setPwd(request.getParameter("pwd"));
		s.setName(request.getParameter("name"));
		s.setEmail(request.getParameter("email"));
		s.setPhone(request.getParameter("phone"));
		
		MemberDAO dao = new MemberDAO();
		int re = dao.insertSignUp(s);
		
		if (re != 1) {
			viewPage = "error.jsp";
			request.setAttribute("msg", "회원가입 실패");
		}
		
		return viewPage;
	}

}
