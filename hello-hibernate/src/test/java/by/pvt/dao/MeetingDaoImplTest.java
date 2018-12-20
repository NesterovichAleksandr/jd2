package by.pvt.dao;

import by.pvt.pojo.Employee;
import by.pvt.pojo.Meeting;
import by.pvt.pojo.Status;
import org.junit.After;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.Calendar;
import java.util.Set;
import java.util.concurrent.locks.ReentrantLock;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class MeetingDaoImplTest {

    private DaoImpl<Meeting> meetingDao;

    private DaoImpl<Employee> employeeDao;

    @Before
    public void setUp() {
        ReentrantLock lock = new ReentrantLock();
        lock.lock();

        meetingDao = new DaoImpl<>(Meeting.class);
        employeeDao = new DaoImpl<>(Employee.class);
        DaoImpl.isTestInstance = true;

        lock.unlock();
    }

    @Test
    public void step1_createNewMeeting() {
        Employee employee1 = createEmployee("1");
        employeeDao.saveOrUpdate(employee1);

        Employee employee2 = createEmployee("2");
        employeeDao.saveOrUpdate(employee2);

        Employee employee3 = createEmployee("3");
        employeeDao.saveOrUpdate(employee3);

        Employee employee4 = createEmployee("4");
        employeeDao.saveOrUpdate(employee4);

        Meeting meeting1 = createMeeting("1");
        meeting1.setAttendees(Set.of(employee1, employee2));
        meeting1.setOrganiser(employee1);
        meetingDao.saveOrUpdate(meeting1);
        assertTrue(meeting1.getId() == 1L);

        meetingDao.saveOrUpdate(meeting1);

        Meeting meeting2 = createMeeting("2");
        meeting2.setOrganiser(employee4);
        meeting2.setAttendees(Set.of(employee1, employee2, employee3, employee4));
        meetingDao.saveOrUpdate(meeting2);
        assertTrue(meeting2.getId() == 2L);

        System.out.println("meeting1 ID: " + meeting1.getId());
        System.out.println("meeting2 ID: " + meeting2.getId());
    }

    @Test
    public void step2_deleteMeeting() {
        meetingDao.delete(1L);
        assertNull(meetingDao.find(1L));
        meetingDao.delete(2L);
        assertNull(meetingDao.find(2L));
    }

    private Meeting createMeeting(String postfix) {
        Meeting meeting = new Meeting();
        meeting.setSubject("Subject" + postfix);
        meeting.setStatus(Status.NEW);
        meeting.setDateTime(Calendar.getInstance().getTime());
        return meeting;
    }

    private Employee createEmployee(String postfix) {
        Employee employee = new Employee();
        employee.setFirstName("First Name" + postfix);
        employee.setLastName("Last Name" + postfix);
        return employee;
    }

    @After
    public void tearDown() {
        DaoImpl.isTestInstance = false;
        meetingDao = null;
        employeeDao = null;
    }
}
