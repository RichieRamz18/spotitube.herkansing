package controllers;

import DTO.PlaylistsDTO;
import services.PlaylistService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/playlists")
public class PlaylistController {
    private PlaylistService playlistService;

    @Inject
    public void setPlaylistService(PlaylistService playlistService){
        this.playlistService = playlistService;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response playlists(@QueryParam("token") String token){
        PlaylistsDTO playlists = playlistService.showPlaylists(token);
        return Response.ok().entity(playlists).build();
    }

}
