package by.pvt.pojo;

import by.pvt.dao.DaoImpl;
import by.pvt.util.HibernateUtil;
import org.hibernate.Session;
import org.junit.*;

import java.io.Serializable;

import static org.junit.Assert.*;

public class StudentTest {

    private Session session;
    private DaoImpl<Student> studentDao;

    @Before
    public void setUp() throws Exception {
        session = HibernateUtil.getInstance().getTestSession();
    }

    @Test
    public void createInstance() {
        Student student = new Student();
        student.setName("Shurik");
        student.setSecondName("Shurik2");
        student.setUniversity("BNTU");
        student.setFaculty("FTK");
        student.setCourseYear((short) 3);

        try {
            session.beginTransaction();
            session.saveOrUpdate(student);
            session.getTransaction().commit();
            assertNotNull(student.getId());
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        }
    }

    @Test
    public void updateStudent() {
        Student student = new Student();
        student.setName("Alex");
        student.setSecondName("Jobs");
        student.setUniversity("BNTU");
        student.setFaculty("SF");

        try {
            session.beginTransaction();
            session.saveOrUpdate(student);
            session.getTransaction().commit();
            assertNotNull(student.getId());
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        }

        student.setFaculty("ATF");
        session.saveOrUpdate(student);




    }

    @After
    public void tearDown() throws Exception {
        if (session != null && session.isOpen()) {
            session.close();
            session = null;
        }
    }
}