package use_cases.view_my_groups_use_case;

import entities.Group;
import entities.User;

public interface ViewMyGroupsDsGateway {
    User getUser(String username);
    Group getGroup(String groupName);
    boolean userIdentifierExists(String username);
}
