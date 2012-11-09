package se.sogeti.tdd.chicken.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import se.sogeti.tdd.chicken.dao.CustomerDAO;

public class CustomerServiceTest {

    private CustomerService sut;
    private CustomerDAO daoMock;

    @Before
    public void setUp() {
        sut = new CustomerService();
        daoMock = Mockito.mock(CustomerDAO.class);
        sut.setCustomerServiceDAO(daoMock);
    }

    @Test
    public void testGenerateCustomerNumber() throws Exception {
        assertEquals(1, sut.generateCustomerNumber());
        assertEquals(2, sut.generateCustomerNumber());
    }

    @Test
    public void testGenerateCustomerWithSpecefiedStartingPoint()
            throws Exception {
        // isolation
        // sut
        sut.startingPoint = 200;
        assertEquals(201, sut.generateCustomerNumber());
        assertEquals(202, sut.generateCustomerNumber());
    }

    @Test
    public void testSave() throws Exception {
        // verify behavior
        sut.save("Demas");

        verify(daoMock).save("Demas", 1);
        verify(daoMock).save("Demas", 1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSaveGeneratesExceptionOnEmpty() throws Exception {
        sut.save("");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSaveGeneratesExceptionOnNull() throws Exception {
        sut.save(null);
    }

}
