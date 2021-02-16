package services;

import DTO.LoginRequestDTO;
import DTO.LoginResponseDTO;
import datasource.DAO.UserDAO;

import javax.ws.rs.NotAuthorizedException;
import java.util.UUID;

public class LoginService {
    private UserDAO userDAO;

    public LoginResponseDTO login(LoginRequestDTO loginRequestDTO) {
        if (loginRequestDTO.getUser().equals("Richane") && loginRequestDTO.getPassword().equals("123")) {
            var loginResponseDTO = new LoginResponseDTO();
            loginResponseDTO.setUser(loginRequestDTO.getUser());
            loginResponseDTO.setToken("12345678");
            return loginResponseDTO;
        }
        else throw new NotAuthorizedException(401);
    }

    public String createToken(){
        String token = UUID.randomUUID().toString();
        return "token = " + token;
    }
}

