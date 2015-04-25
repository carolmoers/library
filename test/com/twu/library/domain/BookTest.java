package com.twu.library.domain;

import org.junit.Test;

import java.util.InputMismatchException;
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
        boolean checkout = false;
        String userThatDoCheckout = null;

        Book book = new Book(code, title, author, yearPublished, checkout, userThatDoCheckout);

        assertThat(book.getCode(), is(equalTo(code)));
        assertThat(book.getAuthor(), is(equalTo(author)));
        assertThat(book.getTitle(), is(equalTo(title)));
        assertThat(book.getYearPublished(), is(equalTo(yearPublished)));
    }

    @Test
    public void checkoutBookTest(){
        List<Book> books = this.getBooks();

        Book book = new Book();
        int code = 1;
        User user = new User("111-1111","123456","Steven Universe", "esteven@universe.com", "3218-4675");
        String returnCheckout = book.checkoutBookFor(code, books, user);

        assertThat(returnCheckout, is(equalTo("Thank you! Enjoy the book.")));
    }

    @Test
    public void checkoutBookThatIsAlreadyCheckoutTest(){
        List<Book> books = this.getBooks();

        Book book = new Book();
        int code = 4;
        User user = new User("111-1111","123456","Steven Universe", "esteven@universe.com", "3218-4675");
        String returnCheckout = book.checkoutBookFor(code, books, user);

        assertThat(returnCheckout, is(equalTo("The book is not available.")));
    }

    @Test(expected = IllegalArgumentException.class)
    public void checkoutBookThrowExceptionTest(){
        Book book = new Book();
        int code = 4;
        book.checkoutBookFor(code, null, null);
    }

    @Test
    public void returnBookTest(){
        List<Book> books = this.getBooks();

        Book book = new Book();
        int code = 2;
        String returnBook = book.returnBookToLibraryFor(code, books);

        assertThat(returnBook, is(equalTo("Thank you for returning the book.")));
    }

    @Test
    public void returnBookThatIsAlreadyInLibraryTest(){
        List<Book> books = this.getBooks();

        Book book = new Book();
        int code = 3;
        String returnBook = book.returnBookToLibraryFor(code, books);

        assertThat(returnBook, is(equalTo("It is not a valid book to return.")));
    }

    @Test(expected = IllegalArgumentException.class)
    public void returnBookThrowExceptionTest(){
        Book book = new Book();
        int code = 3;
        book.returnBookToLibraryFor(code, null);
    }

    private List<Book> getBooks(){
        Books listOfBooks = new Books();
        List<Book> books = listOfBooks.getBooks();

        Book firstBook = new Book(1, "Title1", "Author1", "2011", false, null);
        books.add(firstBook);
        Book secondBook = new Book(2, "Title2", "Author2", "2012", true, null);
        books.add(secondBook);
        Book thirdBook = new Book(3, "Title3", "Author3", "1983", false, null);
        books.add(thirdBook);
        Book fourthBook = new Book(4, "Title4", "Author4", "2014", true, null);
        books.add(fourthBook);

        return books;
    }
}
