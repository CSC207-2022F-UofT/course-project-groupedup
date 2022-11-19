package ApplyToGroup_screens;

import ApplyToGroup.ApplyToGroupInputBoundary;
import ApplyToGroup.ApplyToGroupRequestModel;
import ApplyToGroup.ApplyToGroupResponseModel;


/**
 * Executes the Apply To Group use case.
 */
public class ApplyToGroupController {
    final ApplyToGroupInputBoundary applyToGroupInput;

    public ApplyToGroupController(ApplyToGroupInputBoundary applyGateway){
        this.applyToGroupInput = applyGateway;
    }

    /**
     * @param username the username of the current user
     * @param groupName the group's name the user is applying to
     * @return the response model created by ApplyToGroupPresenter
     */
    ApplyToGroupResponseModel applyToGroup(String username, String groupName) {
        ApplyToGroupRequestModel requestModel = new ApplyToGroupRequestModel(username, groupName);

        return applyToGroupInput.applyToGroup(requestModel);
    }

}

