package com.sist.controller;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sist.action.DeleteBookOKAction;
import com.sist.action.DeltailBookAction;
import com.sist.action.InsertBookAction;
import com.sist.action.InsertBookOKAction;
import com.sist.action.ListBookAction;
import com.sist.action.SistAction;
import com.sist.action.UpdateBookAction;
import com.sist.action.UpdateBookOKAction;

/**
 * Servlet implementation class SistController
 */
//@WebServlet("/SistController")
public class SistController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	//사용자가 요청할 서비스명과 
		//그에 따른 일처리를 위한 객체를 담기 위한 map을 선언한다.
	HashMap<String, SistAction> map;
	
	
	//서블릿이 맨처음 요청될때 한번만 동작하는 init메소드를 오버라이딩 한다.
    @Override
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		//super.init(config);
    	map = new HashMap<String, SistAction>();
    	map.put("listBook.do", new ListBookAction());
    	map.put("insertBook.do", new InsertBookAction());
    	map.put("insertBookOK.do", new InsertBookOKAction());
    	map.put("detailBook.do", new DeltailBookAction());
    	map.put("deleteBookOK.do", new DeleteBookOKAction());
    	map.put("updateBook.do", new UpdateBookAction());
    	map.put("updateBookOK.do", new UpdateBookOKAction());
	}

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
		
		SistAction action = map.get(cmd);
		String viePage = action.pro(request, response);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(viePage);
		dispatcher.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		doGet(request, response);
	}

}
