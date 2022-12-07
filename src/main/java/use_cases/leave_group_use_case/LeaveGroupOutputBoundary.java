package use_cases.leave_group_use_case;

/**
 * The output boundary interface for the leave group use case.
 */
public interface LeaveGroupOutputBoundary {
    void prepareFailureView(String error);
    void prepareSuccessView(LeaveGroupResponseModel responseModel);
}
