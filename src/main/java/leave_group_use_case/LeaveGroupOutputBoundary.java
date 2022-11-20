package leave_group_use_case;

public interface LeaveGroupOutputBoundary {
    LeaveGroupResponseModel prepareFailureView(String error);
    LeaveGroupResponseModel prepareSuccessView(LeaveGroupResponseModel responseModel);
}
