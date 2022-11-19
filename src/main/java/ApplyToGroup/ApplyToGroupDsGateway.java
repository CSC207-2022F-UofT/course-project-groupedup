package ApplyToGroup;

import Entities.User;
import Entities.Group;

public interface ApplyToGroupDsGateway {
    User getUser(String username);
    Group getGroup(String groupName);

    // duplicate from Aarya and Sharon's DsGateways
    boolean userExistsByName(String username);
    boolean groupExistsByName(String groupName);
}
