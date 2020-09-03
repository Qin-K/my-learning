package qinkai.service;

import qinkai.dao.UserDao;
import qinkai.dao.impl.UserDaoImpl;
import qinkai.domain.User;

public class UserServiceImpl implements UserService {

	@Override
	public void userRegist(User user) throws Exception {
		UserDao userDao = new UserDaoImpl();
		userDao.userRegist(user);
	}

	@Override
	public int userLogin(String username, String password) throws Exception {
		UserDao userDao = new UserDaoImpl();
		return userDao.userLogin(username, password);
	}
	
}
