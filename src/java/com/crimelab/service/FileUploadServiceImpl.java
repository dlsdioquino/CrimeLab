/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.crimelab.service;

import com.crimelab.domain.Files;
import com.crimelab.repository.FileUploadDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Daniel
 */
@Service
public class FileUploadServiceImpl implements FileUploadService {

    private final FileUploadDAO fileUploadDAO;

    @Autowired
    public FileUploadServiceImpl(FileUploadDAO fileUploadDAO) {
        this.fileUploadDAO = fileUploadDAO;
    }

    @Override
    public void uploadFile(Files files) {
        fileUploadDAO.uploadFile(files);
    }

    @Override
    public String getFileUploadPath() {
        return fileUploadDAO.getFileUploadPath();
    }

}
