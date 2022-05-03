package co.edu;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/request1.do")
public class Request1 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Request1() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String id = request.getParameter("id");
		String name = request.getParameter("name");

		StudentDAO dao = new StudentDAO();
		Student result = dao.searchStudent(id);
		request.setAttribute("result", result);

		request.setAttribute("id", id);
		request.setAttribute("name", name);

		// response.jsp로 받아서 반환 정보들을 넘겨주겠음
		request.getRequestDispatcher("response.jsp").forward(request, response); // 리퀘스트값을 리스폰즈의 매개값으로 사용
//		response.sendRedirect("response.jsp"); 응답페이지를 보여줄뿐 파라메터를 가져올수 없음  //리퀘스트의 값을 공유할 방법이 없음 

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
