package com.crimelab.domain;

public class UserRole {
    
    private User user;
    private String[] role;

    public UserRole() {
    }

    public UserRole(User user, String[] role) {
        this.user = user;
        this.role = role;
    }

    /**
     * @return the user
     */
    public User getUser() {
        return user;
    }

    /**
     * @param user the user to set
     */
    public void setUser(User user) {
        this.user = user;
    }

    /**
     * @return the role
     */
    public String[] getRole() {
        return role;
    }

    /**
     * @param role the role to set
     */
    public void setRole(String[] role) {
        this.role = role;
    }
    
}
