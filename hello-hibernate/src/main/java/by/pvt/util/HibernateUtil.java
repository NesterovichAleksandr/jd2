package by.pvt.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

    private ThreadLocal<Session> threadLocal = new ThreadLocal<>();
    private ThreadLocal<Session> testThreadLocal = new ThreadLocal<>();
    private SessionFactory sessionFactory;
    private SessionFactory testSessionFactory;

    private static HibernateUtil hibernateUtil;

    private HibernateUtil() {
        sessionFactory = new Configuration()
                .configure()
                .buildSessionFactory();
        testSessionFactory = new Configuration()
                .configure("test.hibernate.cfg.xml")
                .buildSessionFactory();
    }

    public static HibernateUtil getInstance() {
        if (hibernateUtil == null) {
            hibernateUtil = new HibernateUtil();
        }
        return hibernateUtil;
    }

    public Session getSession(String databaseName) {
        return getSession();
    }

    public Session getSession() {
        Session session = threadLocal.get();
        if (session == null || !session.isOpen()) {
            session = sessionFactory.openSession();
            threadLocal.set(session);
        }
        return session;
    }

    public Session getTestSession() {
        Session session = testThreadLocal.get();
        if (session == null || !session.isOpen()) {
            session = testSessionFactory.openSession();
            testThreadLocal.set(session);
        }
        return session;
    }
}
