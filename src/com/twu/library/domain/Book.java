package com.twu.library.domain;

import com.twu.library.util.Message;

import java.util.List;

public class Book {
    private Integer code;
    private String title;
    private String author;
    private String yearPublished;
    private boolean checkout;
    private User userWhoHasCheckedOut;

    public Book(){

    }

    public Book(Integer code, String title, String author, String yearPublished, boolean checkout, User userWhoHasCheckedOut) {
        this.code = code;
        this.title = title;
        this.author = author;
        this.yearPublished = yearPublished;
        this.checkout = checkout;
        this.userWhoHasCheckedOut = userWhoHasCheckedOut;
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

    public User getUserWhoHasCheckedOut() {
        return this.userWhoHasCheckedOut;
    }

    public boolean isCheckout() {
        return this.checkout;
    }

    public void setCheckout(boolean checkout) {
        this.checkout = checkout;
    }

    public void setUserWhoHasCheckedOut(User userWhoHasCheckedOut) {
        this.userWhoHasCheckedOut = userWhoHasCheckedOut;
    }

    public static String checkoutBookFor(Integer code, List<Book> books, User user) {
        try{
            List<Book> availableBooks = Books.getAvailableBooksToCheckout(books);
            for (Book book : availableBooks) {
                if (code.equals(book.getCode())) {
                    book.setCheckout(true);
                    book.setUserWhoHasCheckedOut(user);
                    return Message.SUCCESSFUL_BOOK_CHECKOUT;
                }
            }
        }catch(Exception ex){
            System.out.println(Message.ERROR + ex.getMessage());
            throw new IllegalArgumentException();
        }
        return Message.UNSUCCESSFUL_BOOK_CHECKOUT;
    }

    public static String returnBookToLibraryFor(Integer code, List<Book> books) {
        try{
            for(Book book : books){
                if(code.equals(book.getCode()) && book.isCheckout()){
                    book.setCheckout(false);
                    book.setUserWhoHasCheckedOut(null);
                    return  Message.SUCCESSFUL_BOOK_RETURN;
                }
            }
        }catch (Exception ex){
            System.out.println(Message.ERROR + ex.getMessage());
            throw new IllegalArgumentException();
        }
        return Message.UNSUCCESSFUL_BOOK_RETURN;
    }
}
