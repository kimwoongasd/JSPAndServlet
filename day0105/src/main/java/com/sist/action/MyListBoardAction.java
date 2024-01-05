package com.sist.action;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sist.dao.BoardDAO;
import com.sist.vo.BoardVO;

public class MyListBoardAction implements SistAction {

	@Override
	public String pro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String viewPage = "myListBoard.jsp";
		int pageNum = 1;
		
		BoardDAO dao = new BoardDAO();
		if (request.getParameter("pageNUM") != null) {
			pageNum = Integer.parseInt(request.getParameter("pageNUM"));
			
		}
		HttpSession session = request.getSession();
		String id = (String) session.getAttribute("userID");
		
		ArrayList<BoardVO> list = dao.getMy(id);
		request.setAttribute("list", list);
		request.setAttribute("totalPage", dao.totalPage);
		session.setAttribute("nowPage", pageNum);
		
		return viewPage;
	}

}
