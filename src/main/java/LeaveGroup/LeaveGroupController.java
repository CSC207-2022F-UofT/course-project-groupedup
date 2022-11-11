package LeaveGroup;

//TODO: refactor class into screens package (once UI is made)

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
