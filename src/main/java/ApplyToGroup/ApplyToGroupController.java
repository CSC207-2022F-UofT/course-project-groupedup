package ApplyToGroup;

public class ApplyToGroupController {

    final ApplyToGroupInputBoundary applyToGroupInput;

    public ApplyToGroupController(ApplyToGroupInputBoundary applyGateway){
        this.applyToGroupInput = applyGateway;
    }

    ApplyToGroupResponseModel create(String groupName) {
        ApplyToGroupRequestModel requestModel = new ApplyToGroupRequestModel(groupName);

        return applyToGroupInput.create(requestModel);
    }

}

