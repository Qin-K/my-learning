package qinkai.spring.tx.demo2;

import org.springframework.jdbc.core.support.JdbcDaoSupport;

public class AccountDaoImpl extends JdbcDaoSupport implements AccountDao {

    @Override
    public void outMoney(String name, Double money) {
        this.getJdbcTemplate().update("update account set money = money-? where name=?", money, name);
    }

    @Override
    public void inMoney(String name, Double money) {
        this.getJdbcTemplate().update("update account set money = money+? where name=?", money, name);
    }

}
