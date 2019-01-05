package by.pvt.beans;

public class Manager {

    private String name;
    private String secondName;
    private PersonImpl person;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public PersonImpl getPerson() {
        return person;
    }

    public void setPerson(PersonImpl person) {
        this.person = person;
    }
}
