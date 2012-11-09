package se.sogeti.application;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.sql.SQLException;

import org.junit.*;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;

import se.sogeti.dao.CustomerDao;

public class CustomerServiceTest {

    @Spy private CustomerService sut;
    @Mock private CustomerDao customerDao;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
        sut.setCustomerDao(customerDao);
    }

    @Test
    public void testCreateCustomerNo() {
        int customernNo = sut.createCustomerNo();
        assertEquals(1, customernNo);
    }
    
    @Test
    public void testCreateCustomerNoWithFixedStartingPoint() {
       sut.setCustomerNo(200);
       int createCustomerNo = sut.createCustomerNo();
       assertEquals(201, createCustomerNo);
    }

    @Test
    public void testSaveCustomer() throws SQLException {
        sut.setCustomerNo(1);
        
        int customerNo = sut.saveCustomer("Nisse");
        
        verify(customerDao).save(anyString());
        assertEquals(2, customerNo);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testSaveCustomerWithNull() throws SQLException {
        //doReturn(sut.sendToMars(anyString()));
        //stub(sut.sendToMars(anyString())).toReturn(100);
        sut.saveCustomer(null); 
        //when(sut.sendToMars(anyString()));
    }
    
}
