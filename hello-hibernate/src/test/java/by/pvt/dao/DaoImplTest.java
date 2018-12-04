package by.pvt.dao;

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

        try {
            dao.updateName(null, null);
        } catch (Exception e) {
            e.printStackTrace();
            assertTrue(e instanceof IllegalArgumentException);
            HibernateUtil.getInstance().getSession().getTransaction().rollback();
        }
        dao.updateName(person.getId(), "Petia");
        person = dao.load(person.getId());
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
}