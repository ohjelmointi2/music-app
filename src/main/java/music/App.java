package music;

import java.util.List;

public class App {

    public static void main(String[] args) {
        var database = new ChinookDatabase();
        List<Artist> artists = database.getArtists();

        artists.forEach(a -> System.out.println(a.name()));

        database.getAlbums().forEach(a -> System.out.println(a.title()));
    }
}
