package com.twu.biblioteca;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

/**
 * Created by cmoers on 4/16/15.
 */
public class BooksTest {
    @Test
    public void createBooks(){
        Books predefined = new Books();

        // ver com Anne -
        //assertThat(predefined, arrayWithSize(3));

        assertThat("Title1", is(equalTo(predefined.getBooks().get(0).getTitle())));
        assertThat("Author1", is(equalTo(predefined.getBooks().get(0).getAuthor())));
        assertThat("2011", is(equalTo(predefined.getBooks().get(0).getYearPublished())));

        assertThat("Title2", is(equalTo(predefined.getBooks().get(1).getTitle())));
        assertThat("Author2", is(equalTo(predefined.getBooks().get(1).getAuthor())));
        assertThat("2012", is(equalTo(predefined.getBooks().get(1).getYearPublished())));

        assertThat("Title3", is(equalTo(predefined.getBooks().get(2).getTitle())));
        assertThat("Author3", is(equalTo(predefined.getBooks().get(2).getAuthor())));
        assertThat("1983", is(equalTo(predefined.getBooks().get(2).getYearPublished())));

    }

}
