package DTO;

import java.util.ArrayList;

public class PlaylistDTO {
    private int id;
    private String name;
    private boolean owner;
    private ArrayList<TracksDTO> tracks;

    public PlaylistDTO(int id, String name, boolean owner, ArrayList<TracksDTO> tracks){
        this.id = id;
        this.name = name;
        this.owner = owner;
        this.tracks = tracks;
    }

    public PlaylistDTO(int id, String name, boolean owner){
        this.id = id;
        this.name = name;
        this.owner = owner;
    }

    public PlaylistDTO(){}


    public ArrayList<TracksDTO> getTracks() {
        return tracks;
    }

    public void setTracks(ArrayList<TracksDTO> tracks) {
        this.tracks = tracks;
    }

    public boolean isOwner() {
        return owner;
    }

    public void setOwner(boolean owner) {
        this.owner = owner;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
