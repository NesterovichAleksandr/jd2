package by.pvt.pojo;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;

    @Column
    private String firstName;

    @Column
    private String lastName;

    @Column
    private String cellPhone;

    @JoinColumn
    @ManyToOne(cascade = CascadeType.ALL)
    private Department department;

    @JoinColumn
    @OneToOne(cascade = CascadeType.ALL)
    private EmployeeDetails employeeDetails;

    @JoinColumn
    @ManyToMany(cascade = CascadeType.ALL)
//    @ManyToMany
//    @JoinTable(name = "employee_meeting",
//            joinColumns = {@JoinColumn(name = "employee")},
//            inverseJoinColumns = {@JoinColumn(name = "meeting")})
    private Set<Meeting> meetings;

    public Set<Meeting> getMeetings() {
        return meetings;
    }

    public void setMeetings(Set<Meeting> meetings) {
        this.meetings = meetings;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCellPhone() {
        return cellPhone;
    }

    public void setCellPhone(String cellPhone) {
        this.cellPhone = cellPhone;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public EmployeeDetails getEmployeeDetails() {
        return employeeDetails;
    }

    public void setEmployeeDetails(EmployeeDetails employeeDetails) {
        this.employeeDetails = employeeDetails;
    }
}
