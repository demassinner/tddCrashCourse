package se.sogeti.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class CustomerDao {

    private Connection connection;
    
    public void save(final String name) throws SQLException {
        Statement stmt;

        final String sql =
            "INSERT INTO customer "
                + "(number, name) "
                + "VALUES "
                + "("
                + 1
                + ","
                + "('"
                + name
                + "'))";

        stmt = connection.createStatement();
        stmt.executeUpdate(sql);
        connection.commit();
        stmt.close();
        connection.close();
    }


    void setConnection(Connection connection) {
        this.connection = connection;
    }

}
