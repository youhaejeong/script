package co.edu;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/session.do")
public class SessionServ extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public SessionServ() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String id = request.getParameter("id");
		String pw = request.getParameter("pass"); // 클라이언트가 접속을 하고나면 해당되는 유니크한값을가지고 세션을 서버가 만들어줌

		HttpSession session = null;

		session = request.getSession();
		
		session.setAttribute("id", id);
		session.setAttribute("pass", pw);
		
		response.sendRedirect("session2.jsp");

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
