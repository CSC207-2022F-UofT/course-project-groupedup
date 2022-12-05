package apply_to_group_screens;

import apply_to_group_use_case.ApplyToGroupInputBoundary;
import apply_to_group_use_case.ApplyToGroupRequestModel;
import apply_to_group_use_case.ApplyToGroupResponseModel;


/**
 * The controller that initiates the Apply To Group use case
 */
public class ApplyToGroupController {
    final ApplyToGroupInputBoundary applyToGroupInput;

    public ApplyToGroupController(ApplyToGroupInputBoundary applyGateway){
        this.applyToGroupInput = applyGateway;
    }

    /**
     * @param username the username of the current user
     * @param groupName the group's name the user is applying to
     */
    void applyToGroup(String username, String groupName) {
        ApplyToGroupRequestModel requestModel = new ApplyToGroupRequestModel(username, groupName);

        applyToGroupInput.applyToGroup(requestModel);
    }

}

