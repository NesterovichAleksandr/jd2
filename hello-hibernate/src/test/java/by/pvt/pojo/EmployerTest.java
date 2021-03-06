package by.pvt.pojo;

import by.pvt.util.HibernateUtil;
import org.hibernate.Session;
import org.junit.*;

import static org.junit.Assert.*;

public class EmployerTest {

    private Session session;

    @Before
    public void setUp() throws Exception {
        session = HibernateUtil.getInstance().getTestSession();
    }

    @Test
    public void createInstance() {
        Employer employer = new Employer();

        employer.setName("Ivan");
        employer.setCorporatePhoneNumber("375291234567");

        try {
            session.beginTransaction();
            session.saveOrUpdate(employer);
            session.getTransaction().commit();
            assertNotNull(employer.getId());
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        }
        System.out.println("employer ID: " + employer.getId());
    }

    @After
    public void tearDown() throws Exception {
        if (session != null && session.isOpen()) {
            session.close();
            session = null;
        }
    }
}