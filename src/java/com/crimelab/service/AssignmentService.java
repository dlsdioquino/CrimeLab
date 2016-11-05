/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.crimelab.service;

import java.util.ArrayList;
import java.util.Map;

/**
 *
 * @author Lance
 */
public interface AssignmentService {

    public boolean createTask(String taskName, String description, String username, String users, int priority, String result_id);

    public String createResult(String reprtType, String username, String division);

    public ArrayList<Map<String, Object>> getUsers();

    public ArrayList<Map<String, Object>> getAssignments(String username);

    public boolean updateTaskStatus(String taskID, String status);

    public ArrayList<Map<String, Object>> getUserTasks(String username);

    public ArrayList<Map<String, Object>> getResultTypes();
    
    public int getNotificationCount(String username);
    
    public boolean updateResults(int resultID);
}
