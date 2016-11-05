package com.crimelab.controller;

import com.crimelab.service.AdminService;
import com.crimelab.service.AssignmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController {

    private final AdminService adminservice;
    private final AssignmentService assignmentService;

    @Autowired
    public HomeController(AdminService adminservice,
            AssignmentService assignmentService) {
        this.adminservice = adminservice;
        this.assignmentService = assignmentService;
    }

    @RequestMapping("/")
    public String index(Model model) {
        model.addAttribute("siteabout", adminservice.getSiteAbout());
        model.addAttribute("sitehistory", adminservice.getSiteHistory());
        model.addAttribute("sitedivisions", adminservice.getSiteDivisions());
        return "index";
    }

    @RequestMapping("/divisions")
    public String divisions(Model model) {
        return "divisions";
    }

    @RequestMapping("/FileManagement")
    public String fileManagement(Model model) {
        return "filemanagement";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(Model model,
            @RequestParam(value = "error", required = false) String error,
            @RequestParam(value = "logout", required = false) String logout) {

        model.addAttribute("pageTitle", "Sign in");

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (!(auth instanceof AnonymousAuthenticationToken)) {
            return "redirect:/";
        }

        if (error != null) {
            model.addAttribute("error", "Invalid username and password.");
        }

        if (logout != null) {
            model.addAttribute("msg", "Succesfully logged out.");
        }

        return "login";

    }

    @RequestMapping(value = "/403", method = RequestMethod.GET)
    public String accesssDenied(Model model) {

        //check if user is login
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (!(auth instanceof AnonymousAuthenticationToken)) {
            UserDetails userDetail = (UserDetails) auth.getPrincipal();
            model.addAttribute("username", userDetail.getUsername());
        }

        return "403";

    }

    @RequestMapping(value = "/getNotificationCount", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    String getNotificationCount() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        return assignmentService.getNotificationCount(auth.getName()) + "";
    }

}
