package leave_group_screens;

import leave_group_use_case.LeaveGroupOutputBoundary;
import leave_group_use_case.LeaveGroupResponseModel;

/**
 * Presenter class for leave group use case.
 */

public class LeaveGroupPresenter implements LeaveGroupOutputBoundary {

    /**
     * @param userAndGroup response model with current user's username and the group name of the group they left
     * @return a response model with the current user's username and the group name of the group they left
     */
    @Override
    public LeaveGroupResponseModel prepareSuccessView(LeaveGroupResponseModel userAndGroup) {
        return null;
    }

    /**
     * @param error error message containing the reason for leave group use case failure
     * @return a use case failure exception
     */
    @Override
    public LeaveGroupResponseModel prepareFailureView(String error) {
        throw new LeaveGroupFailed(error);
    }

    @Override
    public LeaveGroupResponseModel prepareGroupLeaderView(LeaveGroupResponseModel responseModel) {
        return null;
    }
}
