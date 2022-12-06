package use_cases.edit_pending_list_use_case;

import entities.Group;
import entities.User;

import java.util.HashMap;

/**
 * The data access interface for the edit pending list use case.
 */

public interface EditPendingListDsGateway {
    User getUser(String username);
    Group getGroup(String groupName);

    /**
     * @return a hashmap of all saved users, mapping username to user object
     */
    HashMap<String, User> loadUsers();
    // I'm not sure what the parameters for the 2 methods below should be, they might be response models

    /**
     * Updates the repository with the accepted/rejected user's updated group information
     * @param user the updated user
     */
    void updateUser(User user);

    /**
     * Updates the repository with the group's updated member information
     * @param group the updated group
     */
    void updateGroup(Group group);
    boolean userInGroup(String username, String groupName);
    boolean groupInUser(String groupName, String username);
    boolean userInMemberRequests(String username, String groupName);
    boolean groupInApplications(String groupName, String username);
    boolean userIdentifierExists(String username);
    boolean groupIdentifierExists(String groupName);

}
