package cancel_application_use_case;

import Entities.Group;
import Entities.User;

import java.util.HashMap;

public interface CancelApplicationDsGateway {
    boolean groupIdentifierExists(String groupname);
    User getUser(String username);
    Group getGroup(String groupname);

    /**
     * Updates the current user after user's applications list has changed. Saves to repository.
     * @param user the current user object
     */
    void updateUser(User user);

    /**
     * Updates the group after group's pending applications list has changed. Saves to repository.
     * @param group the group object
     */
    void updateGroup(Group group);

    boolean userInMemberRequests(String username, String groupName);
    boolean groupInApplications(String groupName, String username);
    HashMap<String, User> loadUsers();
}
