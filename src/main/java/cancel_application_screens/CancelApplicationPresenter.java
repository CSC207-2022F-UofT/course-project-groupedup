package cancel_application_screens;

import cancel_application_use_case.CancelApplicationOutputBoundary;
import cancel_application_use_case.CancelApplicationResponseModel;

import javax.swing.*;

/**
 * Presenter class for cancel application use case.
 */

public class CancelApplicationPresenter implements CancelApplicationOutputBoundary {

    /**
     * @param userAndGroup response model with current user's username and the group name of the group they
     *                     cancelled application for
     */
    @Override
    public void prepareSuccessView(CancelApplicationResponseModel userAndGroup) {
        String username = userAndGroup.getUsername();
        String groupName = userAndGroup.getGroupname();

        JOptionPane.showMessageDialog(null, username + " cancelled application for " +
                groupName + ".");
    }

    /**
     * @param error error message containing the reason for cancel application use case failure
     */
    @Override
    public void prepareFailureView(String error) {
        throw new CancelApplicationFailed(error);
    }

}