package qinkai.spring.tx.demo3;

public interface AccountDao {
    public void outMoney(String name, Double money);

    public void inMoney(String name, Double money);
}
