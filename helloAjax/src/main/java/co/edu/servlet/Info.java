package co.edu.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Info extends HttpServlet {

	// httpservlet�� ���Ѵ�� ����
	// helloAjax�� �ҼӵǼ� ����Ǿ���
	// Info ������ ��û ->Init() -> service() -> Destory ()
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html; charset=UTF-8");
		
		PrintWriter out=resp.getWriter();
		
		out.print("<h3>���� ������</h3>");
		out.print("<h3>�ȳ��ϼ���</h3>");
		out.print("<a href=\"../index.html\">index</a>");
		//  \��빮�� =>���ڱ׷��� ����ϰڽ��ϴ�. <a href="../index.html">index</a>
	}

}
