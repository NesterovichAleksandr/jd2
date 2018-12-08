package by.pvt.pojo;

public class Student extends Person {

    private String university;
    private String faculty;
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
