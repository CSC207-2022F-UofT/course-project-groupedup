package Entities;

import java.util.HashMap;
import java.util.Random;

public class User {
    //name is whatever appears on screen (actual name)
    //username is login credential
    private String name;
    private final String username;
    private final int UserID;
    private String password;
    private HashMap<String, Group> groups;
    private HashMap<String, Group> applicationsList;
    private UserPublicProfile publicProfile;
    private String email;

    // maps username (key) to user ID (value) maybe not in here but somewhere else store
    private static HashMap<Integer, String> UserIDMap;

    public User(String username, String password, String name, String email, UserPublicProfile publicProfile){
        // will look into java builtin later
        Random rand = new Random();
        Integer id = (Integer) rand.nextInt();
        while (UserIDMap.containsKey(id)){
            id = rand.nextInt();
        }
        // if the loop runs for too long we'll stop it maybe
        UserIDMap.put(id, username);
        this.UserID = id;
        this.username = username;
        this.password = password;
        this.name = name;
        this.email = email;
        this.publicProfile = publicProfile;
    }

    public int getID(){
        return this.UserID;
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
    public HashMap<String, Group> getGroups(){
        return this.groups;
    }
    public HashMap<String, Group> getApplicationsList(){
        return this.applicationsList;
    }
    public boolean newUserName(String username){
        // return true if username is not found in the map, in other words it is a new username
        return !UserIDMap.containsValue(username);
    }

    public void removeGroup(String groupname) {
        this.groups.remove(groupname);
    }

    public void removeApplication(String groupname) {
        this.applicationsList.remove(groupname);
    }
//    public void changePassword(String password){
//        this.password = password;
//    }
}

