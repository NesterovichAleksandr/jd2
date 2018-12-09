package by.pvt.pojo;

import by.pvt.dao.DaoImpl;
import by.pvt.util.HibernateUtil;
import org.hibernate.Session;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class AddressTest {

    private DaoImpl<Address> dao;

    @Before
    public void setUp() {
        dao = new DaoImpl<>(Address.class);
        DaoImpl.isTestInstance = true;
    }

    @Test
    public void getId() {
        Address address = new Address("Minsk", "Stroiteley", "5", 24);
        Session session = HibernateUtil.getInstance().getTestSession();
        session.saveOrUpdate(address);

        assertEquals(1L, address.getId());
        session.delete(address);
    }

    @After
    public void tearDown() {
        DaoImpl.isTestInstance = false;
        dao = null;
    }
}