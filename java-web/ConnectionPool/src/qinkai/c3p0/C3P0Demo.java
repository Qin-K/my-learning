package qinkai.c3p0;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.junit.Test;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import qinkai.util.JDBCUtil;

public class C3P0Demo {
	
	@Test
	public void testC3P0() {
		
		ComboPooledDataSource dataSource = new ComboPooledDataSource();
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			dataSource.setDriverClass("com.mysql.jdbc.Driver");
			dataSource.setJdbcUrl("jdbc:mysql://localhost/bank");
			dataSource.setUser("root");
			dataSource.setPassword("admin");
			conn = dataSource.getConnection();
			String sql = "insert into account values(null, ?, ?)";
			ps = conn.prepareStatement(sql);
			ps.setString(1, "admin123");
			ps.setInt(2, 1000);
			
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.release(conn, ps);
		}
	}
}
