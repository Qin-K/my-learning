package qinkai.dao;

import java.sql.SQLException;
import java.util.List;

import qinkai.domain.Student;

/**
 * 针对学生表的数据访问
 */
public interface StudentDao {
	
	int PAGE_SIZE = 5; // 表示一页显示的个数
	/**
	 * 查询所有学生
	 * @return
	 * @throws SQLException
	 */
	List<Student> findAll() throws SQLException;
	
	/**
	 * 根据id查询学生
	 * @return
	 * @throws SQLException
	 */
	Student findStudentById(int sid) throws SQLException;
	
	/**
	 * 根据当前页查询学生
	 * @param currentPage
	 * @return
	 * @throws SQLException
	 */
	List<Student> findStudentByPage(int currentPage) throws SQLException;
	
	/**
	 * 模糊查询
	 * @param sname
	 * @param gender
	 * @return List
	 */
	List<Student> searchStudent(String sname, String gender) throws SQLException;
	
	/**
	 * 获取学生总数
	 * @return
	 * @throws SQLException
	 */
	int getTotalSize() throws SQLException;
	
	/**
	 * 添加学生
	 * @param student
	 * @throws SQLException
	 */
	void insert(Student student) throws SQLException;
	
	/**
	 * 删除学生
	 * @param sid
	 * @throws SQLException
	 */
	void delete(int sid) throws SQLException;
	
	/**
	 * 更新学生
	 */
	void update(Student student) throws SQLException;
}
