import org.workintech.books.Book;
import org.workintech.books.Status;
import org.workintech.library.Library;
import org.workintech.person.*;

import java.sql.SQLOutput;
import java.time.LocalDate;

import java.time.temporal.ChronoUnit;
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
        hakanGundayBooks.add(new Book(1L, hakanGunday, "Kinyas ve Kayra", 105.12, Status.AVAILABLE, "first edition"));
        hakanGundayBooks.add(new Book(2L, hakanGunday, "Daha", 115.12, Status.AVAILABLE, "second edition"));
        hakanGundayBooks.add(new Book(3L, hakanGunday, "Malafa", 120.20, Status.AVAILABLE, "first edition"));
        hakanGunday.setBooks(hakanGundayBooks);

        // Orhan Pamuk Kitapları
        List<Book> orhanPamukBooks = new ArrayList<>();
        orhanPamukBooks.add(new Book(4L, orhanPamuk, "Benim Adım Kırmızı", 130.50, Status.AVAILABLE, "third edition"));
        orhanPamukBooks.add(new Book(5L, orhanPamuk, "Kara Kitap", 140.75, Status.AVAILABLE, "first edition"));
        orhanPamukBooks.add(new Book(6L, orhanPamuk, "Masumiyet Müzesi", 150.80, Status.AVAILABLE, "second edition"));
        orhanPamuk.setBooks(orhanPamukBooks);

        // Sabahattin Ali Kitapları
        List<Book> sabahattinAliBooks = new ArrayList<>();
        sabahattinAliBooks.add(new Book(7L, sabahattinAli, "Kürk Mantolu Madonna", 75.50, Status.AVAILABLE, "fourth edition"));
        sabahattinAliBooks.add(new Book(8L, sabahattinAli, "İçimizdeki Şeytan", 85.25, Status.AVAILABLE, "first edition"));
        sabahattinAliBooks.add(new Book(9L, sabahattinAli, "Kuyucaklı Yusuf", 95.60, Status.AVAILABLE, "second edition"));
        sabahattinAli.setBooks(sabahattinAliBooks);

        // Ahmet Ümit Kitapları
        List<Book> ahmetUmitBooks = new ArrayList<>();
        ahmetUmitBooks.add(new Book(10L, ahmetUmit, "İstanbul Hatırası", 110.40, Status.AVAILABLE, "first edition"));
        ahmetUmitBooks.add(new Book(11L, ahmetUmit, "Beyoğlu Rapsodisi", 100.90, Status.AVAILABLE, "second edition"));
        ahmetUmitBooks.add(new Book(12L, ahmetUmit, "Kavim", 120.00, Status.AVAILABLE, "first edition"));
        ahmetUmit.setBooks(ahmetUmitBooks);

        // Elif Şafak Kitapları
        List<Book> elifShafakBooks = new ArrayList<>();
        elifShafakBooks.add(new Book(13L, elifShafak, "Aşk", 130.70, Status.AVAILABLE, "third edition"));
        elifShafakBooks.add(new Book(14L, elifShafak, "Baba ve Piç", 140.80, Status.AVAILABLE, "first edition"));
        elifShafakBooks.add(new Book(15L, elifShafak, "Şemspare", 150.90, Status.AVAILABLE, "second edition"));
        elifShafak.setBooks(elifShafakBooks);

        //Test Çıktısı
//         System.out.println(hakanGunday);
//       System.out.println(orhanPamuk);
//       System.out.println(sabahattinAli);
//       System.out.println(ahmetUmit);
//       System.out.println(elifShafak);

       List<Book> allBooks=new ArrayList<>();
        allBooks.addAll(elifShafakBooks);
        allBooks.addAll(hakanGundayBooks);
        allBooks.addAll(orhanPamukBooks);
        allBooks.addAll(ahmetUmitBooks);
        allBooks.addAll(sabahattinAliBooks);

   //     System.out.println(allBooks);

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
        Library library =new Library(libraryContent,readers);
       //  System.out.println(library);
        // System.out.println( library.getBook(1L));

        Reader reader=readers.get(0);
     //   System.out.println(reader.getName());
//        Book newbook=allBooks.get(5);
//        LocalDate purchaseDate=LocalDate.of(2023,11,11);
//        reader.purchaseBook(newbook,purchaseDate);
     //   System.out.println(reader.getPurchasedBooks());
    //    System.out.println(library);

    //    library.newBook(new Book(101L,hakanGunday,"Zamir",170.89,Status.AVAILABLE,"Second Edition"));
     //    System.out.println(library);
   //     Author georgeOrwell = new Author("George Orwell");
   //    library.newBook(new Book(16L, georgeOrwell, "1984", 180.50, Status.AVAILABLE, "first edition"));
//
//        System.out.println(library.getBook(16L));
//        System.out.println(library.getReaders());
//        reader.borrowBook(newbook,purchaseDate);
//        System.out.println(newbook.getDateOfPurchase());
            Librarian librarian =new Librarian("Alicent","todayIsBoring1234",library);
         LocalDate today=LocalDate.now();
//        System.out.println(today);
//        System.out.println(newbook.getStatus());
//       // long daysOverdue = ChronoUnit.DAYS.between(purchaseDate,today);
//       // System.out.println(daysOverdue);
//       //
//         reader.borrowBook(library.getBook(8L),purchaseDate);
//         System.out.println(library.getBook(8L).getStatus());
//        librarian.calculateFine(newbook);
     //   System.out.println(library);
        Book newbook = allBooks.get(5);
        LocalDate borrowDate = LocalDate.of(2023, 11, 11);
   //     reader.borrowBook(newbook, borrowDate);
  //      System.out.println("Kitabın durumu: " + newbook.getStatus()); // BURROWED bekleniyor

// Güncel durumu doğrulamak için:
        librarian.registerMember(reader, MembershipType.PERSONAL_MEMBERSHIP,today,"istanbul/Maltepe","5877894512");
        MemberRecord member=library.getMemberByID("MEM1");
        System.out.println(library.getMembers());
       librarian.issueBook(11L,library.getMemberByID("MEM1"),today);
        librarian.issueBook(13L,library.getMemberByID("MEM1"),today);
//       System.out.println(  library.getMemberByID("MEM1"));
//        System.out.println(library.getMemberByID("MEM1").getBorrowedBooks());
//        System.out.println(reader.getBorrowedBooks());
//        System.out.println(reader.toString());

       System.out.println(member.getBorrowedBooks());
        System.out.println(member.getPurchasedBooks());
        System.out.println(library);

    }
}