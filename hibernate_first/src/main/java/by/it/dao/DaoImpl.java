package by.it.dao;

import by.it.pojos.Person;
import by.it.util.HibernateUtil;
import org.hibernate.Session;

public class DaoImpl {

    public void create(Person person) {
        Session session = HibernateUtil.getInstance().getSession();
        session.beginTransaction();
        session.save(person);
        session.getTransaction().commit();
    }

    public Person read(Integer id) {
        Session session = HibernateUtil.getInstance().getSession();
        return session.load(Person.class, id);
    }

    public void delete(Person person) {
        Session session = HibernateUtil.getInstance().getSession();
        session.beginTransaction();
        session.delete(person);
        session.getTransaction().commit();
    }

}
