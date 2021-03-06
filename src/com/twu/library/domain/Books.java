package com.twu.library.domain;

import java.util.ArrayList;
import java.util.List;

public class Books {
    private List<Book> books;

    public Books() {
        this.books = new ArrayList<Book>();
    }

    public List<Book> getBooks() {
        return this.books;
    }

    public List<Book> createPredefinedBooks(){
        Book firstBook = new Book(1, "The Pragmatic Programmer", "Andrew Hunt, David Thomas", "1999", false, null);
        this.books.add(firstBook);
        Book secondBook = new Book(2, "Head First Java", "Kathy Sierra, Bert Bates", "2005", false, null);
        this.books.add(secondBook);
        Book thirdBook = new Book(3, "Test-driven Development", "Kent Beck", "2003", false, null);
        this.books.add(thirdBook);

        return this.books;
    }

    public static List<Book> getAvailableBooksToCheckout(List<Book> books) {
        List<Book> availableBooks = new ArrayList<Book>();

        for(Book book : books){
            if(!book.isCheckout()){
                 availableBooks.add(book);
            }
        }
        return availableBooks;
    }

    public static List<Book> getAvailableBooksToReturn(List<Book> books) {
        List<Book> availableBooks = new ArrayList<Book>();

        for(Book book : books){
            if(book.isCheckout()){
                availableBooks.add(book);
            }
        }
        return availableBooks;
    }
}
