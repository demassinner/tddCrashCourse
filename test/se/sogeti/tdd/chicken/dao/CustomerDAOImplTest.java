package se.sogeti.tdd.chicken.dao;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLDataException;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;

import com.sun.net.httpserver.Authenticator.Success;

public class CustomerDAOImplTest {

    Connection c;
    CustomerDAO sut;

    @Before
    public void setUp() throws SQLException {
        c = DriverManager.getConnection("jdbc:hsqldb:mem:tests", "SA", "");
        sut = new CustomerDAOImpl(c);

        try {
            final Statement st = c.createStatement();
            final String table =
                "CREATE TABLE customer(number integer, name varchar(10))";
            st.executeUpdate(table);
        } catch (final SQLException s) {
            System.out.println("Table all ready exists!");
        }

    }

    @Test
    public void testInsert() throws Exception {
        sut.save("Nisse", 1);
        assertTrue(true);
    }

    @Test(expected = SQLDataException.class)
    public void testInsertTooLong() throws Exception {
        sut.save("Lorum ipsum dolor amet", 1);
        assertTrue(true);
    }

    @Test
    public void testGet() throws Exception {
        sut.save("Nisse", 1);
        final Statement stmt = c.createStatement();
        final ResultSet rs =
            stmt.executeQuery("SELECT number, name FROM customer WHERE number = 1");
        assertTrue(rs.next());
        rs.close();
        assertTrue(true);
    }

    @After
    public void cleanUp() throws SQLException {
        final Statement st = c.createStatement();
        final String table = "drop table customer";
        st.executeUpdate(table);
        c.commit();
        c.close();
    }

}
