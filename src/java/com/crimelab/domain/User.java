package com.crimelab.domain;

import java.sql.Timestamp;

public class User {
    
    private String username;
    private String password;
    private String firstname;
    private String middle;
    private String lastname;
    private String position;
    private Timestamp account_created;
    private int registration_type;
    private String photopath;
    private int enabled;

    public User() {
    }

    public User(String username, String password, String firstname, String middle, String lastname, String position, Timestamp account_created, int registration_type, String photopath, int enabled) {
        this.username = username;
        this.password = password;
        this.firstname = firstname;
        this.middle = middle;
        this.lastname = lastname;
        this.position = position;
        this.account_created = account_created;
        this.registration_type = registration_type;
        this.photopath = photopath;
        this.enabled = enabled;
    }

    /**
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param username the username to set
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return the firstname
     */
    public String getFirstname() {
        return firstname;
    }

    /**
     * @param firstname the firstname to set
     */
    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    /**
     * @return the middle
     */
    public String getMiddle() {
        return middle;
    }

    /**
     * @param middle the middle to set
     */
    public void setMiddle(String middle) {
        this.middle = middle;
    }

    /**
     * @return the lastname
     */
    public String getLastname() {
        return lastname;
    }

    /**
     * @param lastname the lastname to set
     */
    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    /**
     * @return the position
     */
    public String getPosition() {
        return position;
    }

    /**
     * @param position the position to set
     */
    public void setPosition(String position) {
        this.position = position;
    }

    /**
     * @return the account_created
     */
    public Timestamp getAccount_created() {
        return account_created;
    }

    /**
     * @param account_created the account_created to set
     */
    public void setAccount_created(Timestamp account_created) {
        this.account_created = account_created;
    }

    /**
     * @return the registration_type
     */
    public int getRegistration_type() {
        return registration_type;
    }

    /**
     * @param registration_type the registration_type to set
     */
    public void setRegistration_type(int registration_type) {
        this.registration_type = registration_type;
    }

    /**
     * @return the photopath
     */
    public String getPhotopath() {
        return photopath;
    }

    /**
     * @param photopath the photopath to set
     */
    public void setPhotopath(String photopath) {
        this.photopath = photopath;
    }

    /**
     * @return the enabled
     */
    public int getEnabled() {
        return enabled;
    }

    /**
     * @param enabled the enabled to set
     */
    public void setEnabled(int enabled) {
        this.enabled = enabled;
    }
    
    
    
}
