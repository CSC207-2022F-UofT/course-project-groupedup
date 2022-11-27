package leave_group_use_case;

public interface LeaveGroupOutputBoundary {
    LeaveGroupResponseModel prepareFailureView(String error);
    LeaveGroupResponseModel prepareGroupLeaderView(LeaveGroupResponseModel responseModel);
    LeaveGroupResponseModel prepareSuccessView(LeaveGroupResponseModel responseModel);
}
