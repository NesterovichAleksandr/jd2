package by.pvt.dao;

import by.pvt.pojo.Address;
import by.pvt.pojo.EmployeeDetails;
import org.junit.*;
import org.junit.runners.MethodSorters;

import static org.junit.Assert.*;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class EmployeeDetailsDaoImplTest {

    private DaoImpl<EmployeeDetails> employeeDetailsDao;

    @Before
    public void setUp() {
        employeeDetailsDao = new DaoImpl<>(EmployeeDetails.class);
        DaoImpl.isTestInstance = true;
    }

    @Test
    public void step1_createNewEmployeeDetails() {
        EmployeeDetails employeeDetails = new EmployeeDetails();
        employeeDetails.setAddress(new Address());
        employeeDetails.setPosition("PositionDaoTest");
        employeeDetails.setPrivateNr("PrivateNrDaoTest");
        employeeDetailsDao.saveOrUpdate(employeeDetails);

        assertTrue(employeeDetails.getId() > 0);
    }

    @Test
    public void step2_findEmployeeDetails() {
        assertNotNull(employeeDetailsDao.find(1L));
    }

    @Test
    public void step3_updateEmployeeDetails() {
        EmployeeDetails employeeDetails = employeeDetailsDao.load(4L);
        assertEquals("PositionDaoTest", employeeDetails.getPosition());

        employeeDetails.setPosition("New PositionDaoTest");
        employeeDetailsDao.saveOrUpdate(employeeDetails);

        EmployeeDetails testEmployeeDetails = employeeDetailsDao.load(4L);
        assertEquals("New PositionDaoTest", testEmployeeDetails.getPosition());
    }

    @Test
    public void step4_deleteEmployeeDetails() {
        employeeDetailsDao.delete(4L);
        assertNull(employeeDetailsDao.find(4L));
    }

    @After
    public void tearDown() {
        DaoImpl.isTestInstance = false;
        employeeDetailsDao = null;
    }
}
