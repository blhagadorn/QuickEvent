package com.redhammerstudios.quickevent;

import java.util.Date;

/**
 * Created by Vince on 10/21/13.
 */
public class Event {

    String eventId;
    Date eventDate;
    Date dateAdded;
    String creatorId;
    Integer countOfUsersInvited;
    //String array of id's invited to the event
    String[] usersInvitedbyId;

    public Event(String eventId, Date eventDate, Date dateAdded, String creatorId, Integer countOfUsersInvited, String[] usersInvitedbyId) {
        this.eventId = eventId;
        this.eventDate = eventDate;
        this.dateAdded = dateAdded;
        this.creatorId = creatorId;
        this.countOfUsersInvited = countOfUsersInvited;
        this.usersInvitedbyId = usersInvitedbyId;
    }

    public String getEventId() {
        return eventId;
    }

    public void setEventId(String eventId) {
        this.eventId = eventId;
    }

    public Date getEventDate() {
        return eventDate;
    }

    public void setEventDate(Date eventDate) {
        this.eventDate = eventDate;
    }

    public Date getDateAdded() {
        return dateAdded;
    }

    public void setDateAdded(Date dateAdded) {
        this.dateAdded = dateAdded;
    }

    public String getCreatorId() {
        return creatorId;
    }

    public void setCreatorId(String creatorId) {
        this.creatorId = creatorId;
    }

    public Integer getCountOfUsersInvited() {
        return countOfUsersInvited;
    }

    public void setCountOfUsersInvited(Integer countOfUsersInvited) {
        this.countOfUsersInvited = countOfUsersInvited;
    }

    public String[] getUsersInvitedbyId() {
        return usersInvitedbyId;
    }

    public void setUsersInvitedbyId(String[] usersInvitedbyId) {
        this.usersInvitedbyId = usersInvitedbyId;
    }
}
