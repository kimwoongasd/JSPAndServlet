package com.sist.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sist.dao.BoardDAO;
import com.sist.vo.BoardVO;

/**
 * Servlet implementation class insertBoardkOK2
 */
@WebServlet("/insertBoardkOK2")
public class insertBoardkOK2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public insertBoardkOK2() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 세션이 필요할때 request.get서센을 통해서 세션 가져올 수 있다
		
		request.setCharacterEncoding("UTF-8");
		BoardVO b = new BoardVO();
		b.setTitle(request.getParameter("title"));
		b.setWriter(request.getParameter("writer"));
		b.setContent(request.getParameter("content"));
		b.setIp(request.getRemoteAddr());
		
		BoardDAO dao = new BoardDAO();
		int re = dao.insertBoard(b);
		
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		String str = "게시물 등록완료";
		
		if (re != 1) {
			str = "게시물 등록 실패";
		}
		
		out.print(str);
		out.close();
		
	}

}
