package edit_pending_list_use_case;

import Entities.Group;
import Entities.User;

public interface PendingListDsGateway {
    User getUser(Integer id);
    Group getGroup(Integer id);

    // duplicate from Aarya's DS gateway
    boolean userExistsByID(Integer id);

    // boolean groupExistsByID(Integer id);
}
