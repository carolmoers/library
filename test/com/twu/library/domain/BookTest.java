package com.twu.library.domain;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

public class BookTest {

    @Test
    public void createBookTest() {
        String title = "Test Title";
        String author = "Test Author";
        String yearPublished = "2011";
        boolean checkOut = false;

        Book book = new Book(title, author, yearPublished, checkOut);

        assertThat(book.getAuthor(), is(equalTo(author)));
        assertThat(book.getTitle(), is(equalTo(title)));
        assertThat(book.getYearPublished(), is(equalTo(yearPublished)));
    }
}