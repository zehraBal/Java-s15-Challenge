package org.workintech.library;

import org.workintech.books.Book;
import org.workintech.person.Reader;

import java.util.List;

public class Library {
    private List<Book> books;
    private List<Reader> readers;

    public Library(List<Book> books, List<Reader> readers) {
        this.books = books;
        this.readers = readers;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    public List<Reader> getReaders() {
        return readers;
    }

    public void setReaders(List<Reader> readers) {
        this.readers = readers;
    }

    //bookıd ile listede gezinsin bu id ile eşleşen ilk kitabı geri dönsün şeklinde çalışmalı bence?
    public String getBook() {
        StringBuilder sb = new StringBuilder();
        for (Book book : books) {
            sb.append(book.toString()).append("\n");
        }
        return sb.toString();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        // Kitaplar bölümü
        sb.append("Library Books:\n");
        for (Book book : books) {
            sb.append(book.toString()).append("\n");
        }

        // Okuyucular bölümü
        sb.append("Library Readers:\n");
        for (Reader reader : readers) {
            sb.append(frameReader(reader.toString())).append("\n");
        }

        return sb.toString().trim();
    }

        private String frameReader(String readerInfo) {
        StringBuilder sb = new StringBuilder();
        String border = "*********************************";
        int width = border.length() - 4;

        sb.append(border).append("\n");
        sb.append("*").append(" ".repeat(width + 2)).append("*").append("\n");
        for (String line : readerInfo.split("\n")) {
            sb.append("* ").append(String.format("%-" + width + "s", line)).append(" *").append("\n");
        }
        sb.append("*").append(" ".repeat(width + 2)).append("*").append("\n");
        sb.append(border);

        return sb.toString();
    }
}



