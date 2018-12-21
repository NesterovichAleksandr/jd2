package by.pvt.dao;

import by.pvt.pojo.User;
import by.pvt.pojo.UserDetails;
import org.junit.*;
import org.junit.runners.MethodSorters;

import java.sql.Timestamp;

import static org.junit.Assert.*;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class UserDetailsDaoImplTest {

    private DaoImpl<UserDetails> userDetailsDao;

    @Before
    public void setUp() {
        userDetailsDao = new DaoImpl<>(UserDetails.class);
        DaoImpl.isTestInstance = true;
    }

    @Test
    public void step1_createNewUserDetails() {
        UserDetails userDetails = new UserDetails();
        userDetails.setPassword("PasswordDaoTest");
        userDetails.setExpiredDate(new Timestamp(System.currentTimeMillis()));
        userDetails.setLoginAttempts(5);

        User user = new User();
        userDetails.setUser(user);
        userDetailsDao.saveOrUpdate(userDetails);

        assertTrue(userDetails.getId() > 0);

        System.out.println("userDetails ID: " + userDetails.getId());
    }

    @Test
    public void step2_findUserDetails() {
        assertNotNull(userDetailsDao.find(2L));
    }

    @Test
    public void step3_updateUserDetails() {
        UserDetails userDetails = userDetailsDao.load(2L);
        assertEquals("PasswordDaoTest", userDetails.getPassword());

        userDetails.setPassword("New PasswordDaoTest");
        userDetailsDao.saveOrUpdate(userDetails);

        UserDetails testUserDetails = userDetailsDao.load(2L);
        assertEquals("New PasswordDaoTest", testUserDetails.getPassword());

    }

    @Test
    public void step4_deleteUserDetails() {
        userDetailsDao.delete(2L);
        assertNull(userDetailsDao.find(2L));
    }

    @After
    public void tearDown() {
        DaoImpl.isTestInstance = false;
        userDetailsDao = null;
    }
}
