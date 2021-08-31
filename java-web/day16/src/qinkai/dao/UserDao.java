package qinkai.dao;

import java.sql.SQLException;

public interface UserDao {
	boolean checkName(String name) throws SQLException;
}
