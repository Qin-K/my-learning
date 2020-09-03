package qinkai.test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.junit.Test;

import qinkai.util.JDBCUtil;
import qinkai.util.MyDataSource;

public class TestPool {
	@Test
	public void testPool() {
		MyDataSource dataSource = new MyDataSource();
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = dataSource.getConnection();
			String sql = "insert into account values(null,'wangwu', 100)";
			ps = conn.prepareStatement(sql);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.release(conn, ps);
			// dataSource.addBack(conn);
		}
	}
}
