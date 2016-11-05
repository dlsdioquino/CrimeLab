package com.crimelab.controller;

import com.crimelab.service.AdminService;
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
public class AdminController {
    
    private final AdminService adminservice;
    
    @Autowired
    public AdminController(AdminService adminservice) {
        this.adminservice = adminservice;
    }
    
    @RequestMapping("/siteadmin/content")
    public String contentFeed(Model model) {
        model.addAttribute("pageTitle","Announcements");
        model.addAttribute("contents", adminservice.getSiteContents(0,15));
        return "content";
    }
    
    @RequestMapping(value = "/siteadmin/content/loadmore", method = RequestMethod.GET)
    public @ResponseBody String loadMoreContent(
        @RequestParam(value="multiplier", required = true) int multiplier) {
        return adminservice.getRemainingContents(multiplier);
    }
    
    @RequestMapping(value = "/siteadmin/content/savepost", method = RequestMethod.POST)
    public @ResponseBody String savePostContent(
        @RequestParam(value="title", required = true) String title,
        @RequestParam(value="content", required = true) String content) {
        return adminservice.saveContentPost(title, content);
    }
    
    @RequestMapping(value = "/siteadmin/content/latestcontent", method = RequestMethod.GET)
    public @ResponseBody String latestContent(
        @RequestParam(value="postid", required = true) int postid) {
        return adminservice.getLatestContent(postid);
    }
    
    @RequestMapping("/siteadmin/site")
    public String siteSettings(Model model) {
        model.addAttribute("pageTitle","Site Settings");
        model.addAttribute("siteabout", adminservice.getSiteAbout());
        model.addAttribute("sitehistory", adminservice.getSiteHistory());
        model.addAttribute("sitedivisions", adminservice.getSiteDivisions());
        return "sitesettings";
    }
    
    @RequestMapping(value = "/siteadmin/site/savesetting", method = RequestMethod.POST)
    public @ResponseBody String saveSettings(
            @RequestParam(value="setting", required = true) String setting,
            @RequestParam(value="value", required = true) String value) {
        return adminservice.saveSiteSetting(setting, value)+"";
    }
    
    @RequestMapping("/siteadmin/users")
    public String users(Model model,
        @RequestParam(value="updated", required = false) String updated) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (!(auth instanceof AnonymousAuthenticationToken)) {
            UserDetails userDetail = (UserDetails) auth.getPrincipal();	
            model.addAttribute("adminin", userDetail.getUsername());
        }
        model.addAttribute("divs", adminservice.getAllDivisions());
        model.addAttribute("pageTitle","Users");
        model.addAttribute("updated", updated);
        model.addAttribute("users", adminservice.getAllUsers());
        return "users";
    }
    
    @RequestMapping(value = "/siteadmin/users/edituser", method = RequestMethod.GET)
    public @ResponseBody String changeUserStatus(
            @RequestParam(value="username", required = true) String username) {
        return adminservice.toggleUserStatus(username)+"";
    }
    
    @RequestMapping(value = "/siteadmin/users/updateuser", method = RequestMethod.POST)
    public String editUserDetails(Model model,
            @RequestParam(value="username", required = true) String username,
            @RequestParam(value="password", required = true) String password,
            @RequestParam(value="firstname", required = true) String firstname,
            @RequestParam(value="middle", required = false) String middle,
            @RequestParam(value="lastname", required = true) String lastname,
            @RequestParam(value="position", required = true) String position,
            @RequestParam(value="role", required = true) String[] role) {
        model.addAttribute("updated", adminservice.updateUser(username, password, firstname,
                middle, lastname, position, role));
        
        return "redirect:/siteadmin/users";
    }
    
    @RequestMapping(value = "/siteadmin/users/loaduser", method = RequestMethod.GET)
    public @ResponseBody String loadUserDetails(
            @RequestParam(value="username", required = true) String username) {
        return adminservice.getUser(username);
    }
    
    @RequestMapping(value = "/siteadmin/newuser", method = RequestMethod.GET)
    public String newUser(Model model,
            @RequestParam(value="saved", required=false) String status) {
        model.addAttribute("saved", status);
        model.addAttribute("divs", adminservice.getAllDivisions());
        model.addAttribute("pageTitle","Add User");
        return "newuser";
    }
    
    @RequestMapping(value = "/siteadmin/newuser/usercheck", method = RequestMethod.GET)
    public @ResponseBody String checkUserValidity(
            @RequestParam(value="username", required = true) String username) {
        return adminservice.checkUsernameValidity(username)+"";
    }
    
    @RequestMapping(value = "/siteadmin/newuser/adduser", method = RequestMethod.POST)
    public String addUser(Model model,
            @RequestParam(value="username", required = true) String username,
            @RequestParam(value="password", required = true) String password,
            @RequestParam(value="firstname", required = true) String firstname,
            @RequestParam(value="middle", required = false) String middle,
            @RequestParam(value="lastname", required = true) String lastname,
            @RequestParam(value="position", required = true) String position,
            @RequestParam(value="role", required = true) String[] role) {
        
        model.addAttribute("saved", adminservice.addUser(username, password,
                firstname, middle, lastname, position, 1, role));
        
        return "redirect:/siteadmin/newuser";
    }
    
    @RequestMapping("/siteadmin/logs")
    public String siteLogs(Model model) {
        model.addAttribute("pageTitle","Logs");
        return "sitelogs";
    }
    
}
