package qinkai.hibernate.demo1;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import qinkai.hibernate.utils.HibernateUtils;

public class HibernateDemo3 {
    @Test
    public void demo1() {
        Session session = HibernateUtils.openSession();
        Transaction transaction = session.beginTransaction();
        Customer customer1 = session.get(Customer.class, 1l);
        System.out.println(customer1);
        Customer customer2 = session.get(Customer.class, 1l);
        System.out.println(customer2);
        System.out.println(customer1 == customer2);

        transaction.commit();
        session.close();
    }
}
