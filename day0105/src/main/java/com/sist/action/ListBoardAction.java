package com.sist.action;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import com.sist.dao.BoardDAO;
import com.sist.vo.BoardVO;

public class ListBoardAction implements SistAction {

	@Override
	public String pro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String viewPage = "listBoard.jsp";
		int pageNum = 1;
		BoardDAO dao = new BoardDAO();
		HttpSession session = request.getSession();
		if (request.getParameter("pageNUM") != null) {
			pageNum = Integer.parseInt(request.getParameter("pageNUM"));
			
		}
		
		String writer = null;
		if (request.getParameter("writer") != null) {
			writer = request.getParameter("writer");
		}
		
		if (request.getParameter("writer") != null) {
			writer = request.getParameter("writer");
			if (writer.equals("0")) {
				writer = null;
			}
			session.setAttribute("writer", writer);
		}
		
		ArrayList<BoardVO> list = dao.listBoard(pageNum, writer);
		request.setAttribute("list", list);
		request.setAttribute("totalPage", dao.totalPage);
		session.setAttribute("nowPage", pageNum);

		return viewPage;
	}
}
