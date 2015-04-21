package com.twu.library.domain;

import java.util.ArrayList;
import java.util.List;

public class Books {
    private List<Book> books;

    public Books() {
        this.books = new ArrayList<Book>();
    }

    public List<Book> getBooks() {
        return this.books;
    }

    public List<Book> createPredefinedBooks(){
        Book book1 = new Book(1, "Title1", "Author1", "2011", false);
        this.books.add(book1);
        Book book2 = new Book(2, "Title2", "Author2", "2012", false);
        this.books.add(book2);
        Book book3 = new Book(3, "Title3", "Author3", "1983", false);
        this.books.add(book3);

        return this.books;
    }

    public List<Book> getAvailableBooks(List<Book> books) {
        List<Book> availableBooks = new ArrayList<Book>();

        for(Book book : books){
            if(!book.isCheckOut()){
                 availableBooks.add(book);
            }
        }
        return availableBooks;
    }

    public String showInfoBooks(List<Book> booksToShow) {
        StringBuilder infoBook = new StringBuilder("Code\t\tTitle\t\tAuthor\t\tYear\n");
        for(Book book : booksToShow){
            infoBook.append(book.getCode());
            infoBook.append("\t\t\t");
            infoBook.append(book.getTitle());
            infoBook.append("\t\t\t");
            infoBook.append(book.getAuthor());
            infoBook.append("\t\t\t");
            infoBook.append(book.getYearPublished());
            infoBook.append("\n");
        }
        return infoBook.toString();
    }
}
