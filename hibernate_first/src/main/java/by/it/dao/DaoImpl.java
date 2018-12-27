package by.it.dao;

import by.it.util.HibernateUtil;
import org.hibernate.Session;

public class DaoImpl<T> {

    private Class<T> persistentClass;

    public DaoImpl(Class<T> type) {
        this.persistentClass = type;
    }

    public Class<T> getPersistentClass() {
        return persistentClass;
    }

    public T create(T t) {
        Session session = HibernateUtil.getInstance().getSession();
        try {
            session.beginTransaction();
            session.save(t);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
            session.close();
        }
        return t;
    }

    public T read(Integer id) {
        Session session = HibernateUtil.getInstance().getSession();
        T t = null;
        try {
            session.beginTransaction();
            t = session.get(getPersistentClass(), id);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
            session.close();
        }
        return t;
    }

    public T update(T t) {
        Session session = HibernateUtil.getInstance().getSession();
        try {
            session.beginTransaction();
            session.update(t);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
            session.close();
        }
        return t;
    }

    public void delete(T t) {
        Session session = HibernateUtil.getInstance().getSession();
        try {
            session.beginTransaction();
            session.delete(t);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
            session.close();
        }
    }
}
