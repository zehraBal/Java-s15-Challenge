import org.workintech.books.*;
import org.workintech.library.Library;
import org.workintech.person.*;

import java.time.LocalDate;
import java.util.*;

public class LibraryApp {

    public static void main(String[] args) {
        // Başlangıç kitapları ve yazarlar
        Author orwell = new Author("George Orwell");

        Author gunday = new Author("Hakan Günday");
        Author pamuk = new Author("Orhan Pamuk");
        Author ali = new Author("Sabahattin Ali");
        Author umit = new Author("Ahmet Ümit");
        Author tolstoy=new Author("Leo Tolstoy");
        Author dostoyevsky=new Author("Fyodor Dostoyevsky");
        Author kafka=new Author("Franz Kafka");
        Author tolkien=new Author("J.R.R. Tolkien");
        Author rowling=new Author("J.K. Rowling");
        Author martin=new Author("George R.R. Martin");
        Author asimov=new Author("Isaac Asimov");
        Author bradbury=new Author("Ray Bradbury");
        Author clarke=new Author("Arthur C. Clarke");

        // Hakan Günday Kitapları
        List<Book> hakanGundayBooks = new ArrayList<>();
        hakanGundayBooks.add(new TurkishLiteratureBooks(1L, gunday, "Kinyas ve Kayra", 105.12, Status.AVAILABLE, "first edition"));
        hakanGundayBooks.add(new TurkishLiteratureBooks(2L, gunday, "Daha", 115.12, Status.AVAILABLE, "second edition"));
        hakanGundayBooks.add(new TurkishLiteratureBooks(3L, gunday, "Malafa", 120.20, Status.AVAILABLE, "first edition"));
        gunday.setBooks(hakanGundayBooks);

        // Sabahattin Ali Kitapları
        List<Book> sabahattinAliBooks = new ArrayList<>();
        sabahattinAliBooks.add(new TurkishLiteratureBooks(4L, ali, "Kürk Mantolu Madonna", 75.50, Status.AVAILABLE, "fourth edition"));
        sabahattinAliBooks.add(new TurkishLiteratureBooks(5L, ali, "İçimizdeki Şeytan", 85.25, Status.AVAILABLE, "first edition"));
        sabahattinAliBooks.add(new TurkishLiteratureBooks(6L, ali, "Kuyucaklı Yusuf", 95.60, Status.AVAILABLE, "second edition"));
        ali.setBooks(sabahattinAliBooks);

        // Ahmet Ümit Kitapları
        List<Book> ahmetUmitBooks = new ArrayList<>();
        ahmetUmitBooks.add(new TurkishLiteratureBooks(7L, umit, "İstanbul Hatırası", 110.40, Status.AVAILABLE, "first edition"));
        ahmetUmitBooks.add(new TurkishLiteratureBooks(8L, umit, "Beyoğlu Rapsodisi", 100.90, Status.AVAILABLE, "second edition"));
        ahmetUmitBooks.add(new TurkishLiteratureBooks(9L, umit, "Kavim", 120.00, Status.AVAILABLE, "first edition"));
        umit.setBooks(ahmetUmitBooks);

        //Leo Tolstoy
        List<Book> tolstoyBooks = new ArrayList<>();
        tolstoyBooks.add(new WorldClassicsBooks(10L, tolstoy, "Anna Karenina", 120.00, Status.AVAILABLE, "1st Edition"));
        tolstoyBooks.add(new WorldClassicsBooks(11L, tolstoy, "War and Peace", 130.00, Status.AVAILABLE, "1st Edition"));
        tolstoyBooks.add(new WorldClassicsBooks(12L, tolstoy, "Resurrection", 110.00, Status.AVAILABLE, "2nd Edition"));

        //Fyodor Dostoyevsky
        List<Book> dostoyevskiBooks = new ArrayList<>();
        dostoyevskiBooks.add(new WorldClassicsBooks(13L, dostoyevsky, "Crime and Punishment", 125.00, Status.AVAILABLE, "1st Edition"));
        dostoyevskiBooks.add(new WorldClassicsBooks(14L, dostoyevsky, "The Brothers Karamazov", 135.00, Status.AVAILABLE, "1st Edition"));
        dostoyevskiBooks.add(new WorldClassicsBooks(15L, dostoyevsky, "The Idiot", 120.00, Status.AVAILABLE, "2nd Edition"));

        //Franz Kafka
        List<Book> kafkaBooks = new ArrayList<>();
        kafkaBooks.add(new WorldClassicsBooks(16L, kafka, "The Trial", 120.00, Status.AVAILABLE, "1st Edition"));
        kafkaBooks.add(new WorldClassicsBooks(17L, kafka, "The Metamorphosis", 110.00, Status.AVAILABLE, "1st Edition"));
        kafkaBooks.add(new WorldClassicsBooks(18L, kafka, "The Castle", 125.00, Status.AVAILABLE, "2nd Edition"));

        //J.R.R. Tolkien
        List<Book> tolkienBooks = new ArrayList<>();
        tolkienBooks.add(new FantasyFictionBooks(19L, tolkien, "The Hobbit", 150.00, Status.AVAILABLE, "1st Edition"));
        tolkienBooks.add(new FantasyFictionBooks(20L, tolkien, "The Lord of the Rings: The Fellowship of the Ring", 180.00, Status.AVAILABLE, "1st Edition"));
        tolkienBooks.add(new FantasyFictionBooks(21L, tolkien, "The Lord of the Rings: The Two Towers", 180.00, Status.AVAILABLE, "2nd Edition"));

        //J.K. Rowling
        List<Book> rowlingBooks = new ArrayList<>();
        rowlingBooks.add(new FantasyFictionBooks(22L, rowling, "Harry Potter and the Philosopher's Stone", 120.00, Status.AVAILABLE, "1st Edition"));
        rowlingBooks.add(new FantasyFictionBooks(23L, rowling, "Harry Potter and the Chamber of Secrets", 130.00, Status.AVAILABLE, "1st Edition"));
        rowlingBooks.add(new FantasyFictionBooks(24L, rowling, "Harry Potter and the Prisoner of Azkaban", 140.00, Status.AVAILABLE, "2nd Edition"));

        //George R.R. Martin
        List<Book> martinBooks = new ArrayList<>();
        martinBooks.add(new FantasyFictionBooks(25L, martin, "A Game of Thrones", 160.00, Status.AVAILABLE, "1st Edition"));
        martinBooks.add(new FantasyFictionBooks(26L, martin, "A Clash of Kings", 170.00, Status.AVAILABLE, "1st Edition"));
        martinBooks.add(new FantasyFictionBooks(27L, martin, "A Storm of Swords", 180.00, Status.AVAILABLE, "2nd Edition"));

        // Isaac Asimov
        List<Book> asimovBooks = new ArrayList<>();
        asimovBooks.add(new ScienceFictionBooks(28L, asimov, "Foundation", 150.00, Status.AVAILABLE, "1st Edition"));
        asimovBooks.add(new ScienceFictionBooks(29L, asimov, "I, Robot", 140.00, Status.AVAILABLE, "1st Edition"));
        asimovBooks.add(new ScienceFictionBooks(30L, asimov, "The Gods Themselves", 160.00, Status.AVAILABLE, "2nd Edition"));

        // Ray Bradbury
        List<Book> bradburyBooks = new ArrayList<>();
        bradburyBooks.add(new ScienceFictionBooks(31L, bradbury, "Fahrenheit 451", 130.00, Status.AVAILABLE, "1st Edition"));
        bradburyBooks.add(new ScienceFictionBooks(32L, bradbury, "The Martian Chronicles", 125.00, Status.AVAILABLE, "1st Edition"));
        bradburyBooks.add(new ScienceFictionBooks(33L, bradbury, "Something Wicked This Way Comes", 140.00, Status.AVAILABLE, "2nd Edition"));

        // Arthur C. Clarke
        List<Book> clarkeBooks = new ArrayList<>();
        clarkeBooks.add(new ScienceFictionBooks(34L, clarke, "2001: A Space Odyssey", 160.00, Status.AVAILABLE, "1st Edition"));
        clarkeBooks.add(new ScienceFictionBooks(35L, clarke, "Childhood's End", 150.00, Status.AVAILABLE, "1st Edition"));
        clarkeBooks.add(new ScienceFictionBooks(36L, clarke, "Rendezvous with Rama", 170.00, Status.AVAILABLE, "2nd Edition"));

        Map<Author, List<Book>> libraryContents = new TreeMap<>();

        libraryContents.put(gunday, hakanGundayBooks);
        libraryContents.put(ali, sabahattinAliBooks);
        libraryContents.put(umit, ahmetUmitBooks);
        libraryContents.put(tolstoy,tolstoyBooks);
        libraryContents.put(dostoyevsky,dostoyevskiBooks);
        libraryContents.put(kafka,kafkaBooks);
        libraryContents.put(tolkien,tolkienBooks);
        libraryContents.put(martin,martinBooks);
        libraryContents.put(rowling,rowlingBooks);
        libraryContents.put(asimov,asimovBooks);
        libraryContents.put(bradbury,bradburyBooks);
        libraryContents.put(clarke,clarkeBooks);


        // Başlangıç okuyucuları
        Reader reader1 = new Reader("John Doe", 50.00);
        Reader reader2 = new Reader("Jane Smith", 30.00);
        Reader reader3 = new Reader("Alice Johnson", 40.00);
        Reader reader4 = new Reader("Bob Brown", 20.00);

        List<Reader> readers = new ArrayList<>(List.of(reader1, reader2));

        // Kütüphane ve kütüphaneci oluşturma
        Library library = new Library(libraryContents, readers);
        Librarian librarian = new Librarian("Alice", "admin123", library);

        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            System.out.println("Welcome to the Library! Please choose an option:");
            System.out.println("1. Search for a book");
            System.out.println("2. Borrow a book (Members only)");
            System.out.println("3. Purchase a book");
            System.out.println("4. Become a member");
            System.out.println("5. Pay late fee (Members only)");
            System.out.println("6. Show membership details");
            System.out.println("7. Show reader details");
            System.out.println("8. Show borrowed books (Members only)");
            System.out.println("9. Show purchased books");
            System.out.println("10. Show all books in library");
            System.out.println("11. Show all readers");
            System.out.println("12. Show all members");
            System.out.println("13. Return book(Members only");
            System.out.println("14. Exit");

            System.out.print("Your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter the title of the book you want to search: ");
                    String title = scanner.nextLine();
                    Book foundBook = library.getBook(title);
                    if (foundBook != null) {
                        System.out.println(foundBook);
                    } else {
                        System.out.println("Book not found.");
                    }
                    break;

                case 2:  // Borrow a book (Members only)
                    System.out.print("Enter your Member ID: ");
                    String memberId = scanner.nextLine();
                    MemberRecord member = library.getMemberByID(memberId);
                    if (member != null) {
                        System.out.print("Enter the ID of the book you want to borrow: ");
                        long bookId = scanner.nextLong();
                        Book bookToBorrow = library.getBook(bookId);
                        if (bookToBorrow != null && bookToBorrow.getStatus() == Status.AVAILABLE) {
                            member.borrowBook(bookToBorrow, LocalDate.now());
                            library.lendBook(bookToBorrow);
                        } else {
                            System.out.println("The book is not available.");
                        }
                    } else {
                        System.out.println("Member not found.");
                    }
                    break;

                case 3:  // Purchase a book
                    System.out.print("Enter your name: ");
                    String name = scanner.nextLine();
                    Reader reader = library.findReaderByName(name);
                    if (reader != null) {
                        System.out.print("Enter the ID of the book you want to purchase: ");
                        long bookId = scanner.nextLong();
                        Book bookToPurchase = library.getBook(bookId);
                        if (bookToPurchase != null && bookToPurchase.getStatus() == Status.AVAILABLE) {
                            reader.purchaseBook(bookToPurchase, LocalDate.now());
                            library.removeBook(bookToPurchase);
                        } else {
                            System.out.println("The book is not available.");
                        }
                    } else {
                        System.out.println("Reader not found.");
                    }
                    break;

                case 4:  // Become a member
                    System.out.print("Enter your name: ");
                    name = scanner.nextLine();
                    reader = library.findReaderByName(name);
                    if (reader != null) {
                        // Üyelik tipini seçtir
                        System.out.println("Select a membership type:");
                        System.out.println("1. Personal Membership");
                        System.out.println("2. Organizational Membership");
                        System.out.println("3. Corporate Membership");
                        System.out.println("4. Special Membership");
                        System.out.print("Your choice: ");
                        int membershipChoice = scanner.nextInt();
                        scanner.nextLine();  // Consume newline

                        MembershipType selectedMembershipType;
                        switch (membershipChoice) {
                            case 1:
                                selectedMembershipType = MembershipType.PERSONAL_MEMBERSHIP;
                                break;
                            case 2:
                                selectedMembershipType = MembershipType.ORGANIZATIONAL_MEMBERSHIP;
                                break;
                            case 3:
                                selectedMembershipType = MembershipType.CORPORATE_MEMBERSHIP;
                                break;
                            case 4:
                                selectedMembershipType = MembershipType.SPECIAL_MEMBERSHIP;
                                break;
                            default:
                                System.out.println("Invalid choice. Defaulting to Personal Membership.");
                                selectedMembershipType = MembershipType.PERSONAL_MEMBERSHIP;
                                break;
                        }

                        // Kullanıcıdan adres ve telefon numarasını al
                        System.out.print("Enter your address: ");
                        String address = scanner.nextLine();

                        System.out.print("Enter your phone number: ");
                        String phoneNumber = scanner.nextLine();

                        // Üyeyi kaydet
                       String memberID= librarian.registerMember(reader, selectedMembershipType, LocalDate.now(), address, phoneNumber);


                        // Yeni üyenin Member ID'sini göster
                        System.out.println(library.getMemberByID(memberID));
                    }
                    break;

                case 5:  // Pay late fee (Members only)
                    System.out.print("Enter your Member ID: ");
                    memberId = scanner.nextLine();
                    member = library.getMemberByID(memberId);
                    if (member != null) {
                        if (member.getType() == MembershipType.PENALIZED_MEMBERSHIP) {
                            member.payLateFee(member.getLateReturnFee());
                        } else {
                            System.out.println("You don't have any late fees or you're not penalized.");
                        }
                    }
                    break;

                case 6:  // Show membership details
                    System.out.print("Enter your Member ID: ");
                    memberId = scanner.nextLine();
                    member = library.getMemberByID(memberId);
                    if (member != null) {
                        System.out.println(member);
                    } else {
                        System.out.println("Member not found.");
                    }
                    break;

                case 7:  // Show reader details
                    System.out.print("Enter your name: ");
                    name = scanner.nextLine();
                    reader = library.findReaderByName(name);
                    if (reader != null) {
                        System.out.println(reader);
                    } else {
                        System.out.println("Reader not found.");
                    }
                    break;

                case 8:  // Show borrowed books (Members only)
                    System.out.print("Enter your Member ID: ");
                    memberId = scanner.nextLine();
                    member = library.getMemberByID(memberId);
                    if (member != null) {
                        List<Book> borrowedBooks = member.getBorrowedBooks();
                        if (borrowedBooks.isEmpty()) {
                            System.out.println("No borrowed books.");
                        } else {
                            borrowedBooks.forEach(System.out::println);
                        }
                    } else {
                        System.out.println("Member not found.");
                    }
                    break;

                case 9:  // Show purchased books
                    System.out.print("Enter your name: ");
                    name = scanner.nextLine();
                    reader = library.findReaderByName(name);
                    if (reader != null) {
                        List<Book> purchasedBooks = reader.getPurchasedBooks();
                        if (purchasedBooks.isEmpty()) {
                            System.out.println("No purchased books.");
                        } else {
                            purchasedBooks.forEach(System.out::println);
                        }
                    } else {
                        System.out.println("Reader not found.");
                    }
                    break;

                case 10:  // Show all books in library
                    library.getBooks();
                    break;

                case 11:  // Show all readers
                    List<Reader> allReaders = library.getReaders();
                    if (allReaders.isEmpty()) {
                        System.out.println("No readers found.");
                    } else {
                        allReaders.forEach(System.out::println);
                    }
                    break;

                case 12:  // Show all members
                    List<MemberRecord> allMembers = library.getMembers();
                    if (allMembers.isEmpty()) {
                        System.out.println("No members found.");
                    } else {
                        allMembers.forEach(System.out::println);
                    }
                    break;

                case 13:  // Return book
                    System.out.print("Enter your Member ID: ");
                    memberId = scanner.nextLine();
                    member = library.getMemberByID(memberId);
                    if(member!=null){
                        System.out.println("Enter the ID of the book you want to return.");
                       long bookID = scanner.nextLong();
                       librarian.returnBook(member,library.getBook(bookID));
                    }
                case 14:  // Exit
                    System.out.println("Thank you for visiting the library. Goodbye!");
                    exit = true;
                    break;

                default:
                    System.out.println("Invalid option. Please try again.");
                    break;
            }
            System.out.println();
        }

        scanner.close();
    }
}
