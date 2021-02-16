package services;

import DTO.LoginRequestDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.ws.rs.NotAuthorizedException;


class LoginServiceTest {
    private LoginService sut;
    private LoginRequestDTO loginRequestDTO;

    @BeforeEach
    public void setup(){
        sut = new LoginService();
        loginRequestDTO = new LoginRequestDTO();
    }

    @Test
    public void TestIfLoginRequestReturnsCorrectToken(){
        loginRequestDTO.setUser("Richane");
        loginRequestDTO.setPassword("123");

        var response = sut.login(loginRequestDTO);

        Assertions.assertEquals("12345678", response.getToken());
    }

    @Test
    public void TestIfLoginRequestReturnsCorrectUser(){
        loginRequestDTO.setUser("Richane");
        loginRequestDTO.setPassword("123");

        var response = sut.login(loginRequestDTO);

        Assertions.assertEquals("Richane", response.getUser());
    }

    @Test
    public void TestIfIncorrectLoginRequestReturnsNotAuthorizedException(){
        loginRequestDTO.setUser("Trishna");
        loginRequestDTO.setPassword("456");

        Assertions.assertThrows(NotAuthorizedException.class, () -> sut.login(loginRequestDTO));
    }

    @Test
    public void TestCreateTokenData(){
        //Act
        var token = sut.createToken();
        //Assert
        Assertions.assertTrue(token.contains("token ="));
    }

    @Test
    public void TestIfTokenIsAStringType(){
        //Act
        var token = sut.createToken();
        //Assert
        Assertions.assertTrue(token instanceof String);
    }
}