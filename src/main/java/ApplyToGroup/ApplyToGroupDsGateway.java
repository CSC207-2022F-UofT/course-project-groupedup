package ApplyToGroup;

import Entities.User;
import Entities.Group;

public interface ApplyToGroupDsGateway {
    User getUser(String username);
    Group getGroup(String groupName);

    // duplicate from Aarya and Sharon's DsGateways
    boolean userExistsByName(String username);
    boolean groupExistsByName(String groupName);

    /**
     * Updates the user's applications list and saves to repository.
     * @param username the name of the user
     */
    void updateUser(String username);

    /**
     * Updates the group's pending list and saves to repository.
     * @param groupName the name of the group
     */
    void updateGroup(String groupName);
}
