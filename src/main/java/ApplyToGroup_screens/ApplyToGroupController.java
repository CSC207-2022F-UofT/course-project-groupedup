package ApplyToGroup_screens;

import ApplyToGroup.ApplyToGroupInputBoundary;
import ApplyToGroup.ApplyToGroupRequestModel;
import ApplyToGroup.ApplyToGroupResponseModel;

public class ApplyToGroupController {

    final ApplyToGroupInputBoundary applyToGroupInput;

    public ApplyToGroupController(ApplyToGroupInputBoundary applyGateway){
        this.applyToGroupInput = applyGateway;
    }

    ApplyToGroupResponseModel applyToGroup(String username, String groupName) {
        ApplyToGroupRequestModel requestModel = new ApplyToGroupRequestModel(username, groupName);

        return applyToGroupInput.applyToGroup(requestModel);
    }

}

