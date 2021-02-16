package datasource.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class JDBCConnection {
    private static Connection myConn = null;
    private Properties properties;

    public static void main(String[] args) {

    }

    public Connection createDBConnection(){
        properties = new ReadProperties().getProperties();
        try{
            var connectionString = properties.getProperty("url");
            myConn = DriverManager.getConnection(connectionString);
        } catch (SQLException e) {
            System.out.println("Cannot create database connection");
            e.printStackTrace();
        } finally {
            return myConn;
        }
    }
}
