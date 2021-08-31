package qinkai.test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.Test;

import qinkai.jdbc.util.JDBCUtil;

public class TestDemo {
	@Test
	public void testTransaction() {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = JDBCUtil.getConn();
			// 取消自动提交
			conn.setAutoCommit(false);
			
			// 账户1扣钱
			String sql = "update account set money = money - ? where id = ?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, 100);
			ps.setInt(2, 1);
			ps.executeUpdate();
			
			int a = 10 / 0;
			// 账户2增钱
			ps.setInt(1, -100);
			ps.setInt(2, 2);
			ps.executeUpdate();
			
			// 提交事务
			conn.commit();

		} catch (SQLException e) {
			try {
				// 回滚事务
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		} finally {
			JDBCUtil.release(conn, ps, rs);
		}
	}
}
