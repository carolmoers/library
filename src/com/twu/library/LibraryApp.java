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
            System.out.println(message.showWelcomeMessage());

            while(keepRunning) {
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
            }
        }catch (Exception err){
            System.out.println("Something got wrong, the applicattion will close. Error: "+ err.getMessage());
        }
    }

    private static void showBooksLibrary(){
        List<Book> predefinedBooks = books;
        showInfoBooks(Books.getAvailableBooksToCheckout(predefinedBooks));
    }

    private static void showBooksCheckout(){
        List<Book> booksToCheckout = books;

        List<Book> availableBooks = Books.getAvailableBooksToCheckout(booksToCheckout);
        showInfoBooks(Books.getAvailableBooksToCheckout(availableBooks));

        Message message = new Message();
        Scanner input = new Scanner(System.in);
        System.out.print(message.showInputDataMessageCheckoutBook());
        int bookChoose = input.nextInt();
        Book book = new Book();

        String resultCheckout = book.checkOutBookByAvailable(availableBooks, bookChoose);
        System.out.println(resultCheckout);
    }

    private static void showBooksToReturn(){
        List<Book> booksLibrary = books;
        showInfoBooks(Books.getAvailableBooksToReturn(booksLibrary));

        Message message = new Message();
        Scanner input = new Scanner(System.in);
        System.out.print(message.showInputDataMessageReturnBook());
        int bookChoose = input.nextInt();
        Book book = new Book();

        String resultCheckout = book.returnBookToLibrary(booksLibrary, bookChoose);
        System.out.println(resultCheckout);
    }

    private static void showInfoBooks(List<Book> booksToShow){
        String leftAlignFormat = "| %-4s | %-25s | %-25s | %-5s |%n";

        System.out.format("+------+---------------------------+---------------------------+-------+%n");
        System.out.printf("| Code | Title                     | Author                    | Year  |%n");
        System.out.format("+------+---------------------------+---------------------------+-------+%n");

        for(Book book : booksToShow){
            System.out.format(leftAlignFormat, book.getCode(), book.getTitle(), book.getAuthor(), book.getYearPublished());
        }
        System.out.format("+------+---------------------------+---------------------------+-------+%n");
    }
}
