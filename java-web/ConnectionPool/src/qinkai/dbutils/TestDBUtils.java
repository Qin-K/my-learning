package qinkai.dbutils;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.junit.Test;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import qinkai.domain.Account;

public class TestDBUtils {

	@Test
	public void testDBUtils() throws SQLException {
		ComboPooledDataSource dataSource = new ComboPooledDataSource();
		
		QueryRunner queryRunner = new QueryRunner(dataSource);
		
		// 增加
		// queryRunner.update("insert into account values(null, ?, ?)", "haha", 1000);
		
		// 删除
		// queryRunner.update("delete from account where id = ?", 5);
		
		// 改
		// queryRunner.update("update account set money = ? where id = ?", 1000000, 6);
		
		// 查询一个数据, 查询到的数据还是在ResultSet里面，然后调用handle方法自己去封装
		/*Account account = queryRunner.query("select * from account where id = ?", new ResultSetHandler<Account>() {

			@Override
			public Account handle(ResultSet rs) throws SQLException {
				Account account = new Account();
				while (rs.next()) {
					String name = rs.getString("name");
					int money = rs.getInt("money");
					account.setName(name);
					account.setMoney(money);
				}
				return account;
			}
		}, 6);
		
		System.out.println(account);*/
		
		// 查询单个对象
		/*Account account = queryRunner.query("select * from account where id = ?", new BeanHandler<Account>(Account.class), 6);
		System.out.println(account.toString());*/
		
		
		// 查询多个对象
		List<Account> accounts = queryRunner.query("select * from account", 
				new BeanListHandler<Account>(Account.class));
		
		for (Account account : accounts) {
			System.out.println(account);
		}
	}
	
	
	
}
