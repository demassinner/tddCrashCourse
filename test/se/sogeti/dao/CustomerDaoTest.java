package se.sogeti.dao;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class CustomerDaoTest {

    @Mock
    Connection connection;
    @Mock
    private Statement stmt;
    private CustomerDao sut;

    @Before
    public void setup() throws SQLException {
        sut = new CustomerDao();
        MockitoAnnotations.initMocks(this);
        when(connection.createStatement()).thenReturn(stmt);
        sut.setConnection(connection);
    }

    @Test
    public void testCreate() throws Exception {
        sut.setConnection(connection);
        sut.save("kalle");
        verify(connection).createStatement();
        verify(connection).commit();
        verify(stmt).close();
        verify(connection).close();
    }

}
