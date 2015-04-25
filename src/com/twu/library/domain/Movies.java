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
        Movie firstMovie = new Movie(1, "TRON", "1982", "Steven Lisberger", null, false, null);
        this.movies.add(firstMovie);
        Movie secondMovie = new Movie(2, "Scott Pilgrim vs. the World", "2010", "Edgar Wright", 10, false, null);
        this.movies.add(secondMovie);
        Movie thirdMovie = new Movie(3, "Into the Wild", "2007", "Sean Penn", 8, false, null);
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

    public static List<Movie> getAvailableMoviesToReturn(List<Movie> movies) {
        List<Movie> availableMovies = new ArrayList<Movie>();

        for(Movie movie : movies){
            if(movie.isCheckout()){
                availableMovies.add(movie);
            }
        }
        return availableMovies;
    }
}
