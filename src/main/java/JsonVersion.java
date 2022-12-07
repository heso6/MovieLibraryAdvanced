import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class JsonVersion {
    public static void main(String[] args) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);

        File file = new File("src/main/resources/movies.json");

        MovieLibrary movieLibrary = objectMapper.readValue(file, MovieLibrary.class);
//        System.out.println(movieLibrary);


//        movieLibrary.getTitlesOfMoviesByReleaseDate(1990, 2004);
//        System.out.println("\n" + "Random movie: ");
//        movieLibrary.randomMoviePicker();
//        movieLibrary.checkWhichMoviesPlayedActor("Samuel", "Jackson");

        Scanner scanner = new Scanner(System.in);
        System.out.println("Wybierz cyfre  od 1 do 3: ");
        System.out.println("Cyfra 1 -> Wprowadź dwie daty, żeby spradzić jakie filmy z listy miały swoją premiere w tych latach");
        System.out.println("Cyfra 2 -> Wybiera losowy film z list i wyświetla informacje o nim");
        System.out.println("Cyfra 3 -> Wpisz imie i nazwisko aktora, żeby sprawdzić w ktorych filmach z listy zagrał");
        int number = scanner.nextInt();
        switch (number) {
            case 1 -> {
                //1990, 2004
                int from;
                int to;
                System.out.println("Wpisz od którego roku metoda ma sprawdzać premiery filmów");
                from = scanner.nextInt();
                System.out.println("Wpisz do którego roku metoda ma sprawdzać premiery filmów");
                to = scanner.nextInt();
                movieLibrary.getTitlesOfMoviesByReleaseDate(from, to);
            }
            case 2 -> movieLibrary.randomMoviePicker();
            case 3 -> {
                //"Samuel" "Jackson"
                String firstName;
                String lastName;
                System.out.println("Dodaj imię");
                firstName = scanner.next();
                System.out.println("Dodaj nazwisko");
                lastName = scanner.next();
                movieLibrary.checkWhichMoviesPlayedActor(firstName, lastName);
            }
            default -> System.out.println("Wybrałeś liczbe spoza przedziału 1-3, sprobuj ponownie poźniej");
        }
    }
}