package use_cases.view_group_members_use_case;

import entities.Group;
import entities.User;

import java.util.HashMap;

/**
 * The data access interface for the view group members use case.
 */

public interface ViewGroupMembersDsGateway {
    Group getGroup(String groupName);

    /**
     * @return a hashmap of all saved users, mapping username to user object
     */
    HashMap<String, User> loadUsers();

    boolean groupIdentifierExists(String groupName);
}
