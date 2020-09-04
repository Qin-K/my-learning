package qinkai.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import qinkai.dao.StuDao;
import qinkai.domain.Student;
import qinkai.util.JDBCUtil;

public class StuDaoImpl implements StuDao {

	@Override
	public List<Student> findAll() {
		List<Student> list = new ArrayList<>();
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = JDBCUtil.getConn();
			String sql = "select * from t_stu";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			
			// 遍历rs创建Student对象并添加到list中
			while (rs.next()) {
				int id = rs.getInt("id");
				int age = rs.getInt("age");
				String name = rs.getString("name");
				String gender = rs.getString("gender");
				String address = rs.getString("address");
				
				Student stu = new Student(id, name, age, gender, address);
				list.add(stu);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.release(conn, ps, rs);
		}
		return list;
	}

}
