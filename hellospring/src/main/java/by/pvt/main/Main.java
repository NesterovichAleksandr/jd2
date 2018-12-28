package by.pvt.main;

import by.pvt.beans.PersonImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

    public static void main(String[] args) {

        ApplicationContext applicationContext =
                new ClassPathXmlApplicationContext("spring-config.xml");

        PersonImpl person = (PersonImpl) applicationContext.getBean("person");

        System.out.println(person.getAddress().getCity() + " " + person.getAddress().getStreet());

        System.out.println(person.getName() + " " + person.getSecondName());
    }
}
