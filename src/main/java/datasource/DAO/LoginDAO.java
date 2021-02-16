package datasource.DAO;

import datasource.connection.JDBCConnection;
import datasource.connection.ReadProperties;

import javax.inject.Inject;

public class LoginDAO {
    private JDBCConnection myJDBCConnection;
    private ReadProperties readProperties;

    @Inject
    public void setMyJDBCConnection(JDBCConnection myJDBCConnection){
        this.myJDBCConnection = myJDBCConnection;
    }
}
