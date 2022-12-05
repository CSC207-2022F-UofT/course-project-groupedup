package edit_group_profile_screens;
import Entities.Group;
import Entities.NormalGroup;
import Entities.User;
import edit_group_profile_use_case.EditGroupProfileDsGateway;
import edit_group_profile_use_case.EditGroupProfileDsRequestModel;

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
    public void saveGroupProfile(EditGroupProfileDsRequestModel requestModel) {
        Group group = this.groupMap.get(requestModel.getGroupName());
        group.getProfile().setPreferences(requestModel.getPreferences());
        group.getProfile().setCourseCode(requestModel.getCourseCode());
        group.getProfile().setDescription(requestModel.getDescription());

    }
}

