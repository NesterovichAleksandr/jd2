package by.pvt.dao;

import by.pvt.pojo.User;
import by.pvt.pojo.UserDetails;
import org.junit.*;
import org.junit.runners.*;

import java.sql.Timestamp;

import static org.junit.Assert.*;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class UserDaoImplTest {

    DaoImpl<User> userDao;

    @Before
    public void setUp() {
        userDao = new DaoImpl<>(User.class);
        DaoImpl.isTestInstance = true;
    }

    @Test
    public void step1_createNewUser() {
        User user = new User();
        user.setUserName("User");
        user.setUserEmail("mail@mail.ru");

        UserDetails userDetails = new UserDetails();
        userDetails.setPassword("password");
        userDetails.setLoginAttempts(3);
        userDetails.setExpiredDate(new Timestamp(System.currentTimeMillis()));

        user.setUserDetails(userDetails);
        userDetails.setUser(user);

        userDao.saveOrUpdate(user);
        assertTrue(user.getId() > 0);

        System.out.println("user ID: " + user.getId());
    }

    @Test
    public void step2_findUser() {
        User user = userDao.find(1L);
        assertNotNull(user);
        assertNotNull(user.getUserDetails());
    }

    @Test
    public void step3_updateUser() {
        User user = userDao.load(1L);
        assertTrue(user.getUserName().equals("User"));
        assertTrue("password".equals(user.getUserDetails().getPassword()));

        user.setUserName("New User");
        user.getUserDetails().setPassword("New password");
        userDao.saveOrUpdate(user);

        User user1 = userDao.load(1L);
        assertEquals(user1.getUserName(), "New User");
        assertEquals(user1.getUserDetails().getPassword(),"New password");

    }

    @Test
    public void step4_deleteUser(){
        User user = userDao.load(1L);

        userDao.delete(user.getId());

        User user1 = userDao.find(1L);
        assertNull(user1);
    }

    @After
    public void tearDown() {
        DaoImpl.isTestInstance = false;
        userDao = null;
    }

}
