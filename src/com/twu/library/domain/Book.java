package com.twu.library.domain;

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

    public Book(String title, String author, String yearPublished, boolean checkOut) {
        this.title = title;
        this.author = author;
        this.yearPublished = yearPublished;
        this.checkOut = checkOut;
    }

    public String getAuthor() {
        return this.author;
    }

    public String getTitle() {
        return this.title;
    }

    public String getYearPublished() {
        return this.yearPublished;
    }

    public boolean isCheckOut() {
        return this.checkOut;
    }

    public void setCheckOut(boolean checkOut) {
        this.checkOut = checkOut;
    }

}
