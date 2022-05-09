package co.edu.exercise;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class listDAO {
	Connection conn  = null;
	PreparedStatement psmt= null;
	ResultSet rs = null;
	
	//리스트
	public List<listVO> getList(){
		String sql ="select * from todolist";
		getconnect();
		List<listVO> list = new ArrayList<>();
		try {
			psmt =conn.prepareStatement(sql);
			rs=psmt.executeQuery();
			while(rs.next()) {
				listVO vo = new listVO(rs.getString("title"));
				list.add(vo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			disconnect();
		}
		return list;
	}
	
	//리스트 추가
	public void insertDolist(listVO vo) {
		String sql ="insert into toDoList(title) values(?)";
		getconnect();
		try {
			psmt=conn.prepareStatement(sql);
			psmt.setString(1, vo.getTitle());
			int r = psmt.executeUpdate();
			System.out.println(r+"건 완료");
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			disconnect();
		}
	}
	
	public void deleteDolist(String title) {
		String sql = "delete from toDoList where title=?";
		getconnect();
		
		try {
			psmt=conn.prepareStatement(sql);
			psmt.setString(1, title);
			int r = psmt.executeUpdate();
			System.out.println(r + "건 삭제");
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			disconnect();
		}
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public void getconnect() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost", "hr", "hr");
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void disconnect() {
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if (psmt != null) {
			try {
				psmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
