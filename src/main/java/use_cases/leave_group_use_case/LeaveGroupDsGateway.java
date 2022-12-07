package use_cases.leave_group_use_case;

import entities.Group;
import entities.User;

import java.util.HashMap;

/**
 * The data access interface for the leave group use case.
 */
public interface LeaveGroupDsGateway {
    boolean groupIdentifierExists(String groupName);
    User getUser(String username);
    Group getGroup(String groupName);

    /**
     * Updates the current user after user's groups list has changed. Saves to repository.
     * @param user the current user object
     */
    void updateUser(User user);

    /**
     * Updates the group after group's members list has changed. Saves to repository.
     * @param group the group object
     */
    void updateGroup(Group group);
    boolean userInGroup(String username, String groupName);

    /**
     * @param username the username of the current user
     * @param groupName the name of the group
     * @return whether the user's members list contains the group's name.
     */
    boolean groupInUser(String username, String groupName);
    HashMap<String, User> loadUsers();
}
