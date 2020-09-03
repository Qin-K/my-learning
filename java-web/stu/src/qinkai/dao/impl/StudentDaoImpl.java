package qinkai.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import qinkai.dao.StudentDao;
import qinkai.domain.Student;
import qinkai.util.JDBCUtil;
import qinkai.util.TextUtil;

public class StudentDaoImpl implements StudentDao {
	/**
	 * 查询所有
	 * @return List<Student>
	 */
	@Override
	public List<Student> findAll() throws SQLException {
		QueryRunner runner = new QueryRunner(JDBCUtil.getDataSource());
		String sql = "select * from stu";
		return runner.query(sql, new BeanListHandler<Student>(Student.class));
	}
	
	/**
	 * 添加学生
	 * @param 要添加的学生对象
	 */
	@Override
	public void insert(Student student) throws SQLException {
		QueryRunner runner = new QueryRunner(JDBCUtil.getDataSource());
		runner.update("insert into stu values(null, ?, ?, ?, ?, ?, ?)",
				student.getSname(),
				student.getGender(),
				student.getPhone(),
				student.getBirthday(),
				student.getHobby(),
				student.getInfo()
				);
	}

	@Override
	public void delete(int sid) throws SQLException {
		QueryRunner runner = new QueryRunner(JDBCUtil.getDataSource());
		runner.update("delete from stu where sid=?", sid);
	}

	@Override
	public Student findStudentById(int sid) throws SQLException {
		QueryRunner runner = new QueryRunner(JDBCUtil.getDataSource());
		return runner.query("select * from stu where sid=?", new BeanHandler<Student>(Student.class), sid);
	}

	@Override
	public List<Student> searchStudent(String sname, String gender) throws SQLException {
		QueryRunner runner = new QueryRunner(JDBCUtil.getDataSource());
		// 默认sql查询所有
		String sql = "select * from stu where 1=1"; 
		List<String> list = new ArrayList<String>();
		if (!TextUtil.isEmpty(sname)) {
			sql = sql + " and sname like ?";
			list.add("%" + sname + "%");
		}
		if (!TextUtil.isEmpty(gender)) {
			sql = sql + " and gender = ?";
			list.add(gender);
		}
		return runner.query(sql, new BeanListHandler<Student>(Student.class), list.toArray());
	}

	@Override
	public List<Student> findStudentByPage(int currentPage) throws SQLException {
		QueryRunner runner = new QueryRunner(JDBCUtil.getDataSource());
		return runner.query("select * from stu limit ? offset ? ", new BeanListHandler<Student>(Student.class),
				StudentDao.PAGE_SIZE, (currentPage - 1) * StudentDao.PAGE_SIZE);
	}

	@Override
	public int getTotalSize() throws SQLException {
		QueryRunner runner = new QueryRunner(JDBCUtil.getDataSource());
		Long result = (Long) runner.query("select count(*) from stu", new ScalarHandler());
		return result.intValue() ;
	}

	@Override
	public void update(Student student) throws SQLException {
		QueryRunner runner = new QueryRunner(JDBCUtil.getDataSource());
		runner.update("update stu set sname=?, gender=?, phone=?, birthday=?, hobby=?, info=? where sid=?",
				student.getSname(),
				student.getGender(),
				student.getPhone(),
				student.getBirthday(),
				student.getHobby(),
				student.getInfo(),
				student.getSid()
				);
	}
	
}
