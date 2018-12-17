package by.pvt.dao;

import by.pvt.pojo.Person;
import org.junit.*;
import org.junit.runners.MethodSorters;

import java.io.Serializable;

import static org.junit.Assert.*;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class PersonDaoImplTest {

    private DaoImpl<Person> personDao;

    @Before
    public void setUp() {
        personDao = new DaoImpl<>(Person.class);
        DaoImpl.isTestInstance = true;
    }

    @Test
    public void step1_createNewPerson() {
        Person person = new Person();
        person.setName("NameDaoTest");
        person.setSecondName("SecondNameDaoTest");
        personDao.saveOrUpdate(person);

        assertNotNull(person.getId());

        personDao.delete(person.getId());
        assertNull(personDao.find(person.getId()));
    }

    @Test
    public void step2_findPerson() {
        Person person = new Person();
        person.setName("NameDaoTest step2_findPerson");
        personDao.saveOrUpdate(person);
        Serializable id = person.getId();

        Person testPerson = personDao.find(id);
        assertNotNull(testPerson);
        assertEquals("NameDaoTest step2_findPerson", testPerson.getName());

        personDao.delete(person.getId());
        assertNull(personDao.find(person.getId()));
    }

    @Test
    public void step3_updatePerson() {
        Person person = new Person();
        person.setName("NameDaoTest step3_updatePerson");
        personDao.saveOrUpdate(person);
        Serializable id = person.getId();

        Person testPerson = personDao.load(id);
        assertNotNull(testPerson);
        testPerson.setSecondName("SecondNameDaoTest step3_updatePerson");
        personDao.saveOrUpdate(testPerson);

        Person testUpdatePerson = personDao.load(id);
        assertEquals("SecondNameDaoTest step3_updatePerson", testUpdatePerson.getSecondName());

        personDao.delete(id);
        assertNull(personDao.find(id));
    }

    @Test
    public void step4_deletePerson() {
        Person person = new Person();
        Serializable id = person.getId();
        personDao.delete(id);

        assertNull(personDao.find(id));
    }

    @After
    public void tearDown() {
        DaoImpl.isTestInstance = false;
        personDao = null;
    }
}
