package by.pvt.dao;

import by.pvt.pojo.Worker;
import org.junit.*;
import org.junit.runners.MethodSorters;

import java.io.Serializable;
import java.math.BigDecimal;

import static org.junit.Assert.*;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class WorkerDaoImplTest {

    private DaoImpl<Worker> workerDao;

    @Before
    public void setUp() {
        workerDao = new DaoImpl<>(Worker.class);
        DaoImpl.isTestInstance = true;
    }

    @Test
    public void step1_createNewWorker() {
        Worker worker = new Worker();
        worker.setCompanyName("CompanyNameDaoTest");
        worker.setPosition("PositionDaoTest");
        worker.setSalary(BigDecimal.valueOf(500.00));
        workerDao.saveOrUpdate(worker);

        assertNotNull(worker.getId());

        workerDao.delete(worker.getId());
        assertNull(workerDao.find(worker.getId()));

        System.out.println("worker ID: " + worker.getId());
    }

    @Test
    public void step2_findWorker() {
        Worker worker = new Worker();
        worker.setCompanyName("CompanyNameDaoTest step2_findWorker");
        workerDao.saveOrUpdate(worker);
        Serializable id = worker.getId();

        Worker testWorker = workerDao.find(id);
        assertNotNull(testWorker);
        assertEquals("CompanyNameDaoTest step2_findWorker", testWorker.getCompanyName());

        workerDao.delete(worker.getId());
        assertNull(workerDao.find(worker.getId()));
    }

    @Test
    public void step3_updateWorker() {
        Worker worker = new Worker();
        worker.setCompanyName("CompanyNameDaoTest step3_updateWorker");
        workerDao.saveOrUpdate(worker);
        Serializable id = worker.getId();

        Worker testWorker = workerDao.load(id);
        assertNotNull(testWorker);
        testWorker.setPosition("PositionDaoTest step3_updateWorker");
        workerDao.saveOrUpdate(testWorker);

        Worker testUpdateWorker = workerDao.load(id);
        assertEquals("PositionDaoTest step3_updateWorker", testUpdateWorker.getPosition());

        workerDao.delete(id);
        assertNull(workerDao.find(id));
    }

    @Test
    public void step4_deleteWorker() {
        Worker worker = new Worker();
        Serializable id = worker.getId();
        workerDao.delete(id);

        assertNull(workerDao.find(id));
    }

    @After
    public void tearDown() {
        DaoImpl.isTestInstance = false;
        workerDao = null;
    }
}
