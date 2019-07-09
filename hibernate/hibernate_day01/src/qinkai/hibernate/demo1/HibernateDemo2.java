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
    // 查询
    public void demo2() {
        Session session = HibernateUtils.openSession();
        Transaction transaction = session.beginTransaction();
		
		/*Customer customer = session.get(Customer.class, 1l);		
		System.out.println(customer);*/
        Customer customer = session.load(Customer.class, 2l);
        System.out.println(customer);

        transaction.commit();
        session.close();
    }

    @Test
    // 修改
    public void demo3() {
        Session session = HibernateUtils.openSession();
        Transaction transaction = session.beginTransaction();

        Customer customer = new Customer();
        customer.setCust_id(1l);
        customer.setCust_name("张三");
        session.update(customer);

        transaction.commit();
        session.close();
    }

    @Test
    // 删除
    public void demo4() {
        Session session = HibernateUtils.openSession();
        Transaction transaction = session.beginTransaction();

        Customer customer = session.get(Customer.class, 2l);
        session.delete(customer);

        transaction.commit();
        session.close();
    }

    @Test
    // 保存或更新
    public void demo5() {
        Session session = HibernateUtils.openSession();
        Transaction transaction = session.beginTransaction();

        Customer customer = session.get(Customer.class, 3l);
        customer.setCust_name("李娟");
        session.saveOrUpdate(customer);

        transaction.commit();
        session.close();
    }

    @Test
    // 查询所有
    public void demo6() {
        Session session = HibernateUtils.openSession();
        Transaction transaction = session.beginTransaction();

        Query query = session.createQuery("from Customer");
        List<Customer> list = query.list();

        for (Customer customer : list) {
            System.out.println(customer);
        }
        transaction.commit();
        session.close();

    }
}
