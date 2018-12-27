package by.it.dao;

import by.it.pojos.Person;
import org.junit.*;

import static org.junit.Assert.*;

public class DaoImplTest {

    private DaoImpl<Person> dao;

    @Before
    public void setUp() throws Exception {
        dao = new DaoImpl<>(Person.class);
    }

    @Test
    public void create() {
        assertNotNull(dao.create(new Person()));
        assertNotNull(dao.create(new Person(null, 23, "David", "Wilson")));
    }

    @Test
    public void read() {
        assertNotNull(dao.read(2));
    }

    @Test
    public void update() {
        Person person = dao.read(2);
        person.setName("NewName");
        dao.update(person);
        Person testPerson = dao.read(2);
        assertEquals("NewName", testPerson.getName());
    }

    @Test
    public void delete() {
        Person person = dao.read(1);
        dao.delete(person);
        assertNull(dao.read(1));
    }

    @After
    public void tearDown() throws Exception {
        dao = null;
    }
}