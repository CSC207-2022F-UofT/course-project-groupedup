package editpendinglist;

import Entities.Group;
import Entities.User;

import java.util.HashMap;

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
     * @param username the user's username
     */
    void updateUser(String username);

    /**
     * Updates the repository with the group's updated member information
     * @param groupName the group's name
     */
    void updateGroup(String groupName);
    boolean userInGroup(String username, String groupName);
    boolean groupInUser(String groupName, String username);
    boolean userInMemberRequests(String username, String groupName);
    boolean groupInApplications(String groupName, String username);
    boolean userIdentifierExists(String username);

}
