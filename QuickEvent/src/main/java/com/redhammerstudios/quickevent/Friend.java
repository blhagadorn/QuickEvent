package com.redhammerstudios.quickevent;

import java.util.Date;

/**
 * Created by bryant on 10/21/13.
 */
public class Friend {
    int id;
    String firstName;
    String lastName;
    Date dateAdded;
    String phoneNumber;
    String userName;
    int countOfEvents;

    public Friend(int id, String firstName, String lastName, Date dateAdded, String phoneNumber, String userName, int countOfEvents) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateAdded = dateAdded;
        this.phoneNumber = phoneNumber;
        this.userName = userName;
        this.countOfEvents = countOfEvents;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public Date getDateAdded() {
        return dateAdded;
    }

    public void setDateAdded(Date dateAdded) {
        this.dateAdded = dateAdded;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getCountOfEvents() { return countOfEvents;} public void setCountOfEvents(int countOfEvents) {this.countOfEvents = countOfEvents;}
}
