package datasource.connection;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;

class JDBCConnectionTest {
    private JDBCConnection sut;
    private ReadProperties properties;

    @BeforeEach
    public void setup(){
        this.sut = new JDBCConnection();
        properties = new ReadProperties();
    }

    @Test
    public void testIFConnectionIsCreated(){
        var response = sut.createDBConnection();
        Assertions.assertNotNull(response);
    }


    //Test werkt nog niet. Misschien nog omgeschreven worden, door middel van injection.
    @Test
    public void testIfExceptionIsThrown(){
        var connectionString = properties.getProperties().getProperty("hallo");
        Assertions.assertThrows(SQLException.class, () -> sut.createDBConnection());
    }

}