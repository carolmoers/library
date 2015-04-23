package com.twu.library.domain;

import org.junit.Test;

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
        assertThat(8, is(equalTo(movies.getMovies().get(0).getRating())));

        assertThat(2, is(equalTo(movies.getMovies().get(1).getCode())));
        assertThat("Movie2", is(equalTo(movies.getMovies().get(1).getName())));
        assertThat("Director2", is(equalTo(movies.getMovies().get(1).getDirector())));
        assertThat("2000", is(equalTo(movies.getMovies().get(1).getYear())));
        assertThat(7, is(equalTo(movies.getMovies().get(1).getRating())));

        assertThat(3, is(equalTo(movies.getMovies().get(2).getCode())));
        assertThat("Movie3", is(equalTo(movies.getMovies().get(2).getName())));
        assertThat("Director3", is(equalTo(movies.getMovies().get(2).getDirector())));
        assertThat("2001", is(equalTo(movies.getMovies().get(2).getYear())));
        assertThat(9, is(equalTo(movies.getMovies().get(2).getRating())));
    }
}
