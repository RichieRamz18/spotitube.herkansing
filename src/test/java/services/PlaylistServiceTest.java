package services;

import DTO.LoginResponseDTO;
import DTO.PlaylistDTO;
import DTO.PlaylistsDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.ws.rs.NotAuthorizedException;
import java.util.ArrayList;

class PlaylistServiceTest {
    private PlaylistService sut;
    private LoginResponseDTO loginResponseDTO;
    private PlaylistsDTO collectionOfPlaylists;
    private ArrayList<PlaylistDTO> playlists;

    @BeforeEach
    public void setup(){
        sut = new PlaylistService();
        loginResponseDTO = new LoginResponseDTO();
        collectionOfPlaylists = new PlaylistsDTO();
        playlists = new ArrayList<>();
        playlists.add(new PlaylistDTO(1, "SummerVibes", true));
        playlists.add(new PlaylistDTO(2, "TestingIfThisWorks", true));
    }

    //Test doet het voor nu niet, maar kan later worden omgeschreven wanneer database in het spel is.
    @Test
    public void TestIfCorrectTokenReturnsPlaylistsDTO(){
        loginResponseDTO.setToken("12345678");
        collectionOfPlaylists.setLength(1000);
        collectionOfPlaylists.setPlaylists(playlists);
        var response = sut.showPlaylists(loginResponseDTO.getToken());
        Assertions.assertEquals(collectionOfPlaylists, response.getPlaylists());
    }

    @Test
    public void TestIfIncorrectTokenReturnsNotAuthorizedException(){
        loginResponseDTO.setToken("1234");
        Assertions.assertThrows(NotAuthorizedException.class, () -> sut.showPlaylists(loginResponseDTO.getToken()));
    }

}