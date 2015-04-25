package com.twu.library.util;

public class Message {
    public final static String MAIN_MENU_INPUT_DATA = "\nWhat you would like to do (1-7)? ";
    public final static String CHECKOUT_BOOK_INPUT_DATA = "What book would you like to checkout (choose a number)? ";
    public final static String RETURN_BOOK_INPUT_DATA = "What book would you like to return (choose a number)? ";
    public final static String INVALID_OPTION = "Select a valid option!";
    public final static String INVALID_INPUT = "Invalid input, needs to be a number.";
    public final static String ERROR = "Something got wrong, the application will close. Error: ";
    public final static String SUCCESSFUL_BOOK_CHECKOUT = "Thank you! Enjoy the book.";
    public final static String UNSUCCESSFUL_BOOK_CHECKOUT = "The book is not available.";
    public final static String SUCCESSFUL_BOOK_RETURN = "Thank you for returning the book.";
    public final static String UNSUCCESSFUL_BOOK_RETURN = "It is not a valid book to return.";
    public final static String CHECKOUT_MOVIE_INPUT_DATA = "What movie would you like to checkout (choose a number)? ";
    public final static String RETURN_MOVIE_INPUT_DATA = "What movie would you like to return (choose a number)? ";
    public final static String SUCCESSFUL_MOVIE_CHECKOUT = "Thank you! Enjoy the movie.";
    public final static String UNSUCCESSFUL_MOVIE_CHECKOUT = "The movie is not available.";
    public final static String SUCCESSFUL_MOVIE_RETURN = "Thank you for returning the movie.";
    public final static String UNSUCCESSFUL_MOVIE_RETURN = "It is not a valid movie to return.";
    public final static String INVALID_RATING = "Ops, some movie has a invalid rating.";
    public final static String INVALID_LIBRARY_NUMBER = "Ops, some user has a invalid library number.";
    public final static String INVALID_PHONE_NUMBER = "Ops, some user has a invalid phone number.";
    public final static String INVALID_EMAIL = "Ops, some user has a invalid email.";
    public final static String LOGIN_INPUT_LIBRARY_NUMBER = "Enter the library number: ";
    public final static String LOGIN_INPUT_PASSWORD = "Enter the password: ";
    public final static String INVALID_USER = "Library number or password was invalid";

    public static String getWelcomeMessage(){
        StringBuilder welcomeMessage = new StringBuilder();
        welcomeMessage.append("\n\n+------------------------------------------------+\n");
        welcomeMessage.append("|           WELCOME TO THE LIBRARY, %s!       |\n");
        welcomeMessage.append("+------------------------------------------------+\n\n");

        return welcomeMessage.toString();
    }
}
