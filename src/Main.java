import org.workintech.books.Book;
import org.workintech.books.Status;
import org.workintech.library.Library;
import org.workintech.person.Author;
import org.workintech.person.Reader;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

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
        hakanGundayBooks.add(new Book(1L, hakanGunday, "Kinyas ve Kayra", 105.12, Status.AVAILABLE, "first edition", "11.11.2015"));
        hakanGundayBooks.add(new Book(2L, hakanGunday, "Daha", 115.12, Status.AVAILABLE, "second edition", "11.11.2016"));
        hakanGundayBooks.add(new Book(3L, hakanGunday, "Malafa", 120.20, Status.AVAILABLE, "first edition", "11.11.2017"));
        hakanGunday.setBooks(hakanGundayBooks);

        // Orhan Pamuk Kitapları
        List<Book> orhanPamukBooks = new ArrayList<>();
        orhanPamukBooks.add(new Book(4L, orhanPamuk, "Benim Adım Kırmızı", 130.50, Status.AVAILABLE, "third edition", "05.05.2010"));
        orhanPamukBooks.add(new Book(5L, orhanPamuk, "Kara Kitap", 140.75, Status.AVAILABLE, "first edition", "22.02.2012"));
        orhanPamukBooks.add(new Book(6L, orhanPamuk, "Masumiyet Müzesi", 150.80, Status.AVAILABLE, "second edition", "12.12.2014"));
        orhanPamuk.setBooks(orhanPamukBooks);

        // Sabahattin Ali Kitapları
        List<Book> sabahattinAliBooks = new ArrayList<>();
        sabahattinAliBooks.add(new Book(7L, sabahattinAli, "Kürk Mantolu Madonna", 75.50, Status.AVAILABLE, "fourth edition", "08.08.2018"));
        sabahattinAliBooks.add(new Book(8L, sabahattinAli, "İçimizdeki Şeytan", 85.25, Status.AVAILABLE, "first edition", "10.10.2020"));
        sabahattinAliBooks.add(new Book(9L, sabahattinAli, "Kuyucaklı Yusuf", 95.60, Status.AVAILABLE, "second edition", "03.03.2021"));
        sabahattinAli.setBooks(sabahattinAliBooks);

        // Ahmet Ümit Kitapları
        List<Book> ahmetUmitBooks = new ArrayList<>();
        ahmetUmitBooks.add(new Book(10L, ahmetUmit, "İstanbul Hatırası", 110.40, Status.AVAILABLE, "first edition", "15.05.2013"));
        ahmetUmitBooks.add(new Book(11L, ahmetUmit, "Beyoğlu Rapsodisi", 100.90, Status.AVAILABLE, "second edition", "17.07.2015"));
        ahmetUmitBooks.add(new Book(12L, ahmetUmit, "Kavim", 120.00, Status.AVAILABLE, "first edition", "19.09.2017"));
        ahmetUmit.setBooks(ahmetUmitBooks);

        // Elif Şafak Kitapları
        List<Book> elifShafakBooks = new ArrayList<>();
        elifShafakBooks.add(new Book(13L, elifShafak, "Aşk", 130.70, Status.AVAILABLE, "third edition", "23.11.2014"));
        elifShafakBooks.add(new Book(14L, elifShafak, "Baba ve Piç", 140.80, Status.AVAILABLE, "first edition", "25.12.2016"));
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
        readers.add(new Reader("Ahmet Yılmaz",260.0));
        readers.add(new Reader("Ayşe Korkmaz",300.02));
        readers.add(new Reader("Mehmet Tanrıverdi",150.18));
        readers.add(new Reader("Işık Saçan",1000.78));
        readers.add(new Reader("Zehra Bal",80.78));
        readers.add(new Reader("Salih Bal",15000.0));
        Map<Author,List<Book>> libraryContent=new TreeMap<>();
        libraryContent.put(hakanGunday,hakanGundayBooks);
        libraryContent.put(elifShafak,elifShafakBooks);
        libraryContent.put(sabahattinAli,sabahattinAliBooks);
        libraryContent.put(orhanPamuk,orhanPamukBooks);
        libraryContent.put(ahmetUmit,ahmetUmitBooks);
        Library library =new Library(libraryContent);

       // System.out.println(library);
       // System.out.println( library.getBook(hakanGunday,1L));

        Reader reader=readers.get(0);
       // System.out.println(reader.getName());
        Book newbook=allBooks.get(5);
      reader.purchaseBook(newbook,library);
      //  System.out.println(reader.getPurchasedBooks());
       // System.out.println(library);

        library.newBook(new Book(101L,hakanGunday,"Zamir",170.89,Status.AVAILABLE,"Second Edition","15.11.2024"));
       // System.out.println(library);
        Author georgeOrwell = new Author("George Orwell");
       library.newBook(new Book(16L, georgeOrwell, "1984", 180.50, Status.AVAILABLE, "first edition", "01.01.2022")); ;
        library.display();
        //System.out.println(library.getBook(georgeOrwell,16L));
    }
}