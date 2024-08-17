package org.workintech.person;

import org.workintech.books.Book;
import org.workintech.books.Status;
import org.workintech.library.Library;

import java.time.LocalDate;
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
        this.borrowedBooks=new ArrayList<>();
        this.purchasedBooks=new ArrayList<>();
    }

    public double getBudget() {
        return budget;
    }

    public void setBudget(double budget) {
        this.budget = budget;
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

    public void purchaseBook(Book book,LocalDate purchaseDate){
        if (allBooksofReader.size()<=5 && book.getStatus()==Status.AVAILABLE && budget>=book.getPrice()){
            purchasedBooks.add(book);
            budget-=book.getPrice();
            book.updateStatus(Status.PURCHASED);
            book.changeOwner(this);
            book.setDateOfPurchase(purchaseDate);
            System.out.println("The book purchased successfully.Remaining budget is: "+budget);
        }else{
            System.out.println("Transaction failed.");
        }

    }

    public void borrowBook(Book book,LocalDate date){
        if(allBooksofReader.size()<=5 && book.getStatus()==Status.AVAILABLE) {
            borrowedBooks.add(book);
            book.updateStatus(Status.BORROWED);
            budget-=book.getPrice()*0.1;
            book.changeOwner(this);
            book.setDateOfPurchase(date);
            System.out.println("The book borrowed successfully.");
        }else{
            System.out.println("Transaction failed.");
        }

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
        StringBuilder sb = new StringBuilder();
        String border = "*********************************";
        int width = border.length() - 4;  // 2 spaces left, 2 spaces right

        sb.append(border).append("\n");
        sb.append("*").append(" ".repeat(width + 2)).append("*").append("\n");
        sb.append("* ").append(String.format("%-" + width + "s", "Name: " + getName())).append(" *").append("\n");
        sb.append("* ").append(String.format("%-" + width + "s", "Budget: " + budget)).append(" *").append("\n");
        sb.append("*").append(" ".repeat(width + 2)).append("*").append("\n");

        // Borrowed Books
        //  sb.append(border).append("\n");
        sb.append("*").append(" ".repeat(width + 2)).append("*").append("\n");
        sb.append("* ").append(String.format("%-" + width + "s", "Borrowed Books:")).append(" *").append("\n");
        sb.append("*").append(" ".repeat(width + 2)).append("*").append("\n");
        for (Book book : borrowedBooks) {
            //  sb.append(border).append("\n");
            sb.append("* ").append(String.format("%-" + width + "s", "bookID: " + book.getBookID())).append(" *").append("\n");
            sb.append("* ").append(String.format("%-" + width + "s", "title: " + book.getTitle())).append(" *").append("\n");
            sb.append("* ").append(String.format("%-" + width + "s", "price: " + book.getPrice())).append(" *").append("\n");
            sb.append("* ").append(String.format("%-" + width + "s", "status: " + book.getStatus())).append(" *").append("\n");
            sb.append("* ").append(String.format("%-" + width + "s", "edition: " + book.getEdition())).append(" *").append("\n");
            sb.append("* ").append(String.format("%-" + width + "s", "dateOfPurchase: " + book.getDateOfPurchase())).append(" *").append("\n");
            sb.append("*").append(" ".repeat(width + 2)).append("*").append("\n");
            //  sb.append(border).append("\n");
        }

        // Purchased Books
        //  sb.append(border).append("\n");
        sb.append("*").append(" ".repeat(width + 2)).append("*").append("\n");
        sb.append("* ").append(String.format("%-" + width + "s", "Purchased Books:")).append(" *").append("\n");
        sb.append("*").append(" ".repeat(width + 2)).append("*").append("\n");
        for (Book book : purchasedBooks) {
            //   sb.append(border).append("\n");
            sb.append("* ").append(String.format("%-" + width + "s", "bookID: " + book.getBookID())).append(" *").append("\n");
            sb.append("* ").append(String.format("%-" + width + "s", "title: " + book.getTitle())).append(" *").append("\n");
            sb.append("* ").append(String.format("%-" + width + "s", "price: " + book.getPrice())).append(" *").append("\n");
            sb.append("* ").append(String.format("%-" + width + "s", "status: " + book.getStatus())).append(" *").append("\n");
            sb.append("* ").append(String.format("%-" + width + "s", "edition: " + book.getEdition())).append(" *").append("\n");
            sb.append("* ").append(String.format("%-" + width + "s", "dateOfPurchase: " + book.getDateOfPurchase())).append(" *").append("\n");
            sb.append("*").append(" ".repeat(width + 2)).append("*").append("\n");
            //  sb.append(border).append("\n");
        }

        return sb.toString();
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