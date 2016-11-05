package com.crimelab.service;

import com.crimelab.domain.Content;
import com.crimelab.domain.Division;
import com.crimelab.domain.User;
import com.crimelab.domain.UserRole;
import com.crimelab.repository.AdminDAO;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(value = "TransactionManager1", rollbackFor = Exception.class)
public class AdminServiceImpl implements AdminService {
    
    final Logger logger = LoggerFactory.getLogger(AdminServiceImpl.class);
    private final AdminDAO admindao;
    
    @Autowired
    public AdminServiceImpl(AdminDAO admindao) {
        this.admindao = admindao;
    }
    
    @Override
    public List<UserRole> getAllUsers() {
        ArrayList<UserRole> users = new ArrayList<>();
        
        for(User u : admindao.getAllUsers()) {
            users.add(new UserRole(u, getUserRole(u.getUsername())));
        }
        
        return users;
    }
    
    @Override
    public List<Division> getAllDivisions() {
        return admindao.getDivisions();
    }
    
    @Override
    public List<Content> getSiteContents(int offset, int limit) {
        return admindao.getSiteContents(offset, limit);
    }
    
    @Override
    public String getRemainingContents(int multiplier) {
        String jsondata = "[";
        
        for(Content con : getSiteContents(15 + (multiplier * 5), 5)) {
            SimpleDateFormat format = new SimpleDateFormat("MM/dd/yy h:m a");

            jsondata += "{";
            jsondata += "\"content_id\" : " + con.getContent_id()+ ",";
            jsondata += "\"title\" : " + "\"" + con.getTitle() + "\",";
            jsondata += "\"status\" : " + con.getStatus() + ",";
            jsondata += "\"dc\" : \"" + format.format(con.getDate_created()) + "\"";
            jsondata += "},";
        }
        
        if(getSiteContents(15 + (multiplier * 5), 5).size() > 0) {
            jsondata = jsondata.substring(0, jsondata.length()-1);
        }
        
        jsondata += "]";
        
        return jsondata;
    }
    
    @Override
    public String saveContentPost(String title, String content) {
        Content cont = new Content();
        int newid = admindao.getMaxContentId();
        String retval = "{\r\n\t";
        
        try {
            cont.setContent_id(newid);
            cont.setTitle(title);
            cont.setContent(content);

            admindao.insertSitePost(cont);
            
            retval += "\"postid\" : " + newid + ",\r\n\t";
            retval += "\"status\" : true";
        } catch (Exception e) {
            logger.error("There was an error saving the post.\n" + e.getMessage());
            retval += "\"status\" : false";
        }
        
        return retval+="}";
    }
    
    @Override
    public String getLatestContent(int postid) {
        String retval = "{\r\n\t";
        Content con = admindao.getLatestPost(postid);
        
        SimpleDateFormat format = new SimpleDateFormat("MM/dd/yy h:m a");
        
        retval += "\"content_id\" : " + con.getContent_id()+ ",";
        retval += "\"title\" : " + "\"" + con.getTitle() + "\",";
        retval += "\"status\" : " + con.getStatus() + ",";
        retval += "\"dc\" : \"" + format.format(con.getDate_created()) + "\"";
        
        return retval+="}";
    }
    
    @Override
    public String getUser(String username) {
        String jsondata = "{";
        
        User curuser;
        
        try {
            curuser = admindao.getUser(username);
            
            String fname = curuser.getFirstname() == null ? "" : curuser.getFirstname();
            String mid = curuser.getMiddle()== null ? "" : curuser.getMiddle();
            String lname = curuser.getLastname() == null ? "" : curuser.getLastname();
            String pos = curuser.getPosition()== null ? "" : curuser.getPosition();
            
            jsondata += "\t\"username\" : \"" + curuser.getUsername() + "\",\r\n";
            jsondata += "\t\"firstname\" : \"" + fname + "\",\r\n";
            jsondata += "\t\"middle\" : \"" + mid + "\",\r\n";
            jsondata += "\t\"lastname\" : \"" + lname + "\",\r\n";
            jsondata += "\t\"position\" : \"" + pos + "\",\r\n";
            jsondata += "\t\"role\" : [";
            
            for(String s : getUserRole(curuser.getUsername())) {
                jsondata += "\t\t\t\"" + s + "\",";
            }
            jsondata = jsondata.substring(0, jsondata.length()-1);
            
            jsondata += "\t\t]\r\n";
        } catch (Exception e) {
            logger.error("No user was found.\n" + e.getMessage());
        }
        
        return jsondata + "}";
    }
    
