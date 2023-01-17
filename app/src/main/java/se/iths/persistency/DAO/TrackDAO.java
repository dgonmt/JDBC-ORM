package se.iths.persistency.DAO;

import se.iths.persistency.util.CRUDInterface;
import se.iths.persistency.util.ConnectToDB;
import se.iths.persistency.model.Track;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;

public class TrackDAO implements CRUDInterface {
    @Override
    public Collection<Track> findAll() throws SQLException {
        Collection<Track> tracks = new ArrayList<>();



        Connection con = ConnectToDB.getConnection();

        String sql = "SELECT * FROM Track;";

        Statement st = con.createStatement();

        ResultSet rs = st.executeQuery(sql);


        while(rs.next()) {
            Long trackId = rs.getLong("TrackId");
            String trackName = rs.getString("Name");
            Long albumId = rs.getLong("AlbumId");



            tracks.add(new Track(trackId, trackName, albumId));


        }








        ConnectToDB.closeResultSet(rs);
        ConnectToDB.closeStatement(st);
        ConnectToDB.closeConnection(con);




        return tracks;
    }

    @Override
    public Object findById(Long id) throws SQLException {
        return null;
    }

    @Override
    public Object create(Object object) throws SQLException {
        return null;
    }

    @Override
    public Object update(Object object, Long id) throws SQLException {
        return null;
    }

    @Override
    public boolean delete(Object object) throws SQLException {
        return false;
    }

    public Collection<Track> findByAlbumId(Long albumId) throws SQLException {

        Collection<Track> result = new ArrayList<>();

        Connection con = ConnectToDB.getConnection();

        String sql = "SELECT TrackId, Name, AlbumId FROM Track WHERE AlbumId = ?";

        PreparedStatement ps = con.prepareStatement(sql);
        ps.setLong(1, albumId);
        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            Long rsTrackId = rs.getLong("TrackId");
            String rsName = rs.getString("Name");
            Long rsAlbumId = rs.getLong("AlbumId");
            result.add(new Track(rsTrackId, rsName, rsAlbumId));
        }

        ConnectToDB.closeResultSet(rs);
        ConnectToDB.closePreparedStatement(ps);
        ConnectToDB.closeConnection(con);




        return result;

    }

}
