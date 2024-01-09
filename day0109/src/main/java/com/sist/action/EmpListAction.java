package com.sist.action;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sist.dao.EmpDAO;
import com.sist.vo.EmpVO;

public class EmpListAction implements SistAction {

	@Override
	public String pro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String keyword = null;
		String cname = null;
		String j_list = null;
		if (request.getParameter("keyword") != null) {
			keyword = request.getParameter("keyword");
			cname= request.getParameter("cname");
			j_list = request.getParameter("j_list");
		};
		String email = request.getParameter("email");
		EmpDAO dao = EmpDAO.getInstance();
		ArrayList<EmpVO> list = dao.findAll(keyword, cname , j_list);
		request.setAttribute("list", list);
		return "empList.jsp";
	}

}
