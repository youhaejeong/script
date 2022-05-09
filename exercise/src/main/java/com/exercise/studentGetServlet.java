package com.exercise;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/studentGetServlet")
public class studentGetServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public studentGetServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		
		String cmd=request.getParameter("cmd");
		
		if(cmd != null && cmd.equals("search")) {
			String id =request.getParameter("user_id");
		}
		
		
		
		
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
