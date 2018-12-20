package by.pvt.dao;

import by.pvt.pojo.Department;
import org.junit.*;
import org.junit.runners.MethodSorters;

import static org.junit.Assert.*;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class DepartmentDaoImplTest {

    private DaoImpl<Department> departmentDao;

    @Before
    public void setUp() {
        departmentDao = new DaoImpl<>(Department.class);
        DaoImpl.isTestInstance = true;
    }

    @Test
    public void step1_createNewDepartment() {
        Department department = new Department();
        department.setDepartmentName("DepartmentNameDaoTest");
        departmentDao.saveOrUpdate(department);

        assertTrue(department.getId() > 0);

        System.out.println("department ID: " + department.getId());

    }

    @Test
    public void step2_findDepartment() {
        assertNotNull(departmentDao.find(7L));
    }

    @Test
    public void step3_updateDepartment() {
        Department department = departmentDao.load(7L);
        assertEquals("DepartmentNameDaoTest", department.getDepartmentName());

        department.setDepartmentName("New DepartmentNameDaoTest");
        departmentDao.saveOrUpdate(department);

        Department testDepartment = departmentDao.load(7L);
        assertEquals("New DepartmentNameDaoTest", testDepartment.getDepartmentName());

    }

    @Test
    public void step4_deleteDepartment() {
        departmentDao.delete(7L);
        assertNull(departmentDao.find(7L));
    }

    @After
    public void tearDown() {
        DaoImpl.isTestInstance = false;
        departmentDao = null;
    }
}
