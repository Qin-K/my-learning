package qinkai.util;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.SQLFeatureNotSupportedException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import javax.sql.DataSource;

/**
 * 这是一个连接池
 * @author Qin-Kai
 *
 */
public class MyDataSource implements DataSource {
	List<Connection> list = new ArrayList<Connection>();
	
	public MyDataSource() {
		// 一次性创建多个连接并添加到list(连接池中)
		for (int i = 0; i < 10; i++) {
			Connection conn = JDBCUtil.getConn();
			list.add(conn);
		}
	}
	@Override
	public Connection getConnection() throws SQLException {
		// 判断连接池是否为空，为空则要扩容
		if (list.isEmpty()) {
			for (int i = 0; i < 3; i++) {
				Connection conn = JDBCUtil.getConn();
				list.add(conn);
			}
		}
		// 获取conn，从list中移除返回，防止拿到相同的Connection
		Connection conn = list.remove(0);
		Connection connection = new ConnectionWrap(conn, list);
		return connection;
	}
	
	@Override
	public Connection getConnection(String username, String password) throws SQLException {
		return null;
	}
	/**
	 * 归还连接
	 * @param conn
	 */
	public void addBack(Connection conn) {
		list.add(conn);
	}
	
	@Override
	public Logger getParentLogger() throws SQLFeatureNotSupportedException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T> T unwrap(Class<T> iface) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isWrapperFor(Class<?> iface) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public PrintWriter getLogWriter() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setLogWriter(PrintWriter out) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setLoginTimeout(int seconds) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int getLoginTimeout() throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}
	
}
