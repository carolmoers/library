package com.twu.library.domain;

import com.twu.library.util.Message;

import java.util.List;

public class Movie {
    private Integer code;
    private String name;
    private String year;
    private String director;
    private Integer rating;
    private boolean checkout;

    public Movie(){

    }

    public Movie(Integer code, String name, String year, String director, Integer rating, boolean checkout) {
        this.code = code;
        this.name = name;
        this.year = year;
        this.director = director;
        this.rating = rating;
        this.checkout = checkout;
    }

    public Integer getCode() {
        return code;
    }

    public String getName() {
        return this.name;
    }

    public String getYear() {
        return this.year;
    }

    public String getDirector() {
        return this.director;
    }

    public String getRating() {
        if(this.rating == null){
            return "Unrated";
        }else{
            return this.rating.toString();
        }
    }

    public boolean isCheckout() {
        return checkout;
    }

    public void setCheckout(boolean checkout) {
        this.checkout = checkout;
    }

    public static String checkoutMovieFor(Integer code, List<Movie> movies) {
        try{
            List<Movie> availableMovies = Movies.getAvailableMoviesToCheckout(movies);
            for (Movie movie : availableMovies) {
                if (code.equals(movie.getCode())) {
                    movie.setCheckout(true);
                    return Message.SUCCESSFUL_MOVIE_CHECKOUT;
                }
            }
        }catch(Exception ex){
            System.out.println(Message.ERROR + ex.getMessage());
            throw new IllegalArgumentException();
        }
        return Message.UNSUCCESSFUL_MOVIE_CHECKOUT;
    }
}
