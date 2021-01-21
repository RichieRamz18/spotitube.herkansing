package datasource.connection;

import java.io.IOException;
import java.util.Properties;

public class ReadProperties {
    private Properties properties;

    public ReadProperties(){
        properties = new Properties();
        properties.getProperty("db_name");

        try{
            properties.load(getClass().getClassLoader().getResourceAsStream("database.properties"));
            Class.forName(properties.getProperty("driver"));
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public Properties getProperties(){
        return properties;
    }
}
