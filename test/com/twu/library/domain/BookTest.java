package com.twu.library.domain;

import org.junit.Test;

import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

public class BookTest {

    @Test
    public void createBookTest() {
        int code = 1;
        String title = "Test Title";
        String author = "Test Author";
        String yearPublished = "2011";
        boolean checkOut = false;

        Book book = new Book(code, title, author, yearPublished, checkOut);

        assertThat(book.getCode(), is(equalTo(code)));
        assertThat(book.getAuthor(), is(equalTo(author)));
        assertThat(book.getTitle(), is(equalTo(title)));
        assertThat(book.getYearPublished(), is(equalTo(yearPublished)));
    }

    @Test
    public void checkOutBookTest(){
        List<Book> books = this.getBookList();

        Book book = new Book();
        int code = 1;
        String returnCheckout = book.checkoutBookFor(code, books);

        assertThat(returnCheckout, is(equalTo("Thank you! Enjoy the book.")));
    }

    @Test
    public void checkOutBookThatIsAlreadyCheckoutTest(){
        List<Book> books = this.getBookList();

        Book book = new Book();
        int code = 4;
        String returnCheckout = book.checkoutBookFor(code, books);

        assertThat(returnCheckout, is(equalTo("That book is not available.")));
    }

    @Test
    public void returnBookTest(){
        List<Book> books = this.getBookList();

        Book book = new Book();
        int code = 2;
        String returnBook = book.returnBookToLibraryFor(code, books);

        assertThat(returnBook, is(equalTo("Thank you for returning the book.")));
    }

    @Test
    public void returnBookThatIsAlreadyInLibraryTest(){
        List<Book> books = this.getBookList();

        Book book = new Book();
        int code = 3;
        String returnBook = book.returnBookToLibraryFor(code, books);

        assertThat(returnBook, is(equalTo("That is not a valid book to return.")));
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
