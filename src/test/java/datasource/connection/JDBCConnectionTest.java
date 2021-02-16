package datasource.connection;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;


class JDBCConnectionTest {
    private JDBCConnection sut;
    private Properties properties;

    @BeforeEach
    public void setup(){
        sut = new JDBCConnection();
        properties = new ReadProperties().getProperties();
    }

    @Test
    public void testIFConnectionIsCreated(){


    }

}