package com.crimelab.domain;

import java.sql.Timestamp;

public class Division {
    
    private String div_id;
    private String div_name;
    private Timestamp date;
    private int status;

    public Division() {
    }

    public Division(String div_id, String div_name, Timestamp date, int status) {
        this.div_id = div_id;
        this.div_name = div_name;
        this.date = date;
        this.status = status;
    }

    /**
     * @return the div_id
     */
    public String getDiv_id() {
        return div_id;
    }

    /**
     * @param div_id the div_id to set
     */
    public void setDiv_id(String div_id) {
        this.div_id = div_id;
    }

    /**
     * @return the div_name
     */
    public String getDiv_name() {
        return div_name;
    }

    /**
     * @param div_name the div_name to set
     */
    public void setDiv_name(String div_name) {
        this.div_name = div_name;
    }

    /**
     * @return the date
     */
    public Timestamp getDate() {
        return date;
    }

    /**
     * @param date the date to set
     */
    public void setDate(Timestamp date) {
        this.date = date;
    }

    /**
     * @return the status
     */
    public int getStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(int status) {
        this.status = status;
    }
    
}
