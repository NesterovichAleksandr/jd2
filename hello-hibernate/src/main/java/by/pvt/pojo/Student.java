package by.pvt.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
//@DiscriminatorValue("s")
public class Student extends Person {

    @Column
    private String university;

    @Column
    private String faculty;

    @Column
    private short courseYear;

    public String getUniversity() {
        return university;
    }

    public void setUniversity(String university) {
        this.university = university;
    }

    public String getFaculty() {
        return faculty;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    public short getCourseYear() {
        return courseYear;
    }

    public void setCourseYear(short courseYear) {
        this.courseYear = courseYear;
    }
}
