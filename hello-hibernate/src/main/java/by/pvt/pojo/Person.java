package by.pvt.pojo;


import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.io.Serializable;
import java.util.Date;

public class Person implements Serializable {

    private static final long serialVersionUID = -1781191857792849355L;

    private String id;
    private String name;
    private String secondName;
    private int age;
    private Date dateOfBirth;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder()
                .append(id)
                .append(name)
                .append(secondName)
                .append(age)
                .append(dateOfBirth)
                .toHashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Person)) return false;
        Person that = (Person) obj;
        return new EqualsBuilder()
                .append(this.id, that.id)
                .append(this.name, that.name)
                .append(this.secondName, that.secondName)
                .append(this.age, that.age)
                .append(this.dateOfBirth, that.dateOfBirth)
                .isEquals();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("id", id)
                .append("name", name)
                .append("secondName", secondName)
                .append("age", age)
                .append("dateOfBirth", dateOfBirth)
                .toString();
    }
}
