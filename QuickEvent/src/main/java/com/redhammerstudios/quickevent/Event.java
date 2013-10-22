package com.redhammerstudios.quickevent;

import java.util.Date;

/**
 * Created by Vince on 10/21/13.
 */
public class Event {

    String eventId;
    Date eventDate;
    Date dateAdded;
    String creatorUserName;
    String creatorId;


    public String getEventId() {return eventId;}
    public String getFirstName() {
        return firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public Date getDateAdded() {
        return dateAdded;
    }


    public void setId(int id) {
        this.id = id;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public void setDateAdded(Date dateAdded) {
        this.dateAdded = dateAdded;
    }


    }

}
