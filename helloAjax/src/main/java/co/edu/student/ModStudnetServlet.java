package co.edu.student;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ModStudnetServlet
 */
@WebServlet("/ajax/modStudnetServlet")
public class ModStudnetServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ModStudnetServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setCharacterEncoding("utf-8");
		resp.setContentType("text/html; casrset=utf-8");

		String sNo = req.getParameter("a");
		String sName = req.getParameter("b");
		String eng = req.getParameter("c");
		String kor = req.getParameter("d");

		Student std = new Student();
		std.setStudentNo(Integer.parseInt(sNo));
		std.setStudentName(sName);
		std.setEngScore(Integer.parseInt(eng));
		std.setKorScore(Integer.parseInt(kor));

		StudentDAO dao = new StudentDAO();
		boolean OK = dao.modifyStudent(std);

		if (OK) {
			// {"retCode" :"success","studentNo"
			// :sNo,"studentName":"sName","engScore":eng,"korScore":kor}
			resp.getWriter().print("{\"retCode\" :\"OK\",\"studentNo\" :" + sNo + ",\"studentName\":\"" + sName
					+ "\",\"engScore\":" + eng + ",\"korScore\":" + kor + "}");
		} else {
			// {"retCode":"Fail"}
			resp.getWriter().print("{\"retCode\":\"Fail\"}");
		}

	}
}
