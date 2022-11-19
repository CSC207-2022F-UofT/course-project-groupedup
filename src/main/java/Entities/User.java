package Entities;

import java.io.Serializable;
import java.util.HashMap;

public interface User extends Serializable {
    public String getUsername();
    public String getPassword();
    public String getName();
    public String getEmail();
    public HashMap<String, Group> getGroups();
    public HashMap<String, Group> getApplicationsList();
    public UserPublicProfile getUserPublicProfile();
    public void addGroup(Group group);
    public void removeFromApplications(Group group);
}