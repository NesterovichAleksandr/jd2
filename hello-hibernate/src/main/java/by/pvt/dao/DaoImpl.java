package by.pvt.dao;

import by.pvt.pojo.Person;
import by.pvt.util.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.io.Serializable;

public class DaoImpl<T> {

    private Class<T> persistentClass;

    public DaoImpl(Class<T> type) {
        this.persistentClass = type;
    }

    public Class<T> getPersistentClass() {
        return persistentClass;
    }

    public T saveOrUpdate(T t) {
        Session session = HibernateUtil.getInstance().getSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.saveOrUpdate(t);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
                session.close();
            }
        }
        return t;
    }

    @NotNull
    public T load(Serializable id) {
        if (id == null) throw new IllegalArgumentException("Persistent instance id must not be null");
        Session session = HibernateUtil.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        T t = null;
        try {
            t = session.load(getPersistentClass(), id);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
            session.close();
        }
        if (t == null) throw new IllegalStateException("Persistence instance doesn't exist");
        return t;
    }

    @Nullable
    public T find(Serializable id) {
        Session session = HibernateUtil.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        T t = null;
        try {
            t = session.get(getPersistentClass(), id);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
            session.close();
        }
        return t;
    }

    public void updateName(Serializable id, String name) {
        Session session = HibernateUtil.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        try {
            Person person = (Person) session.get(getPersistentClass(), id);
            person.setName(name);
            session.flush();
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
            session.close();
        }
    }

    public void delete(Serializable id) {
        Session session = HibernateUtil.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        try {
            T t = session.get(getPersistentClass(), id);
            session.delete(t);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
            session.close();
        }
    }

    public void refresh(Serializable id, String name) {
        Session session = HibernateUtil.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        try {
            Person person = (Person) session.get(getPersistentClass(), id);
            person.setName(name);
            session.refresh(person);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
            session.close();
        }
    }
}
