package Entities;

import java.util.HashMap;
import java.util.Random;

public class User {
    private String username;
    // maps username (key) to user ID (value) maybe not in here but somewhere else store
    private static HashMap<String, Integer> UserIDMap;
    private int UserID;
    private String password;
    private HashMap<String, Group> groups;
    private HashMap<String, Group> applicationsList;
    private UserPublicProfile publicProfile;
    private class UserPublicProfile {
        private HashMap<String, String> preferences;
        private UserPublicProfile(){
//            this.preferences = HashMap<String, String> ;
        }
    }

    public User(String username, String password){
        Random rand = new Random();
        Integer id = rand.nextInt();
        while (UserIDMap.containsValue(id)){
            id = rand.nextInt();
        }
        // if the loop runs for too long we'll stop it maybe
        UserIDMap.put(username, id);
        this.UserID = id;
        this.username = username;
        this.password = password;
        this.publicProfile = new UserPublicProfile();
    }

//    public int getID(){
//
//    }
}

