package controllers;

import DTO.LoginResponseDTO;
import DTO.PlaylistDTO;
import DTO.PlaylistsDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import services.PlaylistService;

import java.util.ArrayList;


class PlaylistControllerTest {
     private PlaylistService fakeService;
     private PlaylistsDTO fakePlaylistsDTO;
     private ArrayList<PlaylistDTO> fakePlaylists;
     private LoginResponseDTO fakeLoginResponse;

     @BeforeEach
     public void setup(){
         fakePlaylistsDTO = new PlaylistsDTO();
         fakePlaylists = new ArrayList<>();
         fakeLoginResponse = new LoginResponseDTO();
         fakePlaylists.add(new PlaylistDTO(1, "geen", true));
         fakePlaylists.add(new PlaylistDTO(2, "ditIsEenNaam", true));
         fakePlaylistsDTO.setPlaylists(fakePlaylists);
         fakeLoginResponse.setToken("1234");
     }

     @BeforeEach
     public void setUpMockito(){
         fakeService = Mockito.mock(PlaylistService.class);
         Mockito.when(fakeService.showPlaylists(fakeLoginResponse.getToken())).thenReturn(fakePlaylistsDTO);
     }

     @Test
     public void TestIfPlaylistControllerReturnsCorrectHTTPStatusCode(){
         var sut = new PlaylistController();
         sut.setPlaylistService(fakeService);
         var response = sut.playlists(fakeLoginResponse.getToken());
         Assertions.assertEquals(200, response.getStatus());
     }
}