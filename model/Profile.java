package org.akshay.messenger.model;

/*
*   @author:    Akshay Babbar
*   @Version:   1.0
*   @Purpose:
* */

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Profile {
    private long id;
    private String profileName;
    private String firstName;
    private String lastname;

    public Profile(long id, String profileName, String firstName, String lastname) {
        this.id = id;
        this.profileName = profileName;
        this.firstName = firstName;
        this.lastname = lastname;
    }
    public Profile(){}

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getProfileName() {
        return profileName;
    }

    public void setProfileName(String profileName) {
        this.profileName = profileName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }
}
