package group_creation_screens;

import Entities.Group;
import Entities.NormalGroup;
import group_creation_use_case.GroupRegisterDSRequestModel;
import group_creation_use_case.NewGroupDSGateway;

import java.util.HashMap;
import java.util.Map;

/**
 * This group is a database which is used for testing purposes. Instead of using
 * serialization it just contains a map of group names to groups. It does not have
 * data persistence and is only used in the tests, since testing the interactor
 * should not depend on the UI.
 */
public class InMemoryFileGroup implements NewGroupDSGateway {
    private HashMap<String, Group> groups = new HashMap<>();

    public InMemoryFileGroup(){};

    /**
     * Makes a group object using the data from the request model and saves the group in a hashmap.
     * @param groupRegisterDSRequestModel the data to save
     */
    @Override
    public void saveNewGroups(GroupRegisterDSRequestModel groupRegisterDSRequestModel) {
        Group group = new NormalGroup(groupRegisterDSRequestModel.getGroupName());
        groups.put(groupRegisterDSRequestModel.getGroupName(), group);
    }

    /**
     * Returns a hashmap of groupnames to groups.
     * @return
     */
    @Override
    public HashMap<String, Group> loadGroups() {
        return groups;
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
