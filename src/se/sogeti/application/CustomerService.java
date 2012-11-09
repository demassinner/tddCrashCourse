package se.sogeti.application;

import java.sql.SQLException;

import se.sogeti.dao.CustomerDao;
import se.sogeti.tdd.chicken.dao.EvilDAO;

public class CustomerService {

    private int customerNo = 0;
    private CustomerDao customerDao;
    private EvilDAO evilDAO;
    
    public void setCustomerDao(CustomerDao customerDao) {
        this.customerDao = customerDao;
    }

    void setCustomerNo(int customerNo) {
        this.customerNo = customerNo;
    }

    public int createCustomerNo() {
        return ++customerNo;
    }

    public int saveCustomer(String customerName) throws SQLException {
        
        if (customerName == null) {
            throw new IllegalArgumentException("Dö, man kan inte spara en kund med nul i namnet!");
        }
        
        customerDao.save(customerName);
        
        //sendToMars(customerName);
        
        return createCustomerNo();
    }

    int sendToMars(String customerName) {
        evilDAO.sendToMars(customerName);
        return 0;
    }

}
