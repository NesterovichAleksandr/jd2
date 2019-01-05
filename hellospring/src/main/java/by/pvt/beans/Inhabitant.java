package by.pvt.beans;

import java.util.Collection;

public class Inhabitant {

    private Collection<PersonImpl> persons;

    public Collection<PersonImpl> getPersons() {
        return persons;
    }

    public void setPersons(Collection<PersonImpl> persons) {
        this.persons = persons;
    }
}
