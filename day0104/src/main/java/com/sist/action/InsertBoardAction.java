package com.sist.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class InsertBoardAction implements SistAction {

	@Override
	public String pro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int no = 0;
		
		if (request.getParameter("no") != null) {
			no = Integer.parseInt(request.getParameter("no"));
		}
		request.setAttribute("no", no);
		return "insertBoard.jsp";
	}

}
