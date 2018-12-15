package by.pvt.pojo;

import by.pvt.util.HibernateUtil;
import org.hibernate.Session;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;
import java.util.Set;

import static org.junit.Assert.*;

public class MeetingTest {

    private Session session;

    @Before
    public void setUp() throws Exception {
        session = HibernateUtil.getInstance().getTestSession();
    }

    @Test
    public void createInstance() {
        Employee employee1 = new Employee();
        employee1.setFirstName("First Name1");
        employee1.setLastName("Last Name1");
        try {
            session.beginTransaction();
            session.saveOrUpdate(employee1);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        }

        Employee employee2 = new Employee();
        employee2.setFirstName("First Name2");
        employee2.setLastName("Last Name2");

        try {
            session.beginTransaction();
            session.saveOrUpdate(employee2);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        }

        Meeting meeting1 = createMeeting("1");
        meeting1.setAttendees(Set.of(employee1, employee2));
        meeting1.setOrganiser(employee1);

        try {
            session.beginTransaction();
            session.saveOrUpdate(meeting1);
            session.getTransaction().commit();
            assertTrue(meeting1.getId() > 0);
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        }
    }

    private Meeting createMeeting(String postfix) {
        Meeting meeting = new Meeting();
        meeting.setSubject("Subject" + postfix);
        meeting.setStatus(Status.NEW);
        meeting.setDateTime(Calendar.getInstance().getTime());
        return meeting;
    }

    @After
    public void tearDown() throws Exception {
        if (session != null && session.isOpen()) {
            session.close();
            session = null;
        }
    }
}