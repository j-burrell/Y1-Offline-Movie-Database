import java.io.*;

public class OMDB
{

    public static void main ( String [] args ) throws FileNotFoundException
    {
        // Create movie database.
        MovieDatabase movieDatabase = new MovieDatabase();

        // Calling methods to return answer to queries.
        System.out.println ( " Films displayed in chronological order :\n " ) ;
        movieDatabase.chronologicalOrder();

        System.out.println ( " \n3rd longest Film - Noir :\n " ) ;
        movieDatabase.thirdLongestFilmNoir();

        System.out.println ( " \n8th most recent \" UNRATED \" film :\n " ) ;
        movieDatabase.eigthRecentUnrated();

        System.out.println ( " \nFilm with the longest name :\n " ) ;
        movieDatabase.longestName();

    }

}
