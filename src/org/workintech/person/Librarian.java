package org.workintech.person;

import org.workintech.books.Book;
import org.workintech.books.Status;
import org.workintech.library.Library;


import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

public class Librarian extends Person{
    private String password;
    private Library library;
    private static AtomicInteger memberIDCounter = new AtomicInteger(0);
    private static final double dailyFine=1.5;
    public Librarian(String name,String password,Library library) {
        super(name);
        this.password=password;
        this.library=library;
    }

    public String searchBook(Book book){
        if(verifyPassword()){
             library.showBook(book.getAuthor(), book.getBookID());
        }else{
            return "Wrong password.";
        }
        return "The book you are searching does not exist.";

    }

    public boolean verifyMember(MemberRecord memberRecord){
      List<MemberRecord> memberRecords = library.getMembers();
          for(MemberRecord mem: memberRecords){
              if(mem.getMemberID().equals(memberRecord.getMemberID())){
                  return true;
              }
          }
       return false;
    }

    public void issueBook(long bookID, MemberRecord member, LocalDate date){
        if(verifyPassword()){
            if(verifyMember(member) && member.getType()!=MembershipType.PENALIZED_MEMBERSHIP){
                Book book = library.getBook(bookID);
                if (book == null) {
                    System.out.println("The book with ID " + bookID + " is not available in the library.");

                }
                if(book.getStatus()!= Status.AVAILABLE){
                    System.out.println("The book with ID " + bookID + " is not currently available.");

                }
                System.out.println("Would you like to borrow or purchase this book?");
                Scanner scanner=new Scanner(System.in);
                String memberRequest=scanner.next().toLowerCase();
                if(memberRequest.equals("borrow")){
                    member.borrowBook(book,date);
                    book.updateStatus(Status.BORROWED);
                    System.out.println("The book '" + book.getTitle() + "' has been borrowed by " + member.getName() + ".");
                    createBill( member,book,"borrow",date);

                }else if(memberRequest.equals("purchase")){
                    member.purchaseBook(book,date);
                    System.out.println("The book '" + book.getTitle() + "' has been purchased by " + member.getName() + ".");
                    createBill(member,book,"purchase",date);

                }

            }
            System.out.println("The reader is not a valid member of the library.");

        }
        System.out.println("Incorrect password. Access denied.");
    }


    public void returnBook(MemberRecord member,Book book){
        if(book.getStatus()!=Status.PURCHASED && book.getStatus()!=Status.AVAILABLE){
            LocalDate today=LocalDate.now();
            long daysOverdue = ChronoUnit.DAYS.between(book.getDateOfPurchase(), today);
            List<Book> borrowedBooks = member.getBorrowedBooks();
            if(daysOverdue<=15){
                borrowedBooks.remove(book);
                book.updateStatus(Status.AVAILABLE);
                member.setBudget(member.getBudget()+book.getPrice()*0.1);
                System.out.println("You have returned the book within 15 days. Your deposit has been refunded.Thank you.");
            }else if(daysOverdue>15){
             if((member.getBudget()+book.getPrice()*0.1)>=calculateFine(book))    {
                 borrowedBooks.remove(book);
                 book.updateStatus(Status.AVAILABLE);
                 member.setBudget(member.getBudget()+book.getPrice()*0.1-calculateFine(book));
                 System.out.println("Since you did not return your book on time, the late payment penalty has been deducted from your account and your deposit has been deposited into your account.");
             }else{
                 borrowedBooks.remove(book);
                 book.updateStatus(Status.AVAILABLE);
                 member.setBudget(member.getBudget()+book.getPrice()*0.1);
                 System.out.println("You were unable to pay the late fee because you did not have enough funds in your account. Your account has been suspended until your late fee is paid. Please pay your late fee to borrow or purchase a book.");
                 member.updateType(MembershipType.PENALIZED_MEMBERSHIP);
             }
            }
        }
    }

    public void createBill(MemberRecord member, Book book, String transactionType,LocalDate date) {

        // Calculate the amount
        double amount = 0;
        if (transactionType.equals("borrow")) {
           amount=calculateFine(book);
        } else if (transactionType.equals("purchase")) {
            amount=book.getPrice();
        }

        // Create the bill details
        StringBuilder bill = new StringBuilder();
        bill.append("*********************************\n");
        bill.append("*             BILL              *\n");
        bill.append("*********************************\n");
        bill.append("* Member: ").append(member.getName()).append("\n");
        bill.append("* Book: ").append(book.getTitle()).append("\n");
        bill.append("* Transaction: ").append(transactionType.equals("borrow") ? "Borrowed" : "Purchased").append("\n");
        bill.append("* Date: ").append(new Date()).append("\n");
        bill.append("* Amount: $").append(String.format("%.2f", amount)).append("\n");
        bill.append("*********************************\n");

        // Print the bill
        System.out.println(bill.toString());
    }

    public double calculateFine(Book book) {
        if (book.getStatus() != Status.AVAILABLE && book.getStatus()!=Status.PURCHASED) {
       //     System.out.println("1.if döngüsüne girdi.");
            LocalDate today=LocalDate.now();
            long daysOverdue = ChronoUnit.DAYS.between(book.getDateOfPurchase(), today);
            if (daysOverdue > 15) {
         //       System.out.println("2. if döngüsüne girdi.");
                double fine = daysOverdue * dailyFine;
                System.out.println("The book is " + daysOverdue + " days overdue. The fine is: $" + fine);
                return fine;
            }

        }
    //    System.out.println("döngülere girmedi.");
        return 0;
    }

    public void createBill(Book book){

    }
    private boolean verifyPassword(){
        System.out.println("Please enter your password.");
        Scanner scanner =new Scanner(System.in);
        String pswd=scanner.next();
        return pswd.equals(password);
    }

    public void registerMember(Reader reader,MembershipType type, LocalDate dateOfMembership,String address,String phoneNumber){
        library.addMember(new MemberRecord(reader.getName(),reader.getBudget(),generateUniqueMemberID(),type,dateOfMembership,address,phoneNumber));
    }
    private String generateUniqueMemberID(){
        return "MEM"+memberIDCounter.incrementAndGet();
    }

    @Override
    public void whoyouare(){
        System.out.println("This person is a librarian.");
    }
}
