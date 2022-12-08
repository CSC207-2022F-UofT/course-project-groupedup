package use_cases.apply_to_group_use_case;

import entities.User;
import entities.Group;

import java.util.HashMap;

/**
 * The data access interface for the Apply to Group use case
 */

public interface ApplyToGroupDsGateway {
    User getUser(String username);
    Group getGroup(String groupName);

    /**
     * @return a hashmap of all saved users, mapping username to user object
     */
    HashMap<String, User> loadUsers();

    boolean groupIdentifierExists(String groupName);

    /**
     * Updates the user's applications list within the repository.
     * @param user class
     */
    void updateUser(User user);

    /**
     * Updates the group's pending list within the repository.
     * @param group class
     */
    void updateGroup(Group group);

    boolean userInGroup(String username, String groupName);
    boolean groupInUser(String groupName, String username);

    boolean userInMemberRequests(String username, String groupName);
    boolean groupInApplications(String groupName, String username);

}
