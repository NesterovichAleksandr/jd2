package by.pvt.dao;

import by.pvt.pojo.Branch;
import org.junit.*;
import org.junit.runners.MethodSorters;

import static org.junit.Assert.*;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class BranchDaoImplTest {

    private DaoImpl<Branch> branchDao;

    @Before
    public void setUp() {
        branchDao = new DaoImpl<>(Branch.class);
        DaoImpl.isTestInstance = true;
    }

    @Test
    public void step1_createNewBranch() {
        Branch branch = new Branch();
        branch.setBranchName("BranchNameDaoTest");
        branchDao.saveOrUpdate(branch);

        assertTrue(branch.getId() > 0);

        System.out.println("branch id: " + branch.getId());
    }

    @Test
    public void step2_findBranch() {
        assertNotNull(branchDao.find(2L));
    }

    @Test
    public void step3_updateBranch() {
        Branch branch = branchDao.load(2L);
        assertEquals("BranchNameDaoTest", branch.getBranchName());

        branch.setBranchDirector("BranchDirectorDaoTest");
        branchDao.saveOrUpdate(branch);

        Branch testBranch = branchDao.load(2L);
        assertEquals("BranchDirectorDaoTest", testBranch.getBranchDirector());

    }

    @Test
    public void step4_deleteBranch() {
        branchDao.delete(2L);
        assertNull(branchDao.find(2L));
    }

    @After
    public void tearDown() {
        DaoImpl.isTestInstance = false;
        branchDao = null;
    }
}
