package co.edu.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/jsonData.do")
public class JsonData extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/plain; charset=UTF-8");
		//[{"name":"ȫ�浿","age":20},{"name":"Ȳ��ȫ","age":25},{"name":"�����","age":30}]
		
		resp.getWriter().print("[{\"name\":\"ȫ�浿\",\"age\":20},{\"name\":\"Ȳ��ȫ\",\"age\":25},{\"name\":\"�����\",\"age\":30}]");
	}

}
