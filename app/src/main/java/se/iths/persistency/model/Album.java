package se.iths.persistency.model;

import java.util.ArrayList;
import java.util.Collection;

public class Album {
    Long albumId;
    String albumTitle;
    Long artistId;

    Collection<Track> tracks;

    public Album(Long albumId, String albumTitle, Long artistId) {
        this.albumId = albumId;
        this.albumTitle = albumTitle;
        this.artistId = artistId;
    }

    public Long getAlbumId() {
        return albumId;
    }

    public void setAlbumId(Long albumId) {
        this.albumId = albumId;
    }

    public String getAlbumTitle() {
        return albumTitle;
    }

    public void setAlbumTitle(String albumTitle) {
        this.albumTitle = albumTitle;
    }
    public Long getArtistId() {return this.artistId;}
    public void setArtistId(Long artistId) {this.artistId = artistId;}

    @Override
    public String toString() {
        return albumTitle + " -> Tracks : " +  tracks;
    }

    public void add(Collection<Track> track) {

        tracks = tracks == null ? new ArrayList<Track>() : tracks;

        for (Track t : track) {
            tracks.add(t);
        }
    }










}
