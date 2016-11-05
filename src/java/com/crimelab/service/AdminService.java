package com.crimelab.service;

import com.crimelab.domain.Content;
import com.crimelab.domain.Division;
import com.crimelab.domain.UserRole;
import java.util.List;

public interface AdminService {
    
    public List<UserRole> getAllUsers();
    
    public List<Division> getAllDivisions();
    
    public List<Content> getSiteContents(int offset, int limit);
    
    public String getRemainingContents(int multiplier);
    
    public String saveContentPost(String title, String content);
    
    public String getLatestContent(int postid);
    
    public String getUser(String username);
    
    public boolean addUser(String username, String password, String firstname,
                        String middle, String lastname, String position,
                        int enabled, String[] role);
    
    public boolean toggleUserStatus(String username);
    
    public boolean checkUsernameValidity(String username);
    
    public boolean updateUser(String username, String password, String firstname,
                        String middle, String lastname, String position, String[] role);
    
    public String getSiteAbout();
    
    public String getSiteHistory();
    
    public String getSiteDivisions();
    
    public boolean saveSiteSetting(String settingname, String value);
    
}
