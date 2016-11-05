/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.crimelab.repository;

import java.util.ArrayList;
import java.util.Map;
import org.apache.ibatis.annotations.Param;

/**
 *
 * @author Lance
 */
public interface AssignmentDAO {

    //public void createTask(@Param("taskName") String taskName,@Param("description") String description,@Param("username") String username);
    public void createTask(@Param("map") Map<String, Object> map);

    public void createResult(@Param("map") Map<String, Object> map);

    public void assignTask(@Param("taskID") String taskID, @Param("username") String username);

    public ArrayList<Map<String, Object>> getUsers();

    public ArrayList<Map<String, Object>> getResultTypes();

    public ArrayList<Map<String, Object>> getAssignments(@Param("username") String username);

    public void updateTaskStatus(@Param("taskID") String taskID, @Param("status") String status);

    public ArrayList<Map<String, Object>> getUserTasks(@Param("username") String username);

    public int getNotificationCount(@Param("username") String username);

    public void updateResults(@Param("resultID") int resultID);

    public void updateResultStatus(@Param("resultID") String resultID);

    public void updateTaskStatus(@Param("resultID") String resultID);

}
