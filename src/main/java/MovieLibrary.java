import java.util.List;
import java.util.Random;

public class MovieLibrary {
    private List<Movie> movies;

    public MovieLibrary(List<Movie> movies) {
        this.movies = movies;
    }

    public MovieLibrary() {
    }

    public List<Movie> getMovies() {
        return movies;
    }

    public void setMovies(List<Movie> movies) {
        this.movies = movies;
    }


    public void getTitlesOfMoviesByReleaseDate(int from, int to) {
        System.out.println("Titles of movies that had their premieres from year: " + from + " to year: " + to);
        for (Movie movie : movies) {
            if (movie.getYear() > from && movie.getYear() < to) {
                System.out.println(movie.getTitle());
            }
        }
    }

    public void randomMoviePicker() {
        Random rand = new Random();
        Movie randomElement = getMovies().get(rand.nextInt(movies.size()));
        System.out.println(randomElement.toString());
    }

    public void checkWhichMoviesPlayedActor(String firstName, String lastName) {
        System.out.println("Filmy w których zagrał: " + firstName + " " + lastName + ":");
        for (Movie movie : movies) {
            if (movie.getActors().toString().contains(firstName) && movie.getActors().toString().contains(lastName)) {
                System.out.println(movie.getTitle());
            }
        }
    }

    @Override
    public String toString() {
        return "MovieLibrary{" +
                "movies=" + movies +
                '}';
    }
}
