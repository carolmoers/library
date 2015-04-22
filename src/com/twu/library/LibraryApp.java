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
        }catch (Exception ex){
            System.out.println("Something got wrong, the applicattion will close. Error: " + ex.getMessage());
        }
    }

    private static void showBooksLibrary(){
        showInfoBooks(Books.getAvailableBooksToCheckout(books));
    }

    private static void showBooksCheckout(){
        List<Book> availableBooks = Books.getAvailableBooksToCheckout(books);
        showInfoBooks(Books.getAvailableBooksToCheckout(availableBooks));

        Message message = new Message();
        Scanner input = new Scanner(System.in);
        System.out.print(message.showInputDataMessageCheckoutBook());
        int code = input.nextInt();
        Book book = new Book();

        String resultCheckout = book.checkoutBookFor(code, availableBooks);
        System.out.println(resultCheckout);
    }

    private static void showBooksToReturn(){
        showInfoBooks(Books.getAvailableBooksToReturn(books));

        Message message = new Message();
        Scanner input = new Scanner(System.in);
        System.out.print(message.showInputDataMessageReturnBook());
        int code = input.nextInt();
        Book book = new Book();

        String resultCheckout = book.returnBookToLibraryFor(code, books);
        System.out.println(resultCheckout);
    }

    private static void showInfoBooks(List<Book> books){
        String leftAlignFormat = "| %-4s | %-25s | %-25s | %-5s |%n";

        System.out.format("+------+---------------------------+---------------------------+-------+%n");
        System.out.printf("| Code | Title                     | Author                    | Year  |%n");
        System.out.format("+------+---------------------------+---------------------------+-------+%n");

        for(Book book : books){
            System.out.format(leftAlignFormat, book.getCode(), book.getTitle(), book.getAuthor(), book.getYearPublished());
        }
        System.out.format("+------+---------------------------+---------------------------+-------+%n");
    }
}
