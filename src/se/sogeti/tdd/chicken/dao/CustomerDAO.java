package se.sogeti.tdd.chicken.dao;

import java.sql.SQLException;

public interface CustomerDAO {

    void save(String name, int customerNumer) throws SQLException;

}
