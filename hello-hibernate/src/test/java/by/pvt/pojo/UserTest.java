package by.pvt.pojo;

import by.pvt.util.HibernateUtil;
import org.hibernate.Session;
import org.junit.*;

import java.sql.Timestamp;

import static org.junit.Assert.*;

public class UserTest {

    Session session;

    @Before
    public void setUp() throws Exception {
        session = HibernateUtil.getInstance().getTestSession();
    }

    @Test
    public void createInstance() {
        User user = new User();
        user.setUserName("User");
        user.setUserEmail("mail@mail.ru");

        UserDetails userDetails = new UserDetails();
        userDetails.setPassword("password");
        userDetails.setLoginAttempts(3);
        userDetails.setExpiredDate(new Timestamp(System.currentTimeMillis()));

        user.setUserDetails(userDetails);
        userDetails.setUser(user);

        try {
            session.beginTransaction();
            session.saveOrUpdate(user);
            session.saveOrUpdate(userDetails);
            session.getTransaction().commit();
            assertTrue(user.getId() > 0);
            assertTrue(userDetails.getId() > 0);
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        }
        System.out.println("user ID: " + user.getId());
        System.out.println("userDetails ID: " + userDetails.getId());
    }

    @After
    public void tearDown() throws Exception {
        if (session != null && session.isOpen()) {
            session.close();
            session = null;
        }
    }
}