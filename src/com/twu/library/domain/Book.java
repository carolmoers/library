package com.twu.library.domain;

import java.util.List;

public class Book {
    private Integer code;
    private String title;
    private String author;
    private String yearPublished;
    private boolean checkOut;

    public Book(){

    }

    public Book(Integer code, String title, String author, String yearPublished, boolean checkOut) {
        this.code = code;
        this.title = title;
        this.author = author;
        this.yearPublished = yearPublished;
        this.checkOut = checkOut;
    }

    public int getCode() {
        return this.code;
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

    public String checkoutBookFor(Integer code, List<Book> books) {
        List<Book> availableBooks = Books.getAvailableBooksToCheckout(books);
        try{
            for (Book book : availableBooks) {
                if (code.equals(book.getCode())) {
                    book.setCheckOut(true);
                    return "Thank you! Enjoy the book.";
                }
            }
        }catch(Exception ex){
            System.out.println("That book is not available. Error: " + ex.getMessage());
        }
        return "That book is not available.";
    }

    public String returnBookToLibraryFor(Integer code, List<Book> books) {
        try{
            for(Book book : books){
                if(code.equals(book.getCode()) && book.isCheckOut()){
                    book.setCheckOut(false);
                    return  "Thank you for returning the book.";
                }
            }
        }catch (Exception ex){
            System.out.println("That is not a valid book to return. Error: " + ex.getMessage());
        }
        return "That is not a valid book to return.";
    }
}
