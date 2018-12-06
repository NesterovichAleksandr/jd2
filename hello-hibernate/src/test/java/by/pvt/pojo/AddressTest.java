package by.pvt.pojo;

import by.pvt.util.HibernateUtil;
import org.hibernate.Session;
import org.junit.Test;

import static org.junit.Assert.*;

public class AddressTest {

    @Test
    public void getId() {
        Address address = new Address("Minsk", "Stroiteley", "5", 24);
        Session session = HibernateUtil.getInstance().getSession();
        session.saveOrUpdate(address);

        assertEquals(1L, address.getId());
        session.delete(address);
    }
}