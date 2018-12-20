package by.pvt.pojo;

import by.pvt.util.HibernateUtil;
import org.hibernate.Session;
import org.junit.*;

import java.util.Set;

import static org.junit.Assert.assertTrue;

public class EmployeeTest {

    private Session session;

    @Before
    public void setUp() throws Exception {
        session = HibernateUtil.getInstance().getTestSession();
    }

    @Test
    public void createInstance() {
        Employee employee1 = new Employee();
        employee1.setFirstName("Name1");
        employee1.setLastName("LastName1");
        employee1.setCellPhone("11111");

        Employee employee2 = new Employee();
        employee2.setFirstName("Name2");
        employee2.setLastName("LastName2");
        employee2.setCellPhone("22222");

        Employee employee3 = new Employee();
        employee3.setFirstName("Name3");
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

        try {
            session.beginTransaction();
            session.saveOrUpdate(employee1);
            session.saveOrUpdate(employee2);
            session.saveOrUpdate(employee3);
            session.getTransaction().commit();
            assertTrue(employee1.getId() > 0);
            assertTrue(employee2.getId() > 0);
            assertTrue(employee3.getId() > 0);
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
            session.close();
        }
        System.out.println("employee1 ID: " + employee1.getId());
        System.out.println("employee2 ID: " + employee2.getId());
        System.out.println("employee3 ID: " + employee3.getId());
    }

    @After
    public void tearDown() throws Exception {
        if (session != null && session.isOpen()) {
            session.close();
            session = null;
        }
    }
}