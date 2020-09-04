package jdbc.dao;

/**
 * 定义数据库操作方法
 */
public interface UserDao {
	/*
	 * 查询所有
	 */
	void findAll();
	void login(String username, String password);
}
