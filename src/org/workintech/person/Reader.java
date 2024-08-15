package org.workintech.person;

import org.workintech.books.Book;
import org.workintech.books.Status;
import org.workintech.library.Library;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Reader extends Person{
    private List<Book> borrowedBooks=new ArrayList<>();
    private List<Book> purchasedBooks=new ArrayList<>();
    private List<Book> allBooksofReader= new ArrayList<>();

    private double budget;

    public Reader(String name,double budget) {
        super(name);
        this.budget=budget;
    }

    public List<Book> getBorrowedBooks() {
        return borrowedBooks;
    }

    public void setBorrowedBooks(List<Book> borrowedBooks) {
        this.borrowedBooks = borrowedBooks;
    }

    public List<Book> getPurchasedBooks() {
        return purchasedBooks;
    }

    public void setPurchasedBooks(List<Book> purchasedBooks) {
        this.purchasedBooks = purchasedBooks;
    }
    private final void getAllBooks(){
        allBooksofReader.addAll(purchasedBooks);
        allBooksofReader.addAll(borrowedBooks);
    }

    public void purchaseBook(Book book,Library library){
        if (allBooksofReader.size()<=5 && book.getStatus()==Status.AVAILABLE && budget>=book.getPrice()){
            purchasedBooks.add(book);
            budget-=book.getPrice();
            book.updateStatus(Status.PURCHASED);
            book.changeOwner(this);
            library.removeBook(book);
            System.out.println("The book purchased successfully.Remaining budget is: "+budget);
        }else{
            System.out.println("Transaction failed.");
        }

    }

    public void borrowBook(Book book){
        if(allBooksofReader.size()<=5 && book.getStatus()==Status.AVAILABLE) {
            borrowedBooks.add(book);
            book.updateStatus(Status.BORROWED);
            book.changeOwner(this);
            System.out.println("The book borrowed successfully.");
        }
        System.out.println("Transaction failed.");

    }

    public void returnBook(Book book){
        if(borrowedBooks.contains(book)){
            borrowedBooks.remove(book);
            book.updateStatus(Status.AVAILABLE);
            book.changeOwner(null);
            System.out.println("The book returned successfully.");
        }else{
            System.out.println("This book cannot be returned.");

        }
    }

    public void showBook(Book book){
        if(purchasedBooks.contains(book)){
            System.out.println(book.getTitle()+" is purchased.");
            for(Book purchased :purchasedBooks){
                if(purchased.equals(book)){
                    System.out.println(book.toString());
                }
            }
        }else if(borrowedBooks.contains(book)){
            System.out.println(book.getTitle()+" is borrowed.");
            for(Book borrowed:borrowedBooks){
                if(borrowed.equals(book)){
                    System.out.println(book.toString());
                }
            }
        }
        System.out.println("This book is not borrowed or purchased.");
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
