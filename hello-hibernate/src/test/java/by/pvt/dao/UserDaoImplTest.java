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
    }

    @Test
    public void step2_findUser(){
        User user = userDao.find(1L);
        assertNotNull(user);
        assertNotNull(user.getUserDetails());

    }

    @After
    public void tearDown() {
        DaoImpl.isTestInstance = false;
        userDao = null;
    }

}
