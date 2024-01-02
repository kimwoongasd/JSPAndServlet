package com.sist.controller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.sist.action.DeleteBoardAction;
import com.sist.action.DeleteBoardOKAction;
import com.sist.action.DetailBoardAction;
import com.sist.action.InsertBoardAction;
import com.sist.action.InsertBoardOkAction;
import com.sist.action.ListBoardAction;
import com.sist.action.SistAction;
import com.sist.action.UpdateBoardAction;
import com.sist.action.UpdateBoardOKAction;
import com.sist.dao.BoardDAO;
import com.sist.vo.BoardVO;

import oracle.security.o3logon.a;

/**
 * Servlet implementation class sistController
 */
//@WebServlet("/sistController")
public class SistController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	HashMap<String, SistAction> map;
      
	// 서블릿이 
    @Override
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		//super.init(config);
    	
    	// map에 서비스명을 key로하고 일처리 담당 객체를 value로 하여 데이터 등록
    	map = new HashMap<String, SistAction>();
    	map.put("listBoard.do", new ListBoardAction());
    	map.put("insertBoard.do", new InsertBoardAction());
    	map.put("insertBoardOK.do", new InsertBoardOkAction());
    	map.put("detailBoard.do", new DetailBoardAction());
    	map.put("updateBoard.do", new UpdateBoardAction());
    	map.put("updateBoardOK.do", new UpdateBoardOKAction());
    	map.put("deleteBoard.do", new DeleteBoardAction());
    	map.put("deleteBoardOK.do", new DeleteBoardOKAction());
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
		// 사용자의 요청 서비스명을 파락하기 위하여 uri를 알아온다
		String uri = request.getRequestURI();
		
		// uri로 부터 서비스명을 추출하여 cmd에 저장
		String cmd = uri.substring(uri.lastIndexOf("/") + 1);
		
		// 이동할 jsp파일명을 저장하기 위한 변수
		String viewPage = "";
		
		// DAO객체를 생성
		BoardDAO dao = new BoardDAO();
		
		// map으로부터 일처리 담당 객체를 뽑아온다
		SistAction action;
		action = map.get(cmd);
		
		// 일처리 담당객체를 통해서 일처리를 위한 메소드를 호출
		viewPage = action.pro(request, response);
		
		// jsp로 이동시키기 위한 디스패처 객체를 생성
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// 사용자가 get방식으로 요청하거나 post방식으로 효청하거나
		// 동일한 처리를 위하여 post방식으로 요청하면 goGet을 호출
		// 모든 일처리는 doGet에 작성
		doGet(request, response);
	}

}
