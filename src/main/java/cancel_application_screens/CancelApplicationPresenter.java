package cancel_application_screens;

import cancel_application_use_case.CancelApplicationOutputBoundary;
import cancel_application_use_case.CancelApplicationResponseModel;

/**
 * Presenter class for cancel application use case.
 */

public class CancelApplicationPresenter implements CancelApplicationOutputBoundary {

    /**
     * @param userAndGroup response model with current user's username and the group name of the group they
     *                     cancelled application for
     * @return a response model with the current user's username and the group name of the group they
     * cancelled application for
     */
    @Override
    public CancelApplicationResponseModel prepareSuccessView(CancelApplicationResponseModel userAndGroup) {
        return userAndGroup;
    }

    /**
     * @param error error message containing the reason for cancel application use case failure
     * @return a use case failure exception
     */
    @Override
    public CancelApplicationResponseModel prepareFailureView(String error) {
        throw new CancelApplicationFailed(error);
    }


}
