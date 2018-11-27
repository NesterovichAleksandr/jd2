package by.pvt.pojo;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.GregorianCalendar;

import static org.junit.Assert.*;

public class PersonTest {

    Person person1 = new Person();
    Person person2 = new Person();

    private void initPerson(Person person){
        person.setAge(35);
        person.setDateOfBirth(new GregorianCalendar(1990,1,1).getTime());
        person.setId(10);
        person.setName("Natalia");
        person.setSecondName("Ivanova");
    }

    @Before
    public void setUp() throws Exception {
        initPerson(person1);
        initPerson(person2);
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void testHashCode() {
        assertEquals(person1.hashCode(), person2.hashCode());
        assertEquals(person2.hashCode(), person1.hashCode());

        assertEquals(person1.hashCode(), person1.hashCode());
        assertEquals(person2.hashCode(), person2.hashCode());
    }

    @Test
    public void testEquals() {
        assertTrue(person1.equals(person1));
        assertTrue(person2.equals(person2));

        assertTrue(person1.equals(person2) && person2.equals(person1));

        assertFalse(person1.equals(null));
        assertFalse(person2.equals(null));




    }
}