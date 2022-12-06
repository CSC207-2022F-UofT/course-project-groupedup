package use_cases.view_pending_list_use_case;

import entities.Group;
import entities.User;

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
