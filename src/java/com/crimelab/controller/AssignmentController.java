/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.crimelab.controller;

import com.crimelab.service.AssignmentService;
import java.io.IOException;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Lance
 */
@Controller
public class AssignmentController {

    private final AssignmentService assignmentService;

    @Autowired
    public AssignmentController(AssignmentService assignmentService) {
        this.assignmentService = assignmentService;
    }

    @RequestMapping(value = "/{division}/assignment", method = RequestMethod.GET)
    public String assignmentPage(Model model, @PathVariable String division) {
        System.out.println("Division: " + division) ;
        model.addAttribute("resultTypes", assignmentService.getResultTypes());
        return "assignment";
    }

    @RequestMapping(value = "/assignment", method = RequestMethod.POST)
    public String assignTask(Model model, @RequestParam("taskName") String taskName, @RequestParam("description") String description, @RequestParam("users") String users, @RequestParam("reportType") String reportType, @RequestParam("division") String division, @RequestParam("priority") int priority) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String username = auth.getName(); //get logged in username                
        String result_id = assignmentService.createResult(reportType, users, division);
        if (!result_id.isEmpty()) {            
            assignmentService.createTask(taskName, description, username, users, priority,result_id);
            model.addAttribute("success", true);
        }
        return "redirect:/" + division + "/assignment";
    }

    @RequestMapping(value = "/getUsers", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    String getUsers() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(assignmentService.getUsers());
    }

    @RequestMapping(value = "/assignmentList", method = RequestMethod.GET)
    public String assignmentList(Model model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String username = auth.getName(); //get logged in username                
        model.addAttribute("assignments", assignmentService.getAssignments(username));
        return "assignmentList";
    }

    @RequestMapping(value = "/updateTaskStatus", method = RequestMethod.POST)
    public ModelAndView updateTaskStatus(@RequestParam("taskID") String taskID, @RequestParam("status") String status) {
        if (assignmentService.updateTaskStatus(taskID, status)) {
            //nothing here unless needed
        }
        return new ModelAndView("redirect:" + "/assignmentList");
    }

    @RequestMapping(value = "/getAssignments", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    String getAssignments() throws IOException {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String username = auth.getName(); //get logged in username                
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(assignmentService.getAssignments(username));
    }

    @RequestMapping(value = "/getUserTasks", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    String getUserTasks() throws IOException {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String username = auth.getName(); //get logged in username        
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(assignmentService.getUserTasks(username));
    }
    
    @RequestMapping(value = "/myAssignments",method = RequestMethod.GET)
    public String myAssignments(){
        return "myAssignments";
    }        

    @RequestMapping(value = "/notifications")
    public String notifications() {
        return "notifications";
    }

    //TEMPORARY MOVE TO ACTUAL CONTROLLER
    @RequestMapping(value = "/test")
    public String test() {
        return "searchResult";
    }   
}
