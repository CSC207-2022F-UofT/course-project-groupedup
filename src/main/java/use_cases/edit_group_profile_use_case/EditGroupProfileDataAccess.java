package use_cases.edit_group_profile_use_case;
import entities.Group;
import entities.NormalGroup;

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
    public void updateGroup(Group group) {
        String groupName = group.getGroupName();
        groupMap.replace(groupName, group);

    }
}
