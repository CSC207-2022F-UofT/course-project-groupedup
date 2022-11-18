package LeaveGroup;

public class LeaveGroupPresenter implements LeaveGroupOutputBoundary {
    @Override
    public LeaveGroupResponseModel prepareFailureView(String error) {
        return null;
    }

    @Override
    public LeaveGroupResponseModel prepareSuccessView(LeaveGroupResponseModel responseModel) {
        return null;
    }
}
