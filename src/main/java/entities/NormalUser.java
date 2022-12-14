package entities;

import java.io.Serializable;
import java.util.HashMap;

/**
 * This is a normal/average user class
 * username is always unique
 * name is whatever appears on screen (actual name)
 * username is login credential
 */

public class NormalUser implements Serializable, User {
    private String name;
    private final String username;
    private String password;
    private HashMap<String, String> groups;
    private HashMap<String, String> applicationsList;
    private UserPublicProfile publicProfile;
    private String email;

    public NormalUser(String username, String password, String name, String email,
                      UserPublicProfile publicProfile){
        // put user in map in usecase

        this.username = username;
        this.password = password;
        this.name = name;
        this.email = email;
        this.publicProfile = publicProfile;
        this.applicationsList = new HashMap<>();
        this.groups = new HashMap<>();
    }

    public String getUsername(){
        return this.username;
    }
    public String getPassword(){
        return this.password;
    }
    public String getName(){
        return this.name;
    }
    public String getEmail(){
        return this.email;
    }
    public HashMap<String, String> getGroups(){
        return this.groups;
    }
    public HashMap<String, String> getApplicationsList(){
        return this.applicationsList;
    }
    public UserPublicProfile getUserPublicProfile() { return this.publicProfile; }

    @Override
    public void removeApplication(String groupName) {
        this.applicationsList.remove(groupName);
    }

    @Override
    public void removeGroup(String groupName) {
        this.groups.remove(groupName);
    }
    // check if valid new username in usecase
    // public void changePassword(String password){
    // this.password = password;
    // }
    public void addGroup(String groupName) {
        this.groups.put(groupName, groupName);
    }

    public void addApplication(String groupName){ this.applicationsList.put(groupName, groupName); }
}

