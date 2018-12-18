package by.pvt.pojo;

import by.pvt.util.HibernateUtil;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.junit.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.Random;

import static org.junit.Assert.*;

public class WorkerTest {

    private Session session;

    @Before
    public void setUp() throws Exception {
        session = HibernateUtil.getInstance().getTestSession();
    }

    @Test
    public void createInstance() {
        Worker worker = createWorker("0");

        try {
            session.beginTransaction();
            session.saveOrUpdate(worker);
            session.getTransaction().commit();
            assertNotNull(worker.getId());
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        }
    }

    @Test
    public void testCriteria() {
        Worker worker1 = createWorker("1");
        Worker worker2 = createWorker("2");
        Worker worker3 = createWorker("3");
        Worker worker4 = createWorker("4");

        try {
            session.beginTransaction();
            session.saveOrUpdate(worker1);
            session.saveOrUpdate(worker2);
            session.saveOrUpdate(worker3);
            session.saveOrUpdate(worker4);
            session.getTransaction().commit();
            assertNotNull(worker1.getId());
            assertNotNull(worker2.getId());
            assertNotNull(worker3.getId());
            assertNotNull(worker4.getId());
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        }
        //session = HibernateUtil.getInstance().getTestSession();

        Criteria criteria = session.createCriteria(Worker.class);
        criteria.add(Restrictions.ge("salary", new BigDecimal(1000.00)));
        List list = criteria.list();
        System.out.println(list);

        criteria = session.createCriteria(Worker.class);
        criteria.setProjection(Projections.rowCount());
        System.out.println(criteria.list());
    }

    private Worker createWorker(String suffix) {
        if (suffix == null) suffix = "";
        Worker worker = new Worker();
        worker.setSalary(BigDecimal.valueOf(500 + Math.random() * 1000.00));
        worker.setName("Worker name" + suffix);
        return worker;
    }

    @After
    public void tearDown() throws Exception {
        if (session != null && session.isOpen()) {
            session.close();
            session = null;
        }
    }
}