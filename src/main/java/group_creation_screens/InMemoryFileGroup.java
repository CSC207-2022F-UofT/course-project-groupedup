package group_creation_screens;

import group_creation_use_case.GroupDSGateway;
import group_creation_use_case.GroupRegisterDSRequestModel;

import java.util.HashMap;
import java.util.Map;

public class InMemoryFileGroup implements GroupDSGateway {
    private Map<String, GroupRegisterDSRequestModel> groups = new HashMap<>();

    /**
     * Saves Group in a hashmap
     * @param groupRegisterDSRequestModel the data to save
     */
    @Override
    public void save(GroupRegisterDSRequestModel groupRegisterDSRequestModel) {
        groups.put(groupRegisterDSRequestModel.getGroupName(), groupRegisterDSRequestModel);
    }

    /**
     *
     * @param groupName the group's groupname
     * @return whether the user exists
     */

    @Override
    public boolean existsByIdentifier(String groupName) {
        return groups.containsKey(groupName);
    }
}
