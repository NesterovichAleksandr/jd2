package by.pvt.pojo;

public class EmployeeDetails {

    private long id;
    private Address address;
    private String position;
    private String privateNr;

    private Employee employee;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getPrivateNr() {
        return privateNr;
    }

    public void setPrivateNr(String privateNr) {
        this.privateNr = privateNr;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
}
