package qinkai.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import qinkai.dao.CityDao;
import qinkai.domain.City;
import qinkai.util.JDBCUtil02;

public class CityDaoImpl implements CityDao {

	@Override
	public List<City> findCity(int pid) throws SQLException {
		QueryRunner runner = new QueryRunner(JDBCUtil02.getDataSource());
		String sql = "select * from city where pid=?";
		return runner.query(sql, new BeanListHandler<City>(City.class), pid);
	}

}
