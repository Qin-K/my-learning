package qinkai.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import qinkai.dao.UserDao;
import qinkai.util.JDBCUtil;

public class UserDaoImpl implements UserDao {

	@Override
	public boolean login(String userName, String password) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = JDBCUtil.getConn();
			String sql = "select * from t_user where username=? and password=? ";
			ps = conn.prepareStatement(sql);
			ps.setString(1, userName);
			ps.setString(2, password);
			
			rs = ps.executeQuery();
			
			// 返回是否找到
			return rs.next();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.release(conn, ps, rs);
		}
		return false;
	}

}
