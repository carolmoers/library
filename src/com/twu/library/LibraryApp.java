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
                keepRunning = false;
                System.out.close();
                break;
            default:
                System.out.println("Select a valid option!");
                break;
        }
    }

    private static void showBooksLibrary(){
        Books books = new Books();
        List<Book> predefinedBooks = books.createPredefinedBooks();
        List<Book> availableBooks = books.getAvailableBooks(predefinedBooks);

        for(Book book : availableBooks){
            String infoBook = book.getTitle();
            infoBook = infoBook.concat("\n\t\t").concat(book.getAuthor()).concat(" - ").concat(book.getYearPublished());

            System.out.println(infoBook);
        }
    }
}
