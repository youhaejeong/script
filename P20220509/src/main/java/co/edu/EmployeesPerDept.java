package co.edu;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

@WebServlet("/EmployeesPerDept")
public class EmployeesPerDept extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public EmployeesPerDept() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/json; charset=utf-8");
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost", "hr", "hr");
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
		
		
		System.out.println("연결성공");

		String sql = "select e.department_id,  d.department_name, count(1) as cnt from employees e, departments d\r\n"
				+ "where e.department_id = d.department_id\r\n" + "group by e.department_id, d.department_name";

		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			Map<String, Integer> map = new HashMap<String, Integer>();
			while (rs.next()) {
				// department_name, cnt
				map.put(rs.getString("department_name"), rs.getInt("cnt"));
			}
			Gson gson = new GsonBuilder().create();
			response.getWriter().print(gson.toJson(map)); // tiJson 생성
			return;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		// {"err":"에러발생"}
		response.getWriter().print("{\"err\":\"에러발생\"}");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
