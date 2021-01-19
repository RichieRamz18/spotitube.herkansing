package controllers;

import DTO.LoginRequestDTO;
import DTO.LoginResponseDTO;
import services.LoginService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/login")
public class LoginController {
    private LoginService loginService;

    @Inject
    public void setLoginService(LoginService loginService){
        this.loginService = loginService;
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response login(LoginRequestDTO loginRequestDTO){
        LoginResponseDTO loginResponseDTO = loginService.login(loginRequestDTO);
        return Response.ok().entity(loginResponseDTO).build();
    }
}
