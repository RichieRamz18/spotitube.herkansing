package datasource.connection;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

class ReadPropertiesTest {
    private ReadProperties sut;

    @BeforeEach
    void setSut(){
        sut = new ReadProperties();
    }

    @Test
    void getProperties() {
        var properties = sut.getProperties();
        Assertions.assertEquals("1234", properties.getProperty("password"));
    }

    //Test werkt niet
    @Test
    void testIfExceptionIsThrown(){
        Assertions.assertThrows(IOException.class, () -> sut.getProperties().getProperty("hallo"));
    }
}