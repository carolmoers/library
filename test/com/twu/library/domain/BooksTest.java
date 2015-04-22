package com.twu.library.domain;

import org.junit.Test;

import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

public class BooksTest {
    @Test
    public void createBooksTest(){
        Books books = new Books();

        assertThat(books.createPredefinedBooks().size(), is(3));

        assertThat(1, is(equalTo(books.getBooks().get(0).getCode())));
        assertThat("The Pragmatic Programmer", is(equalTo(books.getBooks().get(0).getTitle())));
        assertThat("Andrew Hunt, David Thomas", is(equalTo(books.getBooks().get(0).getAuthor())));
        assertThat("1999", is(equalTo(books.getBooks().get(0).getYearPublished())));

        assertThat(2, is(equalTo(books.getBooks().get(1).getCode())));
        assertThat("Head First Java", is(equalTo(books.getBooks().get(1).getTitle())));
        assertThat("Kathy Sierra, Bert Bates", is(equalTo(books.getBooks().get(1).getAuthor())));
        assertThat("2005", is(equalTo(books.getBooks().get(1).getYearPublished())));

        assertThat(3, is(equalTo(books.getBooks().get(2).getCode())));
        assertThat("Test-driven Development", is(equalTo(books.getBooks().get(2).getTitle())));
        assertThat("Kent Beck", is(equalTo(books.getBooks().get(2).getAuthor())));
        assertThat("2003", is(equalTo(books.getBooks().get(2).getYearPublished())));

    }

    @Test
    public void getAvailableBooksToCheckoutTest(){
        List<Book> availableBooks = Books.getAvailableBooksToCheckout(this.getBookList());

        assertThat(availableBooks.size(), is(2));

        assertThat("Title1", is(equalTo(availableBooks.get(0).getTitle())));
        assertThat("Author1", is(equalTo(availableBooks.get(0).getAuthor())));
        assertThat("2011", is(equalTo(availableBooks.get(0).getYearPublished())));

        assertThat("Title3", is(equalTo(availableBooks.get(1).getTitle())));
        assertThat("Author3", is(equalTo(availableBooks.get(1).getAuthor())));
        assertThat("1983", is(equalTo(availableBooks.get(1).getYearPublished())));

    }

    @Test
    public void getAvailableBooksToReturnTest(){
        List<Book> availableBooks = Books.getAvailableBooksToReturn(this.getBookList());

        assertThat(availableBooks.size(), is(2));

        assertThat("Title2", is(equalTo(availableBooks.get(0).getTitle())));
        assertThat("Author2", is(equalTo(availableBooks.get(0).getAuthor())));
        assertThat("2012", is(equalTo(availableBooks.get(0).getYearPublished())));

        assertThat("Title4", is(equalTo(availableBooks.get(1).getTitle())));
        assertThat("Author4", is(equalTo(availableBooks.get(1).getAuthor())));
        assertThat("2014", is(equalTo(availableBooks.get(1).getYearPublished())));

    }

    private List<Book> getBookList(){
        Books listOfBooks = new Books();
        List<Book> books = listOfBooks.getBooks();

        Book firstBook = new Book(1, "Title1", "Author1", "2011", false);
        books.add(firstBook);
        Book secondBook = new Book(2, "Title2", "Author2", "2012", true);
        books.add(secondBook);
        Book thirdBook = new Book(3, "Title3", "Author3", "1983", false);
        books.add(thirdBook);
        Book fourthBook = new Book(4, "Title4", "Author4", "2014", true);
        books.add(fourthBook);

        return books;
    }
}
