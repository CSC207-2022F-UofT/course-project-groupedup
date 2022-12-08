package edit_group_profile_tests;

import entities.Group;
import entities.NormalGroup;
import use_cases.edit_group_profile_use_case.EditGroupProfileDsGateway;

import java.util.HashMap;


/**
 * Simple imitation of SerializedDataAccess used only for the purpose of testing.
 */

public class EditGroupProfileDataAccess implements EditGroupProfileDsGateway {
    public HashMap<String, Group> groupMap;

    public EditGroupProfileDataAccess(HashMap<String, Group> groups) {
        this.groupMap = groups;
    }

    @Override
    public boolean existsByGroupName(String groupName) {
        return this.groupMap.containsKey(groupName);
    }

    @Override
    public NormalGroup findGroup(String groupName) {
        Group group = this.groupMap.get(groupName);
        return (NormalGroup) group;
    }

    @Override
    public void updateGroup(Group group){
        this.groupMap.replace(group.getGroupName(), group);
    }

}
