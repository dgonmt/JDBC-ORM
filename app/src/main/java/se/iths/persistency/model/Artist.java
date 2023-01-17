package se.iths.persistency.model;

import java.util.ArrayList;
import java.util.Collection;

public class Artist {
    Long artistId;
    String artistName;
    Collection<Album> albums;

    public Artist(String name) {
        this.artistName = name;
    }

    public Artist(Long id, String name) {
        this.artistId = id;
        this.artistName = name;

    }

    public Long getArtistId() {
        return artistId;
    }

    public void setId(Long id) {
        this.artistId = id;
    }

    public String getName() {
        return artistName;
    }

    public void setName(String name) {
        this.artistName = name;
    }

    public Collection<Album> getAlbums() {
        return albums;
    }

    public String test() {
        return albums.toString();
    }

    public void add(Collection<Album> album) {

        albums = albums == null ? new ArrayList<Album>() : albums;

        for (Album a : album) {
            albums.add(a);
        }
    }

    public void remove(Album album) {
        if (albums==null) return;
        albums.remove(album);
    }

    @Override
    public String toString() {

        String returnString = "Artist : " + artistName + " -> Albums : " + albums;


     return returnString;
    }



//    public String toPrintAlbums() {
//        String toReturn = "\n";
//
//        for (Album album : albums) {
//            toReturn += "\t" + album.getAlbumTitle() + "\n";
//        }
//
//        return toReturn;
//    }


}
