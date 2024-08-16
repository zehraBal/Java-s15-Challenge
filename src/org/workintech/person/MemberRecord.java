package org.workintech.person;

import java.time.LocalDate;

public class MemberRecord extends Reader{
   private String memberID;
   private String type;
   private LocalDate dateOfMembership;
   private int numberOfBooksIssued;
   private int maxBookLimit;
   private String address;
   private String phoneNumber;


    public MemberRecord(String name, double budget, String memberID, String type, LocalDate dateOfMembership, String address, String phoneNumber) {
        super(name, budget);
        this.memberID = memberID;
        this.type = type;
        this.dateOfMembership = dateOfMembership;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }

    public String getMemberID() {
        return memberID;
    }

    @Override
    public String toString() {
        return "MemberRecord{" +
                "memberID='" + memberID + '\'' +
                ", type='" + type + '\'' +
                ", dateOfMembership=" + dateOfMembership +
                ", numberOfBooksIssued=" + numberOfBooksIssued +
                ", maxBookLimit=" + maxBookLimit +
                ", address='" + address + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }
}
