package com.crimelab.repository;

import com.crimelab.domain.Content;
import com.crimelab.domain.Division;
import com.crimelab.domain.SiteSetting;
import com.crimelab.domain.User;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AdminDAO {
    
    public List<User> getAllUsers();
    
    public void addUser(User user);
    
    public int getUserStatus(@Param("username") String username);
    
    public User getUser(@Param("username") String username);
    
    public void changeUserStatus(@Param("username") String username,
                                    @Param("enabled") int enabled);
    
    public void addUserDiv(@Param("username") String username,
                            @Param("div_id") String div_id);
    
    public void addUserRole(@Param("username") String username,
                            @Param("role") String role);
    
    public int countUsername(@Param("username") String username);
    
    public void resetUserDivs(@Param("username") String username,
                                @Param("notall") String notall);
    
    public void resetUserRoles(@Param("username") String username,
                                @Param("notall") String notall);
    
    public List<Division> getDivisions();
    
    public List<String> getUserRoles(@Param("username") String username);
    
    public List<String> getUserDivs(@Param("username") String username);
    
    public void updateUser(@Param("username") String username,
                            @Param("password") String password,
                            @Param("firstname") String firstname,
                            @Param("middle") String middle,
                            @Param("lastname") String lastname,
                            @Param("position") String position);
    
    public SiteSetting getSiteSetting(@Param("settingname") String settingname );
    
    public void changeSiteSetting(@Param("setting_name") String setting_name,
                            @Param("setting_value") String setting_value);
    
    public int getMaxContentId();
    
    public List<Content> getSiteContents(@Param("offset") int offset,
                                        @Param("limit") int limit);
    
    public Content getLatestPost(@Param("content_id") int content_id);
    
    public void insertSitePost(Content content);
    
    public void insertSitePhotoPost(Content content);
    
    public void removeDivHead(@Param("username") String username);
    
    public void addDivHeadRole(@Param("username") String username);
    
    public void changeUserType(@Param("username") String username,
                                @Param("type") int type,
                                @Param("div_id") String div_id);
    
    public int getDivHeadCount(@Param("username") String username);
    
}