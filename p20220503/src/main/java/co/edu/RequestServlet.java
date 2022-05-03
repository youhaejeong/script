package co.edu;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/RequestServlet.do")
public class RequestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public RequestServlet() {
		super();

	}

//최초한번만 실행 
	public void init(ServletConfig config) throws ServletException {
		System.out.println("init() call");

	}

	// 요청정보를 처리하는것이 리퀘스트 응답정보처리는 리스폰즈
	// 최초요청이 아닐경우에는 서비스를 실행
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("service() call");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=utf-8");
//content타입이 html이면 태그사용가능
		PrintWriter out = response.getWriter();// 출력스트림.
		out.print("<h1>고길동</h1>"); // 어떤 처리정보가잇고 처리하는지 하는것
		out.print("<h3>네트워크정보</h3>");
		out.print("Request Schema-> " + request.getScheme() + "<br>");
		out.print("Server Name-> " + request.getServerName() + "<br>");
		out.print("Server Address-> " + request.getLocalAddr() + "<br>");
		out.print("Client Address-> " + request.getRemoteAddr() + "<br>");
		out.print("Client Port-> " + request.getRemotePort());
		out.print("<hr>");
		out.print("<h3>요청프로토콜</h3>");
		out.print("Request URI-> " + request.getRequestURI() + "<br>"); //
		out.print("Request URL-> " + request.getRequestURL() + "<br>"); // 전체정보를 가저옴
		out.print("Context path-> " + request.getContextPath() + "<br>");
		out.print("Request protocol-> " + request.getProtocol() + "<br>");
		out.print("Server path-> " + request.getServletPath() + "<br>");
		out.print("<hr>");
		//주로많이쓰고 많이 헷갈려함 꼭 잘 기억할것 
		out.print("queryString-> " + request.getQueryString() + "<br>");
		out.print("id: " + request.getParameter("id") + "<br>");
		out.print("passwd: " + request.getParameter("passwd") + "<br>");
		out.print("name: " + request.getParameter("username") + "<br>");
		out.print("<hr>");
		out.close();

	}
}
