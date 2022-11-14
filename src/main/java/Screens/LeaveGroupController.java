package Screens;

import LeaveGroup.LeaveGroupInputBoundary;
import LeaveGroup.LeaveGroupRequestModel;
import LeaveGroup.LeaveGroupResponseModel;

public class LeaveGroupController {
    final LeaveGroupInputBoundary userInput;

    public LeaveGroupController(LeaveGroupInputBoundary actionGateway) {
        this.userInput = actionGateway;
    }

    LeaveGroupResponseModel leaveGroup(String username, String groupname) {
        LeaveGroupRequestModel requestModel = new LeaveGroupRequestModel(username, groupname);

        return userInput.leaveGroup(requestModel);
    }
}
