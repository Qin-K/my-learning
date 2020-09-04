package JDBCDemo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


import java.sql.Connection;


public class JDBCDemo {

	public static void main(String[] args) {
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;
		
		try {
			// 1. 注册驱动
			conn = JDBCUtil.getConn();
			
			// 3.创建statement
			st = conn.createStatement();
			
			// 4.执行查询，得出结果集
			String sql = "select * from t_stu";
			rs = st.executeQuery(sql);
			
			// 5. 遍历查询每一条记录
			while (rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				int age = rs.getInt("age");
				
				System.out.println(id + " " + name + " " + age);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.release(conn, st, rs);
		}
	}

}
	