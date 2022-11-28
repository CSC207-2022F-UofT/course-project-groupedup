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

    /**
     * @param username the username of the current user
     * @param groupName the group name of the group the user is cancelling their application for
     * @return whether user is in the group's memberRequests list
     */
    boolean userInGroupPendingList(String username, String groupName);

    /**
     * @param username the username of the current user
     * @param groupName the group name of the group the user is cancelling their application for
     * @return whether the group is in the user's applications list
     */
    boolean groupInUserApplicationsList(String username, String groupName);
    HashMap<String, User> loadUsers();
}
