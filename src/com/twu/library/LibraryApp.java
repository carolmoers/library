package com.twu.library;

import com.twu.library.domain.Book;
import com.twu.library.domain.Books;
import com.twu.library.domain.Movie;
import com.twu.library.domain.Movies;
import com.twu.library.processor.BookProcessor;
import com.twu.library.processor.MainProcessor;
import com.twu.library.processor.MovieProcessor;
import com.twu.library.util.MainMenu;
import com.twu.library.util.Message;

import java.util.List;

public class LibraryApp {
    private static boolean keepRunning = true;
    private static List<Book> books;
    private static List<Movie> movies;

    public static void main(String[] args) {
        Books listOfBooks = new Books();
        books = listOfBooks.createPredefinedBooks();

        Movies listOfMovies = new Movies();
        movies = listOfMovies.createPredefinedMovies();

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
                MovieProcessor movieProcessor = new MovieProcessor();

                MainProcessor mainProcessor = new MainProcessor();
                Integer optionChoose = mainProcessor.getInputData(Message.MAIN_MENU_INPUT_DATA);

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
                        movieProcessor.showMoviesLibrary(movies);
                        break;
                    case 5:
                        movieProcessor.showMoviesToCheckout(Message.CHECKOUT_MOVIE_INPUT_DATA, Movies.getAvailableMoviesToCheckout(movies));
                        break;
                    case 6:
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
