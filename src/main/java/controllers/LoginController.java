package controllers;

import DTO.LoginRequestDTO;
import DTO.LoginResponseDTO;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/login")
public class LoginController {
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public LoginResponseDTO login(LoginRequestDTO loginRequestDTO){
        if (loginRequestDTO.getUser().equals("Richane") && loginRequestDTO.getPassword().equals("123")){
            var loginResponseDTO = new LoginResponseDTO();
            loginResponseDTO.setUser(loginRequestDTO.getUser());
            loginResponseDTO.setToken("12345678");
            return loginResponseDTO;
        }
        else throw new NotAuthorizedException(401);
    }
}
