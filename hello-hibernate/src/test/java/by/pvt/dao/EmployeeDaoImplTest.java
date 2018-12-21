package by.pvt.dao;

import by.pvt.pojo.Address;
import by.pvt.pojo.Department;
import by.pvt.pojo.Employee;
import by.pvt.pojo.EmployeeDetails;
import org.junit.*;
import org.junit.runners.MethodSorters;

import java.util.Set;

import static org.junit.Assert.*;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class EmployeeDaoImplTest {

    private DaoImpl<Employee> employeeDao;

    @Before
    public void setUp() {
        employeeDao = new DaoImpl<>(Employee.class);
        DaoImpl.isTestInstance = true;
    }

    @Test
    public void step1_createNewEmployee() {

        Employee employee1 = new Employee();
        employee1.setFirstName("Name12");
        employee1.setLastName("LastName1");
        employee1.setCellPhone("11111");

        Employee employee2 = new Employee();
        employee2.setFirstName("Name22");
        employee2.setLastName("LastName2");
        employee2.setCellPhone("22222");

        Employee employee3 = new Employee();
        employee3.setFirstName("Name32");
        employee3.setLastName("LastName3");
        employee3.setCellPhone("33333");

        Department department1 = new Department();
        department1.setDepartmentName("Department1");
        department1.setEmployees(Set.of(employee1, employee2));
        employee1.setDepartment(department1);
        employee2.setDepartment(department1);

        Department department2 = new Department();
        department2.setDepartmentName("Department2");
        department2.setEmployees(Set.of(employee3));
        employee3.setDepartment(department2);

        EmployeeDetails employeeDetails1 = new EmployeeDetails();
        Address address1 = new Address("Minsk", "Lenina", "1", 1);
        address1.setOfficeNumber("1");
        employeeDetails1.setAddress(address1);
        employeeDetails1.setPosition("employee1");
        employeeDetails1.setPrivateNr("e1");
        employeeDetails1.setEmployee(employee1);
        employee1.setEmployeeDetails(employeeDetails1);

        EmployeeDetails employeeDetails2 = new EmployeeDetails();
        Address address2 = new Address("Minsk", "Lenina", "2", 2);
        address2.setOfficeNumber("2");
        employeeDetails2.setAddress(address2);
        employeeDetails2.setPosition("employee2");
        employeeDetails2.setPrivateNr("e2");
        employeeDetails2.setEmployee(employee2);
        employee2.setEmployeeDetails(employeeDetails2);

        EmployeeDetails employeeDetails3 = new EmployeeDetails();
        Address address3 = new Address("Minsk", "Lenina", "3", 3);
        address3.setOfficeNumber("3");
        employeeDetails3.setAddress(address3);
        employeeDetails3.setPosition("employee3");
        employeeDetails3.setPrivateNr("e3");
        employeeDetails3.setEmployee(employee3);
        employee3.setEmployeeDetails(employeeDetails3);

        employeeDao.saveOrUpdate(employee1);
        employeeDao.saveOrUpdate(employee2);
        employeeDao.saveOrUpdate(employee3);

        assertTrue(employee1.getId() > 0);
        assertTrue(employee2.getId() > 0);
        assertTrue(employee3.getId() > 0);

        System.out.println("employee1 ID: " + employee1.getId());
        System.out.println("employee2 ID: " + employee2.getId());
        System.out.println("employee3 ID: " + employee3.getId());
    }

    @Test
    public void step2_findEmployee() {
        Employee employee = employeeDao.find(2L);
        assertNotNull(employee);
    }

    @Test
    public void step3_updateEmployee() {
        Employee employee1 = employeeDao.load(2L);
        Employee employee2 = employeeDao.load(1L);
        Employee employee3 = employeeDao.load(3L);

        Department department1 = employee1.getDepartment();
        Department department2 = employee3.getDepartment();

        employee1.setDepartment(department2);
        employee2.setDepartment(department2);
        employee3.setDepartment(department1);

        employeeDao.saveOrUpdate(employee1);
        employeeDao.saveOrUpdate(employee2);
        employeeDao.saveOrUpdate(employee3);

        Employee employee4 = employeeDao.load(2L);
        Employee employee5 = employeeDao.load(1L);
        Employee employee6 = employeeDao.load(3L);

        assertEquals(employee4.getDepartment(), department2);
        assertEquals(employee5.getDepartment(), department2);
        assertEquals(employee6.getDepartment(), department1);
    }

    @Ignore
    public void step4_deleteEmployees() {
        Employee employee = employeeDao.load(2L);
        employee.getDepartment().setEmployees(null);

        Employee employee2 = employeeDao.load(1L);
        employee2.getDepartment().setEmployees(null);

        Employee employee3 = employeeDao.load(3L);
        employee3.getDepartment().setEmployees(null);

        employeeDao.delete(2L);
        assertNull(employeeDao.find(2L));

        employeeDao.delete(1L);
        assertNull(employeeDao.find(1L));

        employeeDao.delete(3L);
        assertNull(employeeDao.find(3L));
    }

    @After
    public void tearDown() {
        DaoImpl.isTestInstance = false;
        employeeDao = null;
    }
}
