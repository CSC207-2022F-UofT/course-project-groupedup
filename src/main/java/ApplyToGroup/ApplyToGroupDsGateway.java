package ApplyToGroup;

import Entities.User;
import Entities.Group;

public interface ApplyToGroupDsGateway {
    User getUser(int userID);
    Group getGroup(int groupID);

    // duplicate from Aarya and Sharon's DsGateways
    boolean userExistsByID(Integer userID);
    boolean groupExistsByID(Integer groupID);
}
