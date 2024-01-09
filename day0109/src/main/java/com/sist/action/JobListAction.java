package com.sist.action;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.sist.dao.EmpDAO;

public class JobListAction implements SistAction {

	@Override
	public String pro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		EmpDAO dao = EmpDAO.getInstance();
		ArrayList<String> j_list = dao.getJobList();
		Gson gson = new Gson();
		request.setAttribute("j_list", gson.toJson(j_list));
		return "jobList.jsp";
	}

}
