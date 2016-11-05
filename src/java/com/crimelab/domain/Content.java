package com.crimelab.domain;

import java.sql.Timestamp;

public class Content {
    
    private int content_id;
    private String title;
    private String content;
    private int status;
    private Timestamp date_created;
    private String photopath;

    public Content() {
    }

    public Content(int content_id, String title, String content, int status, Timestamp date_created, String photopath) {
        this.content_id = content_id;
        this.title = title;
        this.content = content;
        this.status = status;
        this.date_created = date_created;
        this.photopath = photopath;
    }

    /**
     * @return the content_id
     */
    public int getContent_id() {
        return content_id;
    }

    /**
     * @param content_id the content_id to set
     */
    public void setContent_id(int content_id) {
        this.content_id = content_id;
    }

    /**
     * @return the title
     */
    public String getTitle() {
        return title;
    }

    /**
     * @param title the title to set
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * @return the content
     */
    public String getContent() {
        return content;
    }

    /**
     * @param content the content to set
     */
    public void setContent(String content) {
        this.content = content;
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

    /**
     * @return the date_created
     */
    public Timestamp getDate_created() {
        return date_created;
    }

    /**
     * @param date_created the date_created to set
     */
    public void setDate_created(Timestamp date_created) {
        this.date_created = date_created;
    }

    public String getPhotopath() {
        return photopath;
    }

    public void setPhotopath(String photopath) {
        this.photopath = photopath;
    }
    
}
