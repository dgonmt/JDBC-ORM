package se.iths.persistency.DAO;

import se.iths.persistency.util.CRUDInterface;
import se.iths.persistency.util.ConnectToDB;
import se.iths.persistency.model.Artist;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;

public class ArtistDAO implements CRUDInterface<Artist> {

    @Override
    public Collection<Artist> findAll() throws SQLException {

        Collection<Artist> artists = new ArrayList<>();
        AlbumDAO albumDao = new AlbumDAO();
        Connection con = ConnectToDB.getConnection();
        String sql = "SELECT * FROM Artist;";
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(sql);

        while(rs.next()) {
            Long artistId = rs.getLong("ArtistId");
            String artistName = rs.getString("Name");

            artists.add(new Artist(artistId, artistName));
        }

        for (Artist artist : artists)  {

            if (albumDao.findByParent(artist.getArtistId()).size() > 0) {
                artist.add(albumDao.findByParent(artist.getArtistId()));

            }
        }

        ConnectToDB.closeResultSet(rs);
        ConnectToDB.closeStatement(st);
        ConnectToDB.closeConnection(con);

        return artists;
    }

    @Override
    public Artist findById(Long id) throws SQLException {

        Artist artist = null;
        Connection con = ConnectToDB.getConnection();
        String sql = "SELECT * FROM Artist WHERE ArtistId = ?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setLong(1, id);
        ResultSet rs = ps.executeQuery();

        if (rs.next()) {
            Long resultId = rs.getLong("ArtistId");
            String resultName = rs.getString("Name");
            artist = new Artist(resultId, resultName);
        }

        ConnectToDB.closeResultSet(rs);
        ConnectToDB.closePreparedStatement(ps);
        ConnectToDB.closeConnection(con);

        return artist;
    }

    @Override
    public Artist create(Artist object) throws SQLException {

        Connection con = ConnectToDB.getConnection();
        String sql_insert = "INSERT INTO Artist (Name) VALUES (?)";
        PreparedStatement ps = con.prepareStatement(sql_insert);
        ps.setString(1, object.getName());
        ps.execute();
        Collection<Artist> result = findAll();
        Integer idOfLastObject_int =  result.size();
        Long idOfLastObject_long = idOfLastObject_int.longValue();

        ConnectToDB.closePreparedStatement(ps);
        ConnectToDB.closeConnection(con);

        return findById(idOfLastObject_long);
    }

    @Override
    public Artist update(Artist object, Long id) throws SQLException {

        Connection con = ConnectToDB.getConnection();
        String sql_update = "UPDATE Artist SET Name = ? WHERE ArtistId = ?";
        PreparedStatement ps = con.prepareStatement(sql_update);
        ps.setString(1, object.getName());
        ps.setLong(2, id);
        ps.execute();

        ConnectToDB.closePreparedStatement(ps);
        ConnectToDB.closeConnection(con);

        return null;
    }

    @Override
    public boolean delete(Artist object) throws SQLException {

        Connection con = ConnectToDB.getConnection();
        String sql_delete = "DELETE FROM Artist WHERE Name LIKE(?)";
        PreparedStatement ps = con.prepareStatement(sql_delete);
        ps.setString(1, object.getName());
        ps.execute();

        ConnectToDB.closePreparedStatement(ps);
        ConnectToDB.closeConnection(con);

        return false;
    }

}
