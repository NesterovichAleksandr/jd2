package by.pvt.beans;

public class PersonImpl {

    private String name;
    private String secondName;
    private Address address;

    public PersonImpl() {
    }

    public PersonImpl(String name, String secondName, Address address) {
        this.name = name;
        this.secondName = secondName;
        this.address = address;
    }

    public String getName() {
        System.out.println("getName()");
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

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
