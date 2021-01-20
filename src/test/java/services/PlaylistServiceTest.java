package services;

import DTO.LoginResponseDTO;
import controllers.LoginController;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.*;

class PlaylistServiceTest {
    private PlaylistService sut;
    private LoginResponseDTO loginResponseDTO;

    @BeforeEach
    public void setup(){
        sut = new PlaylistService();
        loginResponseDTO.setToken("");
    }

}