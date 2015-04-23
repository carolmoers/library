package com.twu.library.domain;

import java.util.ArrayList;
import java.util.List;

public class Movies {
    private List<Movie> movies;

    public Movies() {
        this.movies = new ArrayList<Movie>();
    }

    public List<Movie> getMovies() {
        return this.movies;
    }

    public List<Movie> createPredefinedMovies() {
        Movie firstMovie = new Movie(1, "Movie1", "1999", "Director1", 8, false);
        this.movies.add(firstMovie);
        Movie secondMovie = new Movie(2, "Movie2", "2000", "Director2", null, false);
        this.movies.add(secondMovie);
        Movie thirdMovie = new Movie(3, "Movie3", "2001", "Director3", 9, false);
        this.movies.add(thirdMovie);

        return this.movies;
    }

    public static List<Movie> getAvailableMoviesToCheckout(List<Movie> movies) {
        List<Movie> availableMovies = new ArrayList<Movie>();

        for(Movie movie : movies){
            if(!movie.isCheckout()){
                availableMovies.add(movie);
            }
        }
        return availableMovies;
    }
}
