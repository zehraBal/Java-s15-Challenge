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
    private static final double dailyFine=2.5;
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
      if (verifyPassword()){
          for(MemberRecord mem: memberRecords){
              if(mem.getMemberID().equals(memberRecord.getMemberID())){
                  return true;
              }
          }
      }

       return false;
    }

    public boolean issueBook(long bookID,MemberRecord member,LocalDate date){
        if(verifyPassword()){
            if(verifyMember(member)){
                Book book = library.getBook(bookID);
                if (book == null) {
                    System.out.println("The book with ID " + bookID + " is not available in the library.");
                    return false;
                }
                if(book.getStatus()!= Status.AVAILABLE){
                    System.out.println("The book with ID " + bookID + " is not currently available.");
                    return false;
                }
                System.out.println("Would you like to borrow or purchase this book?");
                Scanner scanner=new Scanner(System.in);
                String memberRequest=scanner.next().toLowerCase();
                if(memberRequest.equals("borrow")){
                    member.borrowBook(book,date);
                    book.updateStatus(Status.BORROWED);
                    System.out.println("The book '" + book.getTitle() + "' has been borrowed by " + member.getName() + ".");
                    return true;
                }else if(memberRequest.equals("purchase")){
                    member.purchaseBook(book,date);
                    System.out.println("The book '" + book.getTitle() + "' has been purchased by " + member.getName() + ".");
                    return true;
                }

            }
            System.out.println("The reader is not a valid member of the library.");
            return false;
        }
        System.out.println("Incorrect password. Access denied.");
        return false;
    }
    public void createBill(MemberRecord member, Book book, String transactionType,LocalDate date) {
        // Verify if the member is valid
        if (!verifyMember(member)) {
            System.out.println("Member not valid.");
            return;
        }

        // Calculate the amount
        double amount = 0;
        if (transactionType.equals("borrow")) {
         //   amount=calculateFine(book);
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
            if (daysOverdue > 0) {
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

    public void registerMember(Reader reader,String type, LocalDate dateOfMembership,String address,String phoneNumber){
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
