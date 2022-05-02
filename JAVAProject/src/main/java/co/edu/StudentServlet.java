package co.edu;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//IOC : Introversion Of Control //제어를 개발자가 하는 것이 아님 
public class StudentServlet extends HttpServlet {
	@Override
	public void init(ServletConfig config) throws ServletException {
		System.out.println("init() 호출"); // 한번만 실행됨
	}
//특별한 기능을 만들고 싶을떈 아래처럼 서비스를 이용해서 만들고 이클립스가 제공해주는것을 사용해도 됨 
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		resp.setContentType("text/html;charset=UTF-8");

		String method = req.getMethod();
		PrintWriter out = resp.getWriter();// 출력스트림 생성 응답페이지에 결과를 보여주는 메소드
		out.print("<h3>Student Sample page.</h3>");
		if (method.equals("GET")) {
			out.println("<h3>Get방식 호출</h3>");
			doGet(req, resp);
		} else if (method.equals("POST")) {
			out.println("<h3>Post방식 호출</h3>");

		}
		out.println("<a href='../index.jsp?user_name=kildong&user_id=go'>index page</a>");
	}

	@Override
	public void destroy() {
		System.out.println("destroy() 호출");
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		super.doGet(req, resp);
	}
}
