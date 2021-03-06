package com.example.teamjavatar.domain;

import com.example.teamjavatar.domain.report.AbstractReport;

public class User extends AbstractUser {

    private String firstName;
    private String lastName;

    /**
     * Constructor for creating a user.
     * 
     * @param userID
     * @param firstName
     * @param lastName
     */
    public User(String userID, String firstName, String lastName) {
        super(userID);
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public void setID(String userID) {
        this.userID = userID;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFullName() {
        return firstName + " " + lastName;
    }

    public AbstractReport makeSpendingReport(long startDate, long endDate) {
        // TODO process and obtain withdrawals
        // return report
        return null;
    }

    public void changePassword() {
        // TODO
        // not sure if this should be here or as part of the database
        // i think just call on requestChangePassword on database.
    }

}
