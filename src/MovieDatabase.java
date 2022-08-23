import java .io .*;
import java.util .*;

public class MovieDatabase
{
    // Declaring attributes for the MovieDatabase object .
    private final ArrayList <Movie > MovieList;

    // MovieDatabase object constructor .
    public MovieDatabase ()
    {
    this.MovieList = populateDatabase ();
    }

    // Methods for answering queries.
    public void chronologicalOrder()
    {
        Collections.sort ( MovieList );

        for( Movie movie : MovieList )
        {
            System .out.println ( movie );
        }
    }

    public void thirdLongestFilmNoir ()
    {
        ArrayList <Movie > tempArray = new ArrayList < >();
        for( Movie movie : MovieList )
        {
            if( movie.getGenres ().contains ( " Film - Noir " ) )
            {
                tempArray .add( movie );
            }
        }

        Collections.sort ( tempArray, new Comparator <Movie >()
        {
            @Override
            public int compare ( Movie movie1, Movie movie2 )
            {
                return Integer.compare ( movie2.getDuration (), movie1.getDuration ());
            }
        });

        System .out.println (tempArray.get(2));
    }

    public void eigthRecentUnrated ()
    {
        ArrayList <Movie > tempArray = new ArrayList < >();
        for( Movie movie : MovieList )
        {
            if( movie.getCertificate ().contains ( " UNRATED " ) )
            {
            tempArray.add( movie );
            }
        }

        Collections.sort (tempArray, new Comparator <Movie >()
        {
            @Override
            public int compare ( Movie movie1, Movie movie2 )
            {
                return movie2.getReleaseDate () - movie1.getReleaseDate ();
            }
        });

        System .out.println ( tempArray .get (7) );
    }

    public void longestName ()
    {
        Collections.sort ( MovieList, new Comparator <Movie >()
        {
            @Override
            public int compare ( Movie movie1, Movie movie2 )
            {
            return Integer.compare ( movie2.getName ().length (), movie1.getName().length () );
            }
        });

        System .out.println ( MovieList .get (0) );
    }

    // Reads in each line from txt file, splits it into each film's details and creates an array of movie objects .
    public static ArrayList <Movie > populateDatabase ()
    {
        File movieFile = new File ("films.txt");
        ArrayList <Movie > moviesArray = new ArrayList<>();
        // Try / Catch clause used to give " nice " error message if film.txt is not in correct directory .
        try
        {
            Scanner sc = new Scanner ( movieFile );
            while (sc.hasNextLine () )
                {
                    String movieDetails = sc. nextLine ();

                    String [] movieDetailParts = movieDetails.split (",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)", -1) ;


                    // Access array created by.split method and store the contents with more meaningful names .
                    String name = movieDetailParts [0];
                    String certificate = movieDetailParts [2];
                    String genres = movieDetailParts [3];
                    int releaseDate = Integer.parseInt ( movieDetailParts [1]);
                    int duration = Integer.parseInt ( movieDetailParts [4]);
                    int rating = Integer.parseInt ( movieDetailParts [5]);

                    //Create Movie object and add it to the moviesArray list.
                    Movie newMovie = new Movie (name, releaseDate, certificate, genres, duration, rating );
                    moviesArray.add( newMovie );
                }
        }
        catch ( FileNotFoundException e)
        {
            System .out.println ( " Movie file is missing ! " );
        }
        return moviesArray;
    }
}