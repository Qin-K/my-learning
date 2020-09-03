package qinkai.dao.impl;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import qinkai.dao.UserDao;
import qinkai.util.JDBCUtil02;

public class UserDaoImpl implements UserDao {

	@Override
	public boolean checkName(String name) throws SQLException {
		QueryRunner runner = new QueryRunner(JDBCUtil02.getDataSource());
		Long result = (Long)runner.query("select count(*) from t_user where username=?",new ScalarHandler(), name );
		return result > 0;
	}

}
