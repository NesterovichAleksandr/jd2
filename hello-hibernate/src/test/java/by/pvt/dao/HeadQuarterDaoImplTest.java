package by.pvt.dao;

import by.pvt.pojo.HeadQuarter;
import org.junit.*;
import org.junit.runners.MethodSorters;

import static org.junit.Assert.*;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class HeadQuarterDaoImplTest {

    private DaoImpl<HeadQuarter> headQuarterDao;

    @Before
    public void setUp() {
        headQuarterDao = new DaoImpl<>(HeadQuarter.class);
        DaoImpl.isTestInstance = true;
    }

    @Test
    public void step1_createNewHeadQuarter() {
        HeadQuarter headQuarter = new HeadQuarter();
        headQuarter.setDirectorName("DirectorNameDaoTest");
        headQuarter.setBankAccount("BankAccountDaoTest");
        headQuarterDao.saveOrUpdate(headQuarter);

        assertTrue(headQuarter.getId() > 0);

        System.out.println("headQuarter ID: " + headQuarter.getId());
    }

    @Test
    public void step2_findHeadQuarter() {
        assertNotNull(headQuarterDao.find(3L));
    }

    @Test
    public void step3_updateHeadQuarter() {
        HeadQuarter testHeadQuarter = headQuarterDao.load(3L);
        assertNotNull(testHeadQuarter);
        testHeadQuarter.setBankAccount("New BankAccountDaoTest");
        headQuarterDao.saveOrUpdate(testHeadQuarter);

        HeadQuarter testUpdateHeadQuarter = headQuarterDao.load(3L);
        assertEquals("New BankAccountDaoTest", testUpdateHeadQuarter.getBankAccount());
    }

    @Test
    public void step4_deleteHeadQuarter() {
        headQuarterDao.delete(3L);
        assertNull(headQuarterDao.find(3L));
    }

    @After
    public void tearDown() {
        DaoImpl.isTestInstance = false;
        headQuarterDao = null;
    }
}
