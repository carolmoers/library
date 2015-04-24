package com.twu.library.processor;

import com.twu.library.domain.Movie;
import com.twu.library.domain.Movies;
import com.twu.library.util.Message;

import java.util.InputMismatchException;
import java.util.List;

public class MovieProcessor {

    public void showMoviesLibrary(List<Movie> movies){
        showMovieDetails(Movies.getAvailableMoviesToCheckout(movies));
    }

    public void showMoviesToCheckout(String message, List<Movie> movies) {
        try{
            showMovieDetails(movies);
            if(!movies.isEmpty()) {
                MainProcessor mainProcessor = new MainProcessor();
                Integer code = mainProcessor.getInputData(message);
                String resultCheckout = Movie.checkoutMovieFor(code, movies);
                System.out.println(resultCheckout);
            }
        } catch (InputMismatchException ex) {
            System.out.println(Message.INVALID_INPUT);
        }
    }

    public void showMoviesToReturn(String message, List<Movie> movies) {
        try{
            showMovieDetails(movies);
            if(!movies.isEmpty()) {
                MainProcessor mainProcessor = new MainProcessor();
                Integer code = mainProcessor.getInputData(message);
                String resultCheckout = Movie.returnMovieToLibraryFor(code, movies);
                System.out.println(resultCheckout);
            }
        } catch (InputMismatchException ex) {
            System.out.println(Message.INVALID_INPUT);
        }
    }

    private void showMovieDetails(List<Movie> movies){
        if(!movies.isEmpty()) {
            String leftAlignFormat = "| %-4s | %-25s | %-25s | %-5s | %-8s |%n";

            System.out.format("+------+---------------------------+---------------------------+-------+----------+%n");
            System.out.printf("| Code | Name                      | Director                  | Year  | Rating   |%n");
            System.out.format("+------+---------------------------+---------------------------+-------+----------+%n");

            for (Movie movie : movies) {
                System.out.format(leftAlignFormat, movie.getCode(), movie.getName(), movie.getDirector(), movie.getYear(), movie.getRating());
            }
            System.out.format("+------+---------------------------+---------------------------+-------+----------+%n");
        }else{
            System.out.format("+------+---------------------------+---------------------------+-------+----------+%n");
            System.out.printf("|                    There are no available movies                     |          |%n");
            System.out.format("+------+---------------------------+---------------------------+-------+----------+%n");
        }
    }
}
