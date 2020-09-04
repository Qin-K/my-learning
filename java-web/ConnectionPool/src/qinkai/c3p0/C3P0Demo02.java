package qinkai.c3p0;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.junit.Test;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import qinkai.util.JDBCUtil;

public class C3P0Demo02 {
	@Test
	public void testC3P0() {
		ComboPooledDataSource dataSource = new ComboPooledDataSource();
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = dataSource.getConnection();
			String sql = "insert into account values(null, ?, ?)";
			ps = conn.prepareStatement(sql);
			ps.setString(1, "aaa");
			ps.setInt(2, 100);
			
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.release(conn, ps);
		}
	}
}
