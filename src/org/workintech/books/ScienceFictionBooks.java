package org.workintech.books;

import org.workintech.person.Author;

public class ScienceFictionBooks extends Book{
    public ScienceFictionBooks(long bookID, Author author, String title, double price, Status status, String edition) {
        super(bookID, author, title, price, status, edition);
    }
}
