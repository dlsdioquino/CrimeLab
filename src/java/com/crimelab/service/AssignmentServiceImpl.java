/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.crimelab.service;

import com.crimelab.repository.AssignmentDAO;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Lance
 */
@Service
public class AssignmentServiceImpl implements AssignmentService {

    private final AssignmentDAO assignmentDAO;

    @Autowired
    public AssignmentServiceImpl(AssignmentDAO assignmentDAO) {
        this.assignmentDAO = assignmentDAO;
    }

    @Override
    public boolean createTask(String taskName, String description, String username, String users, int priority,String result_id) {
        try {
            Map<String, Object> map = new HashMap<>();
            map.put("taskID", null);
            map.put("taskname", taskName);
            map.put("description", description);
            map.put("username", username);
            map.put("priority", priority);
            map.put("result_id",result_id);
            assignmentDAO.createTask(map);
            assignmentDAO.assignTask(map.get("taskID").toString(), users);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public String createResult(String reportType, String username, String division) {
        Map<String, Object> map = new HashMap<>();
        try {
            String divisionID = "";
            switch (division) {
                case "Admin":
                    divisionID = "AD";
                    break;
                case "Chemistry":
                    divisionID = "CHEM";
                    break;
                case "Document":
                    divisionID = "DOCU";
                    break;
                case "Fingerprint":
                    divisionID = "FIN";
                    break;
                case "Firearms":
                    divisionID = "FIRE";
                    break;
                case "Forensic":
                    divisionID = "FP";
                    break;
                case "MedicoLegal":
                    divisionID = "ML";
                    break;
                case "PhysicalIdentification":
                    divisionID = "PI";
                    break;
                case "Polygraph":
                    divisionID = "POLY";
                    break;
                case "SOCO":
                    divisionID = "SOCO";
                    break;
            }
            map.put("result_id", null);
            map.put("reportType", reportType);
            map.put("divisionID", divisionID);
            map.put("username", username);
            assignmentDAO.createResult(map);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("test: " + map.get("result_id").toString());
        return map.get("result_id").toString();
    }

    @Override
    public ArrayList<Map<String, Object>> getUsers() {
        return assignmentDAO.getUsers();
    }

    @Override
    public ArrayList<Map<String, Object>> getAssignments(String username) {
        return assignmentDAO.getAssignments(username);
    }

    @Override
    public boolean updateTaskStatus(String taskID, String status) {
        try {
            assignmentDAO.updateTaskStatus(taskID, status);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public ArrayList<Map<String, Object>> getUserTasks(String username) {
        return assignmentDAO.getUserTasks(username);
    }
    
    @Override
    public ArrayList<Map<String,Object>> getResultTypes(){
        return assignmentDAO.getResultTypes();
    }
    
    @Override
    public int getNotificationCount(String username) {
        return assignmentDAO.getNotificationCount(username);
    }    

    @Override
    public boolean updateResults(int resultID) {
        try {            
            assignmentDAO.updateResults(resultID);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

}
