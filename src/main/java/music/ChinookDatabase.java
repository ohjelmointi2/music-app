package music;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ChinookDatabase {

    private static final String JDBC_URL = "jdbc:sqlite:Chinook_Sqlite.sqlite";

    public List<Artist> getArtists() {
        List<Artist> artists = new ArrayList<>();
        String sql = "SELECT ArtistId, Name FROM Artist ORDER BY Name ASC";

        try (
                Connection connection = DriverManager.getConnection(JDBC_URL);
                PreparedStatement statement = connection.prepareStatement(sql);
                ResultSet results = statement.executeQuery()) {

            while (results.next()) {
                var id = results.getLong("ArtistId");
                var name = results.getString("Name");

                artists.add(new Artist(id, name));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return artists;
    }

    public List<Album> getAlbums() {
        List<Album> albums = new ArrayList<>();
        String sql = "SELECT AlbumId, Title, ArtistId FROM Album ORDER BY Title ASC";

        try (
                Connection connection = DriverManager.getConnection(JDBC_URL);
                PreparedStatement statement = connection.prepareStatement(sql);
                ResultSet results = statement.executeQuery()) {

            while (results.next()) {
                var id = results.getLong("AlbumId");
                var name = results.getString("Title");
                var artistId = results.getLong("ArtistId");

                albums.add(new Album(id, name, artistId));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return albums;
    }
}
