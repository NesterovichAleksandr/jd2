package by.it.loader;

import by.it.dao.DaoImpl;

public class PersonLoader {

    public static void main(String[] args) {
        //Person person = new Person(null, 21, "Ivan", "Ivanov");
        //System.out.println(person);

        DaoImpl dao = new DaoImpl();

        //dao.create(person);
        System.out.println(dao.read(2));
    }
}