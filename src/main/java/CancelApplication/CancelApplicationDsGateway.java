package CancelApplication;

import Entities.Group;
import Entities.User;

public interface CancelApplicationDsGateway {
    boolean groupExists(String groupname);
    User getUser(String username);
    Group getGroup(String groupname);

    /**
     * Updates the current user after user's applications list has changed. Saves to repository.
     * @param username the username of the current user
     */
    void updateUser(String username);

    /**
     * Updates the group after group's pending applications list has changed. Saves to repository.
     * @param groupname the name of the group
     */
    void updateGroup(String groupname);
    boolean userInGroup(String username, String groupName);

    /**
     * @param username the username of the current user
     * @param groupName the name of the group
     * @return whether the user's applications list contains the group's name.
     */
    boolean groupInUser(String username, String groupName);


}
