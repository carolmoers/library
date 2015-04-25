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
    private User userWhoHasCheckedOut;

    public Movie(){

    }

    public Movie(Integer code, String name, String year, String director, Integer rating, boolean checkout, User userWhoHasCheckedOut) {
        validateRating(rating);
        this.code = code;
        this.name = name;
        this.year = year;
        this.director = director;
        this.rating = rating;
        this.checkout = checkout;
        this.userWhoHasCheckedOut = userWhoHasCheckedOut;
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
        return this.rating == null ? "Unrated" : this.rating.toString() ;
    }

    public User getUserWhoHasCheckedOut() {
        return this.userWhoHasCheckedOut;
    }

    public boolean isCheckout() {
        return checkout;
    }

    public void setCheckout(boolean checkout) {
        this.checkout = checkout;
    }

    public void setUserWhoHasCheckedOut(User userWhoHasCheckedOut) {
        this.userWhoHasCheckedOut = userWhoHasCheckedOut;
    }

    public static String checkoutMovieFor(Integer code, List<Movie> movies, User user) {
        try{
            List<Movie> availableMovies = Movies.getAvailableMoviesToCheckout(movies);
            for (Movie movie : availableMovies) {
                if (code.equals(movie.getCode())) {
                    movie.setCheckout(true);
                    movie.setUserWhoHasCheckedOut(user);
                    return Message.SUCCESSFUL_MOVIE_CHECKOUT;
                }
            }
        }catch(Exception ex){
            System.out.println(Message.ERROR + ex.getMessage());
            throw new IllegalArgumentException();
        }
        return Message.UNSUCCESSFUL_MOVIE_CHECKOUT;
    }

    public static String returnMovieToLibraryFor(Integer code, List<Movie> movies) {
        try{
            for(Movie movie : movies){
                if(code.equals(movie.getCode()) && movie.isCheckout()){
                    movie.setCheckout(false);
                    movie.setUserWhoHasCheckedOut(null);
                    return  Message.SUCCESSFUL_MOVIE_RETURN;
                }
            }
        }catch (Exception ex){
            System.out.println(Message.ERROR + ex.getMessage());
            throw new IllegalArgumentException();
        }
        return Message.UNSUCCESSFUL_MOVIE_RETURN;
    }

    private void validateRating(Integer rating){
        if(rating != null && (rating < 1 || rating > 10)){
            throw new IllegalArgumentException(Message.INVALID_RATING);
        }
    }
}
