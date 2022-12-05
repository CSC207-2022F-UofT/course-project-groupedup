package view_pending_list;

import Entities.Group;
import Entities.User;

import java.util.HashMap;

/**
 * The data access interface for the view pending list use case.
 */

public interface ViewPendingListDsGateway {
    boolean groupIdentifierExists(String groupName);
    Group getGroup(String groupName);

    /**
     * @return a hashmap of all saved users, mapping username to user object
     */
    HashMap<String, User> loadUsers();
}
