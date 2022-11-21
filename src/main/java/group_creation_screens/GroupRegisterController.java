package group_creation_screens;

import group_creation_use_case.GroupRegisterInputBoundary;
import group_creation_use_case.GroupRegisterRequestModel;
import group_creation_use_case.GroupRegisterResponseModel;

public class GroupRegisterController {
    final GroupRegisterInputBoundary groupInput;

    public GroupRegisterController(GroupRegisterInputBoundary groupInput){ this.groupInput = groupInput;}

    GroupRegisterResponseModel create(String groupName){
        GroupRegisterRequestModel requestModel = new GroupRegisterRequestModel(groupName);
        return groupInput.create(requestModel);
    }

}
