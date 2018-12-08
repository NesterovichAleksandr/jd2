package by.pvt.pojo;

import by.pvt.util.HibernateUtil;
import org.hibernate.Session;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class HesdQuarterTest {

    private Session session;

    @Before
    public void setUp() throws Exception {
        session = HibernateUtil.getInstance().getTestSession();
    }

    @Test
    public void createInctance(){
        HesdQuarter hesdQuarter = new HesdQuarter();

        hesdQuarter.setCompanyName(" oo sfsf");
        hesdQuarter.setBackAccount("sgfsgf");

        try {
            session.beginTransaction();
            session.saveOrUpdate(hesdQuarter);
            session.getTransaction().commit();
            assertNotNull(hesdQuarter.getId());
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        }


    }

    @After
    public void tearDown() throws Exception {
        if (session != null && session.isOpen()) {
            session.close();
            session = null;
        }
    }
}