package com.twu.library.processor;

import com.twu.library.domain.Movie;

import java.util.List;

public class MovieProcessor {

    public void showMoviesLibrary(List<Movie> movies){
        showMovieDetails(movies);
    }

    private void showMovieDetails(List<Movie> movies){
        if(!movies.isEmpty()) {
            String leftAlignFormat = "| %-4s | %-25s | %-25s | %-5s | %-6s |%n";

            System.out.format("+------+---------------------------+---------------------------+-------+--------+%n");
            System.out.printf("| Code | Name                      | Director                  | Year  | Rating |%n");
            System.out.format("+------+---------------------------+---------------------------+-------+--------+%n");

            for (Movie movie : movies) {
                System.out.format(leftAlignFormat, movie.getCode(), movie.getName(), movie.getDirector(), movie.getYear(), movie.getRating());
            }
            System.out.format("+------+---------------------------+---------------------------+-------+--------+%n");
        }else{
            System.out.format("+------+---------------------------+---------------------------+-------+--------+%n");
            System.out.printf("|                    There are no available movies                     |        |%n");
            System.out.format("+------+---------------------------+---------------------------+-------+--------+%n");
        }
    }
}
