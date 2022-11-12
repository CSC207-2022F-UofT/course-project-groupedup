package ApplyToGroup;

public class ApplyToGroupController {

    final ApplyToGroupInputBoundary applyToGroupInput;

    public ApplyToGroupController(ApplyToGroupInputBoundary applyGateway){
        this.applyToGroupInput = applyGateway;
    }

    ApplyToGroupResponseModel create(Integer groupID) {
        ApplyToGroupRequestModel requestModel = new ApplyToGroupRequestModel(groupID);

        return applyToGroupInput.create(requestModel);
    }

}

