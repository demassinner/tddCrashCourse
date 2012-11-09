package se.sogeti.tdd.chicken.service;

import java.sql.SQLException;

import se.sogeti.tdd.chicken.dao.CustomerDAO;

public class CustomerService {

    protected int startingPoint = 0;

    private CustomerDAO customerServiceDAO;

    public int generateCustomerNumber() {
        return ++startingPoint;
    }

    public void save(final String name) {
        if (name == null || "".equals(name)) {
            throw new IllegalArgumentException(
                    "Trying to save customer without a name");
        }
        try {
            customerServiceDAO.save(name, generateCustomerNumber());
        } catch (final SQLException e) {
            throw new IllegalArgumentException("Boom! U are dead.", e);
        }
    }

    public void setCustomerServiceDAO(final CustomerDAO customerServiceDAO) {
        this.customerServiceDAO = customerServiceDAO;
    }

}
