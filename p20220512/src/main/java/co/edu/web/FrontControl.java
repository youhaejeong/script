package co.edu.web;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/FrontControl")
public class FrontControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
	HashMap<String, Control> list = null;
	String charset = null;

	public FrontControl() {
		super();
	}

	public void init(ServletConfig config) throws ServletException {
		charset = config.getInitParameter("charset");
		list = new HashMap<String, Control>();
	

	}

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding(charset);

		String url = request.getRequestURI();
		String context = request.getContextPath();
		String path = url.substring(context.length());

		Control exeCon = list.get(path);
		exeCon.execute(request, response);

	}

}
