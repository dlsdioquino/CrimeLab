/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.crimelab.repository;

import com.crimelab.domain.Files;

/**
 *
 * @author Daniel
 */
public interface FileUploadDAO {
    public void uploadFile (Files files);
    public String getFileUploadPath();
}
