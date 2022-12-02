package group_creation_screens;

import Entities.Group;
import group_creation_use_case.GroupRegisterDSRequestModel;
import group_creation_use_case.NewGroupDSGateway;

import java.util.HashMap;
import java.util.Map;

public class InMemoryFileGroup implements NewGroupDSGateway {
    private Map<String, GroupRegisterDSRequestModel> groups = new HashMap<>();

    public InMemoryFileGroup(){};

    /**
     * Saves Group in a hashmap
     * @param groupRegisterDSRequestModel the data to save
     */
    @Override
    public void saveNewGroups(GroupRegisterDSRequestModel groupRegisterDSRequestModel) {
        groups.put(groupRegisterDSRequestModel.getGroupName(), groupRegisterDSRequestModel);
    }

    @Override
    public HashMap<String, Group> loadGroups() {
        return null;
    }

    /**
     *
     * @param groupName the group's groupname
     * @return whether the user exists
     */

    @Override
    public boolean groupIdentifierExists(String groupName) {
        return groups.containsKey(groupName);
    }
}
