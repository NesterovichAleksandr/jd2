package by.pvt.beans;

import java.util.Collection;

public class FilterPerson {

    private PersonImpl person;
    private Collection<PersonImpl> persons;
    private String property;

    public PersonImpl getPerson() {
        return person;
    }

    public void setPerson(PersonImpl person) {
        this.person = person;
    }

    public Collection<PersonImpl> getPersons() {
        return persons;
    }

    public void setPersons(Collection<PersonImpl> persons) {
        this.persons = persons;
    }

    public String getProperty() {
        return property;
    }

    public void setProperty(String property) {
        this.property = property;
    }
}
