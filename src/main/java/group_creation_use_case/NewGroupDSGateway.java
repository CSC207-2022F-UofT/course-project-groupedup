package group_creation_use_case;

import Entities.Group;

import java.io.IOException;
import java.util.HashMap;

public interface NewGroupDSGateway{
    public void saveNewGroups(GroupRegisterDSRequestModel groupDSRequestModel);
    public HashMap<String, Group> loadGroups();
    public boolean groupIdentifierExists(String groupName);

}
