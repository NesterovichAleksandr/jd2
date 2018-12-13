package by.it.loader;

import by.it.dao.DaoImpl;
import by.it.pojos.Person;
import by.it.util.HibernateUtil;

public class PersonLoader {

    public static void main(String[] args) {
        Person person = new Person(null, 21, "Ivan", "Ivanov");
        System.out.println(person);

        //DaoImpl dao = new DaoImpl();

        //dao.create(person);
        //Person person1 = dao.read(1);
        //System.out.println(person1);



        HibernateUtil.getInstance().close();
    }
}
