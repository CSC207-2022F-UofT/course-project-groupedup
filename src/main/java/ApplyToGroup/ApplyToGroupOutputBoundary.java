package ApplyToGroup;

public interface ApplyToGroupOutputBoundary {
    ApplyToGroupResponseModel prepareSuccessView(ApplyToGroupResponseModel user);
    ApplyToGroupResponseModel prepareFailView(String error);

}
