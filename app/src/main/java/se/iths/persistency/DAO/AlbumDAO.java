package se.iths.persistency.DAO;

import se.iths.persistency.util.CRUDInterface;
import se.iths.persistency.util.ConnectToDB;
import se.iths.persistency.model.Album;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;

public class AlbumDAO implements CRUDInterface<Album> {

    Connection con = null;

    @Override
    public Collection<Album> findAll() throws SQLException {

        Collection<Album> albums = new ArrayList<>();

        TrackDAO trackDao = new TrackDAO();


        Connection con = ConnectToDB.getConnection();

        String sql = "SELECT * FROM Album";

        Statement st = con.createStatement();

        ResultSet rs = st.executeQuery(sql);


        while (rs.next()) {
            Long albumId = rs.getLong("AlbumId");
            String albumTitle = rs.getString("Title");
            Long artistId = rs.getLong("ArtistId");


            albums.add(new Album(albumId, albumTitle, artistId));


        }



        for (Album album : albums) {

            if (trackDao.findByAlbumId(album.getAlbumId()).size() > 0) {
                album.add(trackDao.findByAlbumId(album.getAlbumId()));

            }
        }



        ConnectToDB.closeResultSet(rs);
        ConnectToDB.closeStatement(st);
        ConnectToDB.closeConnection(con);


        return albums;
    }

    @Override
    public Album findById(Long id) {
        return null;
    }

    @Override
    public Album create(Album object) {
        return null;
    }

    @Override
    public Album update(Album object, Long id) {
        return null;
    }

    @Override
    public boolean delete(Album object) {
        return false;
    }

    public Collection<Album> findByArtistId(Long artistId) throws SQLException {

        Collection<Album> result = new ArrayList<>();

        TrackDAO trackDAO = new TrackDAO();

        Connection con = ConnectToDB.getConnection();

        String sql = "SELECT * FROM Album WHERE ArtistId = ?";

        PreparedStatement ps = con.prepareStatement(sql);
        ps.setLong(1, artistId);
        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            Long rsAlbumId = rs.getLong("AlbumId");
            String rsTitle = rs.getString("Title");
            Long rsArtistId = rs.getLong("ArtistId");
            result.add(new Album(rsAlbumId, rsTitle, rsArtistId));
        }

        ConnectToDB.closeResultSet(rs);
        ConnectToDB.closePreparedStatement(ps);
        ConnectToDB.closeConnection(con);


        for (Album album : result) {

            if (trackDAO.findByAlbumId(album.getAlbumId()).size() > 0) {
                album.add(trackDAO.findByAlbumId(album.getAlbumId()));

            }
        }






        return result;
    }
}
