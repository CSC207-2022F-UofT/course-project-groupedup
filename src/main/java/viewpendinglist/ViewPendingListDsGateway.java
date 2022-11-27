package viewpendinglist;

import Entities.Group;
import Entities.User;

import java.util.HashMap;

public interface ViewPendingListDsGateway {
    Group getGroup(String groupName);

    /**
     * @return a hashmap of all saved users, mapping username to user object
     */
    HashMap<String, User> loadUsers();
}
