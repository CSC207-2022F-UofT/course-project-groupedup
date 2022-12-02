package Entities;

import java.io.Serializable;
import java.util.HashMap;

public interface User extends Serializable {
    String getUsername();
    String getPassword();
    String getName();
    String getEmail();
    HashMap<String, String> getGroups();
    HashMap<String, String> getApplicationsList();
    UserPublicProfile getUserPublicProfile();
    void removeApplication(String groupName);
    void removeGroup(String groupName);
    void addGroup(String groupName);
}