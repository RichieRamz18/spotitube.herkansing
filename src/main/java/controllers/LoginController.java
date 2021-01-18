package controllers;

import DTO.LoginRequestDTO;
import DTO.LoginResponseDTO;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/login")
public class LoginController {
    private LoginRequestDTO loginRequestDTO;

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public LoginResponseDTO login(LoginRequestDTO loginRequestDTO){
        loginRequestDTO.setUsername(loginRequestDTO.getUsername());
        loginRequestDTO.setPassword(loginRequestDTO.getPassword());
        if (loginRequestDTO.getUsername().equals("Richane") && loginRequestDTO.getPassword().equals("123")){
            var loginResponseDTO = new LoginResponseDTO();
            loginResponseDTO.setUser(loginRequestDTO.getUsername());
            loginResponseDTO.setToken("12345678");

            return loginResponseDTO;
        }
        else throw new NotAuthorizedException(401);
    }
}
