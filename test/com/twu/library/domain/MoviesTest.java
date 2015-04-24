package com.twu.library.domain;

import org.junit.Test;

import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

public class MoviesTest {

    @Test
    public void createMoviesTest() {
        Movies movies = new Movies();

        assertThat(movies.createPredefinedMovies().size(), is(3));

        assertThat(1, is(equalTo(movies.getMovies().get(0).getCode())));
        assertThat("Movie1", is(equalTo(movies.getMovies().get(0).getName())));
        assertThat("Director1", is(equalTo(movies.getMovies().get(0).getDirector())));
        assertThat("1999", is(equalTo(movies.getMovies().get(0).getYear())));
        assertThat("8", is(equalTo(movies.getMovies().get(0).getRating())));

        assertThat(2, is(equalTo(movies.getMovies().get(1).getCode())));
        assertThat("Movie2", is(equalTo(movies.getMovies().get(1).getName())));
        assertThat("Director2", is(equalTo(movies.getMovies().get(1).getDirector())));
        assertThat("2000", is(equalTo(movies.getMovies().get(1).getYear())));
        assertThat("Unrated", is(equalTo(movies.getMovies().get(1).getRating())));

        assertThat(3, is(equalTo(movies.getMovies().get(2).getCode())));
        assertThat("Movie3", is(equalTo(movies.getMovies().get(2).getName())));
        assertThat("Director3", is(equalTo(movies.getMovies().get(2).getDirector())));
        assertThat("2001", is(equalTo(movies.getMovies().get(2).getYear())));
        assertThat("9", is(equalTo(movies.getMovies().get(2).getRating())));
    }

    @Test
    public void getAvailableBooksToCheckoutTest(){
        List<Movie> availableMovies = Movies.getAvailableMoviesToCheckout(this.getMovies());

        assertThat(availableMovies.size(), is(2));

        assertThat("Movie1", is(equalTo(availableMovies.get(0).getName())));
        assertThat("Director1", is(equalTo(availableMovies.get(0).getDirector())));
        assertThat("2011", is(equalTo(availableMovies.get(0).getYear())));
        assertThat("8", is(equalTo(availableMovies.get(0).getRating())));

        assertThat("Movie3", is(equalTo(availableMovies.get(1).getName())));
        assertThat("Director3", is(equalTo(availableMovies.get(1).getDirector())));
        assertThat("1983", is(equalTo(availableMovies.get(1).getYear())));
        assertThat("7", is(equalTo(availableMovies.get(1).getRating())));
    }


    @Test
    public void getAvailableMoviesToReturnTest(){
        List<Movie> availableMovies = Movies.getAvailableMoviesToReturn(this.getMovies());

        assertThat(availableMovies.size(), is(1));

        assertThat("Movie2", is(equalTo(availableMovies.get(0).getName())));
        assertThat("Director2", is(equalTo(availableMovies.get(0).getDirector())));
        assertThat("2012", is(equalTo(availableMovies.get(0).getYear())));
        assertThat("Unrated", is(equalTo(availableMovies.get(0).getRating())));
    }
    private List<Movie> getMovies(){
        Movies listOfMovies = new Movies();
        List<Movie> movies = listOfMovies.getMovies();

        Movie firstMovie = new Movie(1, "Movie1", "2011", "Director1", 8, false);
        movies.add(firstMovie);
        Movie secondMovie = new Movie(2, "Movie2", "2012", "Director2", null, true);
        movies.add(secondMovie);
        Movie thirdMovie = new Movie(3, "Movie3", "1983", "Director3", 7, false);
        movies.add(thirdMovie);

        return movies;
    }
}
