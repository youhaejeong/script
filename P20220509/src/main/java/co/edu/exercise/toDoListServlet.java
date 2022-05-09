package co.edu.exercise;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

@WebServlet("/toDoListServlet")
public class toDoListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public toDoListServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	//전체조회
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/json; charset=utf-8");
		
		listDAO dao = new listDAO();
		List<listVO> list = dao.getList();
		
		Gson gson=new GsonBuilder().create();	
		response.getWriter().print(gson.toJson(list));
		}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//입력, 삭제, 선택
		request.setCharacterEncoding("utf-8");
		
		String job =request.getParameter("job");
		
		listDAO dao=new listDAO();
		
		
		if(job.equals("insert")) {
			String title=request.getParameter("title");
			
			listVO vo = new listVO(title);
			dao.insertDolist(vo);
			
		}else if(job.equals("delete")) {
			String title=request.getParameter("title");
			dao.deleteDolist(title);
		}
		
		
	}

}
