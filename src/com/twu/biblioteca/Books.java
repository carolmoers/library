package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by cmoers on 4/16/15.
 */
public class Books {
    private List<Book> books = new ArrayList<Book>();

    public Books() {
        Book book1 = new Book("Title1", "Author1", "2011");
        this.books.add(book1);
        Book book2 = new Book("Title2", "Author2", "2012");
        this.books.add(book2);
        Book book3 = new Book("Title3", "Author3", "1983");
        this.books.add(book3);
 }

    public List<Book> getBooks() {
        return books;
    }
}
