package by.pvt.dao;

import by.pvt.pojo.Employer;
import org.junit.*;
import org.junit.runners.MethodSorters;

import java.io.Serializable;

import static org.junit.Assert.*;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class EmployerDaoImplTest {

    private DaoImpl<Employer> employerDao;

    @Before
    public void setUp() {
        employerDao = new DaoImpl<>(Employer.class);
        DaoImpl.isTestInstance = true;
    }

    @Test
    public void step1_createNewEmployer() {
        Employer employer = new Employer();
        employer.setCompanyTitle("CompanyTitleDaoTest");
        employer.setCorporatePhoneNumber("CorporatePhoneNumberDaoTest");
        employerDao.saveOrUpdate(employer);

        assertNotNull(employer.getId());

        employerDao.delete(employer.getId());
        assertNull(employerDao.find(employer.getId()));

        System.out.println("employer ID: " + employer.getId());
    }

    @Test
    public void step2_findEmployer() {
        Employer employer = new Employer();
        employer.setCompanyTitle("CompanyTitleDaoTest step2_findEmployer");
        employerDao.saveOrUpdate(employer);
        Serializable id = employer.getId();

        Employer testEmployer = employerDao.find(id);
        assertNotNull(testEmployer);
        assertEquals("CompanyTitleDaoTest step2_findEmployer", testEmployer.getCompanyTitle());

        employerDao.delete(employer.getId());
        assertNull(employerDao.find(employer.getId()));
    }

    @Test
    public void step3_updateEmployer() {
        Employer employer = new Employer();
        employer.setCompanyTitle("CompanyTitleDaoTest step3_updateEmployer");
        employerDao.saveOrUpdate(employer);
        Serializable id = employer.getId();

        Employer testEmployer = employerDao.load(id);
        assertNotNull(testEmployer);
        testEmployer.setCorporatePhoneNumber("CorporatePhoneNumberDaoTest step3_updateEmployer");
        employerDao.saveOrUpdate(testEmployer);

        Employer testUpdateEmployer = employerDao.load(id);
        assertEquals("CorporatePhoneNumberDaoTest step3_updateEmployer", testUpdateEmployer.getCorporatePhoneNumber());

        employerDao.delete(id);
        assertNull(employerDao.find(id));
    }

    @Test
    public void step4_deleteEmployer() {
        Employer employer = new Employer();
        Serializable id = employer.getId();
        employerDao.delete(id);

        assertNull(employerDao.find(id));
    }

    @After
    public void tearDown() {
        DaoImpl.isTestInstance = false;
        employerDao = null;
    }
}
