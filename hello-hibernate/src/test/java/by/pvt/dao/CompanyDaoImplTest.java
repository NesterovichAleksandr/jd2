package by.pvt.dao;

import by.pvt.pojo.Address;
import by.pvt.pojo.Company;
import org.junit.*;
import org.junit.runners.*;

import javax.persistence.Id;

import static org.junit.Assert.*;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class CompanyDaoImplTest {

    private DaoImpl<Company> companyDao;

    @Before
    public void setUp() {
        companyDao = new DaoImpl<>(Company.class);
        DaoImpl.isTestInstance = true;

    }

    @Test
    public void saveOrUpdate() {
        Company company = new Company();
        company.setCompanyName("Romashka");
        company.setSiteUrl("www.romashka.by");

        company.setHomeAddress(
                new Address("Minsk", "Lenina", "3a", 4)
        );
        company.setLegalAddress(
                new Address("Minsk", "Stalina", "6", 7)
        );
        Company company1 = companyDao.saveOrUpdate(company);

        assertNotNull(company1);
        assertEquals(company, company1);
        assertEquals(company.getLegalAddress(), company1.getLegalAddress());

        System.out.println("Company ID: " + company1.getId());
    }

    @Ignore
    public void updateAddress() {
        Company company = companyDao.load(3L);
        company.getHomeAddress().setCity("Vitebsk");
        companyDao.saveOrUpdate(company);

        assertEquals("Vitebsk", company.getHomeAddress().getCity());
    }

    @Test
    public void delete() {
        companyDao.delete(companyDao.load(3L).getId());
        assertNull(companyDao.find(3L));
    }

    @After
    public void tearDown() {
        DaoImpl.isTestInstance = false;
        companyDao = null;
    }
}
