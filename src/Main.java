import org.workintech.books.Book;
import org.workintech.books.Status;
import org.workintech.library.Library;
import org.workintech.person.Author;
import org.workintech.person.Reader;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        // Yazarlar
        Author hakanGunday = new Author("Hakan Günday");
        Author orhanPamuk = new Author("Orhan Pamuk");
        Author sabahattinAli = new Author("Sabahattin Ali");
        Author ahmetUmit = new Author("Ahmet Ümit");
        Author elifShafak = new Author("Elif Şafak");

        // Hakan Günday Kitapları
        List<Book> hakanGundayBooks = new ArrayList<>();
        hakanGundayBooks.add(new Book(1L, hakanGunday, "Kinyas ve Kayra", 105.12, Status.PURCHASED, "first edition", "11.11.2015"));
        hakanGundayBooks.add(new Book(2L, hakanGunday, "Daha", 115.12, Status.BORROWED, "second edition", "11.11.2016"));
        hakanGundayBooks.add(new Book(3L, hakanGunday, "Malafa", 120.20, Status.AVAILABLE, "first edition", "11.11.2017"));
        hakanGunday.setBooks(hakanGundayBooks);

        // Orhan Pamuk Kitapları
        List<Book> orhanPamukBooks = new ArrayList<>();
        orhanPamukBooks.add(new Book(4L, orhanPamuk, "Benim Adım Kırmızı", 130.50, Status.PURCHASED, "third edition", "05.05.2010"));
        orhanPamukBooks.add(new Book(5L, orhanPamuk, "Kara Kitap", 140.75, Status.BORROWED, "first edition", "22.02.2012"));
        orhanPamukBooks.add(new Book(6L, orhanPamuk, "Masumiyet Müzesi", 150.80, Status.AVAILABLE, "second edition", "12.12.2014"));
        orhanPamuk.setBooks(orhanPamukBooks);

        // Sabahattin Ali Kitapları
        List<Book> sabahattinAliBooks = new ArrayList<>();
        sabahattinAliBooks.add(new Book(7L, sabahattinAli, "Kürk Mantolu Madonna", 75.50, Status.PURCHASED, "fourth edition", "08.08.2018"));
        sabahattinAliBooks.add(new Book(8L, sabahattinAli, "İçimizdeki Şeytan", 85.25, Status.BORROWED, "first edition", "10.10.2020"));
        sabahattinAliBooks.add(new Book(9L, sabahattinAli, "Kuyucaklı Yusuf", 95.60, Status.AVAILABLE, "second edition", "03.03.2021"));
        sabahattinAli.setBooks(sabahattinAliBooks);

        // Ahmet Ümit Kitapları
        List<Book> ahmetUmitBooks = new ArrayList<>();
        ahmetUmitBooks.add(new Book(10L, ahmetUmit, "İstanbul Hatırası", 110.40, Status.PURCHASED, "first edition", "15.05.2013"));
        ahmetUmitBooks.add(new Book(11L, ahmetUmit, "Beyoğlu Rapsodisi", 100.90, Status.BORROWED, "second edition", "17.07.2015"));
        ahmetUmitBooks.add(new Book(12L, ahmetUmit, "Kavim", 120.00, Status.AVAILABLE, "first edition", "19.09.2017"));
        ahmetUmit.setBooks(ahmetUmitBooks);

        // Elif Şafak Kitapları
        List<Book> elifShafakBooks = new ArrayList<>();
        elifShafakBooks.add(new Book(13L, elifShafak, "Aşk", 130.70, Status.PURCHASED, "third edition", "23.11.2014"));
        elifShafakBooks.add(new Book(14L, elifShafak, "Baba ve Piç", 140.80, Status.BORROWED, "first edition", "25.12.2016"));
        elifShafakBooks.add(new Book(15L, elifShafak, "Şemspare", 150.90, Status.AVAILABLE, "second edition", "27.01.2018"));
        elifShafak.setBooks(elifShafakBooks);

        // Test Çıktısı
//        System.out.println(hakanGunday);
//        System.out.println(orhanPamuk);
//        System.out.println(sabahattinAli);
//        System.out.println(ahmetUmit);
//        System.out.println(elifShafak);

       List<Book> allBooks=new ArrayList<>();
        allBooks.addAll(elifShafakBooks);
        allBooks.addAll(hakanGundayBooks);
        allBooks.addAll(orhanPamukBooks);
        allBooks.addAll(ahmetUmitBooks);
        allBooks.addAll(sabahattinAliBooks);

      //  System.out.println(allBooks);

        List<Reader> readers=new ArrayList<>();
        readers.add(new Reader("Ahmet Yılmaz"));
        readers.add(new Reader("Ayşe Korkmaz"));
        readers.add(new Reader("Mehmet Tanrıverdi"));
        readers.add(new Reader("Işık Saçan"));
        readers.add(new Reader("Zehra Bal"));
        readers.add(new Reader("Salih Bal"));

        Library library=new Library(allBooks,readers);
        System.out.println(library);
    }
}