package com.twu.library;

import com.twu.library.domain.*;
import com.twu.library.processor.*;
import com.twu.library.util.MainMenu;
import com.twu.library.util.Message;

import java.util.List;

public class LibraryApp {
    private static boolean keepRunning = true;
    private static List<Book> books;
    private static List<Movie> movies;
    private static User user;

    public static void main(String[] args) {
        user = LoginProcessor.loginApp();

        if(!user.getName().isEmpty()) {
            Books listOfBooks = new Books();
            books = listOfBooks.createPredefinedBooks();

            Movies listOfMovies = new Movies();
            movies = listOfMovies.createPredefinedMovies();

            System.out.println(String.format(Message.getWelcomeMessage(), user.getName()));
            optionsApp();
        }
    }

    private static void optionsApp(){
        while (keepRunning) {
            try {
                MainMenu menu = new MainMenu();
                String mainMenu = menu.createMainMenu();
                System.out.println(mainMenu);

                BookProcessor bookProcessor = new BookProcessor();
                MovieProcessor movieProcessor = new MovieProcessor();
                UserProcessor userProcessor = new UserProcessor();

                MainProcessor mainProcessor = new MainProcessor();
                Integer optionChoose = mainProcessor.getInputDataInteger(Message.MAIN_MENU_INPUT_DATA);

                switch (optionChoose) {
                    case 1:
                        bookProcessor.showBooksLibrary(books);
                        break;
                    case 2:
                        bookProcessor.showBooksToCheckout(Message.CHECKOUT_BOOK_INPUT_DATA, Books.getAvailableBooksToCheckout(books), user);
                        break;
                    case 3:
                        bookProcessor.showBooksToReturn(Message.RETURN_BOOK_INPUT_DATA, Books.getAvailableBooksToReturn(books));
                        break;
                    case 4:
                        movieProcessor.showMoviesLibrary(movies);
                        break;
                    case 5:
                        movieProcessor.showMoviesToCheckout(Message.CHECKOUT_MOVIE_INPUT_DATA, Movies.getAvailableMoviesToCheckout(movies), user);
                        break;
                    case 6:
                        movieProcessor.showMoviesToReturn(Message.RETURN_MOVIE_INPUT_DATA, Movies.getAvailableMoviesToReturn(movies));
                        break;
                    case 7:
                        userProcessor.showUserInformation(user);
                        break;
                    case 8:
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
