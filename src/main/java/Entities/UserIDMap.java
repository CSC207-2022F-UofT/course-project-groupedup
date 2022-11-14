package Entities;

import java.util.HashMap;

public class UserIDMap implements ObjectMap{

    private HashMap<Integer, String> UserIDMap;


    public UserIDMap(HashMap<Integer, String> UserIDMap){
        this.UserIDMap = UserIDMap;
    }

    public void addToUserIDMap(Integer ID, String username){
        this.UserIDMap.put(ID, username);
    }
    public HashMap<Integer, String> getUserIDMap() {
        return UserIDMap;
    }


}
