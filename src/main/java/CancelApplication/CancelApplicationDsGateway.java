package CancelApplication;

import Entities.Group;
import Entities.User;

public interface CancelApplicationDsGateway {
    boolean groupExists(String groupname);
    User getUser(String username);
    Group getGroup(String groupname);
    void updateUser(String username);
    void updateGroup(String groupname);
    boolean userInGroup(String username, String groupName);
    boolean groupInUser(String username, String groupName);


}
