package by.pvt.pojo;

import by.pvt.util.HibernateUtil;
import org.hibernate.Session;
import org.junit.*;

import static org.junit.Assert.*;

public class BranchTest {

    private Session session;

    @Before
    public void setUp() throws Exception {
        session = HibernateUtil.getInstance().getTestSession();
    }

    @Test
    public void createInstance() {
        Branch branch = new Branch();
        branch.setBranchDirector("Branch Director");
        branch.setBranchName("Branch Name");
        branch.setCompanyName("OOO Vasilek");
        branch.setLegalAddress(new Address("minsk", "Lenina", "21", 1));

        try {
            session.beginTransaction();
            session.saveOrUpdate(branch);
            session.getTransaction().commit();
            assertNotNull(branch.getId());
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