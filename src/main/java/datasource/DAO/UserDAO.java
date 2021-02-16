package datasource.DAO;

import DTO.LoginRequestDTO;
import DTO.LoginResponseDTO;
import datasource.connection.JDBCConnection;
import datasource.connection.ReadProperties;

import javax.inject.Inject;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDAO {
    private JDBCConnection myJDBCConnection;
    private ReadProperties readProperties;

    @Inject
    public void setMyJDBCConnection(JDBCConnection myJDBCConnection){
        this.myJDBCConnection = myJDBCConnection;
    }

    public LoginResponseDTO getUsernameAndPassword (LoginRequestDTO loginRequestDTO){
        try{
            Connection dbConnection = myJDBCConnection.createDBConnection();
            PreparedStatement preparedStatement = dbConnection.prepareStatement("SELECT * FROM login (username, password)");
            ResultSet resultSet = preparedStatement.executeQuery();

            while(resultSet.next()){
                LoginResponseDTO loginResponseDTO = new LoginResponseDTO();

                String Username = resultSet.getString("username");
                String Password = resultSet.getString("password");

                System.out.format("%s, %s\n",Username, Password);

                return loginResponseDTO;
            }
            preparedStatement.close();
            dbConnection.close();
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        return null;
    }
}
