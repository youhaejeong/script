package co.edu.student;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ajax/addStudentServlet") // 주소 최상단에 보이겠음
public class AddStudentServ extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");

		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html; charset=UTF-8");

		// 인풋의 네임속성의 벨류들이 넘어오는 것
		String studentNo = req.getParameter("sno");
		String studentName = req.getParameter("sname");
		String engScore = req.getParameter("eScore");
		String korScore = req.getParameter("kScore");

//인스턴트를 만들기 위한 생성자
		Student stud = new Student();
		stud.setStudentNo(Integer.parseInt(studentNo));
		stud.setStudentName(studentName);
		stud.setEngScore(Integer.parseInt(engScore));
		stud.setKorScore(Integer.parseInt(korScore));

		// db.insert. 기능
		StudentDAO dao = new StudentDAO();
		boolean success = dao.addStudent(stud);
		if (success) {
			// {"retCode" :
			// "Success","stuNo":studentNo,"stuName":"studentName","engScore":engScore,"korScore":korScore}
			resp.getWriter().print("{\"retCode\" : \"Success\",\"studentNo\":" + studentNo + ",\"studentName\":\""
					+ studentName + "\",\"engScore\":" + engScore + ",\"korScore\":" + korScore + "}");
		} else {
			// {"retCode" : "Fail"}
			resp.getWriter().print("{\"retCode\" : \"Fail\"}");
		}
	}

}
