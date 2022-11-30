package leave_group_use_case;

public interface LeaveGroupOutputBoundary {
    void prepareFailureView(String error);
    void prepareSuccessView(LeaveGroupResponseModel responseModel);
}
