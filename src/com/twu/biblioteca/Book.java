package com.twu.biblioteca;

import java.util.Date;

/**
 * Created by cmoers on 4/16/15.
 */
public class Book {
    private String title;
    private String author;
    private String yearPublished;
    private boolean checkOut;

    public Book(String title, String author, String yearPublished) {
        this.title = title;
        this.author = author;
        this.yearPublished = yearPublished;
        this.checkOut = false;
    }

    public String getAuthor() {
        return author;
    }

    public String getTitle() {
        return title;
    }

    public String getYearPublished() {
        return yearPublished;
    }

    public boolean isCheckOut() {
        return checkOut;
    }

}
