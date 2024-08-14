package org.workintech.person;

import org.workintech.books.Book;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Reader extends Person{
    private List<Book> borrowedBooks=new ArrayList<>();

    public Reader(String name) {
        super(name);
    }

    public List<Book> getBorrowedBooks() {
        return borrowedBooks;
    }

    public void setBorrowedBooks(List<Book> borrowedBooks) {
        this.borrowedBooks = borrowedBooks;
    }

    public void purchaseBook(Book book){

    }

    public void borrowBook(Book book){

    }

    public void returnBook(){

    }

    public void showBook(){

    }

    @Override
    public void whoyouare(){
        System.out.println("This person is a reader.");
    }

    @Override
    public String toString() {
        return "Reader{" +
                "borrowedBooks=" + borrowedBooks +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Reader reader = (Reader) o;
        return Objects.equals(borrowedBooks, reader.borrowedBooks);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(borrowedBooks);
    }
}
