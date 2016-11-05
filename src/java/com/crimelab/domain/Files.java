/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.crimelab.domain;

import java.util.Date;

/**
 *
 * @author Daniel
 */
public class Files {

    private byte[] fileBytes;
    private int file_type;
    private int folder_id;
    private String orig_file_name;
    private String file_name;
    private String file_extension;
    private String file_path;
    private Date date;
    private String description;
    private String soco_case;

    public int getFolder_id() {
        return folder_id;
    }

    public void setFolder_id(int folder_id) {
        this.folder_id = folder_id;
    }

    public String getFile_path() {
        return file_path;
    }

    public void setFile_path(String file_path) {
        this.file_path = file_path;
    }
    
    public int getFile_type() {
        return file_type;
    }

    public void setFile_type(int file_type) {
        this.file_type = file_type;
    }

    public String getOrig_file_name() {
        return orig_file_name;
    }

    public void setOrig_file_name(String orig_file_name) {
        this.orig_file_name = orig_file_name;
    }

    public String getFile_name() {
        return file_name;
    }

    public void setFile_name(String file_name) {
        this.file_name = file_name;
    }

    public String getFile_extension() {
        return file_extension;
    }

    public void setFile_extension(String file_extension) {
        this.file_extension = file_extension;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSoco_case() {
        return soco_case;
    }

    public void setSoco_case(String soco_case) {
        this.soco_case = soco_case;
    }

    public byte[] getFileBytes() {
        return fileBytes;
    }

    public void setFileBytes(byte[] fileBytes) {
        this.fileBytes = fileBytes;
    }

}
