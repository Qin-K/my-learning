package qinkai.hibernate.demo1;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import qinkai.hibernate.utils.HibernateUtils;

public class HibernateDemo2 {

    @Test
    // 保存
    public void demo1() {
        Session session = HibernateUtils.openSession();
        Transaction transaction = session.beginTransaction();
        Customer customer = new Customer();
        customer.setCust_name("秦凯");
        session.save(customer);
        transaction.commit();
        session.close();
    }

    @Test
    // 持久态自动更新数据库
    public void demo2() {
        Session session = HibernateUtils.openSession();
        Transaction transaction = session.beginTransaction();
        Customer customer = session.get(Customer.class, 1l);
        customer.setCust_name("秦凯");
        transaction.commit();
        session.close();
    }
}
