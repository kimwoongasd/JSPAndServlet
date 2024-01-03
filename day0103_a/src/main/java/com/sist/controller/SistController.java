package com.sist.controller;

import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Properties;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sist.action.SistAction;

/**
 * Servlet implementation class SistController
 */
@WebServlet("*.do")
public class SistController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	HashMap<String, SistAction> map;
      
	
	
    @Override
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		//super.init(config);
    	map = new HashMap<String, SistAction>();
    	String path = config.getServletContext().getRealPath("WEB-INF");
    	try {
			FileReader fr = new FileReader(path+"/sist.properties");
			Properties prop = new Properties();
			prop.load(fr);
			
			Iterator iter = prop.keySet().iterator();
			while (iter.hasNext()) {
				String key = (String)iter.next();
				String clsName = prop.getProperty(key);
				Object obj = Class.forName(clsName).newInstance();
				SistAction action = (SistAction)obj;
				map.put(key, action);
			}
			fr.close();
		} catch (Exception e) {
			System.out.println("파일 읽기 " +  e.getMessage());
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
		// 현재 콘텍스트 이름을 가져온다
		String uri = request.getRequestURI();
		String cmd = uri.substring(uri.indexOf("/", 1) + 1);
		SistAction action = map.get(cmd);
		String viewPage = action.pro(request, response);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
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
