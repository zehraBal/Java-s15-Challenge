package org.workintech.person;

import org.workintech.books.Book;

import java.time.LocalDate;

public class MemberRecord extends Reader{
   private final String memberID;
   private MembershipType type;
   private final LocalDate dateOfMembership;
   private int numberOfBooksIssued;
   private final int maxBookLimit;
   private final String address;
   private final String phoneNumber;


    public MemberRecord(String name, double budget, String memberID, MembershipType type, LocalDate dateOfMembership, String address, String phoneNumber) {
        super(name, budget);
        this.memberID = memberID;
        this.type = type;
        this.dateOfMembership = dateOfMembership;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.maxBookLimit=5;
        this.numberOfBooksIssued=0;

    }

    public String getMemberID() {
        return memberID;
    }

    public MembershipType getType() {
        return type;
    }

    public void updateType(MembershipType type) {
        this.type = type;
    }


    @Override
    public void borrowBook(Book book, LocalDate date) {
        super.borrowBook(book, date);
        this.numberOfBooksIssued = getBorrowedBooks().size() + getPurchasedBooks().size();
    }

    @Override
    public void purchaseBook(Book book, LocalDate purchaseDate) {
        super.purchaseBook(book, purchaseDate);
        this.numberOfBooksIssued = getBorrowedBooks().size() + getPurchasedBooks().size();
    }
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        String line = "=================================================";
        String title = "Member Details";

        // Calculate the max label length
        int maxLabelLength = 23; // "Number of Books Issued" is the longest label
        int spacing = maxLabelLength + 5; // 5 spaces after the label
        builder.append("\n");
        builder.append(line).append("\n");
        builder.append(String.format("%" + ((line.length() + title.length()) / 2) + "s\n", title));
        builder.append(line).append("\n");

        builder.append(String.format("%-" + spacing + "s: %s\n", "Member ID", memberID));
        builder.append(String.format("%-" + spacing + "s: %s\n", "Name", getName()));
        builder.append(String.format("%-" + spacing + "s: %s\n", "Type", type));
        builder.append(String.format("%-" + spacing + "s: %s\n", "Date of Membership", dateOfMembership));
        builder.append(String.format("%-" + spacing + "s: %d\n", "Number of Books Issued", numberOfBooksIssued));
        builder.append(String.format("%-" + spacing + "s: %d\n", "Max Book Limit", maxBookLimit));
        builder.append(String.format("%-" + spacing + "s: %s\n", "Address", address));
        builder.append(String.format("%-" + spacing + "s: %s\n", "Phone Number", phoneNumber));
        builder.append(String.format("%-" + spacing + "s: %.2f\n", "Budget", getBudget()));

        builder.append(line).append("\n");
        builder.append("Borrowed Books:\n");
        builder.append(line).append("\n");
        if (getBorrowedBooks().isEmpty()) {
            builder.append("No borrowed books.\n");
        } else {
            getBorrowedBooks().forEach(book -> builder.append(book).append("\n"));
        }
        builder.append(line).append("\n");

        builder.append("Purchased Books:\n");
        builder.append(line).append("\n");
        if (getPurchasedBooks().isEmpty()) {
            builder.append("No purchased books.\n");
        } else {
            getPurchasedBooks().forEach(book -> builder.append(book).append("\n"));
        }
        builder.append(line).append("\n");

        return builder.toString();
    }
}
