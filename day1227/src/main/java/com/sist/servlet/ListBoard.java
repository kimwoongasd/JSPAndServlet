package com.sist.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sist.dao.BoardDAO;
import com.sist.vo.BoardVO;

/**
 * Servlet implementation class ListBoard
 */
@WebServlet("/ListBoard")
public class ListBoard extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListBoard() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 이 서블릿은 html을 직접 응답하지않고 게시물 목록을 조회하여 request객체에 상태 유지
		// 한다음 결과를 보여줄 jsp로 이동
		BoardDAO dao = new BoardDAO();
		ArrayList<BoardVO> list = dao.listBoard();
		request.setAttribute("list", list);
		
		// 결과를 보여주기 위한 jsp로 이동시키 위한 dispatcher 객체를 생성
		// 생성시에 매개변수로 이동할 jsp이름을 써준다
		RequestDispatcher dispatcher = request.getRequestDispatcher("listBoard.jsp");
		
		
		// dispatcher 객체를 통하여 jsp로 이동
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
