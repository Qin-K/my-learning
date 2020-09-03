package jdbc.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import jdbc.dao.UserDao;
import jdbc.util.JDBCUtil;

public class UserDaoImpl implements UserDao{

	@Override
	public void findAll() {
		// 1.建立连接
		Connection conn = JDBCUtil.getConn();
		
		// 2.创建statement
		Statement st = null;
		
		ResultSet rs = null;
		try {
			st = conn.createStatement();
			String sql = "select * from t_user";
			rs = st.executeQuery(sql);
			
			while (rs.next()) {
				String username = rs.getString("username");
				String password = rs.getString("password");
				System.out.println(username + " " + password);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.release(conn, st, rs);
		}

	}
	
/*	@Override
	public void login(String username, String password) {
		// 1.建立连接
		Connection conn = JDBCUtil.getConn();
		
		// 2.创建statement
		Statement st = null;
		
		ResultSet rs = null;
		try {
			st = conn.createStatement();
			// SELECT * FROM t_user WHERE username='zhangsan' AND PASSWORD='10086'
			String sql = "SELECT * FROM t_user WHERE username='" + username + "' AND PASSWORD='"+ password +"'";
			rs = st.executeQuery(sql);
			
			if (rs.next()) {
				System.out.println("登录成功！");
			} else {
				System.out.println("登录失败！");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.release(conn, st, rs);
		}

	}*/
	
	@Override
	public void login(String username, String password) {
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;
		try {
			//1. 获取连接对象
			conn = JDBCUtil.getConn();
			//2. 创建statement对象 
			String sql = "select * from t_user where username=? and password=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setString(1, username);
			ps.setString(2, password);
			
			rs = ps.executeQuery();
			
			if(rs.next()){
				System.out.println("登录成功");
			}else{
				System.out.println("登录失败");
			}
			
		} catch (Exception e) { 
			e.printStackTrace();
		} finally {
			JDBCUtil.release(conn, st, rs);
		}
	}

}
