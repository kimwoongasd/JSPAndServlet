package com.sist;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sist.dao.DeptDAO;
import com.sist.vo.DeptVO;

@WebServlet("/listDept")
public class listDept extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public listDept() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		DeptDAO dao = new DeptDAO();
		ArrayList<DeptVO> list = dao.deptList();
		
		String data = "";
		
		data += "<html>"
				+"<head>"
				+"<title>"
				+"서블릿 연습"
				+"</title>"
				+"</head>"
				+"<body>"
				+"<h1>"
				+"부서목록"
				+"</h1>"
				+"<table border='"+1+"'>"
				+"<thead>"
				+"<tr>"
				+"<td>"
				+"부서번호"
				+"</td>"
				+"<td>"
				+"부서명"
				+"</td>"
				+"<td>"
				+"부서위치"
				+"</td>"
				+"</tr>"
				+"<tbody>";
		
		for (DeptVO vo : list) {
			data += "<tr>"
					+"<td>"
					+vo.getDno()
					+"</td>"
					+"<td>"
					+vo.getDname()
					+"</td>"
					+"<td>"
					+vo.getDloc()
					+"</td>"
					+"</tr>";
		}
		data += "</tbody>"
				+"</thead>"
				+"</table>"
				+"</body>"
				+"</html>";
		
		out.print(data);
		out.close();
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
