package by.pvt.main;

import by.pvt.beans.*;
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

        System.out.println("Home: " + ((AddressImpl) person.getAddress()).getHome());

        System.out.println("Person full address: " + person.getFullAddress() + " " + ((AddressImpl) person.getAddress()).getZipCode());

        AddressImpl address = (AddressImpl) applicationContext.getBean("address");
        System.out.println("address.isEndOfStreet() = " + address.isEndOfStreet());

        System.out.println("address.isEndSameStreet() = " + address.isEndSameStreet());

        Inhabitant inhabitant = (Inhabitant) applicationContext.getBean("inhabitant");

        for (PersonImpl person1 : inhabitant.getPersons()) {
            System.out.println("name: " + person1.getName());
        }

        System.out.println("Inhabitants: " + address.getInhabitants());

        Manager manager = (Manager) applicationContext.getBean("manager");

        System.out.println("Manager: " + manager.getName() + " " + manager.getSecondName() + " " + manager.getPerson());

        FilterPerson filterPerson = (FilterPerson) applicationContext.getBean("filter");
        System.out.println("filter: Person= " + filterPerson.getPerson() + " Persons= " + filterPerson.getPersons() + " Property= " + filterPerson.getProperty());

        applicationContext.close();
    }
}
