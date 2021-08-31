package qinkai.dao;

import qinkai.domain.User;

public interface UserDao {

	void userRegist(User user) throws Exception;

	int userLogin(String username, String password)throws Exception;

}
