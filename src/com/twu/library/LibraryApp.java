package com.twu.library;

import com.twu.library.domain.Book;
import com.twu.library.domain.Books;
import com.twu.library.util.Menu;
import com.twu.library.util.Message;

import java.util.List;
import java.util.Scanner;

public class LibraryApp {
    private static boolean keepRunning = true;
    private static List<Book> books;

    public static void main(String[] args) {
        Books listOfBooks = new Books();
        books = listOfBooks.createPredefinedBooks();

        try{
            Message message = new Message();
            System.out.println(Message.WELCOME_MESSAGE);
            optionsApp(message);
        }catch (Exception ex){
            System.out.println(Message.ERROR + ex.getMessage());
        }
    }

    private static void optionsApp(Message message){
        while(keepRunning) {
            Menu menu = new Menu();
            String mainMenu = menu.mainMenu();
            System.out.println(mainMenu);

            Integer optionChoose = getInputData(Message.MAIN_MENU_INPUT_DATA);

            switch (optionChoose) {
                case 1:
                    showBooksLibrary();
                    break;
                case 2:
                    showBooksToCheckout(Message.CHECKOUT_BOOK_INPUT_DATA, Books.getAvailableBooksToCheckout(books));
                    break;
                case 3:
                    showBooksToReturn(Message.RETURN_BOOK_INPUT_DATA, Books.getAvailableBooksToReturn(books));
                    break;
                case 4:
                    keepRunning = false;
                    System.out.close();
                    break;
                default:
                    System.out.println(Message.INVALID_OPTION);
                    break;
            }
        }
    }

    private static Integer getInputData(String message){
        Scanner input = new Scanner(System.in);
        System.out.print(message);
        return input.nextInt();
    }

    private static void showBooksLibrary(){
        showBookDetails(Books.getAvailableBooksToCheckout(books));
    }

    private static void showBooksToCheckout(String message, List<Book> books){
        try{
            showBookDetails(books);
            Integer code = getInputData(message);
            String resultCheckout = Book.checkoutBookFor(code, books);
            System.out.println(resultCheckout);
        } catch (java.util.InputMismatchException ex) {
            System.out.println(Message.INVALID_INPUT);
        }
    }

    private static void showBooksToReturn(String message, List<Book> books){
        try{
            showBookDetails(books);
            Integer code = getInputData(message);
            String resultCheckout = Book.returnBookToLibraryFor(code, books);
            System.out.println(resultCheckout);
        } catch (java.util.InputMismatchException ex) {
            System.out.println(Message.INVALID_INPUT);
        }
    }

    private static void showBookDetails(List<Book> books){
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
}
