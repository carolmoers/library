package com.twu.library.processor;

import com.twu.library.domain.Book;
import com.twu.library.domain.Books;
import com.twu.library.domain.User;
import com.twu.library.util.Message;

import java.util.InputMismatchException;
import java.util.List;

public class BookProcessor {

    public void showBooksLibrary(List<Book> books){
        showBookDetails(Books.getAvailableBooksToCheckout(books));
    }

    public void showBooksToCheckout(String message, List<Book> books, User user){
        try{
            showBookDetails(books);
            if(!books.isEmpty()) {
                MainProcessor mainProcessor = new MainProcessor();
                Integer code = mainProcessor.getInputDataInteger(message);
                String resultCheckout = Book.checkoutBookFor(code, books, user);
                System.out.println(resultCheckout);
            }
        } catch (InputMismatchException ex) {
            System.out.println(Message.INVALID_INPUT);
        }
    }

    public void showBooksToReturn(String message, List<Book> books){
        try{
            showBookToReturnDetails(books);
            if(!books.isEmpty()) {
                MainProcessor mainProcessor = new MainProcessor();
                Integer code = mainProcessor.getInputDataInteger(message);
                String resultReturn = Book.returnBookToLibraryFor(code, books);
                System.out.println(resultReturn);
            }
        } catch (InputMismatchException ex) {
            System.out.println(Message.INVALID_INPUT);
        }
    }

    private void showBookDetails(List<Book> books){
        if(!books.isEmpty()) {
            String leftAlignFormat = "| %-4s | %-25s | %-25s | %-5s |%n";

            System.out.format("+------+---------------------------+---------------------------+-------+%n");
            System.out.printf("| Code | Title                     | Author                    | Year  |%n");
            System.out.format("+------+---------------------------+---------------------------+-------+%n");

            for (Book book : books) {
                System.out.format(leftAlignFormat, book.getCode(), book.getTitle(), book.getAuthor(), book.getYearPublished());
            }
            System.out.format("+------+---------------------------+---------------------------+-------+%n");
        }else{
            System.out.format("+------+---------------------------+---------------------------+-------+%n");
            System.out.printf("|                    There are no available books                      |%n");
            System.out.format("+------+---------------------------+---------------------------+-------+%n");
        }
    }

    private void showBookToReturnDetails(List<Book> books){
        if(!books.isEmpty()) {
            String leftAlignFormat = "| %-4s | %-25s | %-25s | %-5s | %-30s |%n";

            System.out.format("+------+---------------------------+---------------------------+-------+--------------------------------+%n");
            System.out.printf("| Code | Title                     | Author                    | Year  | User Who Checked out           |%n");
            System.out.format("+------+---------------------------+---------------------------+-------+--------------------------------+%n");

            for (Book book : books) {
                System.out.format(leftAlignFormat, book.getCode(), book.getTitle(), book.getAuthor(), book.getYearPublished(), book.getUserWhoHasCheckedOut().getName());
            }
            System.out.format("+------+---------------------------+---------------------------+-------+--------------------------------+%n");
        }else{
            System.out.format("+------+---------------------------+---------------------------+-------+--------------------------------+%n");
            System.out.printf("|                                  There are no available books                                         |%n");
            System.out.format("+------+---------------------------+---------------------------+-------+--------------------------------+%n");
        }
    }
}
