package by.it.pojos;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@NoArgsConstructor
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
}
