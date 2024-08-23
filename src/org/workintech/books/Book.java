package org.workintech.books;

import org.workintech.person.Author;
import org.workintech.person.Reader;

import java.util.Objects;
import java.time.LocalDate;

public class Book {

    private final long bookID;
    private final Author author;
    private final String title;
    private final double price;
    private  final String edition;
    private Status status;
    private LocalDate dateOfPurchase;
    private Reader owner;
    private Genre genre;

    public Book( long bookID, Author author, String title, double price, Status status, String edition,Genre genre) {
        this.bookID = bookID;
        this.author = author;
        this.title = title;
        this.price = price;
        this.status = status;
        this.edition = edition;
        this.genre=genre;

    }
    public Genre getGenre() {
        return genre;
    }


    public long getBookID() {
        return bookID;
    }

    public String getTitle(){
        return title;
    }

    public double getPrice() {
        return price;
    }

    public String getEdition() {
        return edition;
    }

    public Status getStatus() {
        return status;
    }

    public LocalDate getDateOfPurchase() {
        return dateOfPurchase;
    }

    public void setDateOfPurchase(LocalDate dateOfPurchase) {
        this.dateOfPurchase = dateOfPurchase;
    }

    public Author getAuthor(){
        return author;
    }

    public void updateStatus(Status status){
        this.status=status;
    }

    public Reader getOwner(){
    return owner;
    }

    public void changeOwner(Reader newOwner){
        owner=newOwner;
    }

    public void display(){
        System.out.println(this);
    }


//    @Override
//    public String toString() {
//        StringBuilder sb = new StringBuilder();
//        String border = "*********************************";
//        int width = border.length() - 4;  // 2 boşluk sol, 2 boşluk sağ
//
//        sb.append(border).append("\n");
//        sb.append("*").append(" ".repeat(width + 2)).append("*").append("\n");
//        sb.append("* ").append(String.format("%-" + width + "s", "bookID: " + bookID)).append(" *").append("\n");
//        sb.append("* ").append(String.format("%-" + width + "s", "author: " + author.getName())).append(" *").append("\n");
//        sb.append("* ").append(String.format("%-" + width + "s", "title: " + title)).append(" *").append("\n");
//        sb.append("* ").append(String.format("%-" + width + "s", "price: " + price)).append(" *").append("\n");
//        sb.append("* ").append(String.format("%-" + width + "s", "edition: " + edition)).append(" *").append("\n");
//        sb.append("* ").append(String.format("%-" + width + "s", "status: " + status)).append(" *").append("\n");
//        sb.append("* ").append(String.format("%-" + width + "s", "dateOfPurchase: " + dateOfPurchase)).append(" *").append("\n");
//        sb.append("*").append(" ".repeat(width + 2)).append("*").append("\n");
//        sb.append(border).append("\n");
//
//        return sb.toString();
//    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        String border = "*********************************";
        int width = border.length() - 4;  // 2 boşluk sol, 2 boşluk sağ

        sb.append(border).append("\n");
        sb.append("*").append(" ".repeat(width + 2)).append("*").append("\n");
        sb.append(formatLine("bookID: " + bookID, width));
        sb.append(formatLine("author: " + author.getName(), width));
        sb.append(formatLine("title: " + title, width));  // Kitap başlığı
        sb.append(formatLine("price: " + price, width));
        sb.append(formatLine("edition: " + edition, width));
        sb.append(formatLine("status: " + status, width));
        sb.append(formatLine("dateOfPurchase: " + dateOfPurchase, width));
        sb.append("*").append(" ".repeat(width + 2)).append("*").append("\n");
        sb.append(border).append("\n");

        return sb.toString();
    }

    /**
     * Uzun satırları belirli bir genişlikte böler ve biçimlendirir.
     *
     * @param text  Biçimlendirilecek metin.
     * @param width Satır genişliği.
     * @return Biçimlendirilmiş metin satırı.
     */
    private String formatLine(String text, int width) {
        StringBuilder sb = new StringBuilder();
        int start = 0;

        while (start < text.length()) {
            int end = Math.min(start + width, text.length());
            String line = text.substring(start, end);
            sb.append("* ").append(String.format("%-" + width + "s", line)).append(" *\n");
            start = end;
        }

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
