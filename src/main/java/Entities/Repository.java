package Entities;

import java.util.HashMap;

public class Repository {
    private static HashMap<String, Group> groupIDMap;
    private static HashMap<String, User> userIDMap;

    public static HashMap<String, Group> getGroupIDMap(){
        return groupIDMap;
    }
    public static HashMap<String, User> getUserIDMap(){
        return userIDMap;
    }

    public static User getUserByUsername(String username) {
        return userIDMap.get(username);
    }
    public static Group getGroupByGroupName(String groupname) {
        return groupIDMap.get(groupname);
    }
    public static User getUserByUserName(String username) {
        return userIDMap.get(username);
    }
    public static void addGroup(Group group){
        groupIDMap.put(group.getGroupName(), group);
    }
    public static void addUser(User user){
        userIDMap.put(user.getUsername(), user);
    }
}
