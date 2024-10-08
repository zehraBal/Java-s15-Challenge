package org.workintech.library;

import org.workintech.books.Book;
import org.workintech.books.Genre;
import org.workintech.person.Author;
import org.workintech.person.MemberRecord;
import org.workintech.person.Reader;

import java.lang.reflect.Member;
import java.util.*;

public class Library {
    private Map<Author,List<Book>> libraryContents;
    private List<Reader> readers;
    private List<MemberRecord> members;

    public Library(Map<Author, List<Book>> libraryContents,List<Reader> readers) {
        this.libraryContents = libraryContents;
        this.readers=readers;
        members=new ArrayList<>();
    }


    public List<Reader> getReaders(){
        return readers;
    }

    public List<MemberRecord> getMembers(){
        return members;
    }

    public MemberRecord getMemberByID(String memberID){
        for(MemberRecord mem:members){
            if(mem.getMemberID().equalsIgnoreCase(memberID)){
                return mem;
            }
        }
        System.out.println("There is no registered member with the ID you are looking for.");
        return null;
    }
    public Reader findReaderByName(String name) {
        for (Reader reader : readers) {
            if (reader.getName().equalsIgnoreCase(name)) {
                return reader;
            }
        }
        return null;
    }



    public String showBook(Author author,long bookID) {
        Set<Author> keys=libraryContents.keySet();
        for(Author key:keys){
            List<Book> authorBooks=libraryContents.get(key);
            for(Book book:authorBooks){
                if(book.getBookID()==bookID){
                    return book.toString();
                }
            }
        }
        return null;

    }
    public void removeBook(Book book){
        Author author=book.getAuthor();
        List<Book> books =libraryContents.get(author);
        if(books != null){
            books.remove(book);
            System.out.println("Transaction complete.");
        }
    }

    public void newBook(Book book){
        Author author=book.getAuthor();
        List<Book> authorBooks = libraryContents.computeIfAbsent(author, k -> new ArrayList<>());
        authorBooks.add(book);
    }

//    public void getBooks(){
//        Set<Author> keys=libraryContents.keySet();
//        for(Author key:keys){
//            List<Book> authorBooks=libraryContents.get(key);
//            for(Book book:authorBooks){
//                System.out.println(book.toString());
//            }
//        }
//    }
public void getBooks() {
    for (List<Book> books : libraryContents.values()) {
        for (Book book : books) {
            System.out.println(book);
        }
    }
}


    public Book getBook(long bookID){
        Set<Author> keys=libraryContents.keySet();
        for(Author key:keys){
            List<Book> authorBooks=libraryContents.get(key);
            for(Book book:authorBooks){
                if(book.getBookID()==bookID){
                    return book;
                }
            }
        }
        return null;

    }

    public Author findAuthorByName(String name){
        Set<Author> authors=libraryContents.keySet();
        for(Author auth:authors){
            if(auth.getName().equals(name)){
                return auth;
            }
        }
        return null;
    }
    public void getBooksByAuthor(Author author){
        List<Book> authorBooks = libraryContents.get(author);
        for (Book book:authorBooks){
            System.out.println(book);
        }
    }

    public Book getBook(String title){
        Set<Author> keys=libraryContents.keySet();
        for(Author key:keys){
            List<Book> authorBooks=libraryContents.get(key);
            for(Book book:authorBooks){
                if(book.getTitle().equals(title)){
                    return book;
                }
            }
        }
        return null;
    }

    public void getBooksByGenre(Genre genre) {

        System.out.println(genre.name()+"Books");
        for (List<Book> books : libraryContents.values()) {
            for (Book book : books) {
                if (book.getGenre() != null && book.getGenre().equals(genre)) {
                    System.out.println(book);
                }
            }
        }

    }

    public Book findBookById(long bookId) {
        for (List<Book> books : libraryContents.values()) {
            for (Book book : books) {
                if (book.getBookID()==bookId) {
                    return book;
                }
            }
        }
        return null;
    }


    public void updateReaderToMember(Reader reader, MemberRecord memberRecord) {
        readers.remove(reader); // Remove the old reader
        members.add(memberRecord); // Add the new member
    }


    public void lendBook(Book book){
        List<Book> books=libraryContents.get(book.getAuthor());
       if(books.contains(book)){
           books.remove(book);
           libraryContents.put(book.getAuthor(),books);
           System.out.println("Transaction complete.");
       }
    }

    public void takeBackBook(Book book){
        List<Book> books=libraryContents.get(book.getAuthor());
        if(!books.contains(book)){
            books.add(book);
            libraryContents.put(book.getAuthor(),books);
            System.out.println("Transaction complete.");
        }
    }

@Override
public String toString() {
    StringBuilder sb = new StringBuilder();

    // Her yazar için kitapları göster
    for (Map.Entry<Author, List<Book>> entry : libraryContents.entrySet()) {
        Author author = entry.getKey();
        List<Book> books = entry.getValue();

        // Yazar ismi ve kitapların çerçeveli gösterimi
        sb.append(frameAuthorBooks(author, books)).append("\n");
    }

    return sb.toString().trim();
}

    private String frameAuthorBooks(Author author, List<Book> books) {
        StringBuilder sb = new StringBuilder();
        String border = "*********************************";
        int width = border.length() - 4;

        // Yazar ismi çerçeveleme
        sb.append(border).append("\n");
        sb.append("*").append(" ".repeat(width + 2)).append("*").append("\n");
        sb.append("* ").append(String.format("%-" + width + "s", "Author: " + author.getName())).append(" *").append("\n");
        sb.append("*").append(" ".repeat(width + 2)).append("*").append("\n");

        // Her kitap için çerçeveli gösterim
        for (Book book : books) {
            sb.append(border).append("\n");
            sb.append("* ").append(String.format("%-" + width + "s", "bookID: " + book.getBookID())).append(" *").append("\n");
            sb.append("* ").append(String.format("%-" + width + "s", "title: " + book.getTitle())).append(" *").append("\n");
            sb.append("* ").append(String.format("%-" + width + "s", "price: " + book.getPrice())).append(" *").append("\n");
            sb.append("* ").append(String.format("%-" + width + "s", "status: " + book.getStatus())).append(" *").append("\n");
            sb.append("* ").append(String.format("%-" + width + "s", "edition: " + book.getEdition())).append(" *").append("\n");
            sb.append("* ").append(String.format("%-" + width + "s", "dateOfPurchase: " + book.getDateOfPurchase())).append(" *").append("\n");
            sb.append("*").append(" ".repeat(width + 2)).append("*").append("\n");
            sb.append(border).append("\n");
        }

        return sb.toString();
    }


}



