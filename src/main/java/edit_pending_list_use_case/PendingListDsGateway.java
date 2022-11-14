package edit_pending_list_use_case;

import Entities.Group;
import Entities.User;

public interface PendingListDsGateway {
    User getUser(String username);
    Group getGroup(String groupName);


    // duplicate from Aarya's DS gateway
    boolean userExistsByUsername(String username);

    // boolean groupExistsByGroupName(String groupName);
}
