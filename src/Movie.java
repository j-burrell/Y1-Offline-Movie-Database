public class Movie implements Comparable <Movie >
{

    // Declaring attributes that each movie object will have .
    private final String name ;
    private final String certificate ;
    private final String genres ;
    private final int releaseDate ;
    private final int duration ;
    private final int rating ;

    // Movie object constructor .
    public Movie ( String name , int releaseDate , String certificate , String genres , int duration , int rating)
    {
        this.name = name ;
        this.certificate = certificate ;
        this.genres = genres ;
        this.releaseDate = releaseDate ;
        this.duration = duration ;
        this.rating = rating ;
    }

    // Getters for attributes needed for answering queries .
    public int getDuration ()
    {
        return duration ;
    }

    public String getGenres ()
    {
        return genres ;
    }
    public int getReleaseDate ()
    {
        return releaseDate ;
    }

    public String getCertificate ()
    {
        return certificate ;
    }

    public String getName ()
    {
        return name ;
    }

    // toString method so Movie objects can be printed .
    @Override
    public String toString ()
    {
        return name + " ," + releaseDate + " ," + certificate + " ," + genres + " ," + duration + " ," + rating ;
    }

    // For sorting chronologically .
    @Override
    public int compareTo ( Movie otherMovie )
    {
        int compareReleaseDate = ((Movie) otherMovie).getReleaseDate () ;
        return this.releaseDate - compareReleaseDate ;
    }
}

