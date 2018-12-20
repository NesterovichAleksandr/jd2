package by.pvt.pojo;

import by.pvt.util.HibernateUtil;
import org.hibernate.Session;
import org.junit.*;

import static org.junit.Assert.*;

public class HeadQuarterTest {

    private Session session;

    @Before
    public void setUp() throws Exception {
        session = HibernateUtil.getInstance().getTestSession();
    }

    @Test
    public void createInstance(){
        HeadQuarter headQuarter = new HeadQuarter();

        headQuarter.setCompanyName("OOO Vasilek");
        headQuarter.setSiteUrl("www.vasilek.by");
        headQuarter.setBankAccount("hgkd55w5b3563vt34");
        headQuarter.setDirectorName("Director");

        try {
            session.beginTransaction();
            session.saveOrUpdate(headQuarter);
            session.getTransaction().commit();
            assertNotNull(headQuarter.getId());
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        }
        System.out.println("headQuarter ID: " + headQuarter.getId());
    }

    @After
    public void tearDown() throws Exception {
        if (session != null && session.isOpen()) {
            session.close();
            session = null;
        }
    }
}