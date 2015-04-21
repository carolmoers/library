package com.twu.library;

import com.twu.library.domain.Book;
import com.twu.library.domain.Books;
import com.twu.library.util.Menu;
import com.twu.library.util.Message;

import java.util.List;
import java.util.Scanner;

public class LibraryApp {
    private static boolean keepRunning = true;

    public static void main(String[] args) {

        try{
            Message message = new Message();
            System.out.println(message.showWelcomeMessage());

            Menu menu = new Menu();
            String mainMenu = menu.mainMenu();
            System.out.println(mainMenu);

            Scanner input = new Scanner(System.in);
            System.out.print(message.showInputDataMessage());
            int optionChoose = input.nextInt();

            switch (optionChoose) {
                case 1:
                    showBooksLibrary();
                    break;
                case 2:
                    showBooksCheckout();
                    break;
                case 3:
                    showBooksToReturn();
                    break;
                case 4:
                    keepRunning = false;
                    System.out.close();
                    break;
                default:
                    System.out.println("Select a valid option!");
                    break;
            }
        }catch (Exception err){
            System.out.println("Select a valid option!");
        }
    }

    private static void showBooksLibrary(){
        Books books = new Books();
        List<Book> predefinedBooks = books.getBooks();

        if(predefinedBooks.isEmpty()) {
            predefinedBooks = books.createPredefinedBooks();
        }

        List<Book> availableBooks = books.getAvailableBooks(predefinedBooks);
        String infoBook = books.showInfoBooks(availableBooks);
        System.out.println(infoBook);
    }

    private static void showBooksCheckout(){
        Books books = new Books();
        List<Book> booksToCheckout = books.getBooks();

        if(booksToCheckout.isEmpty()) {
            booksToCheckout = books.createPredefinedBooks();
        }

        List<Book> availableBooks = books.getAvailableBooks(booksToCheckout);
        String infoBook = books.showInfoBooks(availableBooks);
        System.out.println(infoBook);

        Message message = new Message();
        Scanner input = new Scanner(System.in);
        System.out.print(message.showInputDataMessageCheckoutBook());
        int bookChoose = input.nextInt();
        Book book = new Book();

        String resultCheckout = book.checkOutBookByAvailable(availableBooks, bookChoose);
        System.out.println(resultCheckout);
    }

    private static void showBooksToReturn(){
        Books books = new Books();
        List<Book> booksLibrary = books.getBooks();

        if(booksLibrary.isEmpty()) {
            booksLibrary = books.createPredefinedBooks();
        }

        String infoBook = books.showInfoBooks(booksLibrary);
        System.out.println(infoBook);

        Message message = new Message();
        Scanner input = new Scanner(System.in);
        System.out.print(message.showInputDataMessageCheckoutBook());
        int bookChoose = input.nextInt();
        Book book = new Book();

        String resultCheckout = book.returnBookToLibrary(booksLibrary, bookChoose);
        System.out.println(resultCheckout);
    }
}
