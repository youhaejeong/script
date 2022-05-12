package co.edu.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.edu.vo.loginVO;

public class loginControl implements Control {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("로그인 ");

		String email = request.getParameter("email");
		String pw = request.getParameter("pw");

		if (email.isEmpty() || pw.isBlank()) {
			request.setAttribute("error", "모든항목을 입력하세요");
			request.getRequestDispatcher("view/login.do").forward(request, response);
			return;
		}
	
	}

}
