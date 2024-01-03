package com.sist.controller;

import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
		//super.init(config);
    	
    	// map에 서비스명을 key로하고 일처리 담당 객체를 value로 하여 데이터 등록
    	map = new HashMap<String, SistAction>();
    	try {
    		// 사용자의 요청명과 일처리를 클래스이름을 설정한 설정파일(sist.properties)이 있는
    		// WEB-INF폴더의 실경로
    		// init메소드에는 request가 없어 ServletConfig config를 통해서 실경로를 알 수 있다
			String path = config.getServletContext().getRealPath("WEB-INF");
			
			// sist.properties의 파일의 내용을 메모리로 읽어들이기 위해 객체를 생성
			FileReader fr = new FileReader(path+"/sist.properties");
			
			// sist.properties의 파일의 내용을 key와 value로 분리하기 위해
			// properties 객체를 생성
			Properties prop = new Properties();
			
			// sist.properties파일의 스트림인 fr를
			// Properties 객체인 prop에 담는다
			// 이렇게 하면 key와 value를 분리하게 된다
			prop.load(fr);
			
			// set형태로 key값을 가져온다
//			Set keyList = prop.keySet();
//			System.out.println(keyList);
			
			// set의 데이터 수만큼 반복수행하기 위해서 iterator 사용
			Iterator iter = prop.keySet().iterator();
			while (iter.hasNext()) {
				String key = (String)iter.next();
				// value값 가져오기 = uri에 해당하는 클래스 가져옴
				String clsName = (String)prop.get(key);
				//System.out.println(key + " : " + clsName);
				// newInstance() : 객체를 생성함, object를 반환
				map.put(key, (SistAction)Class.forName(clsName).newInstance());
			}
			
		fr.close();
		} catch (Exception e) {
			System.out.println("파일읽기 실패 : " + e.getMessage());
		}
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
		String cmd = uri.substring(uri.indexOf("/", 1)+1);
		
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
		request.setCharacterEncoding("UTF-8");
		doGet(request, response);
	}

}
