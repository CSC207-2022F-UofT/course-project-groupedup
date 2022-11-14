package CancelApplication;

import Entities.Group;
import Entities.User;

public interface CancelApplicationDsGateway {
    boolean userExists(String username);
    boolean groupExists(String groupname);
    User getUser(String username);
    Group getGroup(String groupname);
    void updateUser(String username);
    void updateGroup(String groupname);
}
