package apply_to_group_use_case;

import Entities.User;
import Entities.Group;

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
    HashMap<String, User> getUserMap();

    boolean groupExistsByName(String groupName);

    /**
     * Updates the user's applications list within the repository.
     * @param username the name of the user
     */
    void updateUser(String username);

    /**
     * Updates the group's pending list within the repository.
     * @param groupName the name of the group
     */
    void updateGroup(String groupName);

    HashMap<String, User> loadUsers();

    boolean userInGroup(String username, String groupName);
    boolean userInApplications(String groupName, String username);
}
