package by.it.pojos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
//@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Entity
public class Person {

    @Id
    @GeneratedValue
    private Integer id;

    @Column
    private Integer age;

    @Column
    private String name;

    @Column
    private String surname;

    public Person() {
    }

    public Person(Integer id, int age, String name, String surname) {
        this.id = id;
        this.age = age;
        this.name = name;
        this.surname = surname;
    }
}
