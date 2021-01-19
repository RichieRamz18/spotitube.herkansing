package services;

import DTO.PlaylistDTO;
import DTO.PlaylistsDTO;

import javax.ws.rs.NotAuthorizedException;
import javax.ws.rs.QueryParam;
import java.util.ArrayList;

public class PlaylistService {
    public PlaylistsDTO showPlaylists(String token){
        if(token.equals("12345678")) {
            PlaylistsDTO collectionOfPlaylists = new PlaylistsDTO();
            collectionOfPlaylists.setLength(1000);
            ArrayList<PlaylistDTO> playlists = new ArrayList<>();
            playlists.add(new PlaylistDTO(1, "SummerVibes", true));
            playlists.add(new PlaylistDTO(2, "TestingIfThisWorks", true));

            collectionOfPlaylists.setPlaylists(playlists);
            return collectionOfPlaylists;
        }
        else throw new NotAuthorizedException(400);
    }
}
