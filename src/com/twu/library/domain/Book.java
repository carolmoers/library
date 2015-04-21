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

    public String checkOutBookByAvailable(List<Book> booksLibrary, Integer codeBookChoose) {
        List<Book> availableBooks = Books.getAvailableBooks(booksLibrary);
        String result = "";

        try{
            for (Book book : availableBooks) {
                if (codeBookChoose.equals(book.getCode())) {
                    book.setCheckOut(true);
                    result = "Thank you! Enjoy the book.";
                    break;
                }else{
                    result = "That book is not available.";
                }
            }
        }catch(Exception exc){
            System.out.println("That book is not available. Error: " + exc.getMessage());
        }
        return result;
    }

    public String returnBookToLibrary(List<Book> books, Integer codeBookReturn) {
        String result = "";

        try{
            for(Book book : books){
                if(codeBookReturn.equals(book.getCode()) && book.isCheckOut()){
                    book.setCheckOut(false);
                    result = "Thank you for returning the book.";
                    break;
                }else{
                    result = "That is not a valid book to return.";
                }
            }
        }catch (Exception exc){
            System.out.println("That is not a valid book to return. Error: "+exc.getMessage());
        }
        return result;
    }
}
