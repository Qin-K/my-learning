package qinkai.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import com.mchange.v2.c3p0.ComboPooledDataSource;


public class JDBCUtil02 {
	static ComboPooledDataSource dataSource = null;
	static {
		dataSource = new ComboPooledDataSource();
	}
	
	/**
	 * 获取连接对象
	 * @throws SQLException
	 */
	public static Connection getConn() throws SQLException {
		return dataSource.getConnection();
	}
	
	/**
	 * 	释放资源
	 * @param conn
	 * @param st
	 * @param rs
	 */
	public static void release(Connection conn, Statement st, ResultSet rs) {
		closeRs(rs);
		closeSt(st);
		closeConn(conn);
	}
	public static void release(Connection conn, Statement st) {
		closeSt(st);
		closeConn(conn);
	}
	
	private static void closeRs(ResultSet rs) {
		if (rs != null) {
			try {
				rs.close();
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				rs = null;
			}
		}
	}
	
	private static void closeSt(Statement st) {
		if (st != null) {
			try {
				st.close();
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				st = null;
			}
		}
	}
	
	private static void closeConn(Connection conn) {
		if (conn != null) {
			try {
				conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				conn = null;
			}
		}
	}
}
