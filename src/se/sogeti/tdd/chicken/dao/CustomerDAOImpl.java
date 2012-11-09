package se.sogeti.tdd.chicken.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class CustomerDAOImpl implements CustomerDAO {

    Connection c;

    public CustomerDAOImpl(final Connection c) {
        super();
        this.c = c;
    }

    @Override
    public void save(final String name, final int customerNumber)
            throws SQLException {
        Statement stmt;

        final String sql =
            "INSERT INTO customer "
                + "(number, name) "
                + "VALUES "
                + "("
                + customerNumber
                + ","
                + "('"
                + name
                + "'))";

        stmt = c.createStatement();
        stmt.executeUpdate(sql);
        c.commit();
        stmt.close();
    }

}
