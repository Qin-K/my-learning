package qinkai.service.impl;

import java.sql.SQLException;
import java.util.List;

import qinkai.dao.StudentDao;
import qinkai.dao.impl.StudentDaoImpl;
import qinkai.domain.PageBean;
import qinkai.domain.Student;
import qinkai.service.StudentService;

public class StudentServiceImpl implements StudentService {

	public List<Student> findAll() throws SQLException {
		StudentDao dao = new StudentDaoImpl();
		return dao.findAll();
	}

	@Override
	public void insert(Student student) throws SQLException {
		StudentDao dao = new StudentDaoImpl();
		dao.insert(student);		
	}

	@Override
	public void delete(int sid) throws SQLException {
		StudentDao dao = new StudentDaoImpl();
		dao.delete(sid);		
	}

	@Override
	public Student findStudentById(int sid) throws SQLException {
		StudentDao dao = new StudentDaoImpl();
		return dao.findStudentById(sid);
	}

	@Override
	public List<Student> searchStudent(String sname, String gender) throws SQLException {
		StudentDao dao = new StudentDaoImpl();
		return dao.searchStudent(sname, gender);
	}

	@Override
	public PageBean findStudentByPage(int currentPage) throws SQLException {
		StudentDao dao = new StudentDaoImpl();
		int totalSize = dao.getTotalSize();
		int pageSize = StudentDao.PAGE_SIZE;
		List<Student> list = dao.findStudentByPage(currentPage);
		PageBean<Student> pageBean = new PageBean<Student>();
		int totalPage = totalSize % pageSize == 0 ? totalSize / pageSize : totalSize / pageSize + 1;
		
		pageBean.setCurrentPage(currentPage);
		pageBean.setPageSize(pageSize);
		pageBean.setTotalSize(totalSize);
		pageBean.setList(list);
		pageBean.setTotalPage(totalPage);
		
		
		return pageBean;
	}

	@Override
	public void update(Student student) throws SQLException {
		StudentDao dao = new StudentDaoImpl();
		dao.update(student);
	}

}
