package org.workintech.books;

import org.workintech.person.Author;

import java.util.Objects;

public class Book {

    private final long bookID;
    private final Author author;
    private final String title;
    private final double price;
    private  final String edition;
    private Status status;
    private String dateOfPurchase;

    public Book( long bookID, Author author, String title, double price, Status status, String edition, String dateOfPurchase) {
        this.bookID = bookID;
        this.author = author;
        this.title = title;
        this.price = price;
        this.status = status;
        this.edition = edition;
        this.dateOfPurchase = dateOfPurchase;
    }

    public String getTitle(){
        return title;
    }

    public Author getAuthor(){
        return author;
    }

    public void updateStatus(Status status){
        this.status=status;
    }

    public void getOwner(){

    }

    public void display(){

    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        String border = "*********************************";
        int width = border.length() - 4;  // 2 boşluk sol, 2 boşluk sağ

        sb.append(border).append("\n");
        sb.append("*").append(" ".repeat(width + 2)).append("*").append("\n");
        sb.append("* ").append(String.format("%-" + width + "s", "bookID: " + bookID)).append(" *").append("\n");
        sb.append("* ").append(String.format("%-" + width + "s", "author: " + author.getName())).append(" *").append("\n");
        sb.append("* ").append(String.format("%-" + width + "s", "title: " + title)).append(" *").append("\n");
        sb.append("* ").append(String.format("%-" + width + "s", "price: " + price)).append(" *").append("\n");
        sb.append("* ").append(String.format("%-" + width + "s", "edition: " + edition)).append(" *").append("\n");
        sb.append("* ").append(String.format("%-" + width + "s", "status: " + status)).append(" *").append("\n");
        sb.append("* ").append(String.format("%-" + width + "s", "dateOfPurchase: " + dateOfPurchase)).append(" *").append("\n");
        sb.append("*").append(" ".repeat(width + 2)).append("*").append("\n");
        sb.append(border).append("\n");

        return sb.toString();
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return bookID == book.bookID && Double.compare(price, book.price) == 0 && Objects.equals(author, book.author) && Objects.equals(title, book.title) && Objects.equals(edition, book.edition) && status == book.status && Objects.equals(dateOfPurchase, book.dateOfPurchase);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bookID, author, title, price, edition, status, dateOfPurchase);
    }
}
