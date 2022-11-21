package LeaveGroup;

public interface LeaveGroupOutputBoundary {
    LeaveGroupResponseModel prepareFailureView(String error);
    LeaveGroupResponseModel prepareSuccessView(LeaveGroupResponseModel responseModel);
}
