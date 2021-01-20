package controllers;

import DTO.LoginRequestDTO;
import DTO.LoginResponseDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import services.LoginService;

class LoginControllerTest {
    private LoginRequestDTO fakeloginRequestDTO;
    private LoginResponseDTO fakeloginResponseDTO;
    private LoginService fakeService;
    private static final int HTTP_STATUS_CODE_OK = 200;

    @BeforeEach
    public void setup(){
        fakeloginRequestDTO = new LoginRequestDTO();
        fakeloginRequestDTO.setUser("Richane");
        fakeloginRequestDTO.setPassword("456");
        fakeloginResponseDTO = new LoginResponseDTO();
        fakeloginResponseDTO.setToken("AllemaalCijfers");
        fakeloginResponseDTO.setUser("Richane");
    }

    @BeforeEach
    public void setupMockito(){
        fakeService = Mockito.mock(LoginService.class);
        Mockito.when(fakeService.login(fakeloginRequestDTO)).thenReturn(fakeloginResponseDTO);
    }

    @Test
    void testIfLoginControllerReturnsCorrectHTTPStatusCode() {
        var sut = new LoginController();
        sut.setLoginService(fakeService);

        var response = sut.login(fakeloginRequestDTO);
        Assertions.assertEquals(HTTP_STATUS_CODE_OK, response.getStatus());
    }
}