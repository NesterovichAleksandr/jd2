package by.pvt.dao;

import by.pvt.pojo.Student;
import org.junit.*;
import org.junit.runners.MethodSorters;

import java.io.Serializable;

import static org.junit.Assert.*;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class StudentDaoImplTest {

    private DaoImpl<Student> studentDao;

    @Before
    public void setUp() {
        studentDao = new DaoImpl<>(Student.class);
        DaoImpl.isTestInstance = true;
    }

    @Test
    public void step1_createNewStudent() {
        Student student = new Student();
        student.setUniversity("UniversityDaoTest");
        student.setFaculty("FacultyDaoTest");
        student.setCourseYear((short) 3);
        studentDao.saveOrUpdate(student);

        assertNotNull(student.getId());

        studentDao.delete(student.getId());
        assertNull(studentDao.find(student.getId()));
    }

    @Test
    public void step2_findStudent() {
        Student student = new Student();
        student.setUniversity("UniversityDaoTest step2_findStudent");
        studentDao.saveOrUpdate(student);
        Serializable id = student.getId();

        Student testStudent = studentDao.find(id);
        assertNotNull(testStudent);
        assertEquals("UniversityDaoTest step2_findStudent", testStudent.getUniversity());

        studentDao.delete(student.getId());
        assertNull(studentDao.find(student.getId()));
    }

    @Test
    public void step3_updateStudent() {
        Student student = new Student();
        student.setUniversity("UniversityDaoTest step3_updateStudent");
        studentDao.saveOrUpdate(student);
        Serializable id = student.getId();

        Student testStudent = studentDao.load(id);
        assertNotNull(testStudent);
        testStudent.setFaculty("FacultyDaoTest step3_updateStudent");
        studentDao.saveOrUpdate(testStudent);

        Student testUpdateStudent = studentDao.load(id);
        assertEquals("FacultyDaoTest step3_updateStudent", testUpdateStudent.getFaculty());

        studentDao.delete(id);
        assertNull(studentDao.find(id));
    }

    @Test
    public void step4_deleteStudent() {
        Student student = new Student();
        Serializable id = student.getId();
        studentDao.delete(id);

        assertNull(studentDao.find(id));
    }

    @After
    public void tearDown() {
        DaoImpl.isTestInstance = false;
        studentDao = null;
    }
}
