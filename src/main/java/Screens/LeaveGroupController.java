package Screens;

import LeaveGroup.LeaveGroupInputBoundary;
import LeaveGroup.LeaveGroupRequestModel;
import LeaveGroup.LeaveGroupResponseModel;

/**
 * Executes the leaveGroup use case.
 */
public class LeaveGroupController {
    final LeaveGroupInputBoundary userInput;

    public LeaveGroupController(LeaveGroupInputBoundary actionGateway) {
        this.userInput = actionGateway;
    }

    /**
     * @param username the username of the current user
     * @param groupname the groupname of the group the user is leaving
     * @return the response model for the leaveGroupPresenter
     */
    LeaveGroupResponseModel leaveGroup(String username, String groupname) {
        LeaveGroupRequestModel requestModel = new LeaveGroupRequestModel(username, groupname);

        return userInput.leaveGroup(requestModel);
    }
}
