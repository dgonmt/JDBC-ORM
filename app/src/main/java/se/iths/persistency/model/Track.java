package se.iths.persistency.model;

public class Track {

    Long trackId;
    String trackName;
    Long albumId;

    public Track(Long trackId, String trackName, Long albumId) {
        this.trackId = trackId;
        this.trackName = trackName;
        this.albumId = albumId;
    }

    public Long getTrackId() {
        return trackId;
    }

    public void setTrackId(Long trackId) {
        this.trackId = trackId;
    }

    public String getTrackName() {
        return trackName;
    }

    public void setTrackName(String trackName) {
        this.trackName = trackName;
    }

    public Long getAlbumId() {
        return albumId;
    }

    public void setAlbumId(Long albumId) {
        this.albumId = albumId;
    }

    public String toString() {
        return this.trackName;
    }




}
