package Screens;

import LeaveGroup.LeaveGroupInputBoundary;
import LeaveGroup.LeaveGroupRequestModel;
import LeaveGroup.LeaveGroupResponseModel;

public class LeaveGroupController {
    final LeaveGroupInputBoundary userInput;

    public LeaveGroupController(LeaveGroupInputBoundary actionGateway) {
        this.userInput = actionGateway;
    }

    LeaveGroupResponseModel create(Integer groupID) {
        LeaveGroupRequestModel requestModel = new LeaveGroupRequestModel(groupID);

        return userInput.create(requestModel);
    }
}
