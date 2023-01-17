package se.iths;


import se.iths.persistency.DAO.ArtistDAO;
import se.iths.persistency.model.Artist;
import java.sql.SQLException;
import java.util.Collection;


public class App {
  
  public static void main(String[] args) throws SQLException {


    ArtistDAO artistDao = new ArtistDAO();

    Collection<Artist> result = artistDao.findAll();

    for (Artist a : result) {
      System.out.println(a);
    }

  }

}