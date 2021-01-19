package DTO;

import java.util.ArrayList;

public class PlaylistsDTO {
    private int length;
    private ArrayList<PlaylistDTO> playlists;

    public ArrayList<PlaylistDTO> getPlaylists() {
        return playlists;
    }

    public void setPlaylists(ArrayList<PlaylistDTO> playlists) {
        this.playlists = playlists;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }




}
