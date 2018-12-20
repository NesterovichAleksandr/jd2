package by.pvt.dao;

import by.pvt.pojo.Address;
import org.junit.*;
import org.junit.runners.MethodSorters;

import static org.junit.Assert.*;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class AddressDaoImplTest {

    private DaoImpl<Address> addressDao;

    @Before
    public void setUp() {
        addressDao = new DaoImpl<>(Address.class);
        DaoImpl.isTestInstance = true;
    }

    @Test
    public void step1_createNewAddress() {
        Address address = new Address(
                "CityDaoTest",
                "StreetDaoTest",
                "51",
                20);

        addressDao.saveOrUpdate(address);
        assertTrue(address.getId() > 0);

        System.out.println("address id: " + address.getId());
    }

    @Test
    public void step2_findAddress() {
        assertNotNull(addressDao.find(1L));
    }

    @Test
    public void step3_updateAddress() {
        Address address = addressDao.load(1L);
        assertEquals("51", address.getHouseNumber());

        address.setHouseNumber("10");
        addressDao.saveOrUpdate(address);

        Address testAddress = addressDao.load(1L);
        assertEquals("10", testAddress.getHouseNumber());
    }

    @Test
    public void step4_deleteAddress() {
        addressDao.delete(1L);
        assertNull(addressDao.find(1L));
    }

    @After
    public void tearDown() {
        DaoImpl.isTestInstance = false;
        addressDao = null;
    }
}
