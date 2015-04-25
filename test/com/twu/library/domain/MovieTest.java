package com.twu.library.domain;

import org.junit.Test;

import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

public class MovieTest {

    @Test
    public void createMovieTest() {
        int code = 1;
        String name = "Test Movie";
        String director = "Test Director";
        String year = "2011";
        Integer rating = 10;
        boolean checkout = false;
        User userWhoHasCheckedOut = new User();

        Movie movie = new Movie(code,name,year,director,rating,checkout, userWhoHasCheckedOut);

        assertThat(movie.getCode(), is(equalTo(code)));
        assertThat(movie.getName(), is(equalTo(name)));
        assertThat(movie.getDirector(), is(equalTo(director)));
        assertThat(movie.getYear(), is(equalTo(year)));
        assertThat(movie.getRating(), is(equalTo(rating.toString())));
        assertThat(movie.getUserWhoHasCheckedOut(), is(equalTo(userWhoHasCheckedOut)));
    }

    @Test
    public void createMovieUnratedTest(){
        int code = 1;
        String name = "Test Movie";
        String director = "Test Director";
        String year = "2011";
        Integer rating = null;
        boolean checkout = false;
        User userWhoHasCheckedOut = new User();

        Movie movie = new Movie(code,name,year,director,rating,checkout, userWhoHasCheckedOut);

        assertThat(movie.getCode(), is(equalTo(code)));
        assertThat(movie.getName(), is(equalTo(name)));
        assertThat(movie.getDirector(), is(equalTo(director)));
        assertThat(movie.getYear(), is(equalTo(year)));
        assertThat(movie.getRating(), is(equalTo("Unrated")));
        assertThat(movie.getUserWhoHasCheckedOut(), is(equalTo(userWhoHasCheckedOut)));
    }

    @Test(expected = IllegalArgumentException.class)
    public void createMovieWithInvalidRating(){
        int code = 1;
        String name = "Test Movie";
        String director = "Test Director";
        String year = "2011";
        Integer rating = 11;
        boolean checkout = false;
        User userWhoHasCheckedOut = new User();

        new Movie(code,name,year,director,rating,checkout,userWhoHasCheckedOut);
    }

    @Test
    public void checkoutMovieForTest(){
        List<Movie> movies = this.getMovies();

        Movie movie = new Movie();
        int code = 1;
        User userWhoHasCheckedOut = new User("111-1111","123456","Steven Universe", "esteven@universe.com", "3218-4675");
        String returnCheckout = movie.checkoutMovieFor(code, movies, userWhoHasCheckedOut);

        assertThat(returnCheckout, is(equalTo("Thank you! Enjoy the movie.")));
    }

    @Test
    public void checkoutMovieThatIsAlreadyCheckoutTest(){
        List<Movie> movies = this.getMovies();

        Movie movie = new Movie();
        int code = 4;
        User userWhoHasCheckedOut = new User("111-1111","123456","Steven Universe", "esteven@universe.com", "3218-4675");
        String returnCheckout = movie.checkoutMovieFor(code, movies, userWhoHasCheckedOut);

        assertThat(returnCheckout, is(equalTo("The movie is not available.")));
    }

    @Test(expected = IllegalArgumentException.class)
    public void checkoutMovieThrowExceptionTest(){
        Movie movie = new Movie();
        int code = 4;
        User user = new User();

        movie.checkoutMovieFor(code, null, user);
    }

    @Test
    public void returnMovieTest(){
        List<Movie> movies = this.getMovies();

        Movie movie = new Movie();
        int code = 2;
        String returnMovie = movie.returnMovieToLibraryFor(code, movies);

        assertThat(returnMovie, is(equalTo("Thank you for returning the movie.")));
    }

    @Test
    public void returnMovieThatIsAlreadyInLibraryTest(){
        List<Movie> movies = this.getMovies();

        Movie movie = new Movie();
        int code = 3;
        String returnMovie = movie.returnMovieToLibraryFor(code, movies);

        assertThat(returnMovie, is(equalTo("It is not a valid movie to return.")));
    }

    @Test(expected = IllegalArgumentException.class)
    public void returnMovieThrowExceptionTest(){
        Movie movie = new Movie();
        int code = 3;
        movie.returnMovieToLibraryFor(code, null);
    }

    private List<Movie> getMovies(){
        Movies listOfMovies = new Movies();
        List<Movie> movies = listOfMovies.getMovies();

        Movie firstMovie = new Movie(1, "Movie1", "2011", "Director1", 8, false, null);
        movies.add(firstMovie);
        Movie secondMovie = new Movie(2, "Movie2", "2012", "Director2", null, true, null);
        movies.add(secondMovie);
        Movie thirdMovie = new Movie(3, "Movie3", "1983", "Director3", 7, false, null);
        movies.add(thirdMovie);

        return movies;
    }
}
