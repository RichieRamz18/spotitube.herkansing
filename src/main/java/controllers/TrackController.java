package controllers;

import DTO.TrackDTO;
import DTO.TracksDTO;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;

@Path("/")
public class TrackController {

//    @GET
//    @Path("tracks")
//    @Produces(MediaType.APPLICATION_JSON)
//    public TracksDTO tracks(@QueryParam("forPlaylist") int forPlaylist, @QueryParam("token") String token){
//        if (token.equals("12345678") && forPlaylist == 1){
//            TracksDTO tracksCollection = new TracksDTO();
//            ArrayList<TrackDTO> tracks = new ArrayList<>();
//            tracks.add(new TrackDTO(1, "Bad", "Michael Jackson", 345, "Bad", 5, "0601998", "none", true));
//            tracks.add(new TrackDTO(2, "HelloWorld", "Beyonce", 546, "Lemonade", 46, "18021997", "none", true));
//            tracksCollection.setTracks(tracks);
//            return tracksCollection;
//        }
//        else throw new NotAuthorizedException(400);
//    }


    @GET
    @Path("playlists/{id}/tracks")
    @Produces(MediaType.APPLICATION_JSON)
    public TracksDTO getTracksFromPlaylist(@PathParam("id") int playlistID, @QueryParam("token") String token){
        if (token.equals("12345678") && playlistID == 1) {
            TracksDTO tracksCollection = new TracksDTO();
            ArrayList<TrackDTO> tracks = new ArrayList<>();
            tracks.add(new TrackDTO(1, "Bad", "Michael Jackson", 345, "Bad", 5, "0601998", "none", true));
            tracks.add(new TrackDTO(2, "HelloWorld", "Beyonce", 546, "Lemonade", 46, "18021997", "none", true));
            tracksCollection.setTracks(tracks);
            return tracksCollection;
        }
        else throw new NotAuthorizedException(400);
    }
}
