package group_creation_use_case;

import Entities.GeneralDSGateway;
import Entities.Group;

public interface GroupDSGateway extends GeneralDSGateway<GroupRegisterDSRequestModel, String> {
    @Override
    void save(GroupRegisterDSRequestModel group);

    @Override
    boolean existsByIdentifier(String name);

}
