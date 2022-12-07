package controllers_presenters_and_screen_boundaries.apply_to_group_adapters;

import use_cases.apply_to_group_use_case.ApplyToGroupInputBoundary;
import use_cases.apply_to_group_use_case.ApplyToGroupRequestModel;


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
    public void applyToGroup(String username, String groupName) {
        ApplyToGroupRequestModel requestModel = new ApplyToGroupRequestModel(username, groupName);

        applyToGroupInput.applyToGroup(requestModel);
    }

}

