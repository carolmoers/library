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

        try{
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
        }catch (Exception err){
            System.out.println("Select a valid option!");
        }

    }

    private static void showBooksLibrary(){
        Books books = new Books();
        List<Book> predefinedBooks = books.createPredefinedBooks();
        List<Book> availableBooks = books.getAvailableBooks(predefinedBooks);

        StringBuilder infoBook = new StringBuilder("Title\t\tAuthor\t\tYear\n");
        for(Book book : availableBooks){
            infoBook.append(book.getTitle());
            infoBook.append("\t\t");
            infoBook.append(book.getAuthor());
            infoBook.append("\t\t");
            infoBook.append(book.getYearPublished());
            infoBook.append("\n");
        }
        System.out.println(infoBook);
    }
}
