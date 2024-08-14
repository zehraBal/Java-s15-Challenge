package org.workintech.person;

import org.workintech.books.Book;

import java.util.*;

public class Author extends Person{

    private List<Book> books =new ArrayList<>();

    public Author(String name) {
        super(name);
    }

    public Author(String name, List<Book> books) {
        super(name);
        this.books = books;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    public void newBook(Book book){
        if (!books.contains(book)){
            books.add(book);

        }
    }

    public void showBook(){
        for(Book book:books){
            System.out.println(book);
        }

    }

    private String getBooksAsString() {
        StringBuilder sb = new StringBuilder();
        for (Book book : books) {
            sb.append(book.toString()).append("\n");
        }
        return sb.toString();
    }

    @Override
    public void whoyouare() {
        System.out.println("This person is an author.");
    }

    @Override
    public String toString() {
        return "Author: " + super.getName()+"\n"+
                getBooksAsString();

    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Author author = (Author) o;
        return Objects.deepEquals(books, author.books);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(books);
    }
}
