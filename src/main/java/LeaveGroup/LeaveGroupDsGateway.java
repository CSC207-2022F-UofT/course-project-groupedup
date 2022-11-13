package LeaveGroup;

import Entities.Group;

public interface LeaveGroupDsGateway {
    boolean userExistsByID(Integer userID);
    boolean groupExistsByID(Integer groupID);
    Group getGroup(int groupID);
    void updateUser(int userID);
    void updateGroup(int groupID);
}
