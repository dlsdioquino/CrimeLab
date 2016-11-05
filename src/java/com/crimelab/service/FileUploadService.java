/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.crimelab.service;

import com.crimelab.domain.Files;

/**
 *
 * @author Daniel
 */
public interface FileUploadService {
    public void uploadFile(Files files);
    public String getFileUploadPath();
}
