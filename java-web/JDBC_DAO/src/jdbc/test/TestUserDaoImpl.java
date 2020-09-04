package jdbc.test;

import org.junit.Test;

import jdbc.dao.UserDao;
import jdbc.dao.impl.UserDaoImpl;

public class TestUserDaoImpl {

	@Test
	public void testFindAll() {
		UserDao dao = new UserDaoImpl();
		dao.findAll();
		
		dao.login("zhangsan", "10086");
	}
	
	@Test
	public void testLogin() {
		UserDao dao = new UserDaoImpl();
		
		dao.login("zhangsan", "10086");
	}
}