package qinkai.spring.tx.demo1;

public interface AccountDao {
    public void outMoney(String name, Double money);

    public void inMoney(String name, Double money);
}
