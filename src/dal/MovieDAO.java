package dal;

import be.Movie;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MovieDAO implements IMovieDataAccess {

    private static final String MOVIES_FILE_PATH = "data/movie_titles.txt";

    public List<Movie> getAllMovies() throws IOException {
        List<Movie> moviesList = new ArrayList<>();
        File moviesFile = new File(MOVIES_FILE_PATH);
        try (FileReader fr = new FileReader(moviesFile))
        {
            Scanner scanner = new Scanner(fr);
            String[] line;
            while (scanner.hasNext()) {
                line = scanner.nextLine().split(",");
                moviesList.add(new Movie(Integer.parseInt(line[0]), Integer.parseInt(line[1]), line[2]));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return moviesList;
    }

    @Override
    public Movie createMovie(String title, int year) throws Exception {
        return null;
    }

    @Override
    public void updateMovie(Movie movie) throws Exception {

    }

    @Override
    public void deleteMovie(Movie movie) throws Exception {

    }






    /*
    public List<Movie> getAllMovies() {
        List<Movie> allMovieList = new ArrayList<>();

        File moviesFile = new File(MOVIES_FILE);


        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(moviesFile))) {
            boolean hasLines = true;
            while (hasLines) {
                String line = bufferedReader.readLine();
                hasLines = (line != null);
                if (hasLines && !line.isBlank())
                {
                    String[] separatedLine = line.split(",");

                    int id = Integer.parseInt(separatedLine[0]);
                    int year = Integer.parseInt(separatedLine[1]);
                    String title = separatedLine[2];
                    if(separatedLine.length > 3)
                    {
                        for(int i = 3; i < separatedLine.length; i++)
                        {
                            title += "," + separatedLine[i];
                        }
                    }
                    Movie movie = new Movie(id, title, year);
                    allMovieList.add(movie);
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return allMovieList;
    }
    */


}