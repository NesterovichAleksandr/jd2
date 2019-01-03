package by.pvt.main;

import by.pvt.beans.AddressImpl;
import by.pvt.beans.PersonImpl;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

    public static void main(String[] args) {

        ClassPathXmlApplicationContext applicationContext =
                new ClassPathXmlApplicationContext("spring-config.xml");

        PersonImpl person = (PersonImpl) applicationContext.getBean("person");

        System.out.println(person.getAddress().getCity() + " " + person.getAddress().getStreet());

        System.out.println(person.getName() + " " + person.getSecondName());

        System.out.println("   flats " + ((AddressImpl) person.getAddress()).getFlats());

        System.out.println("   Map " + ((AddressImpl) person.getAddress()).getCoordinaty());

        applicationContext.close();
    }
}
