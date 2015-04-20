package com.twu.library.domain;

import org.junit.Test;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

public class BooksTest {
    @Test
    public void createBooks(){
        Books listOfBooks = new Books();

        assertThat(listOfBooks.createPredefinedBooks().size(), is(3));

        assertThat("Title1", is(equalTo(listOfBooks.getBooks().get(0).getTitle())));
        assertThat("Author1", is(equalTo(listOfBooks.getBooks().get(0).getAuthor())));
        assertThat("2011", is(equalTo(listOfBooks.getBooks().get(0).getYearPublished())));

        assertThat("Title2", is(equalTo(listOfBooks.getBooks().get(1).getTitle())));
        assertThat("Author2", is(equalTo(listOfBooks.getBooks().get(1).getAuthor())));
        assertThat("2012", is(equalTo(listOfBooks.getBooks().get(1).getYearPublished())));

        assertThat("Title3", is(equalTo(listOfBooks.getBooks().get(2).getTitle())));
        assertThat("Author3", is(equalTo(listOfBooks.getBooks().get(2).getAuthor())));
        assertThat("1983", is(equalTo(listOfBooks.getBooks().get(2).getYearPublished())));

    }

    @Test
    public void getAvailableBooksTest(){
        Books listOfBooks = new Books();

        List<Book> expectedAvailableBooks = listOfBooks.getBooks();

        Book book1 = new Book("Title1", "Author1", "2011", false);
        expectedAvailableBooks.add(book1);
        Book book2 = new Book("Title2", "Author2", "2012", true);
        expectedAvailableBooks.add(book2);
        Book book3 = new Book("Title3", "Author3", "1983", false);
        expectedAvailableBooks.add(book3);
        Book book4 = new Book("Title4", "Author4", "2014", true);
        expectedAvailableBooks.add(book4);

        List<Book> availableBooks = listOfBooks.getAvailableBooks(expectedAvailableBooks);

        assertThat(availableBooks.size(), is(2));

        assertThat("Title1", is(equalTo(availableBooks.get(0).getTitle())));
        assertThat("Author1", is(equalTo(availableBooks.get(0).getAuthor())));
        assertThat("2011", is(equalTo(availableBooks.get(0).getYearPublished())));

        assertThat("Title3", is(equalTo(availableBooks.get(1).getTitle())));
        assertThat("Author3", is(equalTo(availableBooks.get(1).getAuthor())));
        assertThat("1983", is(equalTo(availableBooks.get(1).getYearPublished())));

    }
}
