package com.twu.biblioteca;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

/**
 * Created by cmoers on 4/16/15.
 */
public class BookTest {

    @Test
    public void createBookTest() {
        String title = "Test Title";
        String author = "Test Author";
        String yearPublished = "2011";

        Book book = new Book(title, author, yearPublished);

        assertThat(book.getAuthor(), is(equalTo(author)));
        assertThat(book.getTitle(), is(equalTo(title)));
        assertThat(book.getYearPublished(), is(equalTo(yearPublished)));
    }
}
