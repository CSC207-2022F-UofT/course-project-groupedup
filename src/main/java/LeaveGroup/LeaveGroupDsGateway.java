package LeaveGroup;

import Entities.Group;

// Use case layer

public interface LeaveGroupDsGateway {
    boolean userExistsByID(Integer userID);
    boolean groupExistsByID(Integer groupID);
    Group getGroup(int groupID);

    //TODO: implement void(save) method along with a DsGatewayRequestModel.
    // OR.. shared saver class for all use cases?
}
