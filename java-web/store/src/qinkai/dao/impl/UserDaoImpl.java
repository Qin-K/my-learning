package qinkai.dao.impl;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import qinkai.dao.UserDao;
import qinkai.domain.User;
import qinkai.util.JDBCUtils;

public class UserDaoImpl implements UserDao {

	@Override
	public void userRegist(User user) throws Exception {
		String sql = "INSERT INTO USER VALUES(?,?,?,?,?,?,?,?,?,?)";
		QueryRunner qr = new QueryRunner(JDBCUtils.getDataSource());
		Object[] params = {user.getUid(),user.getUsername(), user.getPassword(),user.getName(),user.getEmail(), user.getTelephone(),user.getBirthday(), user.getSex(),user.getState(),user.getCode()};
		qr.update(sql, params);
	}

	@Override
	public int userLogin(String username, String password) throws Exception {
		String sql = "select * from user where username=? and password=?";
		QueryRunner qr = new QueryRunner(JDBCUtils.getDataSource());
		User user = qr.query(sql, new BeanHandler<User>(User.class), username, password);
		if (user == null) {
			return 0;
		} else if (user.getState() == 0) {
			return 1;
		} else {
			return 2;
		}
	}

}
