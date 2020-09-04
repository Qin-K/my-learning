package qinkai.service;

import qinkai.domain.User;

public interface UserService {

	void userRegist(User user) throws Exception;

	int userLogin(String username, String password)throws Exception;

}
