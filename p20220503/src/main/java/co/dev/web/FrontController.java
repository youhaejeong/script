package co.dev.web;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//모든 컨트롤을 요청하는 작업 
public class FrontController extends HttpServlet {
	HashMap<String, Control> list = null;
	String charset = null;

	@Override
	public void init(ServletConfig config) throws ServletException {
		charset = config.getInitParameter("charset");
		list = new HashMap<String, Control>();
		list.put("/memberInsert.do", new MemberInsertControl());
		list.put("/memberUpdate.do", new MemberUpdateControl());
		list.put("/memberList.do", new MemberListControl());
		list.put("/memberSearch.do", new MemberSearchControl());
		list.put("/memberDelete.do", new MemberDeleteControl());

		// 이 아래부터는 json관련 등록
		list.put("memberListJson.do", new MemberListJson());
	}

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding(charset);

		String url = req.getRequestURI(); // /p20220503/memberInsert.do
		String context = req.getContextPath();
		String path = url.substring(context.length()); //

		Control exeCon = list.get(path);
		exeCon.execute(req, resp);

		// System.out.println("요청서블릿: " + list.get(path));
	}

}
