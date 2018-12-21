package by.pvt.pojo;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
public class Meeting {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column
    private String subject;

    @JoinColumn
    @OneToOne(cascade = CascadeType.ALL)
    private Employee organiser;

    @JoinColumn
    @ManyToMany//(mappedBy = "meetings")
    private Set<Person> attendees;

    @Column
    private Date dateTime;

    @Column
    private Status status;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public Employee getOrganiser() {
        return organiser;
    }

    public void setOrganiser(Employee organiser) {
        this.organiser = organiser;
    }

    public Set getAttendees() {
        return attendees;
    }

    public void setAttendees(Set attendees) {
        this.attendees = attendees;
    }

    public Date getDateTime() {
        return dateTime;
    }

    public void setDateTime(Date dateTime) {
        this.dateTime = dateTime;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
