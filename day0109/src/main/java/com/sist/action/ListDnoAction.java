package com.sist.action;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.sist.dao.EmpDAO;

public class ListDnoAction implements SistAction {

	@Override
	public String pro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		EmpDAO dao = EmpDAO.getInstance();
		ArrayList<String> d_list = dao.getDnoList();
		Gson gson = new Gson();
		request.setAttribute("d_list", gson.toJson(d_list));
		
		return "listDno.jsp";
	}

}
