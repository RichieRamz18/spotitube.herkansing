package controllers;


import DTO.PlaylistDTO;
import DTO.PlaylistsDTO;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.List;

@Path("/playlists")
public class PlaylistController {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public PlaylistsDTO showPlaylists(@QueryParam("token") String token){
        if(token.equals("12345678")) {
            PlaylistsDTO collectionOfPlaylists = new PlaylistsDTO();
            collectionOfPlaylists.setLength(1000);
            ArrayList<PlaylistDTO> playlists = new ArrayList<>();
            playlists.add(new PlaylistDTO(1, "hallo", true));
            playlists.add(new PlaylistDTO(2, "HelloMyFriend", true));

            collectionOfPlaylists.setPlaylists(playlists);
            return collectionOfPlaylists;
        }
        else throw new NotAuthorizedException(400);
    }

}
