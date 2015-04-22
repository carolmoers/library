package com.twu.library;

import com.twu.library.domain.Book;
import com.twu.library.domain.Books;
import com.twu.library.processor.BookProcessor;
import com.twu.library.util.MainMenu;
import com.twu.library.util.Message;

import java.util.List;

public class LibraryApp {
    private static boolean keepRunning = true;
    private static List<Book> books;

    public static void main(String[] args) {
        Books listOfBooks = new Books();
        books = listOfBooks.createPredefinedBooks();
        System.out.println(Message.WELCOME_MESSAGE);
        optionsApp();
    }

    private static void optionsApp(){
        while (keepRunning) {
            try {
                MainMenu menu = new MainMenu();
                String mainMenu = menu.createMainMenu();
                System.out.println(mainMenu);

                BookProcessor bookProcessor = new BookProcessor();
                Integer optionChoose = bookProcessor.getInputData(Message.MAIN_MENU_INPUT_DATA);

                switch (optionChoose) {
                    case 1:
                        bookProcessor.showBooksLibrary(books);
                        break;
                    case 2:
                        bookProcessor.showBooksToCheckout(Message.CHECKOUT_BOOK_INPUT_DATA, Books.getAvailableBooksToCheckout(books));
                        break;
                    case 3:
                        bookProcessor.showBooksToReturn(Message.RETURN_BOOK_INPUT_DATA, Books.getAvailableBooksToReturn(books));
                        break;
                    case 4:
                        keepRunning = false;
                        System.out.close();
                        break;
                    default:
                        System.out.println(Message.INVALID_OPTION);
                        break;
                }
            }catch (Exception ex){
                System.out.println(Message.INVALID_INPUT);
            }
        }
    }
}
