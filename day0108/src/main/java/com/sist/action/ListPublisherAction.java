package com.sist.action;

import java.io.IOException;
import java.util.HashSet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.sist.dao.BookDAO;

public class ListPublisherAction implements SistAction {

	@Override
	public String pro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BookDAO dao = BookDAO.getInstance();
		HashSet<String> set = dao.listPublisher();

		Gson gson = new Gson();
		String result = gson.toJson(set);
		request.setAttribute("result", result);
		return "listPublusher.jsp";
	}

}
