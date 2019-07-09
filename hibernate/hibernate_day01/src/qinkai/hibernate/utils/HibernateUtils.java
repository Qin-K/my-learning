package qinkai.hibernate.utils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * hibernate工具类的实现
 *
 * @author Qin-Kai
 */
public class HibernateUtils {
    public static final Configuration cf;
    public static final SessionFactory sf;

    static {
        cf = new Configuration().configure();
        sf = cf.buildSessionFactory();
    }

    public static Session openSession() {
        return sf.openSession();
    }
}
