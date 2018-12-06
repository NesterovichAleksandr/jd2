package by.pvt.dao;

import by.pvt.pojo.Address;
import by.pvt.pojo.Person;
import by.pvt.util.HibernateUtil;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.Serializable;

import static org.junit.Assert.*;


public class DaoImplTest {

    private DaoImpl<Person> dao;

    @Before
    public void setUp() {
        dao = new DaoImpl<>(Person.class);
    }

    @After
    public void tearDown() {
        dao = null;
    }

    @Test
    public void saveOrUpdate() {
        assertNull(dao.saveOrUpdate(null));

        assertNotNull(dao.saveOrUpdate(new Person()));

        Person person = new Person();
        assertNull(person.getId());
        Person person2 = dao.saveOrUpdate(person);
        assertEquals(person, person2);
        assertNotNull(person.getId());

        person2.setSecondName("Petrova");
        Person person3 = dao.saveOrUpdate(person2);
        assertEquals("Petrova", person3.getSecondName());
    }

    @Test
    public void load() {
        try {
            dao.load(null);
        } catch (Exception e) {
            assertEquals(e.getClass(), IllegalArgumentException.class);
        }
        try {
            dao.load("testID");
        } catch (Exception e) {
            assertEquals(e.getClass(), IllegalStateException.class);
        }
        Serializable id = dao.saveOrUpdate(new Person()).getId();
        Person loaderPerson = dao.load(id);
        assertNotNull(loaderPerson);
        assertNotNull(loaderPerson.getId());
        assertEquals(id, loaderPerson.getId());
    }

    @Test
    public void find() {
        assertNull(dao.find(null));
        assertNull(dao.find("testID"));
        Serializable id = dao.saveOrUpdate(new Person()).getId();
        assertNotNull(dao.find(id));
    }

    @Test
    public void updateName() {
        Person person = new Person();
        person.setName("Vasia");
        person.setSecondName("Ivanov");
        person = dao.saveOrUpdate(person);
        assertNotNull(person.getId());
        assertEquals(person.getName(), "Vasia");

        System.out.println("contains(person): " + HibernateUtil.getInstance().getSession().contains(person));
        //person POJO is connected with current session
        dao.updateName(person.getId(), "Petia");
        assertEquals(person.getName(), "Petia");
    }

    @Test
    public void updateNameWithExceptionAndRollback() {
        Person person = new Person();
        person.setName("Vasia");
        person.setSecondName("Ivanov");
        person = dao.saveOrUpdate(person);
        assertNotNull(person.getId());
        assertEquals(person.getName(), "Vasia");

        // Throws exception, rollbacks transaction and closes session
        dao.updateName(null, null);

        System.out.println("contains(person): " + HibernateUtil.getInstance().getSession().contains(person));
        //person POJO is disconnected from session and we need reread it
        person = dao.load(person.getId());
        dao.updateName(person.getId(), "Petia");
        assertEquals(person.getName(), "Petia");
    }

    @Test
    public void delete() {
        Person person = new Person();
        Serializable id = dao.saveOrUpdate(person).getId();
        assertNotNull(id);

        dao.delete(id);
        assertNull(dao.find(id));
        System.out.println(person);
    }

    @Test
    public void refresh() {
        Person person = new Person();
        person.setName("Kolia");
        person.setSecondName("Ivanov");
        person = dao.saveOrUpdate(person);
        assertNotNull(person.getId());

        dao.updateName(person.getId(), "Vova");
        dao.refresh(person, person.getId());
        assertEquals(person.getName(), "Vova");
    }

    @Test
    public void savePersonWithAddress() {
        Person person = new Person();
        person.setName("Marina");
        person.setSecondName("Ivanova");
        Address address = new Address("Minsk", "Lenina", "10", 213);
        person.setAddress(address);

        person = dao.saveOrUpdate(person);

        assertNotNull(person.getId());
        assertNotNull(person.getAddress());

        assertEquals("Minsk", person.getAddress().getCity());
        assertEquals("Lenina", person.getAddress().getStreet());
        assertEquals("10", person.getAddress().getHouseNumber());
        System.out.println(person);
    }
}