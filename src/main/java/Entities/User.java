package Entities;

import java.io.Serializable;
import java.util.HashMap;


public interface User extends Serializable {
    String getUsername();
    String getPassword();
    String getName();
    String getEmail();
    HashMap<String, Group> getGroups();
    HashMap<String, Group> getApplicationsList();
    UserPublicProfile getUserPublicProfile();
    void removeApplication(String groupName);
    void removeGroup(String groupName);
}