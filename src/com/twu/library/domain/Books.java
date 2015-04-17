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
        Book book1 = new Book("Title1", "Author1", "2011");
        this.books.add(book1);
        Book book2 = new Book("Title2", "Author2", "2012");
        this.books.add(book2);
        Book book3 = new Book("Title3", "Author3", "1983");
        this.books.add(book3);

        return this.books;
    }

    public List<Book> getAvailableBooks(List<Book> books) {
        List<Book> availableBooks = new ArrayList<Book>();

        for(Book book : books){
            if(!book.isCheckOut()){
                 availableBooks.add(book);
            }
        }

        return availableBooks;
    }
}
