package com.twu.library.domain;

import org.junit.Test;

import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

public class BooksTest {
    @Test
    public void createBooksTest(){
        Books listOfBooks = new Books();

        assertThat(listOfBooks.createPredefinedBooks().size(), is(3));

        assertThat(1, is(equalTo(listOfBooks.getBooks().get(0).getCode())));
        assertThat("Title1", is(equalTo(listOfBooks.getBooks().get(0).getTitle())));
        assertThat("Author1", is(equalTo(listOfBooks.getBooks().get(0).getAuthor())));
        assertThat("2011", is(equalTo(listOfBooks.getBooks().get(0).getYearPublished())));

        assertThat(2, is(equalTo(listOfBooks.getBooks().get(1).getCode())));
        assertThat("Title2", is(equalTo(listOfBooks.getBooks().get(1).getTitle())));
        assertThat("Author2", is(equalTo(listOfBooks.getBooks().get(1).getAuthor())));
        assertThat("2012", is(equalTo(listOfBooks.getBooks().get(1).getYearPublished())));

        assertThat(3, is(equalTo(listOfBooks.getBooks().get(2).getCode())));
        assertThat("Title3", is(equalTo(listOfBooks.getBooks().get(2).getTitle())));
        assertThat("Author3", is(equalTo(listOfBooks.getBooks().get(2).getAuthor())));
        assertThat("1983", is(equalTo(listOfBooks.getBooks().get(2).getYearPublished())));

    }

    @Test
    public void getAvailableBooksTest(){
        Books listOfBooks = new Books();
        List<Book> expectedAvailableBooks = this.getBookList();
        List<Book> availableBooks = listOfBooks.getAvailableBooks(expectedAvailableBooks);

        assertThat(availableBooks.size(), is(2));

        assertThat("Title1", is(equalTo(availableBooks.get(0).getTitle())));
        assertThat("Author1", is(equalTo(availableBooks.get(0).getAuthor())));
        assertThat("2011", is(equalTo(availableBooks.get(0).getYearPublished())));

        assertThat("Title3", is(equalTo(availableBooks.get(1).getTitle())));
        assertThat("Author3", is(equalTo(availableBooks.get(1).getAuthor())));
        assertThat("1983", is(equalTo(availableBooks.get(1).getYearPublished())));

    }

    @Test
    public void showInfoBooksTest(){
        List<Book> booksToShow = this.getBookList();
        Books books = new Books();
        String result = books.showInfoBooks(booksToShow);
        String expectedResult = "Code\t\tTitle\t\tAuthor\t\tYear\n" +
                "1\t\t\tTitle1\t\t\tAuthor1\t\t\t2011\n" +
                "2\t\t\tTitle2\t\t\tAuthor2\t\t\t2012\n" +
                "3\t\t\tTitle3\t\t\tAuthor3\t\t\t1983\n" +
                "4\t\t\tTitle4\t\t\tAuthor4\t\t\t2014\n";

        assertThat(expectedResult, is(equalTo(result)));

    }

    private List<Book> getBookList(){
        Books listOfBooks = new Books();
        List<Book> books = listOfBooks.getBooks();

        Book book1 = new Book(1, "Title1", "Author1", "2011", false);
        books.add(book1);
        Book book2 = new Book(2, "Title2", "Author2", "2012", true);
        books.add(book2);
        Book book3 = new Book(3, "Title3", "Author3", "1983", false);
        books.add(book3);
        Book book4 = new Book(4, "Title4", "Author4", "2014", true);
        books.add(book4);

        return books;
    }
}
