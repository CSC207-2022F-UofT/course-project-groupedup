package group_creation_use_case;

import Entities.GeneralDSGateway;
import Entities.Group;

public interface GroupDSGateway extends GeneralDSGateway<GroupRegisterDSRequestModel, String> {
    /**
     * Saves a Group to the database.
     * @param groupRegisterDSRequestModel the group information to save.
     */
    @Override
    void save(GroupRegisterDSRequestModel groupRegisterDSRequestModel);

    /**
     *
     * @param groupName The unique groupname identifier.
     * @return whether the Group exists or not.
     */
    @Override
    boolean existsByIdentifier(String groupName);

}
