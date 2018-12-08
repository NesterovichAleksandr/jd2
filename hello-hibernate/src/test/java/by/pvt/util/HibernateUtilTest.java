package by.pvt.util;

import org.hibernate.Session;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class HibernateUtilTest {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void getInstance() {
        assertNotNull(HibernateUtil.getInstance());
    }

    @Test
    public void getSession() {
        Session session = HibernateUtil.getInstance().getTestSession();
        assertNotNull(session);

        assertEquals(session, HibernateUtil.getInstance().getTestSession());
    }
}