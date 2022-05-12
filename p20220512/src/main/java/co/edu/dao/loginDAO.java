package co.edu.dao;

import java.sql.SQLException;

import co.edu.vo.loginVO;

public class loginDAO extends DAO {

	// 로그인
	public int login(String email, String pw) {
		loginVO vo = new loginVO();
		conn = getconnect();

		String sql = "select pw from membership where email=?";

		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, email);
			rs = psmt.executeQuery();
			if (rs.next()) {
				if (rs.getString(1).equals(pw)) {
					// 로그인성공
					return 1;
				} else {
					// 로그인실패
					return 0;
				}
			}
			// 아이디없음
			return -1;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		// 오류
		return -2;

	}

}
