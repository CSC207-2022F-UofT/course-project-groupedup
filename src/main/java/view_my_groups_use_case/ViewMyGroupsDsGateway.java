package view_my_groups_use_case;

import Entities.Group;
import Entities.User;

public interface ViewMyGroupsDsGateway {
    User getUser(String username);
    Group getGroup(String groupName);
    boolean userIdentifierExists(String username);
}
