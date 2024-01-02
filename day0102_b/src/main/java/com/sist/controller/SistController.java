package com.sist.controller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.sist.dao.BoardDAO;
import com.sist.vo.BoardVO;

/**
 * Servlet implementation class sistController
 */
//@WebServlet("/sistController")
public class SistController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SistController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uri = request.getRequestURI();
		String cmd = uri.substring(uri.lastIndexOf("/") + 1);
		String viewPage = "";
		
		BoardDAO dao = new BoardDAO();
		if (cmd.equals("listBoard.do")) {
			viewPage = "listBoard.jsp";
			request.setAttribute("list", dao.findAll());
		} else if (cmd.equals("insertBoard.do")) {
			viewPage = "insertBoard.jsp";
		} else if (cmd.equals("insertBoardOK.do")) {
			viewPage = "insertBoardOK.jsp";
			String path = request.getRealPath("data");
			MultipartRequest multi = new MultipartRequest(
					request,
					path,
					1024*1024*5,
					"UTF-8",
					new DefaultFileRenamePolicy());
			
			BoardVO b = new BoardVO();
			b.setNo(dao.getNextNo());
			b.setTitle(multi.getParameter("title"));
			b.setWriter(multi.getParameter("writer"));
			b.setPwd(multi.getParameter("pwd"));
			b.setContent(multi.getParameter("content"));
			b.setFname(multi.getOriginalFileName("upload"));
			b.setIp(request.getRemoteAddr());
			
			int re = dao.insert(b);
			if (re != 1) {
				viewPage = "error.jsp";
				request.setAttribute("msg", "게시물 등록 실패");
			}
		} else if (cmd.equals("updateBoard.do")) {
			int no = Integer.parseInt(request.getParameter("no"));
			BoardVO b = dao.detail(no);
			request.setAttribute("b", b);
			viewPage = "updateBoard.jsp";
		} else if (cmd.equals("updateBoardOK.do")) {
			String path = request.getRealPath("data");
			MultipartRequest multi = new MultipartRequest(
					request,
					path,
					1024*1024*5,
					"UTF-8",
					new DefaultFileRenamePolicy());
			
			BoardVO b = new BoardVO();
			b.setNo(Integer.parseInt(multi.getParameter("no")));
			b.setTitle(multi.getParameter("title"));
			b.setWriter(multi.getParameter("writer"));
			b.setPwd(multi.getParameter("pwd"));
			b.setContent(multi.getParameter("content"));
			String oldFname = multi.getParameter("fname");
			String fname = multi.getOriginalFileName("upload");
			b.setFname(fname);
			if (fname == null) {
				b.setFname(oldFname);
			}
			b.setIp(request.getRemoteAddr());
			viewPage = "updateBoardOK.jsp";
			int re = dao.update(b);
			if (re == 1) {
				if (fname != null) {
					File file = new File(path+"/"+oldFname);
					file.delete();
				}
			} else {
				viewPage = "error.jsp";
				request.setAttribute("msg", "수정 실패");
			}
		} else if (cmd.equals("deleteBoard.do")) {
			int no = Integer.parseInt(request.getParameter("no"));
			request.setAttribute("no", no);
			viewPage = "deleteBoard.jsp";
			
		} else if (cmd.equals("deleteBoardOK.do")) {
			viewPage = "deleteBoardOK.jsp";
			String path = request.getRealPath("data");
			int no = Integer.parseInt(request.getParameter("no"));
			String pwd = request.getParameter("pwd");
			String fname = dao.detail(no).getFname();
			int re = dao.delete(no, pwd);
			if (re == 1) {
				File file = new File(path+"/"+fname);
				file.delete();
			} else {
				viewPage = "error.jsp";
				request.setAttribute("msg", "삭제실패");
			}
		} else if (cmd.equals("detailBoard.do")) {
			int no = Integer.parseInt(request.getParameter("no"));
			BoardVO b = dao.detail(no);
			request.setAttribute("b", b);
			viewPage = "detailBoard.jsp";
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
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
