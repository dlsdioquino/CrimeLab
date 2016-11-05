/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.crimelab.service;

import com.crimelab.repository.AssignmentDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Acer
 */
@Service
public class FileManagementServiceImpl implements FileManagementService {

    @Override
    public boolean addModification() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

//    private final AssignmentDAO assignmentDAO;
//
//    @Autowired
//    public AssignmentServiceImpl(AssignmentDAO assignmentDAO) {
//        this.assignmentDAO = assignmentDAO;
//    }

}
