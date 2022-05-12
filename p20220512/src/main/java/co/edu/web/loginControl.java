package co.edu.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/loginControl")
public class loginControl extends HttpServlet implements Control {
	private static final long serialVersionUID = 1L;

	public loginControl() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println("로그인 ");

		String email = request.getParameter("email");
		String pw = request.getParameter("pw");

		if (email.isEmpty() || pw.isBlank()) {
			request.setAttribute("error", "모든항목을 입력하세요");
			request.getRequestDispatcher("view/login.do").forward(request, response);
			return;
		}
		HttpSession login = null;

		login = request.getSession();
		login.setAttribute("email", email);
		login.setAttribute("pw", pw);
		
		
		response.sendRedirect("loginOutput.jsp");

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
