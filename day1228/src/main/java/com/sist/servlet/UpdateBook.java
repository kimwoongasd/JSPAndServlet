package com.sist.servlet;

import java.io.File;
import java.io.IOException;

import javax.print.attribute.standard.Sides;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.sist.dao.BookDAO;
import com.sist.vo.BookVO;

/**
 * Servlet implementation class UpdateBook
 */
@WebServlet("/updateBook.do")
public class UpdateBook extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateBook() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		int bookid = Integer.parseInt(request.getParameter("bookid"));
		BookDAO dao = new BookDAO();
		BookVO b = dao.detail(bookid);
		
		request.setAttribute("b", b);
		RequestDispatcher dispatcher = request.getRequestDispatcher("updateBook.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String path = request.getRealPath("images");
		MultipartRequest multi = new MultipartRequest(
				request,
				path,
				1024*1024*5,
				"UTF-8",
				new DefaultFileRenamePolicy());
		
		int bookid = Integer.parseInt(multi.getParameter("bookid"));
		String bookname = multi.getParameter("bookname");
		int price = Integer.parseInt(multi.getParameter("price"));
		String publisher = multi.getParameter("publisher");
		String oldFname = multi.getParameter("fname");
		String fname =  multi.getOriginalFileName("upload");
		
		BookDAO dao = new BookDAO();
		BookVO b = new BookVO(bookid, bookname, price, publisher, oldFname);
		if (fname != null) {
			b.setFname(fname);
		}
		
		int re = dao.update(b);
		String viewPage = "updateBookOK.jsp";
		
		if (re == 1) {
			if (fname != null) {
				File file = new File(path+"/"+oldFname);
				file.delete();
			}
		} else {
			viewPage = "error.jsp";
			request.setAttribute("msg", "수정 실패");
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
		dispatcher.forward(request, response);
	}

}
