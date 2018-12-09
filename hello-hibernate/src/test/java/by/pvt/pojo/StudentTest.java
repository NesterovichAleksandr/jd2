package by.pvt.pojo;

import by.pvt.util.HibernateUtil;
import org.hibernate.Session;
import org.junit.*;

import static org.junit.Assert.*;

public class StudentTest {

    private Session session;

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

    @After
    public void tearDown() throws Exception {
        if (session != null && session.isOpen()) {
            session.close();
            session = null;
        }
    }
}