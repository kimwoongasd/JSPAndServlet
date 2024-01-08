package com.sist.action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sist.dao.BookDAO;
import com.sist.vo.BookVO;

public class ListBookAction implements SistAction {

	@Override
	public String pro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String search = null;
		String cname = null;
		String op = null;
		String order = null;
		
		HttpSession session = request.getSession();
		
		// 순서가 중요
		// 검색어가 있을경우 세션에 검색어가 있어도 덮어쓴다
		if (session.getAttribute("search") !=null) {
			search = (String) session.getAttribute("search");
			cname = (String) session.getAttribute("cname");
			op = (String) session.getAttribute("op");
		}
		
		if (request.getParameter("search") != null) {
			search = request.getParameter("search");
			cname = request.getParameter("cname");
			op = request.getParameter("op");
			
			
			session.setAttribute("search", search);
			session.setAttribute("cname", cname);
			session.setAttribute("op", op);
		}
		
		if (request.getParameter("sort") != null) {
			order = request.getParameter("sort");
		}
		
		BookDAO dao = BookDAO.getInstance();
		ArrayList<BookVO> list = dao.findAll(cname, search, op, order);
		request.setAttribute("list", list);
		return "listBook.jsp";
	}

}