    @Override
    public boolean addUser(String username, String password, String firstname,
                        String middle, String lastname, String position,
                        int enabled, String[] role) {
        User user = new User();
        
        if(username.replaceAll(" ", "").equals("")
            && password.replaceAll(" ", "").equals("")
            && firstname.replaceAll(" ", "").equals("")
            && lastname.replaceAll(" ", "").equals("")
            && position.replaceAll(" ", "").equals("")
            && role.length == 0) {
            return false;
        }
        
        try{
            String uname = username.replaceAll(" ", "");
            user.setUsername(uname);
            user.setPassword(passwordGenerator(password));
            user.setFirstname(firstname.trim());
            
            if(middle.replaceAll(" ","").equals("")) {
                user.setMiddle(null);
            } else {
                user.setMiddle(middle.trim());
            }
            
            user.setLastname(lastname.trim());
            user.setPosition(position.trim());
            user.setRegistration_type(0);
            user.setEnabled(1);
            
            admindao.addUser(user);
            
            for(String temprole : role) {
                admindao.addUserRole(uname, temprole.toUpperCase());
                if(!temprole.toUpperCase().equals("ADMIN")) {
                     admindao.addUserDiv(uname, temprole.toUpperCase());
                } else {
                    admindao.resetUserDivs(uname, null);
                    admindao.resetUserRoles(uname, null);
                    admindao.addUserRole(uname, "ADMIN");
                    break;
                }
            }
            
        } catch (Exception e) {
            logger.error("There was an error adding the user to the system.\n" + e.getMessage());
            return false;
        }
        
        return true;
    }

    @Override
    public boolean toggleUserStatus(String username) {
        try {
            int status = admindao.getUserStatus(username);
            if(status == 1) {
                admindao.changeUserStatus(username, 0);
            } else {
                admindao.changeUserStatus(username, 1);
            }
        } catch (Exception e) {
            logger.error("Changing the user status cannot be completed.\n" + e.getMessage());
            return false;
        }
        
        return true;
    }
    
    @Override
    public boolean checkUsernameValidity(String username) {
        int count = admindao.countUsername(username);
        
        return count <= 0;
    }
    
    @Override
    public boolean updateUser(String username, String password, String firstname,
                        String middle, String lastname, String position, String[] role) {
        String uname = username.replaceAll(" ", "");
        String fname = firstname.trim();
        String mid = middle.trim();
        String lname = lastname.trim();
        String pos = position.trim();
        
        try {
            if(!uname.equals("") && !fname.replaceAll(" ", "").equals("")
                && !lname.replaceAll(" ", "").equals("")
                && !pos.replaceAll(" ", "").equals("")
                && role.length != 0) {
                                
                if(!checkUsernameValidity(uname)) {
                    if(password.replaceAll(" ", "").equals("")) {
                        admindao.updateUser(username, null, firstname,
                                mid, lastname, position);
                    } else {
                        admindao.updateUser(username, passwordGenerator(password), firstname,
                                mid, lastname, position);
                    }
                    
                    if(role.length == 1 && role[0].equalsIgnoreCase("ADMIN")) {
                        admindao.resetUserDivs(uname, null);
                        admindao.resetUserRoles(uname, null);
                        admindao.addUserRole(uname, "ADMIN");
                    } else {
                        admindao.resetUserDivs(uname, "yes");
                        admindao.resetUserRoles(uname, "yes");
                        for(String tempdiv : role) {
                            admindao.addUserDiv(uname, tempdiv.toUpperCase());
                        }
                        
                        for(String temprole : admindao.getUserDivs(uname)) {
                            admindao.addUserRole(uname, temprole.toUpperCase());
                        }
                    }
                    
                    return true;
                }
            }
        } catch(Exception e) {
            logger.error("Update of user triggered an error.\n" + e.getMessage());
            e.printStackTrace();
        }
        
        return false;
    }
    
    @Override
    public String getSiteAbout() {
        return admindao.getSiteSetting("about").getSetting_value();
    }
    
    @Override
    public String getSiteHistory() {
        return admindao.getSiteSetting("history").getSetting_value();
    }
    
    @Override
    public String getSiteDivisions() {
        return admindao.getSiteSetting("divisions").getSetting_value();
    }
    
    @Override
    public boolean saveSiteSetting(String settingname, String value) {
        try {
            if(!settingname.replaceAll(" ","").equals("")) {
                admindao.changeSiteSetting(settingname.replaceAll(" ", ""),
                        value.trim());
            }
        } catch (Exception e) {
            logger.error("Site Settings cannot be updated.\n" + e.getMessage());
            return false;
        }
        
        return true;
    }
    
    private static String passwordGenerator(String value) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        return passwordEncoder.encode(value);
    }
    
    private String[] getUserRole(String username) {
        ArrayList<String> templist = (ArrayList<String>) admindao.getUserRoles(username);
        String[] newArray = new String[templist.size()];
        
        for(int i = 0; i < templist.size(); i++) {
            newArray[i] = templist.get(i).replace("ROLE_", "");
        }
        
        return newArray;
    }
    
    private boolean makeUserDivHead(String username, String div) {
        try {
            admindao.addDivHeadRole(username);
            admindao.changeUserType(username, 1, div);
        } catch (Exception e) {
            return false;
        }
        
        return true;
    }
    
    private boolean removeUserDivHead(String username, String div) {
        try {
            if(admindao.getDivHeadCount(username) <= 1) {
                admindao.removeDivHead(username);
            }
            admindao.changeUserType(username, 0, div);
        } catch (Exception e) {
            return false;
        }
        
        return true;
    }
    
}
